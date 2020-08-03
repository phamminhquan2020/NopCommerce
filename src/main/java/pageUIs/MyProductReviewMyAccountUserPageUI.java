package pageUIs;

public class MyProductReviewMyAccountUserPageUI {
    public static final String DYNAMIC_PRODUCT_TITLE = "//div[@class='review-title']/strong[text()='%s']";
    public static final String DYNAMIC_REVIEW_TEXT_BY_TITLE = "//strong[text()='%s']/parent::div/parent::div/following-sibling::div/div[@class='review-text']";
    public static final String DYNAMIC_REVIEW_INFO_BY_TITLE = "//strong[text()='%s']/parent::div/parent::div/following-sibling::div/div[@class='review-info']";
    public static final String DYNAMIC_REVIEW_RATING = "//strong[text()='%s']/parent::div/following-sibling::div//div[@style='width:%s']";
}
