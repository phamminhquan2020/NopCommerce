import testdata.helper.DataHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {
    static DataHelper data;
    public static void main(String[] args) {
getData();
    }
public static void getData() {
        data = DataHelper.getData();
    System.out.println(data.getCreditCardNumber());
    System.out.println(data.getCreditCardExpire());
    int keepDate = 10;
    List<String> dateList = new ArrayList<>();
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy");
    Date startDate = cal.getTime();
    cal.add(Calendar.DATE, -3);
    Date endDate = cal.getTime();

    for (int i = 0; i < keepDate; i++) {
        cal.add(Calendar.DATE, -1);
        dateList.add(formater.format((cal.getTime())).toString());
    }
    System.out.println(dateList);
}
}

