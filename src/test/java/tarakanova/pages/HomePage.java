package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tarakanova.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By makeAppointment = By.id("btn-make-appointment");

    public LoginPage clickMakeAppointment() {
        click(makeAppointment);
        return new LoginPage(driver);
    }


}
