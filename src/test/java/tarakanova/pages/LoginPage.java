package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
     WebDriver driver;
     Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By usernameField = By.id("txt-username");
    private final By passwordField = By.id("txt-password");
    private final By loginButton = By.id("btn-login");

    public void login(String username, String password) {
        logger.info("Entering username");
        driver.findElement(usernameField).sendKeys(username);
        logger.info("Entering password");
        driver.findElement(passwordField).sendKeys(password);
        logger.info("Clocking login button");
        driver.findElement(loginButton).click();
    }


}
