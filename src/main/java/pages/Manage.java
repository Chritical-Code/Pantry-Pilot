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

        //read in product data
        ArrayList<Product> products = Product.getProducts();
        System.out.println(products.size() + " products found");

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
        f_table.add(scrollPane);



        //flow: bottom space
        CFlow f_space = new CFlow();
        add(f_space);
        CLabel space = new CLabel("space");
        f_space.add(space);
    }
}
