package com.qa.cloudwise.pages;

import org.joda.time.DateTime;

public class Deneme {

    public static void main (String[] args) throws InterruptedException {
        DateTime dt = new DateTime();
        System.out.println(dt.getSecondOfDay());
        Thread.sleep(1000);


        DateTime dt2 = new DateTime();
        System.out.println(dt2.getSecondOfDay());
        Thread.sleep(2000);

        DateTime dt3 = new DateTime();
        System.out.println(dt3.getSecondOfDay());
        Thread.sleep(3000);

        DateTime dt4 = new DateTime();
        System.out.println(dt4.getSecondOfDay());
    }
}
