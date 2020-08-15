import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testdata.helper.DataHelper;

public class test {
    static DataHelper data;
    public static void main(String[] args) {
getData();
    }
public static void getData() {
        data = DataHelper.getData();
    System.out.println(data.getCreditCardNumber());
    System.out.println(data.getCreditCardExpire());
}
}

