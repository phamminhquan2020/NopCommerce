package commonFunctions;

import org.openqa.selenium.WebDriver;
import pageObjects.*;


public class PageGeneratorManager extends AbstractTest {
    private static HomeUserPageObject homeUserPage;
    private static RegisterUserPageObject registerUserPage;
    private static LoginUserPageObject loginUserPage;
    private static CustomerInfoMyAccountUserPageObject customerInfoMyAccountUserPage;
    private static AddressMyAccountUserPageObject addressMyAccountUserPage;
    private static ChangePasswordMyAccountUserPageObject changePasswordMyAccountUserPage;
    private static ProductDetailUserPageObject productDetailUserPage;
    private static ProductReviewUserPageObject productReviewUserPage;
    private static MyProductReviewMyAccountUserPageObject myProductReviewMyAccountUserPage;
    private static SearchUserPageObject searchUserPage;
    private static ProductListUserPageObjectBackup productListUserPageBackup;
    private static WishListUserPageObject wishListUserPage;



    public static HomeUserPageObject getHomeUserPage(WebDriver driver) {
        if (homeUserPage==null) {
            homeUserPage = new HomeUserPageObject(driver);
        }
        sleepInSecond(1);
        return homeUserPage;
    }

    public static RegisterUserPageObject getRegisterUserPage(WebDriver driver) {
        if (registerUserPage==null) {
            registerUserPage = new RegisterUserPageObject(driver);
        }
        sleepInSecond(1);
        return registerUserPage;
    }

    public static LoginUserPageObject getLoginUserPage(WebDriver driver) {
        if (loginUserPage==null) {
            loginUserPage = new LoginUserPageObject(driver);
        }
        sleepInSecond(1);
        return loginUserPage;
    }

    public static CustomerInfoMyAccountUserPageObject getMyAccountUserPage(WebDriver driver) {
        if (customerInfoMyAccountUserPage==null) {
            customerInfoMyAccountUserPage = new CustomerInfoMyAccountUserPageObject(driver);
        }
        sleepInSecond(1);
        return customerInfoMyAccountUserPage;
    }

    public static AddressMyAccountUserPageObject getAddressMyAccountUserPage(WebDriver driver) {
        if (addressMyAccountUserPage==null) {
            addressMyAccountUserPage = new AddressMyAccountUserPageObject(driver);
        }
        sleepInSecond(1);
        return addressMyAccountUserPage;
    }

    public static ChangePasswordMyAccountUserPageObject getChangePasswordMyAccountUserPage(WebDriver driver) {
        if (changePasswordMyAccountUserPage==null) {
            changePasswordMyAccountUserPage = new ChangePasswordMyAccountUserPageObject(driver);
        }
        sleepInSecond(1);
        return changePasswordMyAccountUserPage;
    }

    public static ProductDetailUserPageObject getProductDetailUserPage(WebDriver driver) {
        if (productDetailUserPage==null) {
            productDetailUserPage = new ProductDetailUserPageObject(driver);
        }
        sleepInSecond(1);
        return productDetailUserPage;
    }

    public static ProductReviewUserPageObject getProductReviewUserPage(WebDriver driver) {
        if (productReviewUserPage==null) {
            productReviewUserPage = new ProductReviewUserPageObject(driver);
        }
        sleepInSecond(1);
        return productReviewUserPage;
    }

    public static MyProductReviewMyAccountUserPageObject getMyProductReviewMyAccountPage(WebDriver driver) {
        if (myProductReviewMyAccountUserPage==null) {
            myProductReviewMyAccountUserPage = new MyProductReviewMyAccountUserPageObject(driver);
        }
        sleepInSecond(1);
        return myProductReviewMyAccountUserPage;
    }

    public static SearchUserPageObject getSearchUserPage(WebDriver driver) {
        if (searchUserPage==null) {
            searchUserPage = new SearchUserPageObject(driver);
        }
        sleepInSecond(1);
        return searchUserPage;
    }

    public static ProductListUserPageObjectBackup getProductListUserPage(WebDriver driver) {
        if (productListUserPageBackup==null) {
            productListUserPageBackup = new ProductListUserPageObjectBackup(driver);
        }
        sleepInSecond(1);
        return productListUserPageBackup;
    }

    public static WishListUserPageObject getWishListUserPage(WebDriver driver) {
        if (wishListUserPage==null) {
            wishListUserPage = new WishListUserPageObject(driver);
        }
        sleepInSecond(1);
        return wishListUserPage;
    }
}
