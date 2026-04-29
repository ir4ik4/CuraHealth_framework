package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tarakanova.base.BasePage;

public class LoginPage extends BasePage {

     Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver) {
        super(driver);

    }
    private final By usernameField = By.id("txt-username");
    private final By passwordField = By.id("txt-password");
    private final By loginButton = By.id("btn-login");
    private final By errorMessage = By.cssSelector(".lead.text-danger");

    public String getErrorMessage() {
        String loginFailText = driver.findElement(errorMessage).getText().split("!")[0];
        return loginFailText;
    }

    public AppointmentPage login(String username, String password) {
        logger.info("Entering username");
       type(usernameField, username);
        logger.info("Entering password");
        type(passwordField, password);
        logger.info("Clicking login button");
        click(loginButton);
        return new AppointmentPage(driver);
    }


}
