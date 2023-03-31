package Alistirma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alistirma08 {

   WebDriver driver;
        @Before
        public void setup(){
        WebDriverManager.chromedriver().setup();

         driver = new ChromeDriver();

        driver.manage().window().maximize();

        }

        @Test
        public void test(){

            driver.navigate().to("https://www.automationexercise.com/");

            WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
            loginButton.click();

            WebElement name = driver.findElement(By.name("name"));
            name.sendKeys("Furkan");

            WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
            email.sendKeys("frk5487@gmail.com");

            WebElement signupButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
            signupButton.click();

            //Assert
            WebElement resimAssert =  driver.findElement(By.xpath("//img[@alt='Website for practice automation']"));

            Assert.assertTrue(resimAssert.isDisplayed()); //varmı

            WebElement radioButton = driver.findElement(By.id("id_gender1"));

            if (!radioButton.isSelected()){
                radioButton.click();
            }

            WebElement day = driver.findElement(By.xpath("//select[@id='days']"));

            Select select = new Select(day);
            select.selectByValue("10");













        }

}


