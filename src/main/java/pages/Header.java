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
        CButton b_manage = new CButton("Home");
        b_manage.addActionListener(e -> CPage.cardLayout.show(CPage.mainPanel, CPage.p_home));
        b_manage.setMinimumSize(new Dimension(75, 50));
        b_manage.setMaximumSize(new Dimension(75, 50));
        b_manage.setPreferredSize(new Dimension(75, 50));
        add(b_manage);

        //gap
        add(Box.createRigidArea(new Dimension(75,0)));

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
        b_settings.setMinimumSize(new Dimension(75, 50));
        b_settings.setMaximumSize(new Dimension(75, 50));
        b_settings.setPreferredSize(new Dimension(75, 50));
        add(b_settings);

        //gap
        add(Box.createRigidArea(new Dimension(10,0)));

        //button notif
        CButton b_notif = new CButton("Settings");
        b_notif.setMinimumSize(new Dimension(75, 50));
        b_notif.setMaximumSize(new Dimension(75, 50));
        b_notif.setPreferredSize(new Dimension(75, 50));
        add(b_notif);

        //gap
        add(Box.createRigidArea(new Dimension(10,0)));
    }
}
