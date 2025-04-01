package pages;

import gui.*;
import model.*;

public class ViewStock extends CPage {
    public ViewStock(){
        //flow: title
        CFlow f_title = new CFlow();
        add(f_title);
        CLabel title = new CLabel("View Stock");
        f_title.add(title);

        //flow: return
        CFlow f_return = new CFlow();
        add(f_return);
        CButton bManage = new CButton("Home");
        bManage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_home));
        f_return.add(bManage);
    }
}
