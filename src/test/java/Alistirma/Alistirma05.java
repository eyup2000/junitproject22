package Alistirma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alistirma05 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void deneme(){
        //amazona git https://www.amazon.com/
        driver.get("https://www.amazon.com/");


        //Url dogru olup olmadıgını kontrol et yanlışsa dogrusunu yazır
        String expectedUrl ="https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl)){
            System.out.println("url dogru");
        }else {
            System.out.println("url yanlış");
            System.out.println("beklenen url : "+expectedUrl);
            System.out.println("Dogru url : " + actualUrl);
        }


        //sayfada Gaming accessories varmı diye kontol et
        //String expectedText = "Gaming accessorie";
        String actualText = driver.getPageSource();
        if (actualText.contains("Gaming accessories")){
            System.out.println("Test başarili");
        }else {
            System.out.println("Test başarisiz");
        }


        //arama kısmına kaktüs yazdır
       WebElement Arama = driver.findElement(By.id("twotabsearchtextbox"));
        Arama.sendKeys("Kaktüs");


        //yazılan kaktüsü click et
        driver.findElement(By.id("nav-search-submit-button")).click();


        //uysuz Kaktüs e tıkla
        driver.findElement(By.xpath("//img[@alt='Huysuz Kaktüs']")).click();


        //Buy Now butonuna click et tıkla
        driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();


        // çıkan sayfada mail kısmına "yanlışmail8796@gmail.com" yazdır
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("yanlışmail8796@gmail.com");


        //continue click et
        driver.findElement(By.xpath("//input[@id='continue']")).click();


        //"There was a problem" uyarisini aldıgini kontrol et
        String expectedText ="There was a problem";
        String actualTextt = driver.getPageSource();
        if (actualTextt.contains(expectedText)){
            System.out.println("Test Başarili");
        }else {
            System.out.println("Test başarisiz");
        }


        //browser kapat
        // driver.quit();
    }
}
