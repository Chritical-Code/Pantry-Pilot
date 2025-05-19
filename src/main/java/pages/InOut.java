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

public class InOut extends CPage {
    //Variables
    private CFlow f_table;
    private CTable table;

    //Page contents
    public InOut(){
        //header
        add(new Header("I/O"));

        //flow: table
        f_table = new CFlow();
        add(f_table);
        f_table.add(createTable());

        //flow: options
        CFlow f_options = new CFlow();
        add(f_options);
        //product
        CBoxLabel productBox = new CBoxLabel("Product:");
        f_options.add(productBox);
        JComboBox<Product> productsCombo = createComboBox();
        productBox.add(productsCombo);
        //date
        CBoxLabel dateBox = new CBoxLabel("Date:");
        f_options.add(dateBox);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(125, 20));
        dateBox.add(dateChooser);

        //flow: inputs
        CFlow f_inputs = new CFlow();
        add(f_inputs);
        //add button
        CButton b_add = new CButton("Add");
        b_add.addActionListener(e -> add(productsCombo, dateChooser));
        b_add.setBackground(General.green);
        f_inputs.add(b_add);
        //delete button
        CButton b_delete = new CButton("Delete");
        b_delete.addActionListener(e -> delete());
        b_delete.setBackground(General.red);
        f_inputs.add(b_delete);
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
        return new CScrollPane(table);
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
        f_table.revalidate();
        f_table.repaint();
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

        //get id at row, send to delete function, refresh table
        int id = Integer.parseInt(table.getValueAt(row, 0).toString());
        Item.deleteItem(id);
        refreshTable();
    }
}
