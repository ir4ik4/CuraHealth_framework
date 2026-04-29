package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tarakanova.base.BasePage;

public class ConfirmationPage extends BasePage {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By pageTitle = By.tagName("h2");
    private final By facility = By.id("facility");
    private final By readmission = By.id("hospital_readmission");
    private final By healthcareProgram = By.id("program");
    private final By visitDate = By.id("visit_date");
    private final By comments = By.id("comment");

    public String getPageTitle() {
       return getText(pageTitle);

    }

    public String getFacility() {
        return getText(facility);
    }
    public String getReadmission() {
        return getText(readmission);
    }
    public String getHealthcareProgram() {
        return getText(healthcareProgram);
    }
    public String getVisitDate() {
        return getText(visitDate);
    }
    public String getComment() {
        return getText(comments);
    }

}
