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
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        loginUserPage.clickToDynamicProductTitle(driver,"HTC One M8 Android L 5.0 Lollipop");
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
        verifyEquals(wishListUserPage.getSKUByRow("1"),"M8_HTC_5L");
        verifyEquals(wishListUserPage.getProductNameByRow("1"),"HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(wishListUserPage.getPriceByRow("1"),"$245.00");
        wishListUserPage.clickToShareLink();
        verifyEquals(wishListUserPage.getWishListTitle(), "Wishlist of " + GlobalConstants.FIRST_NAME + " " + GlobalConstants.LAST_NAME);
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"),"M8_HTC_5L");
        verifyEquals(wishListUserPage.getProductNameByRow("1"),"HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(wishListUserPage.getPriceByRow("1"),"$245.00");
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
        verifyEquals(cartUserPage.getSKUByRow("1"),"M8_HTC_5L");
        verifyEquals(cartUserPage.getProductNameByRow("1"),"HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(cartUserPage.getPriceByRow("1"),"$245.00");
    }


    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
