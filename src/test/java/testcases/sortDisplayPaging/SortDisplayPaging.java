package testcases.sortDisplayPaging;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.SearchUserPageObject;

public class SortDisplayPaging extends AbstractTest {
    HomeUserPageObject homeUserPage;
    SearchUserPageObject searchUserPage;
    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.hoverToDynamicMenu(driver, "Computers");
        homeUserPage.clickToSubMenu(driver, "Computers", "Notebooks");
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void sortDisplayPaging_01_sort_a_to_z() {
        searchUserPage.selectSortByDropdown("Name: A to Z");
        verifyTrue(searchUserPage.isProductTitleSortedAtoZ());
    }

    @Test
    public void sortDisplayPaging_02_sort_z_to_a() {
        searchUserPage.selectSortByDropdown("Name: Z to A");
        verifyTrue(searchUserPage.isProductTitleSortedZtoA());
    }

    @Test
    public void sortDisplayPaging_03_sort_price_low_to_high() {
        searchUserPage.selectSortByDropdown("Price: Low to High");
        verifyTrue(searchUserPage.isProductPriceSortedLowToHigh());
    }

    @Test
    public void sortDisplayPaging_04_sort_price_high_to_low() {
        searchUserPage.selectSortByDropdown("Price: High to Low");
        verifyTrue(searchUserPage.isProductPriceSortedHighToLow());
    }

    @Test
    public void sortDisplayPaging_05_display_3_product_per_page() {
        searchUserPage.selectDisplayPerPageDropdown("3");
        verifyTrue(Integer.parseInt(searchUserPage.getSizeOfSearchResult()) <= 3);
    }

    @Test
    public void sortDisplayPaging_06_display_6_product_per_page() {
        searchUserPage.selectDisplayPerPageDropdown("6");
        verifyTrue(Integer.parseInt(searchUserPage.getSizeOfSearchResult()) <= 6);
    }

    @Test
    public void sortDisplayPaging_07_display_9_product_per_page() {
        searchUserPage.selectDisplayPerPageDropdown("9");
        verifyTrue(Integer.parseInt(searchUserPage.getSizeOfSearchResult()) <= 9);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

}
