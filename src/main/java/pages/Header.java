package pages;

import gui.*;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    public Header(String inTitle){
        //general settings
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(General.cream);
        //size
        setPreferredSize(new Dimension(600, 100));
        setMaximumSize(new Dimension(99999, 100));

        //gap
        add(Box.createRigidArea(new Dimension(10,0)));

        //home button
        CButton b_home = new CButton("Home");
        b_home.addActionListener(e -> CPage.cardLayout.show(CPage.mainPanel, CPage.p_home));
        General.sizomatic(b_home, 75, 50);
        add(b_home);

        //gap
        add(Box.createRigidArea(new Dimension(85,0)));

        //glue
        add(Box.createHorizontalGlue());

        //title text
        CLabel title = new CLabel(inTitle);
        title.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 60));
        add(title);

        //glue
        add(Box.createHorizontalGlue());

        //button settings
        CButton b_settings = new CButton("Notifications");
        General.sizomatic(b_settings, 75, 50);
        add(b_settings);

        //gap
        add(Box.createRigidArea(new Dimension(10,0)));

        //button notif
        CButton b_notif = new CButton("Settings");
        General.sizomatic(b_notif, 75, 50);
        add(b_notif);

        //gap
        add(Box.createRigidArea(new Dimension(10,0)));
    }
}
