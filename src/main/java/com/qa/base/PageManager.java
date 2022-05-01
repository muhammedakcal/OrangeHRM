package com.qa.base;
import com.qa.pages.GateKeeperPage;
import com.qa.pages.MenuPage;
import com.qa.pages.WaitingPage;
import com.qa.pages.WorkflowPage;


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
