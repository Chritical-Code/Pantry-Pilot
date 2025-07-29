package pages;

import gui.CPage;

import javax.swing.*;
import java.awt.*;

//This is the base upon which pages are placed
//Does not extend CPage
public class Base {
    public Base(){
        //card layout
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        //JFrame setup
        JFrame frame = new JFrame();
        frame.add(mainPanel);
        frame.setTitle("Pantry Pilot");
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //initialize page static variables
        CPage.cardLayout = cardLayout;
        CPage.mainPanel = mainPanel;
        CPage.frame = frame;

        //Create each page
        Home home = new Home();
        Inventory inventory = new Inventory();
        InOut inOut = new InOut();
        Products products = new Products();
        About about = new About();

        //add pages to main panel
        mainPanel.add(home, CPage.p_home);
        mainPanel.add(inventory, CPage.p_inventory);
        mainPanel.add(products, CPage.p_products);
        mainPanel.add(inOut, CPage.p_inOut);
        mainPanel.add(about, CPage.p_about);

        //set default page
        cardLayout.show(mainPanel, "Home");
    }
}
