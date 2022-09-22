import models.User;
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


        User user=new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @Test
    public void negativeWrongEmail(){

        User user=new User().withEmail("noagmail.com").withPassword("Nnoa12345$");

        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        // Assert errorMessagge
        // Assert buttonYalla not active
    }
    @Test
    public void negativeWrongPassword(){
        User user=new User().withEmail("noa@gmail.com").withPassword("Wwow12345$");

        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        // Assert text message "Authorization error"

    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }
}
