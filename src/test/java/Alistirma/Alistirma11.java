package Alistirma;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Alistirma11 {

    WebDriver driver;
    @Before
    public void setup (){

        WebDriverManager.chromedriver().setup();

         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    Faker faker = new Faker();

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.automationexercise.com/");

     WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
     login.click();

     driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());
     driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(faker.internet().emailAddress());
     driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


     Thread.sleep(2000);
    WebElement Mrbutton = driver.findElement(By.xpath("//input[@id='id_gender1']"));

    if (!Mrbutton.isSelected()){
        Mrbutton.click();
    }

    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(faker.internet().password());

       WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
        Select select =new Select(days);
        select.selectByIndex(16);

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1 =new Select(month);
        select1.selectByIndex(10);

        WebElement years = driver.findElement(By.xpath("//select[@id='years']"));
        Select select3 =new Select(years);
        select3.selectByValue("1993");

        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(faker.address().fullAddress());


        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select select4 =new Select(country);
        select4.selectByIndex(5);


        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());

        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

      WebElement assertt =  driver.findElement(By.xpath("//b"));
        Assert.assertTrue(assertt.isDisplayed());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        WebElement  assert2=  driver.findElement(By.xpath("//b"));
        Assert.assertTrue(assert2.isDisplayed());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(5000);
    }





    @After
    public void close(){
        driver.close();
    }
}
