package tarakanova.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driver;
    }


    @BeforeMethod
    public void setUp() {

        logger.info("Launching browser");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        logger.info("Opening CURA application");

        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
