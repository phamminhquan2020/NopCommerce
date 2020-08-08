package reportConfig;

import commonFunctions.AbstractTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportNGListener extends AbstractTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
      log.info("---------- " + context.getName() + " STARTED test----------");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("---------- " + context.getName() + " FINISHED test----------");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("---------- " + result.getName() + " STARTED test case----------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("---------- " + result.getName() + " SUCCESS test case----------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("---------- " + result.getName() + " FAILED test case----------");
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Object testClass = result.getInstance();
        log.info(testClass.toString());
        WebDriver driver = ((AbstractTest) testClass).getDriver();
        log.info(driver.toString());

        String screenshotPath = captureScreenshot(driver, result.getName());

        Reporter.getCurrentTestResult();
        Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
        Reporter.setCurrentTestResult(null);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("---------- " + result.getName() + " SKIPPED test case----------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("---------- " + result.getName() + " FAILED WITH SUCCESS PERCENTAGE test case----------");
    }

    public String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenPath = System.getProperty("user.dir") + "/ReportNGScreenShots/" + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
            FileUtils.copyFile(source, new File(screenPath));
            return screenPath;
        } catch (IOException e) {
            log.error("Exception while taking screenshot: " + e.getMessage());
            return e.getMessage();
        }
    }

}