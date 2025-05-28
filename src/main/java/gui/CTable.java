package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CTable extends JTable {
    public CTable(DefaultTableModel model){
        super(model);

        //customize
        getTableHeader().setReorderingAllowed(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //setBackground(General.lightBlue);
        //getTableHeader().setBackground(General.lightBlue);


        //settings
        setFont(General.mainFont);
        setRowHeight(24);
        getTableHeader().setFont(General.mainFontBold);
    }
}
