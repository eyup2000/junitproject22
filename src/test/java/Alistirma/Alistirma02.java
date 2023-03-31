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

public class Alistirma02 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test(){
        driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();

      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");

      driver.findElement(By.id("nav-search-submit-button")).click();

      WebElement test = driver.findElement(By.xpath("(//span[@class='a-size-medium-plus a-color-base'])[1]"));
      Assert.assertTrue(test.isDisplayed());

      driver.findElement(By.xpath("(//img[@class='s-image'])[3]")).click();

     WebElement test1 = driver.findElement(By.id("canvasCaption"));
     Assert.assertTrue(test1.isDisplayed());
    }

}
