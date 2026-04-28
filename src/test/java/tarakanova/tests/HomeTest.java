package tarakanova.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;

import java.util.Objects;

public class HomeTest extends BaseTest {

    @Test
    public void userShouldLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getPageSource().contains("Make Appointment"));
    }
}
