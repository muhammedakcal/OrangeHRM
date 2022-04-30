package com.qa.cloudwise.base;



import com.qa.cloudwise.pages.GateKeeperPage;
import com.qa.cloudwise.pages.MenuPage;
import com.qa.cloudwise.pages.WaitingPage;
import com.qa.cloudwise.pages.WorkflowPage;


public class PageManager {


    public static MenuPage menuPage;
    public static WaitingPage waitingPage;
    public static WorkflowPage workflowPage;
    public static GateKeeperPage gatekeeperPage;


    /**
     * Initialize pages
     */
    public static void initialize() {
        menuPage = new MenuPage();
        waitingPage = new WaitingPage();
        workflowPage = new WorkflowPage();
        gatekeeperPage = new GateKeeperPage();

    }
}
