package gui;

import javax.swing.*;
import java.awt.*;

//Each display page of this application is an extended CPage, which is an extended JPanel
//Each page will be defined and formatted in its own class
public class CPage extends JPanel {
    public static CardLayout cardLayout;
    public static JPanel mainPanel;

    //page names
    public static String p_home = "Home";
    public static String p_viewStock = "ViewStock";
    public static String p_manage = "Manage";
    public static String p_inOut = "InOut";

    public CPage(){
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);
        setBackground(General.vanilla);
    }
}
