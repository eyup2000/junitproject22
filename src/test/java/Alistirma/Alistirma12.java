package Alistirma;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Alistirma12 {

    WebDriver driver;
    @Before
    public void setup (){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    @Test
    public void test() throws InterruptedException {



        driver.get("https://www.google.com.tr/?hl=tr");

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("ingilizce klavye sticer" , Keys.ENTER);

        driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[3]")).click();

       WebElement sepeteEkleAssert = driver.findElement(By.xpath("//button[@class='add-to-basket']"));

        Assert.assertTrue(sepeteEkleAssert.isDisplayed());
        Thread.sleep(3000);
        sepeteEkleAssert.click();
        Thread.sleep(5000);
}
    @After
    public void close(){
        driver.quit();
    }
}
