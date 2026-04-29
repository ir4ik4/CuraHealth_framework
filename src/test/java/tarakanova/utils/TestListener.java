package tarakanova.utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import tarakanova.base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Listeners(TestListener.class)
public class TestListener implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentReportManager
                .getReport()
                .createTest(result.getName());

        test.info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.getReport().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        System.out.println("Failed parameters: " + java.util.Arrays.toString(result.getParameters()));
        System.out.println("Failure reason: " + result.getThrowable().getMessage());


        try{
            BaseTest baseTest = (BaseTest) result.getInstance();
            File screenshot =
                    ((TakesScreenshot) baseTest.getDriver()).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/"
                    + result.getName()
                    + "_"
                    + System.currentTimeMillis()
                    + ".png";

            Files.copy(screenshot.toPath(), Paths.get(path));
            System.out.println("Screenshot saved at: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
