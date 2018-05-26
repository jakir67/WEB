import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Base {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());

   // public static String screenShotLocation="C:\Users\SQLDBA\IdeaProjects\WEB\Application\src\test\TestResult\Screenshot";
    @Parameters({"useSauceLab", "userName", "key", "appUrl", "os", "browserName", "browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab, String userName, String key, String appUrl, String os, String browserName, String browserVersion) throws IOException {
        if (useSauceLab == true) {
            //getSauceLabDriver(userName, key, os, browserName, browserVersion);
        } else {
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appUrl);
        //driver.manage().window().maximize();
        log.info("browser loaded with App");
    }


    //@AfterMethod
    //public void cleanUp() throws InterruptedException, IOException {
      //  TakesScreenshot scrShot =((TakesScreenshot)driver);
      //  File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

      //  File DestFile = new File(screenShotLocation);
      //  FileUtils.copyFile(SrcFile, DestFile);

      //  log.info("driver is quiting");
      //  driver.quit();
    //}

    //get local driver
    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            //driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "");
            } else {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\User6\\Desktop\\My Web\\WEB\\Generic\\src\\resource\\driver\\chromedriver");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            //driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "");
            //driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("htmlunit")) {
            //driver = new HtmlUnitDriver();
        }
        return driver;
    }
}