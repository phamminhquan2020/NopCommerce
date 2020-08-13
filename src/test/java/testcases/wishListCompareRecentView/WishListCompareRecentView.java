package testcases.wishListCompareRecentView;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;

public class WishListCompareRecentView extends AbstractTest {
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    ProductDetailUserPageObject productDetailUserPage;
    WishListUserPageObject wishListUserPage;
    CartUserPageObject cartUserPage;
    CompareProductsPageObject compareProductsPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Navigate to Home");
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        log.info("Click Login Link");
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        log.info("input email");
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        log.info("input password");
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        log.info("click login button");
        loginUserPage.clickToLoginButton();
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        log.info("click product title");
        homeUserPage.clickToDynamicProductImageByTitle(driver, "HTC One M8 Android L 5.0 Lollipop");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }


    @Test
    public void wishlist_01_add_to_wishlish() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToWishListButton();
        productDetailUserPage.waitForAjaxLoadingIconDisappeared(driver);
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your wishlist");
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToWishListLink(driver);
        wishListUserPage = PageGeneratorManager.getWishListUserPage(driver);
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"), "M8_HTC_5L");
        verifyEquals(wishListUserPage.getProductNameByRow("1"), "HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(wishListUserPage.getPriceByRow("1"), "$245.00");
        wishListUserPage.clickToShareLink();
        verifyEquals(wishListUserPage.getWishListTitle(), "Wishlist of " + GlobalConstants.FIRST_NAME + " " + GlobalConstants.LAST_NAME);
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"), "M8_HTC_5L");
        verifyEquals(wishListUserPage.getProductNameByRow("1"), "HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(wishListUserPage.getPriceByRow("1"), "$245.00");
    }

    @Test
    public void wishlist_02_add_wishlish_to_cart() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToWishListButton();
        productDetailUserPage.waitForAjaxLoadingIconDisappeared(driver);
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToWishListLink(driver);
        wishListUserPage = PageGeneratorManager.getWishListUserPage(driver);
        wishListUserPage.clickAddToCartCheckboxByRow("1");
        wishListUserPage.clickAddToCartButton();
        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        verifyEquals(cartUserPage.getPageUrl(driver), "https://demo.nopcommerce.com/cart");
        verifyTrue(cartUserPage.isOnlyOnceProductInCart());
        verifyEquals(cartUserPage.getSKUByRow("1"), "M8_HTC_5L");
        verifyEquals(cartUserPage.getProductNameByRow("1"), "HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(cartUserPage.getPriceByRow("1"), "$245.00");
    }

    @Test
    public void wishlist_03_remove_product_in_wishlist_page() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToWishListButton();
        productDetailUserPage.waitForAjaxLoadingIconDisappeared(driver);
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your wishlist");
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToWishListLink(driver);
        wishListUserPage = PageGeneratorManager.getWishListUserPage(driver);
        wishListUserPage.clickRemoveCheckboxByRow("1");
        wishListUserPage.clickUpdateWishListButton();
        verifyTrue(wishListUserPage.isEmptyWishlistMessageDisplayed());
        verifyTrue(wishListUserPage.isNoRowDisplayedInWishlist());

    }

    @Test
    public void wishlist_04_add_product_to_compare() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToCompareButton();
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your product comparison");
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.clickToDynamicProductImageByTitle(driver, "Apple MacBook Pro 13-inch");
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToCompareButton();
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your product comparison");
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToDynamicFooterMenu(driver, "Compare products list");
        compareProductsPage = PageGeneratorManager.getCompareProductsPage(driver);
        verifyEquals(compareProductsPage.getNumberOfProductInComparePage(), "2");
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow("HTC One M8 Android L 5.0 Lollipop", "Price"), "$245.00");
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow("Apple MacBook Pro 13-inch", "Screensize"), "13.0''");
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow("Apple MacBook Pro 13-inch", "CPU Type"), "Intel Core i5");
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow("Apple MacBook Pro 13-inch", "Memory"), "4 GB");
        verifyTrue(compareProductsPage.isRemoveButtonDisplayedByProductName("HTC One M8 Android L 5.0 Lollipop"));
        verifyTrue(compareProductsPage.isRemoveButtonDisplayedByProductName("Apple MacBook Pro 13-inch"));
        compareProductsPage.clickToClearListButton();
        verifyTrue(compareProductsPage.isEmptyMessageDisplayed());
        verifyEquals(compareProductsPage.getNumberOfProductInComparePage(), "0");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
