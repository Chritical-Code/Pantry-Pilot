package gui;

import java.awt.*;

//General properties for use in GUI class
public class General {
    //theme colors
    public static Color vanilla = new Color(255, 251, 239);
    public static Color lightBlue = new Color(135, 219, 255);
    public static Color clear = new Color(0, 0, 0, 0);
    public static Color cream = new Color(255, 225, 142);
    //form button colors
    public static Color green = new Color(123, 244, 102);
    public static Color red = new Color(255, 86 ,86);
    public static Color yellow = new Color(255, 225, 102);
    public static Color orange = new Color(255, 154, 86);
    //fonts
    public static Font mainFont = new Font("Arial", Font.PLAIN, 16);
    public static Font mainFontBold = new Font("Arial", Font.BOLD, 16);

    //Functions
    //set the size of a component
    public static void sizomatic(Component component, int width, int height){
        Dimension dim = new Dimension(width, height);
        component.setMinimumSize(dim);
        component.setMaximumSize(dim);
        component.setPreferredSize(dim);
    }
}
