package pages;

import gui.*;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    //header
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
        add(Box.createRigidArea(new Dimension(20,0)));

        //about button
        //<a target="_blank" href="https://icons8.com/icon/6644/question-mark">Question Mark</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
        CButtonIcon b_about = new CButtonIcon("/icons/about-icon.png");
        b_about.addActionListener(e -> CPage.cardLayout.show(CPage.mainPanel, CPage.p_about));
        add(b_about);

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

        //jwindow
        //notificationBox();

        //extra layout
        //extraLayout();
    }

    //notifications window
    public void notificationBox(){
        //layer
        JLayeredPane layer = CPage.frame.getLayeredPane();
        //BoxLayout box = new BoxLayout(layer, BoxLayout.PAGE_AXIS);
        //layer.setLayout(box);

        //horizontal glue
        layer.add(Box.createHorizontalGlue(), JLayeredPane.PALETTE_LAYER);

        //notif panel
        JPanel notifBox = new JPanel();
        notifBox.add(new JLabel("I'm a floating panel!"));
        notifBox.setBackground(new java.awt.Color(200, 200, 255));
        General.sizomatic(notifBox, 100, 100);
        layer.add(notifBox, JLayeredPane.PALETTE_LAYER);
    }

    //test extra layout
    public void extraLayout(){
        JFrame frame = new JFrame("OverlayLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel() {
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };
        panel.setLayout(new OverlayLayout(panel));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setAlignmentX(0.5f);
        bottomPanel.setAlignmentY(0.5f);
        General.sizomatic(bottomPanel, 300, 300);
        bottomPanel.add(new JLabel("Bottom Panel Text"));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.red);
        topPanel.setAlignmentX(0.5f);
        topPanel.setAlignmentY(0.5f);
        General.sizomatic(topPanel, 200, 200);
        topPanel.add(new JLabel("Top Panel Text"));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.yellow);
        panel3.setAlignmentX(0.5f);
        panel3.setAlignmentY(0.5f);
        General.sizomatic(panel3, 400, 100);
        panel3.add(new JLabel("Panel 3 Text"));

        panel.add(bottomPanel);
        panel.add(topPanel, 0);
        panel.add(panel3, 0);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
