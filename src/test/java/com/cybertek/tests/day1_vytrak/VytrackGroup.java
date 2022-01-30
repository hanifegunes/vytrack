package com.cybertek.tests.day1_vytrak;

import com.cybertek.tests.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VytrackGroup {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
       String url = "https://qa2.vytrack.com/";
        driver.get(url);



       WebElement noClickFleetButton =driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));

    Actions actions = new Actions(driver);
        actions.moveToElement(noClickFleetButton).perform();
        Thread.sleep(2000);


        WebElement vehiclesButton = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        vehiclesButton.click();

        // 1. Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
        // <li class="dropdown dropdown-level-1">
        WebElement fleetPage = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        actions.moveToElement(fleetPage).perform();
        // <span class="title title-level-2">Vehicles</span>
         vehiclesButton = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        vehiclesButton.click();
         actions = new Actions(driver);

        String appUrl = "https://qa3.vytrack.com/user/login";
        String userName = "user13";
        String password = "UserUser123";


        // ->> 1. Open website / go to login page
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        Actions action = new Actions(driver);

        // ->> 2. Enter valid  username:
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(userName);
        Thread.sleep(2000);

        //    ->> 3. Enter valid password:
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys(password);
        Thread.sleep(2000);

        //    ->> 4. Click "Log in" button
        WebElement logInButton = driver.findElement(By.cssSelector("button[type='submit']"));
        logInButton.click();

        // 1. Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
        // <li class="dropdown dropdown-level-1">
        fleetPage = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        action.moveToElement(fleetPage).perform();
        // <span class="title title-level-2">Vehicles</span>
         vehiclesButton = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        vehiclesButton.click();



    }
}
