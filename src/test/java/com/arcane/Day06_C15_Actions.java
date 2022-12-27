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

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Day06_C15_Actions {
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
//
//    Test method olustur : contextClickMethod() ve scenario test et:

//   1-  Given kullanici the https://the-internet.herokuapp.com/context_menu sayfasindadir
        driver.get("https://the-internet.herokuapp.com/context_menu");
//   2-  When box (kutucuk) Right clicks edilir
        //1.adım action object oluştur
        Actions actions = new Actions(driver);

        //2.adım çalışmak istenilen elementi locat et
      WebElement box = driver.findElement(By.id("hot-spot"));

        //3.adım action object oluştu , elementi bulduk aldık right(sağ tıkla ) click yap perform() sonda mutlaka kullan
        actions.contextClick(box).perform();

//   3- Then “You selected a context menu” alert mesajini verify et
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
//        String expected = "You selected a context menu";
//        String actual = driver.switchTo().alert().getText();
//        Assert.assertEquals(expected,actual);

//   4- Then alert'u accept et
        driver.switchTo().alert().accept();



    }
}
