package driverFactory;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BrowserDriverManager extends AbstractTest {
    protected WebDriver driver;
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            createDriver();
        }
        threadLocalDriver.get().manage().window().setSize(new Dimension(1920, 1080));
        threadLocalDriver.get().manage().window().setPosition(new Point(0, 0));
        threadLocalDriver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
        log.info("Set window size " + threadLocalDriver.get().manage().window().getSize());
        log.info("Set window position " + threadLocalDriver.get().manage().window().getPosition());
        return threadLocalDriver.get();
    }

    public WebDriver getDriverForWriteLog() {
        return threadLocalDriver.get();
    }

    public void quitDriver() {
        if (threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.set(null);
        }
    }

}
