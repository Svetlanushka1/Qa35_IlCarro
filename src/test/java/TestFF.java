import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestFF {
    WebDriver wd;
    @Test
    public void test(){
       // System.setProperty("webdriver.gecko.driver","/Users/tayahatum/Qa35/Qa35_IlCarro/geckodriver");
        wd = new FirefoxDriver();
    }
}
