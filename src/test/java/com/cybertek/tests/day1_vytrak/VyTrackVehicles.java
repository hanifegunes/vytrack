package com.cybertek.tests.day1_vytrak;

import com.cybertek.tests.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VyTrackVehicles {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/";
        driver.get(url);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username or Email']"));
               username.sendKeys("user13");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']") );
                password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-uppercase btn-primary pull-right']"));
              login.click();

        WebElement fleetClick = driver.findElement(By.className ( "unclickable" ));
        fleetClick.getAttribute ( "href" );
        fleetClick.click ();

        Thread.sleep ( 10000 );

        WebElement fleetElement = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
                     fleetElement.click();

        List<String>expectedItems = new ArrayList<>(Arrays.asList("Vehicles","Vehicle Odometer","Vehicle Cost","Vehicle Contracts","Vehicle Fuel Logs"));


         List<WebElement> menuItems = driver.findElements(By.xpath("//span[@class='title title-level-2']"));

            int count = 0;
         




        List<WebElement>cars =driver.findElements(By.xpath("//li[@class='dropdown-menu-single-item']")) ;
        System.out.println("Count: "+cars.size());                                                //li[@class='
            for(WebElement each: cars){
                each.click();

                Thread.sleep(3000);
            }



    }
}
     /*

     User Story:
   As a truck driver I should be able to access Vehicle under Fleet module

Acceptance Criteria:
   1. Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
   2. Verify that when user click on any car on the grid , system should display general information
about the car
   3. Verify that truck driver can add Event and it should display under Activity tab and General
information page as well .
   4. Verify that Truck driver can reset the setting


      */