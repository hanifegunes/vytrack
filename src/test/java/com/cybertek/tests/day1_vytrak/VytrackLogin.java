package com.cybertek.tests.day1_vytrak;

import com.cybertek.tests.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackLogin {
    public static void main(String[] args) throws InterruptedException {

      WebDriver access = WebDriverFactory.getDriver("chrome");
        access.manage().window().maximize();
        access.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String link = "https://qa2.vytrack.com/";
        access.get(link);


        Actions action = new Actions(access);

        String user_name = "user13", user_password = "UserUser123";


        access.findElement(By.xpath("(//div//input[@type='text'][1])")).sendKeys(user_name);
        access.findElement(By.xpath("(//div//input[@type='password'][1])")).sendKeys(user_password);

        Thread.sleep(2000);
        access.findElement(By.xpath("(//div//button[@type='submit'])")).click();

        Thread.sleep(2000);
        access.findElement(By.xpath("(//div//span[@class='title title-level-1'])[1]")).click();



        Thread.sleep(2000);
        List<WebElement> bax = access.findElements(By.xpath("//span[contains(text(),'Vehicle')]"));

        Thread.sleep(1000);
        for(WebElement each: bax){
            Thread.sleep(1000);
            action.moveToElement(each).perform();
        }



        Thread.sleep(1000);
        access.findElement(By.xpath("//span[@class='title title-level-2'][1]")).click();

        Thread.sleep(1000);
        List<WebElement> list_of_car = access.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));
        System.out.println("list of car:" + list_of_car.size() );

        WebElement vehicle = access.findElement(By.xpath("//td[@data-column-label='License Plate']"));
        vehicle.click();

        WebElement event = access.findElement(By.xpath("//a[@title='Add an event to this record']"));
        event.click();






        Thread.sleep(5000);
        access.findElement(By.xpath("//input[@data-name='field__title']")).sendKeys("2021_November_Title");
        Thread.sleep(5000);
        WebElement descriptionInbox = access.findElement(By.xpath("//body[@id='tinymce']"));
        action.moveToElement(descriptionInbox).click();
        descriptionInbox.sendKeys("2021_November_Title");


//        Thread.sleep(5000);
//        WebElement saveButton = access.findElement(By.xpath("//button[.='Save']"));
//        saveButton.click();


        Thread.sleep(10000);
        access.quit();











        
    }
}
