package gui;

import javax.swing.*;
import java.awt.*;

public class CBoxLabel extends JPanel {
    public CLabel label;

    public CBoxLabel(String text){
        //settings
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(General.clear);

        //layout
        label = new CLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);

    }
}
