package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CTable extends JTable {
    public CTable(DefaultTableModel model){
        super(model);

        //customize
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setBackground(General.vanilla);
        getTableHeader().setBackground(General.vanilla);
    }
}
