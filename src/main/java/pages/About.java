package pages;

import gui.*;
import javax.swing.*;

public class About extends CPage {
    //Page Content
    @Override
    public void loadContent(){
        //header
        add(new Header("About"));

        //vertical glue
        add(Box.createVerticalGlue());

        //home credits
        CLinkCredit home = new CLinkCredit("Home", "https://icons8.com/icon/73/home", "/icons/home-icon.png");
        add(home);

        //about credits
        CLinkCredit about = new CLinkCredit("Question Mark", "https://icons8.com/icon/6644/question-mark", "/icons/about-icon.png");
        add(about);

        //settings credits
        CLinkCredit settings = new CLinkCredit("Settings", "https://icons8.com/icon/364/settings", "/icons/settings-icon.png");
        add(settings);

        //notif credits
        CLinkCredit notif = new CLinkCredit("Notifications", "https://icons8.com/icon/nJRLlq8KqcX5/notifications", "/icons/notifications-icon.png");
        add(notif);

        //vertical glue
        add(Box.createVerticalGlue());
    }
}
