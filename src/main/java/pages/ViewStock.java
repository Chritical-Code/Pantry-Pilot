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

        // Add the JTable to a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        return scrollPane;
    }

    //refresh table
    private void refreshTable(){
        f_table.removeAll();
        JScrollPane scrollPane = createTable();
        f_table.add(scrollPane);
        f_table.revalidate();
        f_table.repaint();
    }
}
