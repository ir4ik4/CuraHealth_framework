package tarakanova.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.AppointmentPage;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithInvalidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickMakeAppointment();
        AppointmentPage appointmentPage = loginPage.login("John ", "ThisIsAPassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Login failed");
     }

}
