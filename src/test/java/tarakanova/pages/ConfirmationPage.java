package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pageTitle = By.tagName("h2");
    private final By facility = By.id("facility");
    private final By readmission = By.id("hospital_readmission");
    private final By healthcareProgram = By.id("program");
    private final By visitDate = By.id("visit_date");
    private final By comments = By.id("comment");

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getFacility() {
        return driver.findElement(facility).getText();
    }
    public String getReadmission() {
        return driver.findElement(readmission).getText();
    }
    public String getHealthcareProgram() {
        return driver.findElement(healthcareProgram).getText();
    }
    public String getVisitDate() {
        return driver.findElement(visitDate).getText();
    }
    public String getComment() {
        return driver.findElement(comments).getText();
    }





}
