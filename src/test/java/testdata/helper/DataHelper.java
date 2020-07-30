package testdata.helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private Locale locale = new Locale("en");
    private Faker faker = new Faker(locale);

    public static DataHelper getData() {
        return new DataHelper();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getCompany() {
        return faker.company().name();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password();
    }
}
 