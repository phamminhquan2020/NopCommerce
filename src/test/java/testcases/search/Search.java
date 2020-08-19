package testcases.search;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import pageObjects.SearchUserPageObject;

public class Search extends AbstractTest {
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    SearchUserPageObject searchUserPage;
    String userEmail, userPassword;
    String emptyDataMsg, keywordTC02, noResultMsg, keywordTC03, sizeOfSearchResultTC03, searchResultTitle01TC03, searchResultTitle02TC03, keywordTC04, sizeOfSearchResultTC04, searchResultTitleTC04, keywordTC05, categoryTC05, keywordTC06, categoryTC06, sizeOfSearchResultTC06, searchResultTitleTC06, keywordTC07, categoryTC07, manufacturerTC07, keywordTC08, categoryTC08, manufacturerTC08, sizeOfSearchResultTC08, searchResultTitleTC08, keywordTC09, categoryTC09, manufacturerTC09, priceFromTC09, priceToTC09, sizeOfSearchResultTC09, searchResultTitleTC09, keywordTC10, categoryTC10, manufacturerTC10, priceFromTC10, priceToTC10, keywordTC11, categoryTC11, manufacturerTC11, priceFromTC11, priceToTC11;
    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {

        userEmail = GlobalConstants.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;
        emptyDataMsg = "Search term minimum length is 3 characters";

        keywordTC02 = "Macbook Pro 2050";
        noResultMsg = "No products were found that matched your criteria.";

        keywordTC03 = "Lenovo";
        sizeOfSearchResultTC03 = "2";
        searchResultTitle01TC03 = "Lenovo IdeaCentre 600 All-in-One PC";
        searchResultTitle02TC03 = "Lenovo Thinkpad X1 Carbon Laptop";

        keywordTC04 = "Thinkpad X1 Carbon";
        sizeOfSearchResultTC04 = "1";
        searchResultTitleTC04 = "Lenovo Thinkpad X1 Carbon Laptop";

        keywordTC05 = "Apple Macbook Pro";
        categoryTC05 = "Computers";

        keywordTC06 = "Apple Macbook Pro";
        categoryTC06 = "Computers";
        sizeOfSearchResultTC06 = "1";
        searchResultTitleTC06 = "Apple MacBook Pro 13-inch";

        keywordTC07 = "Apple Macbook Pro";
        categoryTC07 = "Computers";
        manufacturerTC07 = "HP";

        keywordTC08 = "Apple Macbook Pro";
        categoryTC08 = "Computers";
        manufacturerTC08 = "Apple";
        sizeOfSearchResultTC08 = "1";
        searchResultTitleTC08 = "Apple MacBook Pro 13-inch";

        keywordTC09 = "Apple Macbook Pro";
        categoryTC09 = "Computers";
        manufacturerTC09 = "Apple";
        priceFromTC09 = "1000";
        priceToTC09 = "2000";
        sizeOfSearchResultTC09 = "1";
        searchResultTitleTC09 = "Apple MacBook Pro 13-inch";

        keywordTC10 = "Apple Macbook Pro";
        categoryTC10 = "Computers";
        manufacturerTC10 = "Apple";
        priceFromTC10 = "1000";
        priceToTC10 = "1700";


        keywordTC11 = "Apple Macbook Pro";
        categoryTC11 = "Computers";
        manufacturerTC11 = "Apple";
        priceFromTC11 = "1900";
        priceToTC11 = "5000";

        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);

    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.inputToPasswordTextBox(userPassword);
        loginUserPage.clickToLoginButton();
        loginUserPage.clickToSearchLink(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void search_01_empty_data() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getWarningMsg(), emptyDataMsg);
    }

    @Test
    public void search_02_not_exist_data() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC02);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getNoResultMsg(), noResultMsg);
    }

    @Test
    public void search_03_search_with_relative_product_name() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC03);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getSizeOfSearchResult(), sizeOfSearchResultTC03);
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(searchResultTitle01TC03) && searchUserPage.getTitlesOfSearchResult().contains(searchResultTitle02TC03));
    }

    @Test
    public void search_04_search_with_absolute_product_name() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC04);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getSizeOfSearchResult(), sizeOfSearchResultTC04);
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(searchResultTitleTC04));
    }

    @Test
    public void search_05_advance_search_with_parent_category() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC05);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC05);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getNoResultMsg(), noResultMsg);
    }

    @Test
    public void search_06_advance_search_with_sub_category() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC06);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC06);
        searchUserPage.clickToSearchSubcategoryCheckbox();
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getSizeOfSearchResult(), sizeOfSearchResultTC06);
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(searchResultTitleTC06));
    }

    @Test
    public void search_07_advance_search_with_incorrect_manufacturer() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC07);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC07);
        searchUserPage.clickToSearchSubcategoryCheckbox();
        searchUserPage.selectManufacturerDropdown(manufacturerTC07);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getNoResultMsg(), noResultMsg);
    }

    @Test
    public void search_08_advance_search_with_correct_manufacturer() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC08);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC08);
        searchUserPage.clickToSearchSubcategoryCheckbox();
        searchUserPage.selectManufacturerDropdown(manufacturerTC08);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getSizeOfSearchResult(), sizeOfSearchResultTC08);
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(searchResultTitleTC08));
    }

    @Test
    public void search_09_advance_search_with_in_range_price() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC09);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC09);
        searchUserPage.clickToSearchSubcategoryCheckbox();
        searchUserPage.selectManufacturerDropdown(manufacturerTC09);
        searchUserPage.inputToPriceFromTextbox(priceFromTC09);
        searchUserPage.inputToPriceToTextbox(priceToTC09);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getSizeOfSearchResult(), sizeOfSearchResultTC09);
        verifyTrue(searchUserPage.getTitlesOfSearchResult().contains(searchResultTitleTC09));
    }

    @Test
    public void search_10_advance_search_with_lower_range_price() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC10);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC10);
        searchUserPage.clickToSearchSubcategoryCheckbox();
        searchUserPage.selectManufacturerDropdown(manufacturerTC10);
        searchUserPage.inputToPriceFromTextbox(priceFromTC10);
        searchUserPage.inputToPriceToTextbox(priceToTC10);
        searchUserPage.clickToSearchButton();
        verifyEquals(searchUserPage.getNoResultMsg(), noResultMsg);
    }

    @Test
    public void search_11_advance_search_with_higher_range_price() {
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.inputToKeywordField(keywordTC11);
        searchUserPage.clickToAdvanceSearchCheckbox();
        searchUserPage.selectCategoryDropdown(categoryTC11);
        searchUserPage.clickToSearchSubcategoryCheckbox();
        searchUserPage.selectManufacturerDropdown(manufacturerTC11);
        searchUserPage.inputToPriceFromTextbox(priceFromTC11);
        searchUserPage.inputToPriceToTextbox(priceToTC11);
        searchUserPage.clickToSearchButton();

        verifyEquals(searchUserPage.getNoResultMsg(), noResultMsg);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

}
