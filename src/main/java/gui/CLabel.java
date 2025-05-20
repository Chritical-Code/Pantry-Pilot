package gui;

import javax.swing.*;
import java.awt.*;

//Customized version of JLabel
public class CLabel extends JLabel {
    public CLabel(String inText){
        super(inText);
        setFont(General.mainFont);
    }
}
