package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginFormHeader() {

        wd.findElement(By.cssSelector("a[href ^='/login']")).click();
       // wd.findElement(By.cssSelector("a[href ='/lo']")).click();
        // //a[text()=' Log in ']
    }
    public void openLoginFormFooter() {
        // a[href ^='/login']
        wd.findElement(By.xpath("//a[text()='Log in']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public String getMessage() {
      //pause(3000);
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));

        return wd.findElement(By.cssSelector("h2.message")).getText();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        wd.findElement(By.xpath("//a[text()=' Logout ']")).click();
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        click(By.xpath("//button[text()='Ok']"));
        logger.info("Click OK button was needed");
    }

    public String  getErrorText() {
        return wd.findElement(By.cssSelector("div.error>div")).getText();
    }

    public boolean isYallaButtonNotActive() {
        boolean res =isElementPresent(By.cssSelector("button[disabled]"));

        return res &&!wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
    }

    public String getTitleMessage() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));

       // pause(2000);
        return wd.findElement(By.cssSelector("div.dialog-container>h1")).getText();
    }

    public void openRegistrationFormHeader() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastname());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
        click(By.cssSelector("label[for='terms-of-use']"));
    }
    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int  wight = rect.getWidth();
        int height = rect.getHeight();
        int x  = rect.getX();
        int y = rect.getY();
        int xOffsSet = wight/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label,-xOffsSet,0).click().release().perform();

    }

    public void login(User user) {
        openLoginFormHeader();
        fillLoginForm(user);
        submit();
        clickOkButton();
    }
}
