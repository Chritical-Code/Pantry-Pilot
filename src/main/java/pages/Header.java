package pages;

import gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Header extends JPanel {
    public Header(String inTitle){
        //general settings
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(General.cream);
        //size
        setPreferredSize(new Dimension(600, 100));
        setMaximumSize(new Dimension(99999, 100));

        //gap
        add(Box.createRigidArea(new Dimension(20,0)));

        //home button
        //<a target="_blank" href="https://icons8.com/icon/73/home">Home</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
        CButtonIcon b_home = new CButtonIcon("/icons/home-icon.png");
        b_home.addActionListener(e -> CPage.cardLayout.show(CPage.mainPanel, CPage.p_home));
        add(b_home);

        //gap
        add(Box.createRigidArea(new Dimension(80,0)));

        //horizontal glue
        add(Box.createHorizontalGlue());

        //title text
        CLabel title = new CLabel(inTitle);
        title.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 60));
        add(title);

        //horizontal glue
        add(Box.createHorizontalGlue());

        //button settings
        //<a target="_blank" href="https://icons8.com/icon/364/settings">Settings</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
        CButtonIcon b_settings = new CButtonIcon("/icons/settings-icon.png");
        add(b_settings);

        //gap
        add(Box.createRigidArea(new Dimension(20,0)));

        //button notif
        //<a target="_blank" href="https://icons8.com/icon/nJRLlq8KqcX5/notifications">Notifications</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
        CButtonIcon b_notif = new CButtonIcon("/icons/notifications-icon.png");
        General.sizomatic(b_notif, 50, 50);
        add(b_notif);

        //gap
        add(Box.createRigidArea(new Dimension(20,0)));
    }
}
