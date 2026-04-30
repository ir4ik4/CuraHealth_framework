package tarakanova.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.AppointmentPage;
import tarakanova.pages.ConfirmationPage;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;
import tarakanova.utils.RetryAnalyzer;

import java.time.Duration;

public class AppointmentTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userShouldBookAppointment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();

        LoginPage loginPage =  homePage.clickMakeAppointment();
        AppointmentPage appointmentPage = loginPage.login("John Doe", "ThisIsNotAPassword");

        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.clickReadmissionCheckbox();
        appointmentPage.selectMedicaid();
        appointmentPage.enterVisitDate("30/05/2026");
        appointmentPage.enterComment("First automation appointment test");
        appointmentPage.clickBookAppointment();
        WebElement goHomeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-default")));
        Assert.assertTrue(goHomeButton.isDisplayed());

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        Assert.assertEquals(confirmationPage.getPageTitle(), "Make Appointment");
        Assert.assertEquals(confirmationPage.getFacility(), "Hongkong CURA Healthcare Center");
        Assert.assertEquals(confirmationPage.getReadmission(), "Yes");
        Assert.assertEquals(confirmationPage.getHealthcareProgram(), "Medicaid");
        Assert.assertEquals(confirmationPage.getVisitDate(), "30/05/2026");
        Assert.assertEquals(confirmationPage.getComment(), "First automation appointment test");
    }
}
