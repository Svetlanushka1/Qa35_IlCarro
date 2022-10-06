import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
       if (!app.getHelperUser().isLogged()) {
           User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
           app.getHelperUser().login(user);
           logger.info("The login was needed with user : " +user.toString());
       }
    }

    @Test
    public void addCarSuccess(){


        Random random = new Random();
        int i = random.nextInt(1000)+100;

        Car car = Car.builder()
                .location("Haifa, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.5")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegistrationNumber("11-000-"+i)
                .price("65")
                .distanceIncluded("800")
                .features("Type of features")
                .about("very nice car")
                .build();
        logger.info("The test used car model : " +car.toString());
        app.helperCar().openCarForm();
        app.helperCar().fillCarForm(car);
        app.helperCar().attachPhoto("/Users/tayahatum/Qa35/Qa35_IlCarro/src/test/resources/car1.jpeg");
        app.helperCar().submit();

        Assert.assertEquals(app.getHelperUser().getTitleMessage(),"Car added");
        logger.info("In assert checked message 'Car added' in dialog  ");

    }

    @AfterMethod
    public void posCondition(){
        app.helperCar().returnToHomePage();
    }
}
