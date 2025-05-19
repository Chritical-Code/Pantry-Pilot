package gui;

import javax.swing.*;

//like a flow except using boxlayout instead of flow layout
public class CBoxFlow extends JPanel {
    public CBoxFlow(){
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(General.clear);
    }
}
