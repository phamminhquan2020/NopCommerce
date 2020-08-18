package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyProductReviewMyAccountUserPageUI;

public class MyProductReviewMyAccountUserPageObject extends AbstractPage {
    private WebDriver driver;

    public MyProductReviewMyAccountUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public boolean isReviewTitleDisplayed(String reviewTitle) {
        return isElementDisplayed(driver, MyProductReviewMyAccountUserPageUI.DYNAMIC_PRODUCT_TITLE, reviewTitle);
    }

    public String getReviewTextByTitle(String reviewTitle) {
        waitElementVisible(driver, MyProductReviewMyAccountUserPageUI.DYNAMIC_REVIEW_TEXT_BY_TITLE, reviewTitle);
        return getElementText(driver, MyProductReviewMyAccountUserPageUI.DYNAMIC_REVIEW_TEXT_BY_TITLE, reviewTitle);
    }

    public String getReviewInfoByTitle(String reviewTitle) {
        waitElementVisible(driver, MyProductReviewMyAccountUserPageUI.DYNAMIC_REVIEW_INFO_BY_TITLE, reviewTitle);
        return getElementText(driver, MyProductReviewMyAccountUserPageUI.DYNAMIC_REVIEW_INFO_BY_TITLE, reviewTitle);

    }

    public boolean isReviewRatingDisplayedCorrectly(String reviewTitle, String ratingValue) {
        int ratingInt = 20 * Integer.parseInt(ratingValue);
        ratingValue = Integer.toString(ratingInt) + "%";
        System.out.println("rating value: " + ratingValue);
        return isElementDisplayed(driver, MyProductReviewMyAccountUserPageUI.DYNAMIC_REVIEW_RATING, reviewTitle, ratingValue);
    }
}
