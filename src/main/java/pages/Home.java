package pages;

import gui.CButton;
import gui.CFlow;
import gui.CLabel;
import gui.CPage;

public class Home extends CPage {
    public Home(){
        //Header
        CFlow f_title = new CFlow();
        add(f_title);
        //Label 1
        CLabel b1_label = new CLabel("Pantry Pilot");
        f_title.add(b1_label);

        //Row 1 icons
        CFlow f_nav1 = new CFlow();
        add(f_nav1);
        //page: view stock
        CButton bViewStock = new CButton("View Stock");
        bViewStock.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_viewStock));
        f_nav1.add(bViewStock);
        //page: I/O
        CButton bInOut = new CButton("I/O");
        bInOut.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_inOut));
        f_nav1.add(bInOut);
        //page: manage
        CButton bManage = new CButton("Manage");
        bManage.addActionListener(e -> cardLayout.show(mainPanel, CPage.p_manage));
        f_nav1.add(bManage);
    }
}