import javafx.application.Application;
import javafx.stage.Stage;
import testdata.helper.DataHelper;

public class test  {

    public static void main(String[] args) {
        DataHelper  data = DataHelper.getData();
        System.out.println(data.getEmail());
    }


    }

