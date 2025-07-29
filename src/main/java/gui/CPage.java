package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

//Each display page of this application is an extended CPage, which is an extended JPanel
//Each page will be defined and formatted in its own class
public class CPage extends JPanel {
    //Variables
    //general
    public static CardLayout cardLayout;
    public static JPanel mainPanel;
    public static JFrame frame;
    //page names
    public static String p_home = "Home";
    public static String p_inventory = "Inventory";
    public static String p_products = "Products";
    public static String p_inOut = "InOut";
    public static String p_about = "About";

    //Constructor
    public CPage(){
        //settings
        BoxLayout box = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(box);
        setBackground(General.vanilla);

        //events
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                //do nothing
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                //do nothing
            }

            @Override
            public void componentShown(ComponentEvent e) {
                //reset page, load page
                reset();
                loadContent();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                //reset page
                reset();
            }
        });
    }

    //Functions
    //reset
    public void reset(){
        //clear panel
        removeAll();
        revalidate();
        repaint();
    }

    //load content
    public void loadContent(){
        //load page content
        System.out.println("Load content... OVERRIDE ME");
    }
}
