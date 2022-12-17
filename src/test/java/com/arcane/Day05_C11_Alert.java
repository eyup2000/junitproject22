package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_C11_Alert {
    /*
    Go to https://the-internet.herokuapp.com/javascript_alerts
    setUp method olustur
    3 test methodu olustur:
    acceptAlert() => birinci alert'e tikla, Text'in “I am a JS Alert” oldugunu verify et ve OK'ye tikla , sonra “You successfully clicked an alert” metnini verify et
    dismissAlert()=> ikinci alert'e tikla,  Text'in "I am a JS Confirm” oldugunu verify et, cancel'i tikla, sonra “You clicked: Cancel” verify et
    sendKeysAlert()=> ucuncu alert'e tikla,  Text'in“I am a JS prompt” oldugunu verify et, “Hello Word” Text'i yaz, OK'ye tikla, and “You entered: Hello Word” Text'ini verify et
 */
        Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert() {
//birinci alert'e tikla,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

// Text'in “I am a JS Alert” oldugunu verify et
        String expected = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expected, actualText);

// ve OK'ye tikla
        driver.switchTo().alert().accept();

// , sonra “You successfully clicked an alert” metnini verify et
        String resault = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You successfully clicked an alert", resault);
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
    }

    @Test
    public void dismissAlert() {
        // ikinci alert'e tikla,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        // Text'in "I am a JS Confirm” oldugunu verify et,
        Assert.assertEquals("I am a JS Confirm", driver.switchTo().alert().getText());

        // cancel'i tikla,
        driver.switchTo().alert().dismiss();

        // sonra “You clicked: Cancel” verify et
        String result2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You clicked: Cancel", result2);
    }

    @Test
    public void SentKeysAlert() {
        //ucuncu alert'e tikla,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        // Text'in“I am a JS prompt” oldugunu verify et,
        Assert.assertEquals("I am a JS prompt", driver.switchTo().alert().getText());

        // “Hello World” Text'i yaz,
        driver.switchTo().alert().sendKeys("Hello World");
        // OK'ye tikla,
        driver.switchTo().alert().accept();
        // and “You entered: Hello Word” Text'ini verify et
     String actuals =   driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You entered: Hello World",actuals);
    }
}