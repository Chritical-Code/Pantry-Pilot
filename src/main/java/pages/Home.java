package pages;

import gui.*;

import javax.swing.*;
import java.awt.*;

public class Home extends CPage {
    public Home(){
        //header
        add(new Header("Pantry Pilot"));

        //gap
        add(Box.createRigidArea(new Dimension(0,150)));

        //Row 1 links
        JPanel f_row1 = new JPanel();
        f_row1.setBackground(General.clear);
        add(f_row1);

        //button: view stock
        CButton b_ViewStock = new CButton("View Stock");
        b_ViewStock.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_viewStock));
        b_ViewStock.setPreferredSize(new Dimension(100, 100));
        f_row1.add(b_ViewStock);

        //gap
        f_row1.add(Box.createRigidArea(new Dimension(100, 0)));

        //button: I/O
        CButton b_InOut = new CButton("I/O");
        b_InOut.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_inOut));
        b_InOut.setPreferredSize(new Dimension(100, 100));
        f_row1.add(b_InOut);

        //gap
        f_row1.add(Box.createRigidArea(new Dimension(100, 0)));

        //button: manage
        CButton b_Manage = new CButton("Manage");
        b_Manage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_manage));
        b_Manage.setPreferredSize(new Dimension(100, 100));
        f_row1.add(b_Manage);
    }
}