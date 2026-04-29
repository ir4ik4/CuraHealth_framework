package tarakanova.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tarakanova.base.BaseTest;
import tarakanova.pages.HomePage;
import tarakanova.pages.LoginPage;
import tarakanova.utils.JsonDataReader;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String username, String password) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickMakeAppointment();
       loginPage.login(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), "Login failed");
     }

     @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() throws FileNotFoundException {
        return JsonDataReader.getInvalidLoginData();
        }
     }


