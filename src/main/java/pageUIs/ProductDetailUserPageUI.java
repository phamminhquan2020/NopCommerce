package pageUIs;

public class ProductDetailUserPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "//a[contains(text(),'Add your review')]";
    public static final String ADD_TO_WISH_LIST_BUTTON = "//div[@class='add-to-wishlist']//input[@value='Add to wishlist']";
    public static final String ADD_TO_COMPARE_BUTTON = "//div[@class='compare-products']//input[@value='Add to compare list']";
    public static final String ADD_TO_CART_BUTTON = "//input[@value='Add to cart']";
    public static final String PROCESSOR_DROPDOWN = "//select[@id='product_attribute_1']";
    public static final String RAM_DROPDOWN = "//select[@id='product_attribute_2']";
    public static final String DYNAMIC_INPUT_OPTION = "//label[contains(text(),'%s')]";
    public static final String QTY_TEXTBOX = "//input[contains(@class,'qty-input')]";

    public static final String DYNAMIC_SOFTWARE_OPTION = "//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String UPDATE_BUTTON = "//input[@value='Update']";
}
