package driverFactory;

import commonFunctions.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BrowserDriverManager {
    protected WebDriver driver;

    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        System.out.println("before: "+ driver.manage().window().getSize());
        System.out.println("before: "+ driver.manage().window().getPosition());
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setPosition(new Point(4,4));
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);

        System.out.println("before: "+ driver.manage().window().getSize());
        System.out.println("before: "+ driver.manage().window().getPosition());
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
