package commonFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import commonUIs.UserAbstractPageUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private Alert alert;
    private WebElement element;
    private Select select;
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
    private List<WebElement> elements;
    private Actions action;

    public boolean isPageLoaded(String pageUrl) {
        return false;
    }

    public void navigatePageUrl(WebDriver driver, String url) {
        driver.get(url);
        if (driver.toString().contains("internet explorer")) {
            sleepInSecond(5);
        }
    }

    public void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
        if (driver.toString().contains("internet explorer")) {
            sleepInSecond(5);
        }
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
        if (driver.toString().contains("internet explorer")) {
            sleepInSecond(5);
        }
    }

    public void fowardToPage(WebDriver driver) {
        driver.navigate().forward();
        if (driver.toString().contains("internet explorer")) {
            sleepInSecond(5);
        }
    }

    public void waitAlertPresent(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresent(driver);
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresent(driver);
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText(WebDriver driver) {
        waitAlertPresent(driver);
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        driver.switchTo().defaultContent();
        return alertText;
    }

    public void sendkeyToAlert(WebDriver driver, String text) {
        waitAlertPresent(driver);
        alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (window.equals(parentID)) {
                driver.switchTo().window(window);
                break;
            }

        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentID)) {
                driver.switchTo().window(window);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    public WebElement find(WebDriver driver, String xpathValue) {
        return driver.findElement(By.xpath(xpathValue));
    }

    public List<WebElement> finds(WebDriver driver, String xpathValue) {
        return driver.findElements(byXpath(xpathValue));
    }

    public By byXpath(String xpathValue) {
        return By.xpath(xpathValue);
    }

    public void clickToElement(WebDriver driver, String xpathValue) {
        if (driver.toString().contains("internet explorer")) {
            clickToElementByJS(driver, xpathValue);
            sleepInSecond(5);
        } else {
            find(driver, xpathValue).click();
        }
    }

    public void clickToElement(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        if (driver.toString().contains("internet explorer")) {
            clickToElementByJS(driver, xpathValue);
            sleepInSecond(5);
        } else {
            find(driver, xpathValue).click();
        }
    }

    public void sendkeyToElementHaveDefaultText(WebDriver driver, String xpathValue, String text) {
        element = find(driver, xpathValue);
        action = new Actions(driver);
        action.sendKeys(element, Keys.CONTROL, "a", text);
//		element.clear();
//		element.sendKeys(text);
    }

    public void sendkeyToElement(WebDriver driver, String xpathValue, String text) {
        element = find(driver, xpathValue);
        element.clear();
        element.sendKeys(text);
    }

//	public void clearTextOfElement(WebDriver driver, String xpathValue) {
//		action.sendKeys(find(driver, xpathValue), Keys.CONTROL, "a", Keys.DELETE);
//	}

    public void sendkeyToElement(WebDriver driver, String xpathValue, String text, String... value) {
        xpathValue = castToRestParam(xpathValue, value);
        element = find(driver, xpathValue);
        element.clear();
        action = new Actions(driver);
        action.sendKeys(element, Keys.CONTROL, "a", Keys.DELETE);
        element.sendKeys(text);
    }

    public void selectOptionInDropdown(WebDriver driver, String xpathValue, String option) {
        select = new Select(find(driver, xpathValue));
        select.selectByVisibleText(option);
    }

    public void selectOptionInDropdown(WebDriver driver, String xpathValue, String option, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        select = new Select(find(driver, xpathValue));
        select.selectByVisibleText(option);
    }

    public String getSelectedItemInDropDown(WebDriver driver, String xpathValue) {
        select = new Select(find(driver, xpathValue));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpathValue) {
        select = new Select(find(driver, xpathValue));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        find(driver, parentLocator).click();
        sleepInSecond(1);

        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));

        elements = finds(driver, childItemLocator);

        for (WebElement item : elements) {
            if (item.getText().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementAttributeValue(WebDriver driver, String xpathValue, String attributeName) {
        return find(driver, xpathValue).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).getText();
    }

    public String getElementText(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        return find(driver, xpathValue).getText();
    }

    public int countElementNumber(WebDriver driver, String xpathValue) {
        return finds(driver, xpathValue).size();
    }

    public int countElementNumber(WebDriver driver, String xpathValue, String... values) {
        return finds(driver, castToRestParam(xpathValue, values)).size();
    }

    public void checkToCheckBox(WebDriver driver, String xpathValue) {
        element = find(driver, xpathValue);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(WebDriver driver, String xpathValue) {
        element = find(driver, xpathValue);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathValue) {
        try {
            return find(driver, xpathValue).isDisplayed();

        } catch (Exception e) {
            return false;
        }

    }

    public boolean isElementDisplayed(WebDriver driver, String xpathValue, String... values) {
        try {
            return find(driver, castToRestParam(xpathValue, values)).isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void overrideGlobalTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public boolean isElementUnDisplayed(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME_OUT);
        List<WebElement> elements = finds(driver, xpathValue);
        if (elements.size() == 0) {
            System.out.println("Elements not in DOM");
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Elements in DOM but not displayed");
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
            return true;

        } else {
            System.out.println("Elements in DOM and displayed");
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
            return false;
        }

    }

    public void waitElementNotPresence(WebDriver driver, String xpathValue) {
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathValue)));
    }

    public boolean isElementEnabled(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).isSelected();
    }

    public void switchToFrame(WebDriver driver, String xpathValue) {
        driver.switchTo().frame(find(driver, xpathValue));
    }

    public void switchToDedaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String xpathValue) {
        action = new Actions(driver);
        action.moveToElement(find(driver, xpathValue)).perform();
    }

    public void hoverToElement(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        action = new Actions(driver);
        action.moveToElement(find(driver, xpathValue)).perform();
    }

    public void sendkeyBoardToElement(WebDriver driver, String xpathValue, Keys key) {
        action = new Actions(driver);
        action.sendKeys(find(driver, xpathValue), key);

    }

    public void sendkeyBoardToElement(WebDriver driver, String xpathValue, Keys key, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        action = new Actions(driver);
        action.sendKeys(find(driver, xpathValue), key);

    }

    public Object executeForBrowser(WebDriver driver, String javaSript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaSript);
    }

    public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
        if (driver.toString().contains("internet explorer")) {
            sleepInSecond(5);
        }
    }

    public void highlightElement(WebDriver driver, String xpathValue) {
        element = find(driver, xpathValue);
        String originalStyle = element.getAttribute("style");
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

    }

    public void clickToElementByJS(WebDriver driver, String xpathValue) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", find(driver, xpathValue));
    }

    public void clickToElementByJS(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", find(driver, xpathValue));
    }

    public void scrollToElement(WebDriver driver, String xpathValue) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, xpathValue));
    }

    public void scrollToElementAtCenter(WebDriver driver, String xpathValue) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto',block: 'center',inline: 'center'});", find(driver, xpathValue));

    }

    public void sendkeyToElementByJS(WebDriver driver, String xpathValue, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, xpathValue));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathValue));
    }

    public void addAttributeInDOM(WebDriver driver, String xpathValue, String attributeAdd, String attributeValue) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeAdd + "', '" + attributeValue + "');", find(driver, xpathValue));
    }

    public void waitElementVisible(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
    }

    public void waitElementStaleness(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.stalenessOf(find(driver, xpathValue)));
    }

    public void waitElementVisible(WebDriver driver, String xpathValue, String... values) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToRestParam(xpathValue, values))));
    }

    public void waitElementInvisible(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME_OUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
    }

    public void waitAllElementsInvisible(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(finds(driver, xpathValue)));
    }

    public void waitAllElementsInvisible(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(finds(driver, xpathValue)));
    }

    public void waitElementClickable(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
    }

    public void waitElementClickable(WebDriver driver, String xpathValue, String... values) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToRestParam(xpathValue, values))));
    }

    public String castToRestParam(String locator, String... values) {
        return String.format(locator, (Object[]) values);
    }

    public void upLoadMultipleFile(WebDriver driver, String xpathValue, String... fileNames) {
        String fullFileName = "";
        for (String fileName : fileNames) {
            fullFileName = fullFileName + GlobalConstants.UPLOAD_FOLDER + "\\" + fileName + "\n";
        }

        fullFileName = fullFileName.trim();

        System.out.println(xpathValue);
        System.out.println(fullFileName);
        sendkeyToElement(driver, xpathValue, fullFileName);
    }

    public boolean isDataSortedAscending(WebDriver driver, String locator) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = finds(driver, locator);
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        System.out.println("--------Dữ liệu trên UI");
        for (String name : arrayList) {
            System.out.println(name);
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);

        System.out.println("--------Dữ liệu đã sort ASC trong code------------");
        for (String name : arrayList) {
            System.out.println(name);
        }
        return sortedList.equals(arrayList);
    }

    public boolean isDataSortedDecending(WebDriver driver, String locator) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = finds(driver, locator);
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        System.out.println("--------Dữ liệu trên UI");
        for (String name : arrayList) {
            System.out.println(name);
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        System.out.println("--------Dữ liệu đã sort ASC trong code------------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        Collections.reverse(arrayList);
        System.out.println("----------Dữ liệu đã sort DESC trong code-------------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        return sortedList.equals(arrayList);
    }

    public boolean isPriceSortedAscending(WebDriver driver, String xpathValue) {
        ArrayList<Float> arrayList = new ArrayList<Float>();
        List<WebElement> elementList = finds(driver, xpathValue);
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText()));
        }
        System.out.println("-------Dữ liệu trên UI----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList);
        System.out.println("---------Dữ liệu đã SORT ASC trong code----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }
        return sortedList.equals(arrayList);
    }

    //start common function of user page
    public void clickToRegisterLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.REGISTER_LINK);
        clickToElement(driver, UserAbstractPageUI.REGISTER_LINK);
    }


    //end of common function of user page

    //start common function of testcase.admin page

    //end of common function of testcase.admin page
}
