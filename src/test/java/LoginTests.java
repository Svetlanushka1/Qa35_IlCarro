import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{



    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
        //if(app.getHelperUser().isElementPresent(By.xpath("//a"))){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess(){
      app.getHelperUser().openLoginFormHeader();
      app.getHelperUser().fillLoginForm("noa@gmail.com","Nnoa12345$");
      app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @Test
    public void loginSuccessModels(){


        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }
}
