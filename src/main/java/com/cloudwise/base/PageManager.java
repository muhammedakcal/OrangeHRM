package com.cloudwise.base;

import com.cloudwise.pages.*;
import com.cloudwise.utils.HelperMethods;

public class PageManager {

    public static MenuPage menuPage;
    public static WaitingPage waitingPage;
    public static WorkflowPage workflowPage;
    public static HelperMethods helperMethods;
    public static GatekeeperPage gatekeeperPage;



    // initialize pages
    public static void initialize() {
        menuPage = new MenuPage();
        waitingPage = new WaitingPage();
        workflowPage = new WorkflowPage();
        helperMethods = new HelperMethods();
        gatekeeperPage = new GatekeeperPage();

    }
}
