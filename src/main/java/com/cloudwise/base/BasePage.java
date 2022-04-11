package com.cloudwise.base;


import com.cloudwise.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;



import java.util.concurrent.TimeUnit;

public class BasePage {


    public static boolean highlightElement;
    public static boolean drowBorderOnElement;
    public static WebDriver driver;

    /**
     * - Driver Initializing to execute the test on selected browser
     * - Please take in account that, this configuration can not be supported by the remote webdriver which is used for the pipeline execution
     * - This project was created for the Cloudwise Company's Assignment
     *
     * @return - driver
     * @author - Muhammed Akcal
     */
    public static WebDriver initializeDriver() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILE);
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        highlightElement = ConfigReader.getProperty("highlight").equals("yes");
        drowBorderOnElement = ConfigReader.getProperty("drowborder").equals("yes");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(OptionsManager.getChromeOptions());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
                break;

            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name...!");
        }

        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        PageManager.initialize();
        return driver;
    }


    /**Close the browser at the end of the test*/
    public static void tearDown() {if (driver != null) {driver.quit();}

    }

}
