package com.qa.testutilities;

import com.qa.base.PageManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.qa.base.BasePage.driver;

public class TestUtil extends PageManager {

    private static String getTimeStamp() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    }

    /**
     * Take screenshot and save it
     * @param filename - file name
     * @return - picBytes
     */

    public static byte[] takeScreenshot(String filename) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File file = ts.getScreenshotAs(OutputType.FILE);
        // create destination as : filepath + filename + timestamp + .png
        String destination = System.getProperty("user.dir") + "/screenshot/" + filename + getTimeStamp() + ".png";

        try {

            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {

            e.printStackTrace();
        }

        return picBytes;
    }


}
