package pages;

import gui.*;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    public Header(String inTitle){
        //general settings
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(General.cream);
        //size
        setPreferredSize(new Dimension(600, 100));
        setMaximumSize(new Dimension(99999, 100));

        //home flow
        CFlow f_home = new CFlow();
        f_home.setPreferredSize(new Dimension(50, 50));
        add(f_home);
        //home button
        CButton b_manage = new CButton("Home");
        b_manage.addActionListener(e -> CPage.cardLayout.show(CPage.mainPanel, CPage.p_home));
        f_home.add(b_manage);

        //title flow
        CFlow f_title = new CFlow();
        f_title.setPreferredSize(new Dimension(400, 100));
        add(f_title);
        //title text
        CLabel title = new CLabel(inTitle);
        title.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 60));
        f_title.add(title);

        //third flow
        CFlow f_third = new CFlow();
        f_third.setPreferredSize(new Dimension(50, 50));
        add(f_third);
        //button
        CButton button = new CButton("Button");
        f_third.add(button);
    }
}
