package commonFunctions;

import org.openqa.selenium.WebDriver;
import pageObjects.*;


public class PageGeneratorManager extends AbstractTest {
    private static long pageStableTimeout = GlobalConstants.PAGE_STABLE_TIMEOUT;
    public static HomeUserPageObject homeUserPage;
    public static RegisterUserPageObject registerUserPage;
    public static LoginUserPageObject loginUserPage;
    public static CustomerInfoMyAccountUserPageObject customerInfoMyAccountUserPage;
    public static AddressMyAccountUserPageObject addressMyAccountUserPage;
    public static ChangePasswordMyAccountUserPageObject changePasswordMyAccountUserPage;
    public static ProductDetailUserPageObject productDetailUserPage;
    public static ProductReviewUserPageObject productReviewUserPage;
    public static MyProductReviewMyAccountUserPageObject myProductReviewMyAccountUserPage;
    public static SearchUserPageObject searchUserPage;
    public static WishListUserPageObject wishListUserPage;
    public static CartUserPageObject cartUserPage;
    public static CompareProductsPageObject compareProductsPage;
    public static CheckOutPageObject checkOutPage;
    public static OrdersMyAccountUserPageObject ordersMyAccountUserPage;
    public static OrderDetailPageObject orderDetailPage;
    public static LoginAdminPageObject loginAdminPage;
    public static DashboardAdminPageObject dashboardAdminPage;
    public static ProductListAdminPageObject productAdminPage;
    public static EditProductAdminPageObject editProductAdminPage;


    public static HomeUserPageObject getHomeUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (homeUserPage == null || homeUserPage.getDriver() != driver) {
            homeUserPage = new HomeUserPageObject(driver);
        }
        return homeUserPage;
    }

    public static RegisterUserPageObject getRegisterUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (registerUserPage == null || registerUserPage.getDriver() != driver) {
            registerUserPage = new RegisterUserPageObject(driver);
        }
        return registerUserPage;
    }

    public static LoginUserPageObject getLoginUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (loginUserPage == null || loginUserPage.getDriver() != driver) {
            loginUserPage = new LoginUserPageObject(driver);
        }
        return loginUserPage;
    }

    public static CustomerInfoMyAccountUserPageObject getCustomerInfoMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (customerInfoMyAccountUserPage == null || customerInfoMyAccountUserPage.getDriver() != driver) {
            customerInfoMyAccountUserPage = new CustomerInfoMyAccountUserPageObject(driver);
        }
        return customerInfoMyAccountUserPage;
    }

    public static AddressMyAccountUserPageObject getAddressMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (addressMyAccountUserPage == null || addressMyAccountUserPage.getDriver() != driver) {
            addressMyAccountUserPage = new AddressMyAccountUserPageObject(driver);
        }
        return addressMyAccountUserPage;
    }

    public static ChangePasswordMyAccountUserPageObject getChangePasswordMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (changePasswordMyAccountUserPage == null || changePasswordMyAccountUserPage.getDriver() != driver) {
            changePasswordMyAccountUserPage = new ChangePasswordMyAccountUserPageObject(driver);
        }
        return changePasswordMyAccountUserPage;
    }

    public static ProductDetailUserPageObject getProductDetailUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (productDetailUserPage == null || productDetailUserPage.getDriver() != driver) {
            productDetailUserPage = new ProductDetailUserPageObject(driver);
        }
        return productDetailUserPage;
    }

    public static ProductReviewUserPageObject getProductReviewUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (productReviewUserPage == null || productReviewUserPage.getDriver() != driver) {
            productReviewUserPage = new ProductReviewUserPageObject(driver);
        }
        return productReviewUserPage;
    }

    public static MyProductReviewMyAccountUserPageObject getMyProductReviewMyAccountPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (myProductReviewMyAccountUserPage == null || myProductReviewMyAccountUserPage.getDriver() != driver) {
            myProductReviewMyAccountUserPage = new MyProductReviewMyAccountUserPageObject(driver);
        }
        return myProductReviewMyAccountUserPage;
    }

    public static SearchUserPageObject getSearchUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (searchUserPage == null || searchUserPage.getDriver() != driver) {
            searchUserPage = new SearchUserPageObject(driver);
        }
        return searchUserPage;
    }

    public static WishListUserPageObject getWishListUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (wishListUserPage == null || wishListUserPage.getDriver() != driver) {
            wishListUserPage = new WishListUserPageObject(driver);
        }
        return wishListUserPage;
    }

    public static CartUserPageObject getCartUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (cartUserPage == null || cartUserPage.getDriver() != driver) {
            cartUserPage = new CartUserPageObject(driver);
        }
        return cartUserPage;
    }

    public static CompareProductsPageObject getCompareProductsPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (compareProductsPage == null || compareProductsPage.getDriver() != driver) {
            compareProductsPage = new CompareProductsPageObject(driver);
        }
        return compareProductsPage;
    }

    public static CheckOutPageObject getCheckOutPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (checkOutPage == null || checkOutPage.getDriver() != driver) {
            checkOutPage = new CheckOutPageObject(driver);
        }
        return checkOutPage;
    }

    public static OrdersMyAccountUserPageObject getOrdersMyAccountUserPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (ordersMyAccountUserPage == null || ordersMyAccountUserPage.getDriver() != driver) {
            ordersMyAccountUserPage = new OrdersMyAccountUserPageObject(driver);
        }
        return ordersMyAccountUserPage;
    }

    public static OrderDetailPageObject getOrderDetailPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (orderDetailPage == null || orderDetailPage.getDriver() != driver) {
            orderDetailPage = new OrderDetailPageObject(driver);
        }
        return orderDetailPage;
    }

    public static LoginAdminPageObject getLoginAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (loginAdminPage == null || loginAdminPage.getDriver() != driver) {
            loginAdminPage = new LoginAdminPageObject(driver);
        }
        return loginAdminPage;
    }

    public static DashboardAdminPageObject getDashboardAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (dashboardAdminPage == null || dashboardAdminPage.getDriver() != driver) {
            dashboardAdminPage = new DashboardAdminPageObject(driver);
        }
        return dashboardAdminPage;
    }

    public static ProductListAdminPageObject getProductAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (productAdminPage == null || productAdminPage.getDriver() != driver) {
            productAdminPage = new ProductListAdminPageObject(driver);
        }
        return productAdminPage;
    }

    public static EditProductAdminPageObject getEditProductAdminPage(WebDriver driver) {
        sleepInSecond(pageStableTimeout);
        if (editProductAdminPage == null || editProductAdminPage.getDriver() != driver) {
            editProductAdminPage = new EditProductAdminPageObject(driver);
        }
        return editProductAdminPage;
    }
}
