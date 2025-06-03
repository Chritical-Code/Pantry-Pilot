package gui;

import pages.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class CLinkCredit extends CFlow{
    public CLinkCredit (String title, String link, String imagePath){
        //icon
        ImageIcon preIcon = new ImageIcon(Header.class.getResource(imagePath));
        Image preImage = preIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(preImage);
        JLabel iconHolder = new JLabel(icon);
        add(iconHolder);

        //icon link
        CLabel iconLink = new CLabel(String.format("<html><a href='%s'>%s</a></html>", link, title));
        iconLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconLink.addMouseListener(openLink(link));
        add(iconLink);

        //text
        CLabel iconText = new CLabel(" icon by ");
        add(iconText);

        //icons8 link
        CLabel icons8Link = new CLabel("<html><a href='https://icons8.com'>Icons8</a></html>");
        icons8Link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        icons8Link.addMouseListener(openLink("https://icons8.com"));
        add(icons8Link);
    }

    //Functions
    //open link
    public MouseAdapter openLink(String link){
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new java.net.URI(link));
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }
}
