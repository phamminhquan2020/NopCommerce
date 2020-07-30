package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class RegisterUserPageObject extends AbstractPage {
    private WebDriver driver;

    public RegisterUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMaleGender() {

    }

    public void inputFirstName(String firstname) {

    }

    public void inputLastName(String lastname) {
        //todo
    }

    public void selectDay(String day) {
        //todo
    }

    public void selectMonth(String month) {
        //todo
    }

    public void selectYear(String year) {
    }

    public void inputEmail(String email) {
    }

    public void inputCompanyName(String companyName) {
    }

    public void inputPassword(String password) {
    }

    public void inputConfirmPassword(String password) {
    }

    public void clickRegisterButton() {
    }
}
