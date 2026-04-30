package tarakanova.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.AppointmentPage;
import tarakanova.pages.ConfirmationPage;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;
import tarakanova.utils.RetryAnalyzer;


public class AppointmentTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userShouldBookAppointment(){
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =  homePage.clickMakeAppointment();
        AppointmentPage appointmentPage = loginPage.login("John Doe", "ThisIsNotAPassword");

        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.clickReadmissionCheckbox();
        appointmentPage.selectMedicaid();
        appointmentPage.enterVisitDate("30/05/2026");
        appointmentPage.enterComment("First automation appointment test");

        ConfirmationPage confirmationPage = appointmentPage.clickBookAppointment();

        Assert.assertEquals(confirmationPage.getPageTitle(), "Appointment Confirmation");
        Assert.assertEquals(confirmationPage.getFacility(), "Hongkong CURA Healthcare Center");
        Assert.assertEquals(confirmationPage.getReadmission(), "Yes");
        Assert.assertEquals(confirmationPage.getHealthcareProgram(), "Medicaid");
        Assert.assertEquals(confirmationPage.getVisitDate(), "30/05/2026");
        Assert.assertEquals(confirmationPage.getComment(), "First automation appointment test");
    }
}
