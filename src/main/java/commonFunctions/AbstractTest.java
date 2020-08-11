package commonFunctions;

import driverFactory.BrowserDriverManager;
import driverFactory.DriverFactoryManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import reportConfig.VerificationFailures;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    protected final Log log;
    BrowserDriverManager driverManager;

    public AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    private WebDriver driver;
    ChromeOptions option;


    public WebDriver getBrowserDriverFromFactory(String browser){
        driverManager = DriverFactoryManager.getDriverManager(browser);
        return driver = driverManager.getDriver();
    }

    public WebDriver getBrowserDriver(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().arch64().setup();
            driver = new EdgeDriver();
        } else if (browser.equals("ie")) {
            WebDriverManager.iedriver().arch64().setup();
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Please select your browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
        return driver;
    }

    public int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

    public void printCurrentTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss.SSS");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
    }

    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    protected void closeBrowserAndDriver(WebDriver driver) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String cmd = "";
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }

            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            sleepInSecond(2);

            log.info("---------- QUIT BROWSER SUCCESS ----------");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    protected void printBrowserConsoleLogs(WebDriver driver) {
        LogEntries logs = driver.manage().logs().get("browser");
        List<LogEntry> logList = logs.getAll();
        for (LogEntry logging : logList) {
            System.out.println("--------" + logging.getLevel().toString() + "---------\n" + logging.getMessage());
        }
    }

    public long getCurrentUnixTime() {
        return Instant.now().getEpochSecond();
    }

    @BeforeSuite
    public void deleteAllFilesInReportNGScreenshot() {
       log.info("-----START delete file in folder-----");
        String workingDir = System.getProperty("user.dir");
        String pathFolderDownload = workingDir + "\\ReportNGScreenshots";
        deleteAllFileInFolder(pathFolderDownload);
        log.info("-----END delete file in folder-----");
    }

    public void deleteAllFileInFolder(String pathFolderDownload) {
        try {
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0;i< listOfFiles.length;i++) {
                if (listOfFiles[i].isFile()) {
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
    public static void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
