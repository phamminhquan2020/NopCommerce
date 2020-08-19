package testcases.order;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import testdata.helper.DataHelper;

import java.util.ArrayList;
import java.util.List;

public class Order extends AbstractTest {
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    ProductDetailUserPageObject productDetailUserPage;
    CartUserPageObject cartUserPage;
    SearchUserPageObject searchUserPage;
    CheckOutPageObject checkOutPage;
    CustomerInfoMyAccountUserPageObject customerInfoMyAccountUserPage;
    OrdersMyAccountUserPageObject ordersMyAccountUserPage;
    OrderDetailPageObject orderDetailPage;
    DataHelper data;
    String userEmail, userPassword;
    String productName1, processor1, ram1, hdd1, os1, productAttribute1;
    float basePrice, price1, processorAddPrice1, ramAddPrice1, hddAddPrice1, osAddPrice1, softwareAddPrice1;
    List<String> softwares1;
    int qty1;
    String productName2, processor2, ram2, hdd2, os2, productAttribute2;
    float price2, processorAddPrice2, ramAddPrice2, hddAddPrice2, osAddPrice2, softwareAddPrice2;
    List<String> softwares2;
    int qty2;
    String productName4;
    float basePrice4;
    int qty4;
    String productName5 = "Apple MacBook Pro 13-inch";
    String giftWrapping, country, state, shippingMethod, city, address1, zipcode, phoneNumber, paymentMethod05, orderID, paymentMethod06;
    float totalPrice;
    List<String> billingAddressInfo, paymentMethodInfo, shippingAddressInfo, shippingMethodInfo;
    List<String> billingAddressInfoConfirmOrder, paymentMethodInfoConfirmOrder, shippingAddressInfoConfirmOrder, shippingMethodInfoConfirmOrder;
    String creditCartType, cartHolderName, cartNumber, month, year, code;
    int qty7;
    float totalPrice7;
    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        data = DataHelper.getData();
        userEmail = data.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);


        productName1 = "Build your own computer";
        processor1 = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        processorAddPrice1 = 15;
        ram1 = "8GB [+$60.00]";
        ramAddPrice1 = 60;
        hdd1 = "400 GB [+$100.00]";
        hddAddPrice1 = 100;
        os1 = "Vista Premium [+$60.00]";
        osAddPrice1 = 60;
        softwares1 = new ArrayList<String>();
        softwares1.add("Acrobat Reader [+$10.00]");
        softwareAddPrice1 += 10;
        softwares1.add("Microsoft Office [+$50.00]");
        softwareAddPrice1 += 50;
        basePrice = 1200;
        qty1 = 1;

        processor2 = "2.2 GHz Intel Pentium Dual-Core E2200";
        processorAddPrice2 = 0;
        ram2 = "4GB [+$20.00]";
        ramAddPrice2 = 20;
        hdd2 = "320 GB";
        hddAddPrice2 = 0;
        os2 = "Vista Home [+$50.00]";
        osAddPrice2 = 50;
        softwares2 = new ArrayList<String>();
        softwares2.add("Microsoft Office [+$50.00]");
        softwareAddPrice2 += 50;
        softwares2.add("Acrobat Reader [+$10.00]");
        softwareAddPrice2 += 10;
        qty2 = 2;

        productName4 = "Lenovo IdeaCentre 600 All-in-One PC";
        basePrice4 = 500;
        qty4 = 5;

        giftWrapping = "Yes [+$10.00]";
        country = "United States";
        state = "Texas";
        zipcode = "75217";
        shippingMethod = "Next Day Air";
        city = "Dallas";
        address1 = "E Main Street";
        phoneNumber = "123456789";
        paymentMethod05 = "Check / Money Order";
        totalPrice = 3610;

        paymentMethod06 = "Credit Card";
        creditCartType = "Master card";
        cartHolderName = "Camilla Edwards";
        month = "04";
        year = "2026";
        code = "791";
        cartNumber = "5198178217867618";

        qty7 = 10;
        totalPrice7 = 18010;

    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.inputToPasswordTextBox(userPassword);
        loginUserPage.clickToLoginButton();
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void order_01_add_product_to_cart() {
        homeUserPage.clickToDynamicProductImageByTitle(driver, productName1);
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        price1 = basePrice;
        productDetailUserPage.selectProcessor(processor1);
        price1 += processorAddPrice1;
        productDetailUserPage.selectRam(ram1);
        price1 += ramAddPrice1;
        productDetailUserPage.selectHDD(hdd1);
        price1 += hddAddPrice1;
        productDetailUserPage.selectOS(os1);
        price1 += osAddPrice1;
        productDetailUserPage.selectSoftware(softwares1);
        price1 += softwareAddPrice1;
        productDetailUserPage.inputQuantity(Integer.toString(qty1));
        productDetailUserPage.clickAddToCartButton();
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your shopping cart");
        productDetailUserPage.clickToCloseIcon(driver);
        verifyEquals(productDetailUserPage.getCartQuantity(driver), "(" + qty1 + ")");
        productDetailUserPage.hoverToCartLink(driver);
        verifyEquals(productDetailUserPage.getCartTitle(driver), "There are " + qty1 + " item(s) in your cart.");
        verifyTrue(productDetailUserPage.isProductNameInCart(driver, productName1));
        verifyEquals(productDetailUserPage.getProductPriceInCart(driver, productName1), price1);
        productAttribute1 = productDetailUserPage.getProductAttributeInCart(driver, productName1).replace("\n", "");
        verifyTrue(productAttribute1.contains(processor1));
        verifyTrue(productAttribute1.contains(ram1));
        verifyTrue(productAttribute1.contains(hdd1));
        verifyTrue(productAttribute1.contains(os1));
        for (String software : softwares1) {
            verifyTrue(productAttribute1.contains(software));
        }
        verifyEquals(productDetailUserPage.getProductQuantityInCart(driver, productName1), Integer.toString(qty1));
        verifyEquals(productDetailUserPage.getSubTotalInCart(driver), price1 * qty1);

    }

    @Test
    public void order_02_edit_product_in_cart() {
        homeUserPage.clickToCartLink(driver);
        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        cartUserPage.clickToEditLink();
        price2 = basePrice;
        productDetailUserPage.selectProcessor(processor2);
        price2 += processorAddPrice2;
        productDetailUserPage.selectRam(ram2);
        price2 += ramAddPrice2;
        productDetailUserPage.selectHDD(hdd2);
        price2 += hddAddPrice2;
        productDetailUserPage.selectOS(os2);
        price2 += osAddPrice2;
        productDetailUserPage.selectSoftware(softwares2);
        price2 += softwareAddPrice2;
        productDetailUserPage.inputQuantity(Integer.toString(qty2));
        productDetailUserPage.clickToUpdateButton();
        verifyEquals(productDetailUserPage.getNotificationMsg(driver), "The product has been added to your shopping cart");
        productDetailUserPage.clickToCloseIcon(driver);
        verifyEquals(productDetailUserPage.getCartQuantity(driver), "(" + qty2 + ")");
        productDetailUserPage.hoverToCartLink(driver);
        verifyEquals(productDetailUserPage.getCartTitle(driver), "There are " + qty2 + " item(s) in your cart.");
        verifyTrue(productDetailUserPage.isProductNameInCart(driver, productName1));
        verifyEquals(productDetailUserPage.getProductPriceInCart(driver, productName1), price2);
        productAttribute2 = productDetailUserPage.getProductAttributeInCart(driver, productName1).replace("\n", "");
        verifyTrue(productAttribute2.contains(processor2));
        verifyTrue(productAttribute2.contains(ram2));
        verifyTrue(productAttribute2.contains(hdd2));
        verifyTrue(productAttribute2.contains(os2));
        for (String software : softwares2) {
            verifyTrue(productAttribute2.contains(software));
        }
        verifyEquals(productDetailUserPage.getProductQuantityInCart(driver, productName1), Integer.toString(qty2));
        verifyEquals(productDetailUserPage.getSubTotalInCart(driver), price2 * qty2);
    }

    @Test
    public void order_03_remove_from_cart() {
        homeUserPage.clickToCartLink(driver);
        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        cartUserPage.clickToRemoveCheckbox();
        cartUserPage.clickToUpdateShoppingCartButton();
        verifyTrue(cartUserPage.isEmptyCartMessageDisplayed());
    }

    @Test
    public void order_04_update_shopping_cart() {
        homeUserPage.hoverToDynamicMenu(driver, "Computers");
        homeUserPage.clickToSubMenu(driver, "Computers", "Desktops");
        searchUserPage = PageGeneratorManager.getSearchUserPage(driver);
        searchUserPage.clickToDynamicProductImageByTitle(driver, productName4);
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickAddToCartButton();
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToCartLink(driver);
        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        cartUserPage.inputQuantity(Integer.toString(qty4));
        cartUserPage.clickToUpdateShoppingCartButton();
        verifyEquals(cartUserPage.getProductTotalPriceInCart(driver, productName4), basePrice4 * qty4);
        cartUserPage.clickToRemoveCheckbox();
        cartUserPage.clickToUpdateShoppingCartButton();

    }

    @Test
    public void order_05_checkout_payment_by_cheque() {
        homeUserPage.clickToDynamicProductImageByTitle(driver, productName5);
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickAddToCartButton();
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToCartLink(driver);
        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        cartUserPage.selectGiftWrappingDropdown(giftWrapping);
        cartUserPage.clickToEstimateShippingButton();
        cartUserPage.selectCountryInDrropdown(country);
        cartUserPage.selectStateInDropdown(state);
        cartUserPage.inputToZipcodeTextbox(zipcode);
        cartUserPage.clickToShippingMethod(shippingMethod);
        cartUserPage.clickToApplyButton();
        cartUserPage.waitForAjaxLoadingIconDisappeared(driver);
        verifyEquals(cartUserPage.getTotalValue(), totalPrice);
        cartUserPage.clickToTermOfServiceCheckbox();
        cartUserPage.clickToCheckOutButton();

        checkOutPage = PageGeneratorManager.getCheckOutPage(driver);
        checkOutPage.selectNewAddressIfAny();
        checkOutPage.selectCountryInDropdown(country);
        checkOutPage.selectStateInDropdown(state);
        checkOutPage.inputToCityTextBox(city);
        checkOutPage.inputToAddress1TextBox(address1);
        checkOutPage.inputToZipcodeTextBox(zipcode);
        checkOutPage.inputToPhoneNumberTextBox(phoneNumber);
        checkOutPage.clickToCoutinueBillingButton();
        checkOutPage.waitForLoadingTextBillingDisappeared();

        checkOutPage.clickToShippingMethodRadio(shippingMethod);
        checkOutPage.clickToContinueShippingMethodButton();
        checkOutPage.waitForLoadingTextShippingMethodDisappear();

        checkOutPage.clickToDynamicPaymentMethod(paymentMethod05);
        checkOutPage.clickToContinuePaymentMethodButton();
        checkOutPage.waitForLoadingTextPaymentMethodDisappeared();

        System.out.println(checkOutPage.getPaymentInfoText());
        checkOutPage.clickToContinueButtonPaymentInfo();
        checkOutPage.waitForLoadingTextPaymentInfoDisappeared();

        //verify

        billingAddressInfoConfirmOrder = checkOutPage.getBillingAddressInfoConfirmOrder();
        log.info("billingAddressInfo" + billingAddressInfoConfirmOrder);
        verifyTrue(billingAddressInfoConfirmOrder.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfoConfirmOrder.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfoConfirmOrder.contains(address1));
        verifyTrue(billingAddressInfoConfirmOrder.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfoConfirmOrder.contains(country));

        paymentMethodInfoConfirmOrder = checkOutPage.getPaymentMethodInfoConfirmOrder();
        log.info("paymentMethodInfo" + paymentMethodInfoConfirmOrder);
        verifyTrue(paymentMethodInfoConfirmOrder.contains("Payment Method: " + paymentMethod05));

        shippingAddressInfoConfirmOrder = checkOutPage.getShippingAddressInfoConfirmOrder();
        log.info("shippingAddressInfo" + shippingAddressInfoConfirmOrder);
        verifyTrue(billingAddressInfoConfirmOrder.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfoConfirmOrder.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfoConfirmOrder.contains(address1));
        verifyTrue(billingAddressInfoConfirmOrder.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfoConfirmOrder.contains(country));

        shippingMethodInfoConfirmOrder = checkOutPage.getShippingMethodInfoConfirmOrder();
        log.info("shippingMethodInfo" + shippingMethodInfoConfirmOrder);
        verifyTrue(shippingMethodInfoConfirmOrder.contains("Shipping Method: " + shippingMethod));
        verifyEquals(checkOutPage.getProductNameAtConfirm(), productName5);
        verifyEquals(checkOutPage.getTotalPriceAtConfirm(), totalPrice);

        //verify

        checkOutPage.clickToConfirmButton();
        checkOutPage.waitForSubmittingOrderTextDisappeared();

        orderID = checkOutPage.getOrderID();
        checkOutPage.clickToContinueButtonCartSuccess();
        verifyEquals(checkOutPage.getPageUrl(driver), GlobalConstants.USER_URL);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Orders");
        ordersMyAccountUserPage = PageGeneratorManager.getOrdersMyAccountUserPage(driver);
        ordersMyAccountUserPage.clickToDynamicDetailButtonByOrderID(orderID);

        orderDetailPage = PageGeneratorManager.getOrderDetailPage(driver);
        verifyEquals(orderDetailPage.getOrderID(), orderID);
        verifyEquals(orderDetailPage.getStatus(), "Pending");
        verifyEquals(orderDetailPage.getTotalPrice(), totalPrice);

        billingAddressInfo = orderDetailPage.getBillingAddressInfo();
        log.info("billingAddressInfo" + billingAddressInfo);
        verifyTrue(billingAddressInfo.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfo.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfo.contains(address1));
        verifyTrue(billingAddressInfo.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfo.contains(country));

        paymentMethodInfo = orderDetailPage.getPaymentMethodInfo();
        log.info("paymentMethodInfo" + paymentMethodInfo);
        verifyTrue(paymentMethodInfo.contains("Payment Method: " + paymentMethod05));
        verifyTrue(paymentMethodInfo.contains("Payment Status: Pending"));

        shippingAddressInfo = orderDetailPage.getShippingAddressInfo();
        log.info("shippingAddressInfo" + shippingAddressInfo);
        verifyTrue(billingAddressInfo.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfo.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfo.contains(address1));
        verifyTrue(billingAddressInfo.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfo.contains(country));

        shippingMethodInfo = orderDetailPage.getShippingMethodInfo();
        log.info("shippingMethodInfo" + shippingMethodInfo);
        verifyTrue(shippingMethodInfo.contains("Shipping Method: " + shippingMethod));
        verifyTrue(shippingMethodInfo.contains("Shipping Status: Not yet shipped"));


    }

    @Test
    public void order_06_checkout_payment_by_cart() {
        homeUserPage.clickToDynamicProductImageByTitle(driver, productName5);
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickAddToCartButton();
        productDetailUserPage.clickToCloseIcon(driver);
        productDetailUserPage.clickToCartLink(driver);
        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        cartUserPage.selectGiftWrappingDropdown(giftWrapping);
        cartUserPage.clickToEstimateShippingButton();
        cartUserPage.selectCountryInDrropdown(country);
        cartUserPage.selectStateInDropdown(state);
        cartUserPage.inputToZipcodeTextbox(zipcode);
        cartUserPage.clickToShippingMethod(shippingMethod);
        cartUserPage.clickToApplyButton();
        cartUserPage.waitForAjaxLoadingIconDisappeared(driver);
        verifyEquals(cartUserPage.getTotalValue(), totalPrice);
        cartUserPage.clickToTermOfServiceCheckbox();
        cartUserPage.clickToCheckOutButton();

        checkOutPage = PageGeneratorManager.getCheckOutPage(driver);
        checkOutPage.selectNewAddressIfAny();
        checkOutPage.selectCountryInDropdown(country);
        checkOutPage.selectStateInDropdown(state);
        checkOutPage.inputToCityTextBox(city);
        checkOutPage.inputToAddress1TextBox(address1);
        checkOutPage.inputToZipcodeTextBox(zipcode);
        checkOutPage.inputToPhoneNumberTextBox(phoneNumber);
        checkOutPage.clickToCoutinueBillingButton();
        checkOutPage.waitForLoadingTextBillingDisappeared();

        checkOutPage.clickToShippingMethodRadio(shippingMethod);
        checkOutPage.clickToContinueShippingMethodButton();
        checkOutPage.waitForLoadingTextShippingMethodDisappear();

        checkOutPage.clickToDynamicPaymentMethod(paymentMethod06);
        checkOutPage.clickToContinuePaymentMethodButton();
        checkOutPage.waitForLoadingTextPaymentMethodDisappeared();

        checkOutPage.selectCreditCartType(creditCartType);
        checkOutPage.inputCardHolderName(cartHolderName);
        checkOutPage.inputCardNumber(cartNumber);
        checkOutPage.selectExpireMonth(month);
        checkOutPage.selectExpireYear(year);
        checkOutPage.inputToCartCodeTextbox(code);
        checkOutPage.clickToContinueButtonPaymentInfo();
        checkOutPage.waitForLoadingTextPaymentInfoDisappeared();

        //verify

        billingAddressInfoConfirmOrder = checkOutPage.getBillingAddressInfoConfirmOrder();
        log.info("billingAddressInfo" + billingAddressInfoConfirmOrder);
        verifyTrue(billingAddressInfoConfirmOrder.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfoConfirmOrder.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfoConfirmOrder.contains(address1));
        verifyTrue(billingAddressInfoConfirmOrder.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfoConfirmOrder.contains(country));

        paymentMethodInfoConfirmOrder = checkOutPage.getPaymentMethodInfoConfirmOrder();
        log.info("paymentMethodInfo" + paymentMethodInfoConfirmOrder);
        verifyTrue(paymentMethodInfoConfirmOrder.contains("Payment Method: " + paymentMethod06));

        shippingAddressInfoConfirmOrder = checkOutPage.getShippingAddressInfoConfirmOrder();
        log.info("shippingAddressInfo" + shippingAddressInfoConfirmOrder);
        verifyTrue(billingAddressInfoConfirmOrder.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfoConfirmOrder.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfoConfirmOrder.contains(address1));
        verifyTrue(billingAddressInfoConfirmOrder.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfoConfirmOrder.contains(country));

        shippingMethodInfoConfirmOrder = checkOutPage.getShippingMethodInfoConfirmOrder();
        log.info("shippingMethodInfo" + shippingMethodInfoConfirmOrder);
        verifyTrue(shippingMethodInfoConfirmOrder.contains("Shipping Method: " + shippingMethod));
        verifyEquals(checkOutPage.getProductNameAtConfirm(), productName5);
        verifyEquals(checkOutPage.getTotalPriceAtConfirm(), totalPrice);

        //verify

        checkOutPage.clickToConfirmButton();
        checkOutPage.waitForSubmittingOrderTextDisappeared();

        orderID = checkOutPage.getOrderID();
        checkOutPage.clickToContinueButtonCartSuccess();
        verifyEquals(checkOutPage.getPageUrl(driver), GlobalConstants.USER_URL);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Orders");
        ordersMyAccountUserPage = PageGeneratorManager.getOrdersMyAccountUserPage(driver);
        ordersMyAccountUserPage.clickToDynamicDetailButtonByOrderID(orderID);

        orderDetailPage = PageGeneratorManager.getOrderDetailPage(driver);
        verifyEquals(orderDetailPage.getOrderID(), orderID);
        verifyEquals(orderDetailPage.getStatus(), "Pending");
        verifyEquals(orderDetailPage.getTotalPrice(), totalPrice);

        billingAddressInfo = orderDetailPage.getBillingAddressInfo();
        log.info("billingAddressInfo" + billingAddressInfo);
        verifyTrue(billingAddressInfo.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfo.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfo.contains(address1));
        verifyTrue(billingAddressInfo.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfo.contains(country));

        paymentMethodInfo = orderDetailPage.getPaymentMethodInfo();
        log.info("paymentMethodInfo" + paymentMethodInfo);
        verifyTrue(paymentMethodInfo.contains("Payment Method: " + paymentMethod06));
        verifyTrue(paymentMethodInfo.contains("Payment Status: Pending"));

        shippingAddressInfo = orderDetailPage.getShippingAddressInfo();
        log.info("shippingAddressInfo" + shippingAddressInfo);
        verifyTrue(billingAddressInfo.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfo.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfo.contains(address1));
        verifyTrue(billingAddressInfo.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfo.contains(country));

        shippingMethodInfo = orderDetailPage.getShippingMethodInfo();
        log.info("shippingMethodInfo" + shippingMethodInfo);
        verifyTrue(shippingMethodInfo.contains("Shipping Method: " + shippingMethod));
        verifyTrue(shippingMethodInfo.contains("Shipping Status: Not yet shipped"));


    }

    @Test
    public void order_07_reorder() {
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Orders");

        ordersMyAccountUserPage = PageGeneratorManager.getOrdersMyAccountUserPage(driver);
        ordersMyAccountUserPage.clickToDynamicDetailButtonByOrderID(orderID);

        orderDetailPage = PageGeneratorManager.getOrderDetailPage(driver);
        orderDetailPage.clickToReorderButton();

        cartUserPage = PageGeneratorManager.getCartUserPage(driver);
        cartUserPage.inputQuantity(Integer.toString(qty7));
        cartUserPage.clickToUpdateShoppingCartButton();

        verifyEquals(cartUserPage.getTotalValue(), totalPrice7);
        cartUserPage.clickToTermOfServiceCheckbox();
        cartUserPage.clickToCheckOutButton();

        checkOutPage = PageGeneratorManager.getCheckOutPage(driver);
        checkOutPage.selectNewAddressIfAny();
        checkOutPage.selectCountryInDropdown(country);
        checkOutPage.selectStateInDropdown(state);
        checkOutPage.inputToCityTextBox(city);
        checkOutPage.inputToAddress1TextBox(address1);
        checkOutPage.inputToZipcodeTextBox(zipcode);
        checkOutPage.inputToPhoneNumberTextBox(phoneNumber);
        checkOutPage.clickToCoutinueBillingButton();
        checkOutPage.waitForLoadingTextBillingDisappeared();

        checkOutPage.clickToShippingMethodRadio(shippingMethod);
        checkOutPage.clickToContinueShippingMethodButton();
        checkOutPage.waitForLoadingTextShippingMethodDisappear();

        checkOutPage.clickToDynamicPaymentMethod(paymentMethod06);
        checkOutPage.clickToContinuePaymentMethodButton();
        checkOutPage.waitForLoadingTextPaymentMethodDisappeared();

        checkOutPage.selectCreditCartType(creditCartType);
        checkOutPage.inputCardHolderName(cartHolderName);
        checkOutPage.inputCardNumber(cartNumber);
        checkOutPage.selectExpireMonth(month);
        checkOutPage.selectExpireYear(year);
        checkOutPage.inputToCartCodeTextbox(code);
        checkOutPage.clickToContinueButtonPaymentInfo();
        checkOutPage.waitForLoadingTextPaymentInfoDisappeared();

        //verify

        billingAddressInfoConfirmOrder = checkOutPage.getBillingAddressInfoConfirmOrder();
        log.info("billingAddressInfo" + billingAddressInfoConfirmOrder);
        verifyTrue(billingAddressInfoConfirmOrder.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfoConfirmOrder.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfoConfirmOrder.contains(address1));
        verifyTrue(billingAddressInfoConfirmOrder.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfoConfirmOrder.contains(country));

        paymentMethodInfoConfirmOrder = checkOutPage.getPaymentMethodInfoConfirmOrder();
        log.info("paymentMethodInfo" + paymentMethodInfoConfirmOrder);
        verifyTrue(paymentMethodInfoConfirmOrder.contains("Payment Method: " + paymentMethod06));

        shippingAddressInfoConfirmOrder = checkOutPage.getShippingAddressInfoConfirmOrder();
        log.info("shippingAddressInfo" + shippingAddressInfoConfirmOrder);
        verifyTrue(billingAddressInfoConfirmOrder.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfoConfirmOrder.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfoConfirmOrder.contains(address1));
        verifyTrue(billingAddressInfoConfirmOrder.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfoConfirmOrder.contains(country));

        shippingMethodInfoConfirmOrder = checkOutPage.getShippingMethodInfoConfirmOrder();
        log.info("shippingMethodInfo" + shippingMethodInfoConfirmOrder);
        verifyTrue(shippingMethodInfoConfirmOrder.contains("Shipping Method: " + shippingMethod));
        verifyEquals(checkOutPage.getProductNameAtConfirm(), productName5);
        verifyEquals(checkOutPage.getTotalPriceAtConfirm(), totalPrice7);

        //verify

        checkOutPage.clickToConfirmButton();
        checkOutPage.waitForSubmittingOrderTextDisappeared();

        orderID = checkOutPage.getOrderID();
        checkOutPage.clickToContinueButtonCartSuccess();
        verifyEquals(checkOutPage.getPageUrl(driver), GlobalConstants.USER_URL);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Orders");
        ordersMyAccountUserPage = PageGeneratorManager.getOrdersMyAccountUserPage(driver);
        ordersMyAccountUserPage.clickToDynamicDetailButtonByOrderID(orderID);

        orderDetailPage = PageGeneratorManager.getOrderDetailPage(driver);
        verifyEquals(orderDetailPage.getOrderID(), orderID);
        verifyEquals(orderDetailPage.getStatus(), "Pending");
        verifyEquals(orderDetailPage.getTotalPrice(), totalPrice7);

        billingAddressInfo = orderDetailPage.getBillingAddressInfo();
        log.info("billingAddressInfo" + billingAddressInfo);
        verifyTrue(billingAddressInfo.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfo.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfo.contains(address1));
        verifyTrue(billingAddressInfo.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfo.contains(country));

        paymentMethodInfo = orderDetailPage.getPaymentMethodInfo();
        log.info("paymentMethodInfo" + paymentMethodInfo);
        verifyTrue(paymentMethodInfo.contains("Payment Method: " + paymentMethod06));
        verifyTrue(paymentMethodInfo.contains("Payment Status: Pending"));

        shippingAddressInfo = orderDetailPage.getShippingAddressInfo();
        log.info("shippingAddressInfo" + shippingAddressInfo);
        verifyTrue(billingAddressInfo.contains("Email: " + userEmail));
        verifyTrue(billingAddressInfo.contains("Phone: " + phoneNumber));
        verifyTrue(billingAddressInfo.contains(address1));
        verifyTrue(billingAddressInfo.contains(city + "," + state + "," + zipcode));
        verifyTrue(billingAddressInfo.contains(country));

        shippingMethodInfo = orderDetailPage.getShippingMethodInfo();
        log.info("shippingMethodInfo" + shippingMethodInfo);
        verifyTrue(shippingMethodInfo.contains("Shipping Method: " + shippingMethod));
        verifyTrue(shippingMethodInfo.contains("Shipping Status: Not yet shipped"));


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}


