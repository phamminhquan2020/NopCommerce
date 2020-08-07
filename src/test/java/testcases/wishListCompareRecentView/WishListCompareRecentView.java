package testcases.wishListCompareRecentView;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import pageObjects.ProductDetailUserPageObject;
import pageObjects.WishListUserPageObject;

public class WishListCompareRecentView extends AbstractTest {
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    ProductDetailUserPageObject productDetailUserPage;
    WishListUserPageObject wishListUserPage;
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
    public void testName() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToWishListButton();
        productDetailUserPage.waitForAjaxLoadingIconDisappeared(driver);
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your wishlist");
        productDetailUserPage.clickToWishListLink(driver);
        wishListUserPage = PageGeneratorManager.getWishListUserPage(driver);
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"),"M8_HTC_5L");
        verifyEquals(wishListUserPage.getProductNameByRow("1"),"HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(wishListUserPage.getPriceByRow("1"),"$245.00");
        wishListUserPage.clickToShareLink();
        System.out.println(wishListUserPage.getWishListTitle());
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"),"M8_HTC_5L");
        verifyEquals(wishListUserPage.getProductNameByRow("1"),"HTC One M8 Android L 5.0 Lollipop");
        verifyEquals(wishListUserPage.getPriceByRow("1"),"$245.00");
    }


    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
