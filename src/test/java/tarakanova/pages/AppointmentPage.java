package tarakanova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import tarakanova.base.BasePage;

public class AppointmentPage extends BasePage {
     WebDriver driver;
    public AppointmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By facilityDropdown = By.id("combo_facility");
    private final By hospitalReadmission = By.cssSelector(".checkbox-inline");
    private final By healthcareProgram = By.id("radio_program_medicaid");
    private final By visitDateField = By.id("txt_visit_date");
    private final By commentField = By.id("txt_comment");
    private final By bookAppointmentButton = By.id("btn-book-appointment");
    private final By confirmationTitle =
            By.xpath("//h2[text()='Appointment Confirmation']");


    public void selectFacility(String facility) {
        Select select = new Select(driver.findElement(facilityDropdown));
        select.selectByVisibleText(facility);
    }

    public void clickReadmissionCheckbox() {
        click(hospitalReadmission);
    }
    public void selectMedicaid(){
       click(healthcareProgram);
    }
    public void enterVisitDate(String date){
       type(visitDateField, date);
    }
    public void enterComment(String comment){
        type(commentField, comment);
    }
    public ConfirmationPage clickBookAppointment() {
       click(bookAppointmentButton);
        waitForVisibility(confirmationTitle);
        return new ConfirmationPage(driver);
    }

}
