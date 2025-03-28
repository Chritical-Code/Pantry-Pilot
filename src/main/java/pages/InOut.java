package pages;

import gui.CButton;
import gui.CFlow;
import gui.CLabel;
import gui.CPage;

public class InOut extends CPage {
    public InOut(){
        //flow: title
        CFlow f_title = new CFlow();
        add(f_title);
        CLabel title = new CLabel("I/O");
        f_title.add(title);

        //flow: return
        CFlow f_return = new CFlow();
        add(f_return);
        CButton bManage = new CButton("Home");
        bManage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_home));
        f_return.add(bManage);
    }
}
