package tarakanova.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.AppointmentPage;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;

import java.time.Duration;

public class AppointmentTest extends BaseTest {

    @Test
    public void userShouldBookAppointment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.clickReadmissionCheckbox();
        appointmentPage.selectMedicaid();
        appointmentPage.enterVisitDate("30/05/2026");
        appointmentPage.enterComment("Looking forward to my appointment!");
        appointmentPage.clickBookAppointment();
        WebElement goHomeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-default")));

        Assert.assertTrue(goHomeButton.isDisplayed());
    }
}
