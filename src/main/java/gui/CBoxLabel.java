package gui;

import javax.swing.*;
import java.awt.*;

public class CBoxLabel extends JPanel {
    public CLabel label;

    public CBoxLabel(String text){
        //settings
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(General.clear);

        //flow: label
        CBoxFlow f_label = new CBoxFlow();
        add(f_label);
        //label
        label = new CLabel(text);
        label.setFont(General.mainFontBold);
        f_label.add(label);

    }
}
