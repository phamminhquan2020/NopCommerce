package testcases.admin;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AbstractTest {
    LoginAdminPageObject loginAdminPageObject;
    DashboardAdminPageObject dashboardAdminPage;
    ProductListAdminPageObject productAdminPage;
    EditProductAdminPageObject editProductAdminPage;
    CustomerListAdminPageObject customerListAdminPage;
    CustomerCreateAdminPageObject customerCreateAdminPage;
    CustomerEditAdminPageObject customerEditAdminPage;
    String productName01, sku01, type01;
    float price01;
    int stock01;
    String categoryOption02, categoryOption04, categoryOption05, manufacturer05;
    String email, password, firstName, lastName, dob, companyName, vendorName, adminComment;
    String storeNames, roleNames;
    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {

        productName01 = "Lenovo IdeaCentre 600 All-in-One PC";
        sku01 = "LE_IC_600";
        price01 = 500;
        stock01 = 10000;
        type01 = "Simple";

        categoryOption02 = "Computers";

        categoryOption04 = "Computers >> Desktops";
        categoryOption05 = "All";
        manufacturer05 = "Apple";

        email = "leo" + randomNumber() + "@gmail.com";
        password = "123456";
        firstName = "Automation";
        lastName = "FC";
        dob = "8/15/2000";
        companyName = "AutomationFC";


        storeNames = "Your store name";
        roleNames = "Guests";
        vendorName = "Vendor 1";
        adminComment = "New Customer";

        driver = getBrowserDriverFromFactory(browser);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginAdminPageObject = PageGeneratorManager.getLoginAdminPage(driver);
        loginAdminPageObject.navigatePageUrl(driver, GlobalConstants.ADMIN_URL);
        loginAdminPageObject.inputToEmailTextbox(GlobalConstants.ADMIN_EMAIL);
        loginAdminPageObject.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
        loginAdminPageObject.clickToLoginButton();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }


    public void admin_01_search_with_product_name() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Catalog");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Catalog", "Products");

        productAdminPage = PageGeneratorManager.getProductAdminPage(driver);
        productAdminPage.inputToProductNameTextbox(productName01);
        productAdminPage.clickToSearchButton();
        productAdminPage.waitForAjaxLoadingIconAdminDisappeared(driver);
        verifyEquals(productAdminPage.getNumberOfItemInList(), 1);
        verifyFalse(productAdminPage.isEmptyRowMessageDisplayed());
        verifyEquals(productAdminPage.getSKUByProductName(productName01), sku01);
        verifyEquals(productAdminPage.getPriceByProductName(productName01), price01);
        verifyEquals(productAdminPage.getStockByProductName(productName01), stock01);
        verifyEquals(productAdminPage.getProductTypeByProductName(productName01), type01);
    }


    public void admin_02_search_with_product_name_parent_category_unchecked() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Catalog");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Catalog", "Products");

        productAdminPage = PageGeneratorManager.getProductAdminPage(driver);
        productAdminPage.inputToProductNameTextbox(productName01);
        productAdminPage.selectCategoryDropdown(categoryOption02);
        productAdminPage.clickToSearchButton();
        productAdminPage.waitForAjaxLoadingIconAdminDisappeared(driver);
        verifyEquals(productAdminPage.getNumberOfItemInList(), 1);
        verifyTrue(productAdminPage.isEmptyRowMessageDisplayed());
    }


    public void admin_03_search_with_product_name_parent_category_checked() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Catalog");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Catalog", "Products");

        productAdminPage = PageGeneratorManager.getProductAdminPage(driver);
        productAdminPage.inputToProductNameTextbox(productName01);
        productAdminPage.selectCategoryDropdown(categoryOption02);
        productAdminPage.clickToSearchSubcatogoryCheckbox();
        productAdminPage.clickToSearchButton();
        productAdminPage.waitForAjaxLoadingIconAdminDisappeared(driver);
        verifyEquals(productAdminPage.getNumberOfItemInList(), 1);
        verifyFalse(productAdminPage.isEmptyRowMessageDisplayed());
        verifyEquals(productAdminPage.getSKUByProductName(productName01), sku01);
        verifyEquals(productAdminPage.getPriceByProductName(productName01), price01);
        verifyEquals(productAdminPage.getStockByProductName(productName01), stock01);
        verifyEquals(productAdminPage.getProductTypeByProductName(productName01), type01);
    }


    public void admin_04_search_with_product_name_child_category() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Catalog");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Catalog", "Products");

        productAdminPage = PageGeneratorManager.getProductAdminPage(driver);
        productAdminPage.inputToProductNameTextbox(productName01);
        productAdminPage.selectCategoryDropdown(categoryOption04);
        productAdminPage.clickToSearchButton();
        productAdminPage.waitForAjaxLoadingIconAdminDisappeared(driver);
        verifyEquals(productAdminPage.getNumberOfItemInList(), 1);
        verifyFalse(productAdminPage.isEmptyRowMessageDisplayed());
        verifyEquals(productAdminPage.getSKUByProductName(productName01), sku01);
        verifyEquals(productAdminPage.getPriceByProductName(productName01), price01);
        verifyEquals(productAdminPage.getStockByProductName(productName01), stock01);
        verifyEquals(productAdminPage.getProductTypeByProductName(productName01), type01);
    }


    public void admin_05_search_with_product_name_manufacturer() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Catalog");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Catalog", "Products");

        productAdminPage = PageGeneratorManager.getProductAdminPage(driver);
        productAdminPage.inputToProductNameTextbox(productName01);
        productAdminPage.selectCategoryDropdown(categoryOption05);
        productAdminPage.selectManufacturerDropdown(manufacturer05);
        productAdminPage.clickToSearchButton();
        productAdminPage.waitForAjaxLoadingIconAdminDisappeared(driver);
        verifyEquals(productAdminPage.getNumberOfItemInList(), 1);
        verifyTrue(productAdminPage.isEmptyRowMessageDisplayed());
    }


    public void admin_06_go_directly_product_sku() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Catalog");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Catalog", "Products");

        productAdminPage = PageGeneratorManager.getProductAdminPage(driver);
        productAdminPage.inputToGoDirectlyProductSKUTextbox(sku01);
        productAdminPage.clickToGoDirectlyProductSKUButton();

        editProductAdminPage = PageGeneratorManager.getEditProductAdminPage(driver);
        verifyEquals(editProductAdminPage.getProductName(), productName01);
        verifyTrue(editProductAdminPage.isDynamicCategoryDisplayed(categoryOption04));
        verifyEquals(editProductAdminPage.getSelectedProductType(), type01);
        verifyEquals(editProductAdminPage.getPrice(), price01);


    }

    @Test
    public void admin_07_create_new_customer() {
        dashboardAdminPage = PageGeneratorManager.getDashboardAdminPage(driver);
        dashboardAdminPage.clickToDynamicAdminMenu(driver, "Customers");
        dashboardAdminPage.clickToDynamicAdminSubmenu(driver, "Customers", "Customers");

        customerListAdminPage = PageGeneratorManager.getCustomerListAdminPage(driver);
        customerListAdminPage.clickToAddNewButton();

        customerCreateAdminPage = PageGeneratorManager.getCustomerCreateAdminPage(driver);
        customerCreateAdminPage.inputToEmailTextbox(email);
        customerCreateAdminPage.inputToPasswordTextbox(password);
        customerCreateAdminPage.inputToFirstNameTextbox(firstName);
        customerCreateAdminPage.inputToLastNameTextbox(lastName);
        customerCreateAdminPage.clickToMaleRadio();
        customerCreateAdminPage.inputToDayOfBirthTextbox(dob);
        customerCreateAdminPage.inputToCompanyNameTextbox(companyName);
        customerCreateAdminPage.checkToIsTaxExemptCheckbox();
        customerCreateAdminPage.deleteItemInCustomDropdown(driver, "Registered");
        customerCreateAdminPage.selectNewsletterMultiSelectDropdown(storeNames);
        customerCreateAdminPage.selectCustomerRolesMultiSelectDropdown(roleNames);
        customerCreateAdminPage.selectManagerOfVendorDropdown(vendorName);
        customerCreateAdminPage.checkToActiveCheckbox();
        customerCreateAdminPage.inputToAdminComment(adminComment);
        customerCreateAdminPage.clickToSaveAndContinueEditButton();

        customerEditAdminPage = PageGeneratorManager.getCustomerEditAdminPage(driver);
        verifyEquals(customerEditAdminPage.getNotificationMessageOfAdmin(driver), "The new customer has been added successfully.");
        verifyEquals(customerEditAdminPage.getEmail(), email);
        verifyEquals(customerEditAdminPage.getFirstName(), firstName);
        verifyEquals(customerEditAdminPage.getLastName(), lastName);
        verifyTrue(customerEditAdminPage.isMaleGenderSelected());
        verifyEquals(customerEditAdminPage.getDayOfBirth(), dob);
        verifyEquals(customerEditAdminPage.getCompanyName(), companyName);
        verifyTrue(customerEditAdminPage.isTaxExemptChecked());
        verifyTrue(customerEditAdminPage.isStoreNameSelected(storeNames));
        verifyTrue(customerEditAdminPage.isRoleNameSelected(roleNames));
        verifyEquals(customerEditAdminPage.getSelectedVendor(), vendorName);
        verifyTrue(customerEditAdminPage.isActiveChecked());
        verifyEquals(customerEditAdminPage.getAminComment(), adminComment);
        customerEditAdminPage.clickToBackToCustomerListButton();

        customerListAdminPage = PageGeneratorManager.getCustomerListAdminPage(driver);
        customerListAdminPage.deleteItemInCustomDropdown(driver, "Registered");
        customerListAdminPage.selectCustomerRolesMultiSelectDropdown(roleNames);
        customerListAdminPage.clickToSearchButton();
        customerListAdminPage.waitForAjaxLoadingIconAdminDisappeared(driver);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
