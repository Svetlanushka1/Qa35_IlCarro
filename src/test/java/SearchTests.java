import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess(){
        app.getSearch().searchCurrentMonth2("Tel Aviv","10/25/2022","10/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchNextMonthSuccess(){
        app.getSearch().searchNextMonth("Tel Aviv","11/25/2022","11/30/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }
}
