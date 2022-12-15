package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_C1_FirstMavenClass {
    public static void main(String[] args) {
        //System.setPropert("driver Type" , Driver path ) kullanılmayacak

        //Chrome driver set et
        WebDriverManager.chromedriver().setup();

        //driver objesi oluştur
        WebDriver driver = new ChromeDriver();

        //Ekranı kapla
        driver.manage().window().maximize();

        //amazona git
        driver.get("https://www.amazon.com");

        //browser kapat
        driver.close();
    }
}
