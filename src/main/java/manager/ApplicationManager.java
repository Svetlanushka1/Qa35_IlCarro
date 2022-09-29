package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    HelperCar helperCar;


    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://ilcarro-1578153671498.web.app");
        helperUser = new HelperUser(wd);
        helperCar= new HelperCar(wd);
    }


    public void stop(){
        wd.quit();
    }


    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperCar helperCar() {
        return helperCar;
    }
}
