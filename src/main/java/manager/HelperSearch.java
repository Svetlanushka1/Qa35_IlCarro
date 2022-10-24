package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {

        typeCity(city);
        click(By.id("dates"));
        //   "10/25/2022"
        // "aaa/fff/r"   ["aaa"] ["fff"] ["r"]
        String[] from =dataFrom.split("/");  /// ["10"] ["25"] ["2022"]  from[1] ="25"

       // String locator1 ="//div[text()=' 25 ']";
        String locator = "//div[text()=' "+from[1]+" ']";

        ///  "how are you, Dolli?"      names [Dolli] [Molli] [lis]
        //  "how are you, "+names[2]+"?"      how are you, lis?

        click(By.xpath(locator));




        // "10/30/2022"
        String [] to = dataTo.split("/");   /// to[1]
        String locator2 = "//div[text()=' "+to[1]+" ']";

        click(By.xpath(locator2));

    }
    public void searchCurrentMonth2(String city, String dataFrom, String dataTo) {

        typeCity(city);
        clearTextBoxDates();
        click(By.id("dates"));

        String[] from =dataFrom.split("/");


        //String locator = "//div[text()=' "+from[1]+" ']";
        String locator = String.format("//div[text()=' %s ']",from[1]) ;
        click(By.xpath(locator));


        String [] to = dataTo.split("/");

        String locator2 =  String.format("//div[text()=' %s ']",to[1]);

        click(By.xpath(locator2));

    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        pause(500);
        click(By.cssSelector("div.pac-item"));

    }

    public void searchNextMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        clearTextBoxDates();
        click(By.id("dates"));
        click(By.cssSelector("button[aria-label='Next month']"));

      //  "11/25/2022","11/30/2022"
        
        //div[text()=' 25 ']
        String [] from = dataFrom.split("/"); // ["11"] ["25"] ["2022"] from[1] = "25"
        
        String locator = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locator));
        
        String [] to =dataTo.split("/");
        String locator1 =String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator1));
        

    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    public void selectAnyPeriod(String city, String dataFrom, String dataTo) {  // "11/10/2022"                   "6/10/2023"
        typeCity(city);
        clearTextBoxDates();
        click(By.id("dates"));
        //String  nowData = "10/20/2022";
        LocalDate now = LocalDate.now();
        LocalDate from=LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));


        logger.info("year --> " +now.getYear() );
        logger.info("Day  of Month -->" +now.getDayOfMonth() );
        logger.info("Month value -->" +now.getMonthValue() );

//        String [] from = dataFrom.split("/");//  from[2] = "2022";
//        int diffYear = Integer.parseInt(from[2]) -now.getYear();


        int diffYear;
        int diffMonth;
        diffYear = from.getYear()-now.getYear();
        if(diffYear==0){
            diffMonth= from.getMonthValue()-now.getMonthValue(); //11-10 = 1
        }else {
            diffMonth=12-now.getMonthValue()+from.getMonthValue();// 12-10+3 = 5
        }

        clickNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        ///****************
        diffYear = to.getYear()-from.getYear();
        if (diffYear==0){
            diffMonth = to.getMonthValue()-from.getMonthValue();
        }else {
            diffMonth = 12-from.getMonthValue()+ to.getMonthValue();
        }
        clickNextMonth(diffMonth);
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));

    }

    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("button[aria-label='Next month']"));
        }

    }

    public boolean isDataCorrect(String from, String to) {
        WebElement element= wd.findElement(By.cssSelector("input[aria-haspopup='dialog']"));
        System.out.println(element.getText());
        return true;

    }

    public void typePeriodInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);
        clearTextBoxDates();
        typePeriod(dataFrom,dataTo);
    }

    private void typePeriod(String dataFrom, String dataTo) {  // 9/25/2022 - 10/26/2022
        type(By.id("dates"),dataFrom + " - "+dataTo);
        click(By.cssSelector(".cdk-overlay-container"));
    }

    public void clickLogo() {
        click(By.cssSelector(".header a.logo"));
    }

    public void clearTextBoxDates(){
        WebElement  el = wd.findElement(By.id("dates"));
        String osName = System.getProperty("os.name");
        System.out.println(osName);   /// Mac OS X
        if(osName.startsWith("Mac")){
            logger.info("OS is --->" +osName);
            // Command +a
            el.sendKeys(Keys.COMMAND,"a");
        }else {
            logger.info("OS is --->" +osName);
            el.sendKeys(Keys.CONTROL,"a");
          //  Cntr +a
        }
        el.sendKeys(Keys.DELETE);
    }
}
