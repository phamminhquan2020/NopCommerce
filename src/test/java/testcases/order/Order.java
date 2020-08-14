package testcases.order;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import pageObjects.ProductDetailUserPageObject;

import java.util.ArrayList;
import java.util.List;

public class Order extends AbstractTest {
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    ProductDetailUserPageObject productDetailUserPage;
    String productName, processor, ram, hdd, os, productAttribute;
    float basePrice, price, processorAddPrice, ramAddPrice, hddAddPrice, osAddPrice, softwareAddPrice;
    List<String> softwares;
    int qty;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        productName = "Build your own computer";
        processor = "2.2 GHz Intel Pentium Dual-Core E2200";
        processorAddPrice = 0;
        ram = "8GB [+$60.00]";
        ramAddPrice = 60;
        hdd = "400 GB [+$100.00]";
        hddAddPrice = 100;
        os = "Vista Premium [+$60.00]";
        osAddPrice = 60;
        softwares = new ArrayList<String >();
        softwares.add("Acrobat Reader [+$10.00]");
        softwareAddPrice +=10;
        softwares.add("Microsoft Office [+$50.00]");
        softwareAddPrice +=50;
        basePrice = 1200;
        qty = 2;
    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.clickToDynamicProductImageByTitle(driver, productName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void order_01_add_product_to_cart() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        price = basePrice;
        productDetailUserPage.selectProcessor(processor);
        price += processorAddPrice;
        productDetailUserPage.selectRam(ram);
        price += ramAddPrice;
        productDetailUserPage.selectHDD(hdd);
        price += hddAddPrice;
        productDetailUserPage.selectOS(os);
        price += osAddPrice;
        productDetailUserPage.selectSoftware(softwares);
        price += softwareAddPrice;
        productDetailUserPage.inputQuantity(Integer.toString(qty));
        productDetailUserPage.clickAddToCartButton();
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your shopping cart");
        productDetailUserPage.clickToCloseIcon(driver);
        verifyEquals(productDetailUserPage.getCartQuantity(driver), "(" + qty + ")");
        productDetailUserPage.hoverToCartLink(driver);
        verifyEquals(productDetailUserPage.getCartTitle(driver), "There are " + qty + " item(s) in your cart.");
        verifyTrue(productDetailUserPage.isProductNameInCart(driver, productName));
        verifyEquals(productDetailUserPage.getProductPriceInCart(driver, productName), price);
        productAttribute = productDetailUserPage.getProductAttributeInCart(driver, productName).replace("\n", "");
        verifyTrue(productAttribute.contains(processor));
        verifyTrue(productAttribute.contains(ram));
        verifyTrue(productAttribute.contains(hdd));
        verifyTrue(productAttribute.contains(os));
        for (String software:softwares) {
            verifyTrue(productAttribute.contains(software));
        }
        verifyEquals(productDetailUserPage.getProductQuantityInCart(driver, productName), Integer.toString(qty));
        verifyEquals(productDetailUserPage.getSubTotalInCart(driver), price*qty);

    }

    public void order_02_edit_product_in_cart() {
        //productDetailUserPage.clickToCartLink();
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}


