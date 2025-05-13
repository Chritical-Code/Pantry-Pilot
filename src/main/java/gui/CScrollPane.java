package gui;

import javax.swing.*;
import java.awt.*;

public class CScrollPane extends JScrollPane {
    public CScrollPane(Component component){
        super(component);

        //settings
        setPreferredSize(new Dimension(550, 200));
        getViewport().setBackground(General.vanilla);
        getVerticalScrollBar().setBackground(General.vanilla);
    }
}
