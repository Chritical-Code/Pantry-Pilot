package pages;

import com.toedter.calendar.JDateChooser;
import gui.*;
import model.Item;
import model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class InOut extends CPage {
    //Variables
    private CBoxFlow f_table;
    private CTable table;
    CBoxFlow f_options;
    JComboBox<Product> productsCombo;
    JDateChooser dateChooser;


    //Page Content
    @Override
    public void loadContent(){
        //header
        add(new Header("I/O"));

        //vertical glue
        add(Box.createVerticalGlue());

        //flow: table
        f_table = new CBoxFlow();
        General.sizomatic(f_table, 1200, 300);
        add(f_table);
        CompletableFuture.runAsync(this::refreshTable);

        //vertical glue
        add(Box.createVerticalGlue());

        //flow: options
        f_options = new CBoxFlow();
        General.sizomatic(f_options, 1200, 100);
        add(f_options);
        CompletableFuture.runAsync(this::refreshOptionSection);

        //vertical glue
        add(Box.createVerticalGlue());

        //flow: inputs
        CBoxFlow f_inputs = createInputSection();
        add(f_inputs);

        //vertical glue
        add(Box.createVerticalGlue());
    }

    //Functions
    //create table
    private CScrollPane createTable(){
        //read in product data
        ArrayList<Item> items = Item.readItems();
        Collections.reverse(items);

        // Define column names and data
        String[] columnNames = {"ID", "Product", "Expiry"};
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Item item : items){
            Object[] row = {item.id, item.productName, item.expiry};
            dataList.add(row);
        }
        Object[][] data = dataList.toArray(new Object[0][]);

        // Create a JTable with the data and column names
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Disable editing for all cells
                return false;
            }
        };
        table = new CTable(tableModel);

        //add select function
        table.getSelectionModel().addListSelectionListener(this::selectEntry);

        // Add the JTable to a JScrollPane for scroll functionality
        CScrollPane scrollPane = new CScrollPane(table);
        General.sizomatic(scrollPane, 1200, 300);
        return scrollPane;
    }

    //create options section
    private CBoxFlow createOptionSection(){
        //create flow
        CBoxFlow f_options = new CBoxFlow();

        //horizontal glue
        f_options.add(Box.createHorizontalGlue());

        //product
        CBoxLabel productBox = new CBoxLabel("Product:");
        f_options.add(productBox);
        productsCombo = createComboBox();
        General.sizomatic(productsCombo, 300, 40);
        productsCombo.setFont(General.mainFont);
        productBox.add(productsCombo);

        //horizontal glue
        f_options.add(Box.createHorizontalGlue());

        //date
        CBoxLabel dateBox = new CBoxLabel("Date:");
        f_options.add(dateBox);
        dateChooser = new JDateChooser();
        General.sizomatic(dateChooser, 300, 40);
        dateChooser.setFont(General.mainFont);
        dateBox.add(dateChooser);

        //horizontal glue
        f_options.add(Box.createHorizontalGlue());

        //return flow
        return f_options;
    }

    //create button input section
    private CBoxFlow createInputSection(){
        //make the flow
        CBoxFlow f_inputs = new CBoxFlow();

        //horizontal glue
        f_inputs.add(Box.createHorizontalGlue());

        //add button
        CButton b_add = new CButton("Add");
        b_add.addActionListener(e -> add(productsCombo, dateChooser));
        b_add.setBackground(General.green);
        General.sizomatic(b_add, 100, 50);
        f_inputs.add(b_add);

        //horizontal glue
        f_inputs.add(Box.createHorizontalGlue());

        //delete button
        CButton b_delete = new CButton("Delete");
        b_delete.addActionListener(e -> delete());
        b_delete.setBackground(General.red);
        General.sizomatic(b_delete, 100, 50);
        f_inputs.add(b_delete);

        //horizontal glue
        f_inputs.add(Box.createHorizontalGlue());

        //return the flow
        return f_inputs;
    }

    //create combo box
    private JComboBox<Product> createComboBox(){
        //read in product data, convert to array
        ArrayList<Product> lProducts = Product.readProducts();
        Product[] aProducts = lProducts.toArray(Product[]::new);

        //shove inside of combo box
        return new JComboBox<>(aProducts);
    }

    //refresh table
    private void refreshTable(){
        f_table.removeAll();
        JScrollPane scrollPane = createTable();
        f_table.add(scrollPane);
        //f_table.revalidate();
        //f_table.repaint();
        revalidate();
        repaint();
    }

    //refresh input section
    private void refreshOptionSection(){
        f_options.removeAll();
        f_options.add(createOptionSection());
        f_options.revalidate();
        f_options.repaint();
        revalidate();
        repaint();
    }

    //Button functions
    //select an entry in the table
    private void selectEntry(ListSelectionEvent e){
        //add custom logic
    }

    //add button
    private void add(JComboBox<Product> productsCombo, JDateChooser dateChooser){
        //get selected index
        int selected = productsCombo.getSelectedIndex();

        //check if null
        if (productsCombo.getItemAt(selected) == null){
            return;
        }

        //construct item object
        Item item = new Item();
        item.productID = productsCombo.getItemAt(selected).id;
        item.expiry = dateChooser.getDate();

        //send item and refresh
        Item.createItem(item);
        refreshTable();
    }

    //delete button
    private void delete(){
        int row = table.getSelectedRow();

        //if empty
        if(row == -1){
            return;
        }

        //get id at row, send to delete function
        int id = Integer.parseInt(table.getValueAt(row, 0).toString());
        Item.deleteItem(id);

        //remove item from table
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.removeRow(row);
    }
}
