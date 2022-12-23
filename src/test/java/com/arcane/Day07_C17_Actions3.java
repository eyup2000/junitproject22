package com.arcane;

import com.arcane.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day07_C17_Actions3 extends TestBase {

    /*
    1- test method olustur : keysUpDown()
    2- https://www.google.com sayfasina git
    3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.
    4- cift tiklayarak search box'i etkilestir
 */
    @Test
    public void windowHandle()  {

//        1- test method olustur : keysUpDown()
//        2- https://www.google.com sayfasina git
        driver.get("https://www.google.com");

//        3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.
       WebElement searcBox = driver.findElement(By.xpath("//input[@name='q']"));
        Actions actions = new Actions(driver);

//        4- cift tiklayarak search box'i etkilestir
        actions.keyDown(searcBox , Keys.SHIFT).//Shift butonuna bas
                sendKeys("iPhone Pro Max").//element içine yaz
                keyUp(searcBox,Keys.SHIFT).//shift butonuna basmayı kaldır
                sendKeys("14" + Keys.ENTER).
                build().// perform() daha guçlu yapar __yazmasakta çalışır
                perform();
    }
}
