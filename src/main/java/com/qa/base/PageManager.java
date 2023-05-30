package com.qa.base;
import com.qa.pages.LoginPage;
import com.qa.utils.Waiting;


public class PageManager {


    public static LoginPage loginPage;


    /**
     * Initialize pages
     */
    public static void initialize() {
        loginPage = new LoginPage();


    }
}
