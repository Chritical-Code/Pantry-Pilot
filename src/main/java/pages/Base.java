package pages;

import gui.CPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        frame.setSize(600, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //initialize page static variables
        CPage.cardLayout = cardLayout;
        CPage.mainPanel = mainPanel;

        //Create each page
        Home home = new Home();
        ViewStock viewStock = new ViewStock();
        InOut inOut = new InOut();
        Manage manage = new Manage();

        //add pages to main panel
        mainPanel.add(home, CPage.p_home);
        mainPanel.add(viewStock, CPage.p_viewStock);
        mainPanel.add(manage, CPage.p_manage);
        mainPanel.add(inOut, CPage.p_inOut);

        /*//set default page
        cardLayout.show(mainPanel, "Home");

        // Add a KeyListener to the panel
        frame.setFocusable(true); // Make sure the panel can receive key events
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // This method is called when a key is pressed
                System.out.println("Key Pressed: " + e.getKeyCode());
            }
        });*/
    }
}
