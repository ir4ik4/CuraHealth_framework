package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By makeApppointment = By.id("btn-make-appointment");

    public void clickMakeAppointment() {
        driver.findElement(makeApppointment).click();
    }

}
