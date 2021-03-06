package commonFunctions;

import commonUIs.AdminAbstractPageUI;
import commonUIs.UserAbstractPageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        sleepInSecond(1);
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

    public void forwardToPage(WebDriver driver) {
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

    public List<WebElement> finds(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
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
            WebElement element = find(driver, xpathValue);
            element.click();
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
    }

    public void sendkeyToElement(WebDriver driver, String xpathValue, String text) {
        element = find(driver, xpathValue);
        element.clear();
        element.sendKeys(text);
    }

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
                try {
                    item.click();
                } catch (Exception e) {
                    jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                    item.click();
                }
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

    public String getElementAttributeValue(WebDriver driver, String xpathValue, String attributeName, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        return find(driver, xpathValue).getAttribute(attributeName);
    }

    public String getElementTextByJS(WebDriver driver, String xpathValue) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].value", find(driver, xpathValue));
    }

    public String getElementText(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).getText();
    }

    public List<String> getElementsText(WebDriver driver, String xpathValue) {
        List<WebElement> elements = finds(driver, xpathValue);
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
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
        xpathValue = castToRestParam(xpathValue, values);
        try {
            return find(driver, xpathValue).isDisplayed();

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
        elements = finds(driver, xpathValue);
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

    public boolean isElementSelected(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
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

    public void scrollToElement(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToRestParam(xpathValue, values);
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, xpathValue));
    }

    public void scrollToElementAtCenter(WebDriver driver, String xpathValue) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth',block: 'center',inline: 'center'});", find(driver, xpathValue));

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

    public void waitAllElementsVisible(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(xpathValue)));
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
        sendkeyToElement(driver, xpathValue, fullFileName);
    }

    public boolean isDataSortedAscending(WebDriver driver, String locator) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = finds(driver, locator);
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        return sortedList.equals(arrayList);
    }

    public boolean isDataSortedDecending(WebDriver driver, String locator) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = finds(driver, locator);
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);

        Collections.reverse(arrayList);

        return sortedList.equals(arrayList);
    }

    public boolean isPriceSortedAscending(WebDriver driver, String xpathValue) {
        ArrayList<Float> arrayList = new ArrayList<Float>();
        List<WebElement> elementList = finds(driver, xpathValue);
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList);
        return sortedList.equals(arrayList);
    }

    public boolean isPriceSortedDecending(WebDriver driver, String xpathValue) {
        ArrayList<Float> arrayList = new ArrayList<Float>();
        List<WebElement> elementList = finds(driver, xpathValue);
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        return sortedList.equals(arrayList);
    }


    public void printCurrentTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss.SSS");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
    }

    //start common function of user page
    public void clickToRegisterLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.REGISTER_LINK);
        clickToElement(driver, UserAbstractPageUI.REGISTER_LINK);
    }

    public void clickToLoginLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.LOGIN_LINK);
        clickToElement(driver, UserAbstractPageUI.LOGIN_LINK);

    }

    public void clickToMyAccountLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserAbstractPageUI.MY_ACCOUNT_LINK);
    }

    public void clickToSearchLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.SEARCH_LINK);
        clickToElement(driver, UserAbstractPageUI.SEARCH_LINK);
    }

    public void clickToDynamicMyAccountMenu(WebDriver driver, String menu) {
        waitElementVisible(driver, UserAbstractPageUI.DYNAMIC_MY_ACCOUNT_MENU, menu);
        clickToElement(driver, UserAbstractPageUI.DYNAMIC_MY_ACCOUNT_MENU, menu);
    }

    public void clickToLogoutLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.LOGOUT_LINK);
        clickToElement(driver, UserAbstractPageUI.LOGOUT_LINK);

    }

    ;

    public void clickToDynamicProductImageByTitle(WebDriver driver, String productTitle) {
        waitElementClickable(driver, UserAbstractPageUI.DYNAMIC_PRODUCT_IMAGE_BY_TITLE, productTitle);
        clickToElement(driver, UserAbstractPageUI.DYNAMIC_PRODUCT_IMAGE_BY_TITLE, productTitle);
    }

    ;

    public void hoverToDynamicMenu(WebDriver driver, String menu) {
        waitElementVisible(driver, UserAbstractPageUI.DYNAMIC_MENU_BY_NAME, menu);
        hoverToElement(driver, UserAbstractPageUI.DYNAMIC_MENU_BY_NAME, menu);
    }

    public void clickToSubMenu(WebDriver driver, String menu, String subMenu) {
        waitElementVisible(driver, UserAbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, menu, subMenu);
        clickToElement(driver, UserAbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, menu, subMenu);
    }

    public void waitForAjaxLoadingIconDisappeared(WebDriver driver) {
        waitElementInvisible(driver, UserAbstractPageUI.LOADING_ICON);
    }

    public String getNotificationMsg(WebDriver driver) {
        waitElementVisible(driver, UserAbstractPageUI.NOTIFICATION_MSG);
        return getElementText(driver, UserAbstractPageUI.NOTIFICATION_MSG);
    }

    public void clickToWishListLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.WISH_LIST_LINK);
        clickToElement(driver, UserAbstractPageUI.WISH_LIST_LINK);
        //     clickToElementByJS(driver, UserAbstractPageUI.WISH_LIST_LINK);
    }

    public String getDataByColumnNameAndRow(WebDriver driver, String columnName, String rowNumber) {
        int index = finds(driver, "//th[text()='" + columnName + "']/preceding-sibling::*").size() + 1;
        return getElementText(driver, UserAbstractPageUI.DYNAMIC_DATA_CELL, rowNumber, Integer.toString(index));

    }

    public void clickToCloseIcon(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.CLOSE_ICON);
        clickToElement(driver, UserAbstractPageUI.CLOSE_ICON);
        sleepInSecond(2);
    }

    public void clickToDynamicFooterMenu(WebDriver driver, String menu) {
        waitElementClickable(driver, UserAbstractPageUI.DYNAMIC_FOOTER_MENU_BY_NAME, menu);
        clickToElement(driver, UserAbstractPageUI.DYNAMIC_FOOTER_MENU_BY_NAME, menu);
    }

    public String getCartQuantity(WebDriver driver) {
        waitElementVisible(driver, UserAbstractPageUI.CART_QTY);
        return getElementText(driver, UserAbstractPageUI.CART_QTY);
    }

    public void hoverToCartLink(WebDriver driver) {
        scrollToElement(driver, UserAbstractPageUI.CART_LINK);
        waitElementVisible(driver, UserAbstractPageUI.CART_LINK);
        hoverToElement(driver, UserAbstractPageUI.CART_LINK);
    }

    public String getCartTitle(WebDriver driver) {
        waitElementVisible(driver, UserAbstractPageUI.CART_TITLE);
        return getElementText(driver, UserAbstractPageUI.CART_TITLE);
    }

    public Boolean isProductNameInCart(WebDriver driver, String productName) {
        return isElementDisplayed(driver, UserAbstractPageUI.PRODUCT_NAME_CART, productName);
    }

    public Float getProductPriceInCart(WebDriver driver, String productName) {
        waitElementVisible(driver, UserAbstractPageUI.PRODUCT_PRICE_BY_NAME, productName);
        return Float.parseFloat(getElementText(driver, UserAbstractPageUI.PRODUCT_PRICE_BY_NAME, productName).replace("$", "").replace(",", ""));
    }

    public String getProductAttributeInCart(WebDriver driver, String productName) {
        waitElementVisible(driver, UserAbstractPageUI.PRODUCT_ATTRIBUTE_BY_NAME, productName);
        return getElementText(driver, UserAbstractPageUI.PRODUCT_ATTRIBUTE_BY_NAME, productName);
    }

    public String getProductQuantityInCart(WebDriver driver, String productName) {
        waitElementVisible(driver, UserAbstractPageUI.PRODUCT_QTY_BY_NAME, productName);
        return getElementText(driver, UserAbstractPageUI.PRODUCT_QTY_BY_NAME, productName);
    }

    public Float getSubTotalInCart(WebDriver driver) {
        waitElementVisible(driver, UserAbstractPageUI.SUB_TOTAL);
        return Float.parseFloat(getElementText(driver, UserAbstractPageUI.SUB_TOTAL).replace("$", "").replace(",", ""));

    }

    public void clickToCartLink(WebDriver driver) {
        waitElementClickable(driver, UserAbstractPageUI.CART_LINK);
        clickToElement(driver, UserAbstractPageUI.CART_LINK);
    }

    public Float getProductTotalPriceInCart(WebDriver driver, String productName) {
        waitElementVisible(driver, UserAbstractPageUI.DYNAMIC_SUBTOTAL_BY_PRODUCT_NAME, productName);
        return Float.parseFloat(getElementText(driver, UserAbstractPageUI.DYNAMIC_SUBTOTAL_BY_PRODUCT_NAME, productName).replace("$", "").replace(",", ""));
    }

    //end of common function of user page

    //start common function of testcase.admin page

    public void clickToDynamicAdminMenu(WebDriver driver, String catalog) {
        waitElementClickable(driver, AdminAbstractPageUI.DYNAMIC_MENU_BY_NAME, catalog);
        clickToElement(driver, AdminAbstractPageUI.DYNAMIC_MENU_BY_NAME, catalog);
    }

    public void clickToDynamicAdminSubmenu(WebDriver driver, String catalog, String products) {
        waitElementClickable(driver, AdminAbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, catalog, products);
        clickToElement(driver, AdminAbstractPageUI.DYNAMIC_SUB_MENU_BY_NAME, catalog, products);
    }

    public void waitForAjaxLoadingIconAdminDisappeared(WebDriver driver) {
        waitElementInvisible(driver, AdminAbstractPageUI.LOADING_ICON_AJAX);
    }

    public String getNotificationMessageOfAdmin(WebDriver driver) {
        waitElementVisible(driver, AdminAbstractPageUI.ALERT_NOTIFICATION);
        return getElementText(driver, AdminAbstractPageUI.ALERT_NOTIFICATION).replace("×", "").trim();
    }

    public void deleteItemInCustomDropdown(WebDriver driver, String option) {
        waitElementClickable(driver, AdminAbstractPageUI.DYNAMIC_DELETE_ICON, option);
        clickToElement(driver, AdminAbstractPageUI.DYNAMIC_DELETE_ICON, option);
    }

    //end of common function of testcase.admin page
}
