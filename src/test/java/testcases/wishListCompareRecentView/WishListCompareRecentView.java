package testcases.wishListCompareRecentView;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import testdata.helper.DataHelper;

public class WishListCompareRecentView extends AbstractTest {
    private WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    ProductDetailUserPageObject productDetailUserPage;
    WishListUserPageObject wishListUserPage;
    CartUserPageObject cartUserPage;
    CompareProductsPageObject compareProductsPage;
    SearchUserPageObject searchUserPage;
    String userEmail, userPassword;
    String productTitle01, sku01, price01, productTitle02, price02, screenSize02, cpuType, memory02, productTitle03, productTitle04, productTitle05, productTitle06;
    String successAddedWishListMessage, cartUrl, successAddedComparisionMessage;
    DataHelper data;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        data = DataHelper.getData();
        userEmail = DataHelper.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;
        productTitle01 = "HTC One M8 Android L 5.0 Lollipop";
        successAddedWishListMessage = "The product has been added to your wishlist";
        sku01 = "M8_HTC_5L";
        price01 = "$245.00";
        cartUrl = GlobalConstants.CART_URL;
        successAddedComparisionMessage = "The product has been added to your product comparison";

        productTitle02 = "Apple MacBook Pro 13-inch";
        price02 = "$1,800.00";
        screenSize02 = "13.0''";
        cpuType = "Intel Core i5";
        memory02 = "4 GB";

        productTitle03 = "Lenovo Thinkpad X1 Carbon Laptop";
        productTitle04 = "Asus N551JK-XO076H Laptop";
        productTitle05 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        productTitle06 = "HP Spectre XT Pro UltraBook";
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
        loginUserPage.inputToEmailTextBox(userEmail);
        log.info("input password");
        loginUserPage.inputToPasswordTextBox(userPassword);
        log.info("click login button");
        loginUserPage.clickToLoginButton();
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        log.info("click product title");
        homeUserPage.clickToDynamicProductImageByTitle(driver, productTitle01);
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
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), successAddedWishListMessage);
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToWishListLink(driver);
        wishListUserPage = PageGeneratorManager.getWishListUserPage(driver);
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"), sku01);
        verifyEquals(wishListUserPage.getProductNameByRow("1"), productTitle01);
        verifyEquals(wishListUserPage.getPriceByRow("1"), price01);
        wishListUserPage.clickToShareLink();
        verifyEquals(wishListUserPage.getWishListTitle(), "Wishlist of " + GlobalConstants.FIRST_NAME + " " + GlobalConstants.LAST_NAME);
        verifyTrue(wishListUserPage.isOnlyOnceProductInWishList());
        verifyEquals(wishListUserPage.getSKUByRow("1"), sku01);
        verifyEquals(wishListUserPage.getProductNameByRow("1"), productTitle01);
        verifyEquals(wishListUserPage.getPriceByRow("1"), price01);
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
        verifyEquals(cartUserPage.getPageUrl(driver), cartUrl);
        verifyTrue(cartUserPage.isOnlyOnceProductInCart());
        verifyEquals(cartUserPage.getSKUByRow("1"), sku01);
        verifyEquals(cartUserPage.getProductNameByRow("1"), productTitle01);
        verifyEquals(cartUserPage.getPriceByRow("1"), price01);
        cartUserPage.clickToRemoveCheckbox();
        cartUserPage.clickToUpdateShoppingCartButton();
    }

    @Test
    public void wishlist_03_remove_product_in_wishlist_page() {
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToWishListButton();
        productDetailUserPage.waitForAjaxLoadingIconDisappeared(driver);
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), successAddedWishListMessage);
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
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), successAddedComparisionMessage);
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.clickToDynamicProductImageByTitle(driver, productTitle02);
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickToAddToCompareButton();
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), successAddedWishListMessage);
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToDynamicFooterMenu(driver, "Compare products list");
        compareProductsPage = PageGeneratorManager.getCompareProductsPage(driver);
        verifyEquals(compareProductsPage.getNumberOfProductInComparePage(), "2");
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow(productTitle01, "Price"), price01);
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow(productTitle02, "Price"), price02);
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow(productTitle02, "Screensize"), screenSize02);
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow(productTitle02, "CPU Type"), cpuType);
        verifyEquals(compareProductsPage.getCellDataByProductNameAndRow(productTitle02, "Memory"), memory02);
        verifyTrue(compareProductsPage.isRemoveButtonDisplayedByProductName(productTitle01));
        verifyTrue(compareProductsPage.isRemoveButtonDisplayedByProductName(productTitle02));
        compareProductsPage.clickToClearListButton();
        verifyTrue(compareProductsPage.isEmptyMessageDisplayed());
        verifyEquals(compareProductsPage.getNumberOfProductInComparePage(), "0");
    }

    @Test
    public void wishlist_05_recent_view() {
        homeUserPage.hoverToDynamicMenu(driver, "Computers");
        homeUserPage.clickToSubMenu(driver, "Computers", "Notebooks");
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.clickToDynamicProductImageByTitle(driver, productTitle03);
        searchUserPage.backToPage(driver);
        searchUserPage.clickToDynamicProductImageByTitle(driver, productTitle04);
        searchUserPage.backToPage(driver);
        searchUserPage.clickToDynamicProductImageByTitle(driver, productTitle05);
        searchUserPage.backToPage(driver);
        searchUserPage.clickToDynamicProductImageByTitle(driver, productTitle06);
        searchUserPage.backToPage(driver);
        searchUserPage.clickToDynamicProductImageByTitle(driver, productTitle02);
        searchUserPage.clickToDynamicFooterMenu(driver, "Recently viewed products");
        verifyEquals(searchUserPage.getSizeOfSearchResult(), "3");
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(productTitle02));
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(productTitle06));
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(productTitle05));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
