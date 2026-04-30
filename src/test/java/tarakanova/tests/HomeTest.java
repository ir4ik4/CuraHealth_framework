package tarakanova.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;
import tarakanova.utils.RetryAnalyzer;


public class HomeTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userShouldLogin(){
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickMakeAppointment();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getPageSource().contains("Make Appointment"));
    }
}
