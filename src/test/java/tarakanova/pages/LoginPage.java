package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
     WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By usernameField = By.id("txt-username");
    private final By passwordField = By.id("txt-password");
    private final By loginButton = By.id("btn-login");

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }


}
