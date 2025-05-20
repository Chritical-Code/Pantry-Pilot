package gui;

import javax.swing.*;
import java.awt.*;

public class CTextField extends JTextField {
    public CTextField(int size){
        //set font
        super(size);
        setFont(General.mainFont);
    }
}
