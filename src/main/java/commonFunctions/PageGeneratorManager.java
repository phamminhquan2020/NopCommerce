package commonFunctions;

import org.openqa.selenium.WebDriver;
import pageObjects.*;


public class PageGeneratorManager extends AbstractTest {
    private static long pageStableTimeout = GlobalConstants.PAGE_STABLE_TIMEOUT;
    public static DashboardAdminPageObject dashboardAdminPage;
    public static ProductListAdminPageObject productAdminPage;
    public static EditProductAdminPageObject editProductAdminPage;




    public static HomeUserPageObject getHomeUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new HomeUserPageObject(driver);
    }

    public static RegisterUserPageObject getRegisterUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new RegisterUserPageObject(driver);
    }

    public static LoginUserPageObject getLoginUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new LoginUserPageObject(driver);
    }

    public static CustomerInfoMyAccountUserPageObject getCustomerInfoMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new CustomerInfoMyAccountUserPageObject(driver);
    }

    public static AddressMyAccountUserPageObject getAddressMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new AddressMyAccountUserPageObject(driver);
    }

    public static ChangePasswordMyAccountUserPageObject getChangePasswordMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new ChangePasswordMyAccountUserPageObject(driver);
    }

    public static ProductDetailUserPageObject getProductDetailUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new ProductDetailUserPageObject(driver);
    }

    public static ProductReviewUserPageObject getProductReviewUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new ProductReviewUserPageObject(driver);
    }

    public static MyProductReviewMyAccountUserPageObject getMyProductReviewMyAccountPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new MyProductReviewMyAccountUserPageObject(driver);
    }

    public static SearchUserPageObject getSearchUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new SearchUserPageObject(driver);
    }

    public static ProductListUserPageObjectBackup getProductListUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new ProductListUserPageObjectBackup(driver);
    }

    public static WishListUserPageObject getWishListUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new WishListUserPageObject(driver);
    }

    public static CartUserPageObject getCartUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new CartUserPageObject(driver);
    }

    public static CompareProductsPageObject getCompareProductsPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new CompareProductsPageObject(driver);
    }

    public static CheckOutPageObject getCheckOutPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new CheckOutPageObject(driver);
    }

    public static OrdersMyAccountUserPageObject getOrdersMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new OrdersMyAccountUserPageObject(driver);
    }

    public static OrderDetailPageObject getOrderDetailPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new OrderDetailPageObject(driver);
    }

    public static LoginAdminPageObject getLoginAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        return new LoginAdminPageObject(driver);
    }

    public static DashboardAdminPageObject getDashboardAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (dashboardAdminPage == null) {
            dashboardAdminPage = new DashboardAdminPageObject(driver);
        }
        return dashboardAdminPage;
    }

    public static ProductListAdminPageObject getProductAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (productAdminPage == null) {
            productAdminPage = new ProductListAdminPageObject(driver);
        }
        return productAdminPage;
    }

    public static EditProductAdminPageObject getEditProductAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (editProductAdminPage == null) {
            editProductAdminPage = new EditProductAdminPageObject(driver);
        }
        return editProductAdminPage;
    }
}
