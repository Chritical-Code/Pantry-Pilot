package gui;

import javax.swing.*;
import java.awt.*;

public class CBoxLabel extends JPanel {
    public CLabel label;

    public CBoxLabel(String text){
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);

        label = new CLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);
    }
}
