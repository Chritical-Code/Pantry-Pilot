package gui;

import pages.Header;

import javax.swing.*;
import java.awt.*;

public class CButtonIcon extends JButton {
    public CButtonIcon(String imagePath){
        //image
        ImageIcon preHomeIcon = new ImageIcon(Header.class.getResource(imagePath));
        Image preHomeImage = preHomeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon homeIcon = new ImageIcon(preHomeImage);
        setIcon(homeIcon);

        //general
        setFocusPainted(false);
        setBackground(General.lightBlue);
        General.sizomatic(this, 50, 50);
    }
}
