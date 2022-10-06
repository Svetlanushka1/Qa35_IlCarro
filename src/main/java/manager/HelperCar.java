package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);
        //click(By.cssSelector("[href='/let-car-work']"));
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"),car.getEngine());
        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWD());
        type(By.id("doors"), car.getDoors());
        type(By.id("seats"),car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegistrationNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        type(By.cssSelector(".feature-input"), car.getFeatures());
        type(By.id("about"), car.getAbout());


    }

    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);
        //select.selectByIndex(3);
        //select.selectByValue("Diesel");
        //select.selectByVisibleText("");
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"),location);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public void attachPhoto(String link) {

        wd.findElement(By.id("photos")).sendKeys(link);
    }

    public void returnToHomePage() {
        click(By.xpath("//button[text()='Search cars']"));
        logger.info("We returned to Home Page");
    }
}
