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
    //Variables
    private CBoxFlow f_table;
    private CTable table;
    CTextField id, brand, name, category;


    //Page contents
    public Manage(){
        //header
        add(new Header("Manage"));

        //glue
        add(Box.createVerticalGlue());

        //flow: table
        f_table = new CBoxFlow();
        General.sizomatic(f_table, 1200, 300);
        add(f_table);
        f_table.add(createTable());

        //glue
        add(Box.createVerticalGlue());

        //flow: text input
        CBoxFlow f_textInput = textInputSection();
        General.sizomatic(f_textInput, 1200, 100);
        add(f_textInput);

        //glue
        add(Box.createVerticalGlue());

        //flow: button input
        CBoxFlow f_buttonInput = buttonInputSection();
        General.sizomatic(f_buttonInput, 1200, 100);
        add(f_buttonInput);

        //glue
        add(Box.createVerticalGlue());
    }


    //Functions
    //create table
    private CScrollPane createTable(){
        //read in product data
        ArrayList<Product> products = Product.readProducts();
        Collections.reverse(products);

        // Define column names and data
        String[] columnNames = {"ID", "Brand", "Name", "Category"};
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
        table = new CTable(tableModel);

        //add select function
        table.getSelectionModel().addListSelectionListener(e -> selectEntry(e));

        // Add the JTable to a JScrollPane for scroll functionality
        return new CScrollPane(table);
    }

    //create text input section
    private CBoxFlow textInputSection(){
        //create flow
        CBoxFlow f_textInput = new CBoxFlow();

        //glue
        f_textInput.add(Box.createHorizontalGlue());

        //id
        CBoxLabel idBox = new CBoxLabel("ID:");
        General.sizomatic(idBox, 60, 80);
        f_textInput.add(idBox);
        id = new CTextField(5);
        id.setEditable(false);
        General.sizomatic(id, 60, 40);
        idBox.add(id);

        //glue
        f_textInput.add(Box.createHorizontalGlue());

        //brand
        CBoxLabel brandBox = new CBoxLabel("Brand:");
        General.sizomatic(brandBox, 300, 80);
        f_textInput.add(brandBox);
        brand = new CTextField(10);
        General.sizomatic(brand, 300, 40);
        brandBox.add(brand);

        //glue
        f_textInput.add(Box.createHorizontalGlue());

        //name
        CBoxLabel nameBox = new CBoxLabel("Name:");
        General.sizomatic(nameBox, 300, 80);
        f_textInput.add(nameBox);
        name = new CTextField(10);
        General.sizomatic(name, 300, 40);
        nameBox.add(name);

        //glue
        f_textInput.add(Box.createHorizontalGlue());

        //category
        CBoxLabel categoryBox = new CBoxLabel("Category:");
        General.sizomatic(categoryBox, 300, 80);
        f_textInput.add(categoryBox);
        category = new CTextField(10);
        General.sizomatic(category, 300, 40);
        categoryBox.add(category);

        //glue
        f_textInput.add(Box.createHorizontalGlue());

        return  f_textInput;
    }

    //create button input section
    private  CBoxFlow buttonInputSection(){
        //create flow
        CBoxFlow f_buttonInput = new CBoxFlow();

        //glue
        f_buttonInput.add(Box.createHorizontalGlue());

        //clear button
        CButton b_clear = new CButton("Clear");
        b_clear.addActionListener(e -> clearData());
        b_clear.setBackground(General.orange);
        General.sizomatic(b_clear, 100, 50);
        f_buttonInput.add(b_clear);

        //glue
        f_buttonInput.add(Box.createHorizontalGlue());

        //insert button
        CButton b_insert = new CButton("Add");
        b_insert.addActionListener(e -> insertEntry());
        b_insert.setBackground(General.green);
        General.sizomatic(b_insert, 100, 50);
        f_buttonInput.add(b_insert);

        //glue
        f_buttonInput.add(Box.createHorizontalGlue());

        //update button
        CButton b_update = new CButton("Update");
        b_update.addActionListener(e -> updateEntry());
        b_update.setBackground(General.yellow);
        General.sizomatic(b_update, 100, 50);
        f_buttonInput.add(b_update);

        //glue
        f_buttonInput.add(Box.createHorizontalGlue());

        //delete button
        CButton b_delete = new CButton("Delete");
        b_delete.addActionListener(e -> deleteEntry());
        b_delete.setBackground(General.red);
        General.sizomatic(b_delete, 100, 50);
        f_buttonInput.add(b_delete);

        //glue
        f_buttonInput.add(Box.createHorizontalGlue());

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
        revalidate();
        repaint();
    }


    //Button functions
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
