package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_C5_GoogleAramaTest {
    /*
    Yeni class olustur : GoogleAramaTest
    Test method'u  olustur ve asagidaki task'i tamamlayin.
    Kullanici https://www.google.com gider
    “porselen caydanlik” aransin
    Bununla baglantili Google'da kac tane sonuc gosteriliyor test edin
    */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //implicitly Wait BEKLEME
        // 30 saniye kadar bekle eger ihtiyaç duyarsan
        //neden beklemeye ihtiyaç duyarız
        //internetimiz yavaş olabilr
        //pc özellikleri den yavaş olabilir
    }

    @Test
    public void Arama (){

        driver.get("https://www.google.com");
      driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("porselen caydanlik"+ Keys.ENTER);
        //driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
     String sonuc =   driver.findElement(By.xpath("//div[@id='result-stats']")).getText().substring(9,16);
        System.out.println(sonuc);
    }
}
