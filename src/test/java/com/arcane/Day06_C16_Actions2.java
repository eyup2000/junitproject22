package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day06_C16_Actions2 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void windowHandle() {

//    test method olustur : hoverOver() and test the following scenario:
//    1- Given kullanici  https://www.amazon.com/ adresine gider
        driver.get("https://www.amazon.com/");

//    2- When kullanici “Account” linkini click eder
        //1.adım actions object oluştur
        Actions actions = new Actions(driver);

        //2.adım çalışmak istenilen elementi locat et
       WebElement accountList = driver.findElement(By.id("nav-link-accountList"));

       //3.adım haver over yap
        actions.moveToElement(accountList).perform();
        driver.findElement(By.linkText("Account")).click();


//    3- Then page title'in “Your Account” icerdigini verify et
        Assert.assertTrue(driver.getTitle().contains("Your Account"));


    }
}

