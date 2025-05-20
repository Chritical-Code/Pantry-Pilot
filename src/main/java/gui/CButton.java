package gui;

import javax.swing.*;
import java.awt.*;

public class CButton extends JButton {
    //constructor
    public CButton(String defaultText){
        super(defaultText);
        setFocusPainted(false);
        setBackground(General.lightBlue);
        setFont(General.mainFontBold);
    }

    //Functions
}
