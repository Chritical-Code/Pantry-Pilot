package pages;

import gui.*;
import model.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

public class ViewStock extends CPage {
    //Variables
    private CFlow f_table;
    private JTable table;

    //Page contents
    public ViewStock(){
        //flow: title
        CFlow f_title = new CFlow();
        add(f_title);
        CLabel title = new CLabel("View Stock");
        f_title.add(title);

        //flow: return
        CFlow f_return = new CFlow();
        add(f_return);
        CButton b_manage = new CButton("Home");
        b_manage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_home));
        f_return.add(b_manage);

        //flow: table
        f_table = new CFlow();
        add(f_table);
        f_table.setPreferredSize(new Dimension(600, 200));
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
        CButton b_add = new CButton("Add");
        b_add.addActionListener(e -> add(productsCombo, dateChooser));
        CButton b_delete = new CButton("Delete");
        b_delete.addActionListener(e -> delete());
        f_inputs.add(b_add);
        f_inputs.add(b_delete);
    }


    //Functions
    //create table
    private JScrollPane createTable(){
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
        table = new JTable(tableModel);

        //set some table settings *****may want to add to my own CTable*********
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //add select function
        table.getSelectionModel().addListSelectionListener(e -> selectEntry(e));

        // Add the JTable to a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        return scrollPane;
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
        int outID = Integer.parseInt(table.getValueAt(row, 0).toString());
        System.out.println("Pretend deleted number: " + outID);

        //if no product selected
    }
}
