package pages;

import gui.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ViewStock extends CPage {
    //Variables
    private CFlow f_table;
    private CTable table;

    //Page contents
    public ViewStock(){
        //header
        add(new Header("View Stock"));

        //flow: table
        f_table = new CFlow();
        add(f_table);
        f_table.add(createTable());
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

        // Add the JTable to a JScrollPane for scroll functionality
        return new CScrollPane(table);
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
}
