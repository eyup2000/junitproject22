package Alistirma;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class A1_C1 {
    Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.functionize.com/demo");
    }
    @Test
    public void alistirma(){
       WebElement tiklaVeYaz = driver.findElement(By.xpath("//input[@name='firstname']"));
       tiklaVeYaz.sendKeys(faker.name().firstName());

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.phoneNumber().cellPhone());

        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(faker.company().name());

     WebElement dropDown =   driver.findElement(By.xpath("//select[@name='job_role']"));
        Select drop = new Select(dropDown);
        drop.selectByValue("CIO / CTO");

       WebElement dropDown1 = driver.findElement(By.xpath("//select[@name='biggest_software_challenge']"));
       Select Down = new Select(dropDown1);
       Down.selectByIndex(3);
    }





}
