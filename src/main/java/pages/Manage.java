package pages;

import gui.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Manage extends CPage {
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
        CFlow f_table = new CFlow();
        add(f_table);
        f_table.setPreferredSize(new Dimension(600, 200));
        f_table.add(createTable());

        //flow: create item
        add(createAddSection());

        //flow: bottom space
        CFlow f_space = new CFlow();
        add(f_space);
        CLabel space = new CLabel("space");
        f_space.add(space);
    }

    //Create table
    private JScrollPane createTable(){
        //read in product data
        ArrayList<Product> products = Product.getProducts();

        // Define column names and data
        String[] columnNames = {"id", "brand", "name", "category"};
        ArrayList<Object[]> dataList = new ArrayList<>();
        for (Product product : products){
            Object[] row = {product.id, product.brand, product.name, product.category};
            dataList.add(row);
        }
        Object[][] data = dataList.toArray(new Object[0][]);

        // Create a JTable with the data and column names
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // Add the JTable to a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        return scrollPane;
    }

    //create inputs
    private CFlow createAddSection(){
        //create flow
        CFlow f_create = new CFlow();

        //brand
        CBoxLabel brandBox = new CBoxLabel("Brand:");
        f_create.add(brandBox);
        JTextField brand = new JTextField(10);
        brandBox.add(brand);

        //name
        CBoxLabel nameBox = new CBoxLabel("Name:");
        f_create.add(nameBox);
        JTextField name = new JTextField(10);
        nameBox.add(name);

        //category
        CBoxLabel categoryBox = new CBoxLabel("Category:");
        f_create.add(categoryBox);
        JTextField category = new JTextField(10);
        categoryBox.add(category);

        //insert button
        CButton b_insert = new CButton("Add");
        f_create.add(b_insert);
        b_insert.addActionListener(e -> insertData(brand.getText(), name.getText(), category.getText()));

        return  f_create;
    }

    //insert data
    private void insertData(String brand, String name, String category){
        //turn the text into an object
        Product product = new Product();
        product.brand = brand;
        product.name = name;
        product.category = category;

        //send the object to the model function
        Product.insertProduct(product);
    }
}
