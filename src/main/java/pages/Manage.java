package pages;

import gui.*;
import model.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Manage extends CPage {
    private CFlow f_table;
    private JTable table;
    JTextField id, brand, name, category;


    public Manage(){
        //flow: title
        CFlow f_title = new CFlow();
        add(f_title);
        CLabel title = new CLabel("Manage");
        f_title.add(title);

        //flow: return
        CFlow f_return = new CFlow();
        add(f_return);
        CButton bManage = new CButton("Home");
        bManage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_home));
        f_return.add(bManage);

        //flow: table
        f_table = new CFlow();
        add(f_table);
        f_table.setPreferredSize(new Dimension(600, 200));
        f_table.add(createTable());

        //flow: text input
        add(textInputSection());

        //flow: button input
        add(buttonInputSection());

        //flow: bottom space
        CFlow f_space = new CFlow();
        add(f_space);
        CLabel space = new CLabel("space");
        f_space.add(space);
    }

    //functions
    //Create table
    private JScrollPane createTable(){
        //read in product data
        ArrayList<Product> products = Product.readProducts();
        Collections.reverse(products);

        // Define column names and data
        String[] columnNames = {"id", "brand", "name", "category"};
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Product product : products){
            Object[] row = {product.id, product.brand, product.name, product.category};
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

    //create input section
    private CFlow textInputSection(){
        //create flow
        CFlow f_textInput = new CFlow();

        //clear button
        CButton b_clear = new CButton("Clear");
        b_clear.addActionListener(e -> clearData());
        f_textInput.add(b_clear);

        //id
        CBoxLabel idBox = new CBoxLabel("ID:");
        f_textInput.add(idBox);
        id = new JTextField(5);
        id.setEditable(false);
        idBox.add(id);

        //brand
        CBoxLabel brandBox = new CBoxLabel("Brand:");
        f_textInput.add(brandBox);
        brand = new JTextField(10);
        brandBox.add(brand);

        //name
        CBoxLabel nameBox = new CBoxLabel("Name:");
        f_textInput.add(nameBox);
        name = new JTextField(10);
        nameBox.add(name);

        //category
        CBoxLabel categoryBox = new CBoxLabel("Category:");
        f_textInput.add(categoryBox);
        category = new JTextField(10);
        categoryBox.add(category);

        return  f_textInput;
    }

    //create button input section
    private  CFlow buttonInputSection(){
        //create flow
        CFlow f_buttonInput = new CFlow();

        //insert button
        CButton b_insert = new CButton("Add");
        b_insert.addActionListener(e -> insertEntry());
        f_buttonInput.add(b_insert);

        //update button
        CButton b_update = new CButton("Update");
        b_update.addActionListener(e -> updateEntry());
        f_buttonInput.add(b_update);

        //delete button
        CButton b_delete = new CButton("Delete");
        b_delete.addActionListener(e -> deleteEntry());
        f_buttonInput.add(b_delete);

        //return flow
        return  f_buttonInput;
    }

    //refresh table
    private void refreshTable(){
        f_table.removeAll();
        JScrollPane scrollPane = createTable();
        f_table.add(scrollPane);
        f_table.revalidate();
        f_table.repaint();
    }


    //button functions
    //insert data
    private void insertEntry(){
        //cancel if name is empty
        if(Objects.equals(name.getText(), "")){
            return;
        }

        //turn the text into an object
        Product product = new Product();
        product.brand = brand.getText();
        product.name = name.getText();
        product.category = category.getText();

        //send product and refresh
        Product.createProduct(product);
        clearData();
        refreshTable();
    }

    //clear
    private void clearData(){
        table.clearSelection();
        id.setText("");
        brand.setText("");
        name.setText("");
        category.setText("");
    }

    //update
    private void updateEntry(){
        //cancel if id is empty
        if(Objects.equals(id.getText(), "")){
            return;
        }

        //form a product
        Product product = new Product();
        product.id = Integer.parseInt(id.getText());
        product.brand = brand.getText();
        product.name = name.getText();
        product.category = category.getText();

        //send statement and refresh
        Product.updateProduct(product);
        clearData();
        refreshTable();
    }

    //delete
    private void deleteEntry(){
        //cancel if id is empty
        if(Objects.equals(id.getText(), "")){
            return;
        }

        //send the id to the delete function
        Product.deleteProduct(Integer.parseInt(id.getText()));

        //refresh table
        refreshTable();

        //clear selection
        clearData();
    }

    //select
    private void selectEntry(ListSelectionEvent e){
        if(!e.getValueIsAdjusting()){
            int row = table.getSelectedRow();
            if(row != -1){
                //put data into text input
                id.setText(table.getValueAt(row, 0).toString());
                brand.setText((String) table.getValueAt(row, 1));
                name.setText((String) table.getValueAt(row, 2));
                category.setText((String) table.getValueAt(row, 3));
            }
        }
    }
}
