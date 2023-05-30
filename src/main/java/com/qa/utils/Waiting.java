package com.qa.utils;

import com.qa.TestToolException;

public class Waiting {

    /**
     * Wait for a certain number of seconds
     * @param waitingTime - seconds
     */
    public static void waitForSeconds(int waitingTime) {
        try {
            Thread.sleep(waitingTime * 1000L);
        } catch (InterruptedException e) {
            throw new TestToolException("Some error occured while waiting for " + waitingTime + "seconds: " + e.getCause());
        }
    }


    /**
     * Wait for a certain number of minutes
     * @param waitingTime - minutes
     */
    public static void waitForMinutes(int waitingTime) {
        try {
            Thread.sleep(waitingTime * 10000L);
        } catch (InterruptedException e) {
            throw new TestToolException("Some error occured while waiting for " + waitingTime + "minutes: " + e.getCause());
        }

    }
}