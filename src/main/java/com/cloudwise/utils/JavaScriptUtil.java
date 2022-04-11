package com.cloudwise.utils;

import error.TestToolException;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;


import static com.cloudwise.base.BasePage.driver;

import static com.cloudwise.utils.HelperMethods.printInfo;


public class JavaScriptUtil {

    public static void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element);// 1
            changeColor(bgcolor, element);// 2
        }
    }


    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        try {
            js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
            Thread.sleep(20);
        } catch (InterruptedException e) {

            throw new TestToolException("Some error occured while changing the coler: " + e.getCause());
        }

    }

    public static void drawBorder(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }


    public static void generateAlert(String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }


    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);

    }

    public static void refreshBrowserByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return document.title;").toString();
    }

    public static String getPageInnerText() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return document.documentElement.innerText;").toString();
    }

    public static void scrollPageDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,-450)");
    }

    public static void scrollPageTillTheEnd() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getBrowserInfo() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return navigator.userAgent;").toString();
    }

    public static void sendKeysUsingJSWithId(String id, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
    }

    public static void sendKeysUsingJSWithName(String name, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
    }


    public static void checkPageIsReady(String methodName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            printInfo(methodName + " is loaded!");
        }

    }
}
