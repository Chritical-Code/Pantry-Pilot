package pages;

import gui.*;
import javax.swing.*;

public class Home extends CPage {

    //Constructor
    public Home(){
        reset();
        loadContent();
    }

    //Page Content
    @Override
    public void loadContent(){
        //header
        add(new Header("Pantry Pilot"));

        //vertical glue
        add(Box.createVerticalGlue());

        //Row 1 links
        CBoxFlow f_row1 = new CBoxFlow();
        add(f_row1);

        //horizontal glue
        f_row1.add(Box.createHorizontalGlue());

        //button: view stock
        CButton b_ViewStock = new CButton("Inventory");
        b_ViewStock.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_inventory));
        General.sizomatic(b_ViewStock, 150, 100);
        f_row1.add(b_ViewStock);

        //horizontal glue
        f_row1.add(Box.createHorizontalGlue());

        //button: I/O
        CButton b_InOut = new CButton("I/O");
        b_InOut.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_inOut));
        General.sizomatic(b_InOut, 150, 100);
        f_row1.add(b_InOut);

        //horizontal glue
        f_row1.add(Box.createHorizontalGlue());

        //button: manage
        CButton b_Manage = new CButton("Products");
        b_Manage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_products));
        General.sizomatic(b_Manage, 150, 100);
        f_row1.add(b_Manage);

        //horizontal glue
        f_row1.add(Box.createHorizontalGlue());

        //vertical glue
        add(Box.createVerticalGlue());
    }
}