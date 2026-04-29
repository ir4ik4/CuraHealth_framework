package tarakanova.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;
import tarakanova.pages.MenuPage;
import tarakanova.utils.TestListener;

@Listeners(TestListener.class)
public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage =  homePage.clickMakeAppointment();
        loginPage.login("John Doe", "ThisIsNotAPassword");

        MenuPage menuPage = new MenuPage(driver);
        menuPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("katalon-demo-cura"));

    }
}
