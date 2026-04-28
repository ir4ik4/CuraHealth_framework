package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
     WebDriver driver;
    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By facilityDropdown = By.id("combo_facility");
    private final By hospitalReadmission = By.cssSelector(".checkbox-inline");
    private final By healthcareProgram = By.id("radio_program_medicaid");
    private final By visitDateField = By.id("txt_visit_date");
    private final By commentField = By.id("txt_comment");
    private final By bookAppointmentButton = By.id("btn-book-appointment");


    public void selectFacility(String facility) {
        Select select = new Select(driver.findElement(facilityDropdown));
        select.selectByVisibleText(facility);
    }

    public void clickReadmissionCheckbox() {
        driver.findElement(hospitalReadmission).click();
    }
    public void selectMedicaid(){
        driver.findElement(healthcareProgram).click();
    }
    public void enterVisitDate(String date){
        driver.findElement(visitDateField).sendKeys(date);
    }
    public void enterComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickBookAppointment() {
        driver.findElement(bookAppointmentButton).click();
    }

}
