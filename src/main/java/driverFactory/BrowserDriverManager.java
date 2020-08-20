package driverFactory;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BrowserDriverManager extends AbstractTest {
    protected WebDriver driver;

    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
        log.info("Set window size " + driver.manage().window().getSize());
        log.info("Set window position " + driver.manage().window().getPosition());
        return driver;
    }

    public WebDriver getDriverForWriteLog() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
