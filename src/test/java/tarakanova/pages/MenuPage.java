package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tarakanova.base.BasePage;

public class MenuPage  extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private final By menuButton = By.id("menu-toggle");
    private final By logoutButton = By.cssSelector("a[href*='logout']");

    public void logout(){
        click(menuButton);
        waitForVisibility(logoutButton);
        click(logoutButton);

    }
}
