package Alistirma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alıştırma09 {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void Test(){

        driver.get("https://demoqa.com/text-box");

       WebElement fullName= driver.findElement(By.id("userName"));
       fullName.sendKeys("Mehmet Durmus");

        WebElement email= driver.findElement(By.id("userEmail"));
        email.sendKeys("durmus54@gamil.com");

        WebElement address= driver.findElement(By.id("currentAddress"));
        address.sendKeys("yeni mah. yarasa sk. Bakırköy/İstanbul");

        WebElement address2= driver.findElement(By.id("permanentAddress"));
        address2.sendKeys("yeni mah. yarasa sk. Bakırköy/İstanbul");

        WebElement submitButton= driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement assertt =driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']"));

        Assert.assertTrue(assertt.isDisplayed());

    }

}
