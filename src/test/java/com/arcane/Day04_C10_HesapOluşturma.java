package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_C10_HesapOluşturma {
    /*
    Zorunlu tum alanlari doldurun ve Hesap olusturmanin basarili oldugunu verify edin
1. Create a class HesapOlusturma
2. Go to https://www.automationexercise.com/
3. Signup/Login link'ine click edin
4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
5. Text'i Verify et : ENTER ACCOUNT INFORMATION
6. Text'i Verify et : ADDRESS INFORMATION
7. Text'i Verify et : Title
8. title'i secin
9. Name girin (var olani degistir)
10. Password girin
11. Date of Birth (dogum tarihi) girin
12. Sign up for our newsletter! click edin
13. Receive special offers from our partners! click edin
14. first name girin
15. last name girin
16. company girin
17. Address girin
18. Country secin
19. State girin
20. City girin
21. ZipCode girin
22. mobile phone girin
23. Create Account'u Click edin
24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
     */
    Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setUp(){


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");


    }
    @Test
    public void hesapOlustur(){
      //  3. Signup/Login link'ine click edin
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
        //isim
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().lastName());

        //email
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(faker.internet().emailAddress());

        //click
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


        //5. Text'i Verify et : ENTER ACCOUNT INFORMATION
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());


      //  6. Text'i Verify et : ADDRESS INFORMATION
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Address Information']")).isDisplayed());


        //7. Text'i Verify et : Title
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Title']")).isDisplayed());

        //8. title'i secin
        WebElement male =driver.findElement(By.xpath("//div[@class='radio']"));
        if (!male.isSelected()){
            male.click();
        }

        //9. Name girin (var olani degistir)
//        10. Password girin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(faker.internet().password());
//
//        11. Date of Birth (dogum tarihi) girin
        //Day
        WebElement Day = driver.findElement(By.xpath("//select[@name='days']"));
        Select DayDropDown = new Select(Day);
        DayDropDown.selectByValue("10");

        //Ay
        WebElement Ay =  driver.findElement(By.xpath("//select[@name='months']"));
        Select AyDropDown = new Select(Ay);
        AyDropDown.selectByVisibleText("May");

      //Yıl
        WebElement Yil =  driver.findElement(By.xpath("//select[@name='years']"));
        Select yilDropDown = new Select(Yil);
        yilDropDown.selectByVisibleText("1999");


//        12. Sign up for our newsletter! click edin
      WebElement newSletter =  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        if (!newSletter.isSelected()){
            newSletter.click();
        }
//        13. Receive special offers from our partners! click edin
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
//
//        14. first name girin
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(faker.name().firstName());
//
//        15. last name girin
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(faker.name().firstName());

//        16. company girin
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(faker.company().name());


//        17. Address girin
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(faker.address().fullAddress());

        //adress 2
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(faker.address().fullAddress());

//        18. Country secin
       WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select countryDropDown = new Select(country);
        countryDropDown.selectByValue("Canada");
//        19. State girin
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys(faker.address().state());

//        20. City girin
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys(faker.address().city());

//        21. ZipCode girin
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys(faker.address().zipCode());

//        22. mobile phone girin
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys(faker.phoneNumber().cellPhone());

//        23. Create Account'u Click edin
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

//        24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
        String expectedUrl = "https://www.automationexercise.com/account_created";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.contains(actualUrl)){
            System.out.println("Tebrikler Test başarılı :)");
        }else {
            System.out.println(expectedUrl+"sayfasında değilsiniz Test başarisiz");

        }

      driver.close();
















    }
 }