package Note;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alistirma {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Alistirma01(){
        //"https://www.trendyol.com/" adresine git
        driver.navigate().to("https://www.trendyol.com/");

        //çıkan sayfada erkege tıkla
       //1.Yol
      //WebElement erkekSec = driver.findElement(By.xpath("//img[@alt='Male']"));
      //erkekSec.click();

      //2.Yol
      driver.findElement(By.xpath("//img[@alt='Male']")).click();

      //çıkan sayfada  "Akıllı Cep Telefonları" yazısı oldugunu kontrol et
        String Kontrol =  driver.getPageSource();
        if (Kontrol.contains("Akıllı Cep Telefonları")){

            System.out.println("Test Basarili");
        }else {
            System.out.println("Test Basarisiz");
        }

        //"Akıllı Cep Telefonları" na git
        driver.findElement(By.xpath("//span[@class='name'][1]")).click();
        driver.findElement(By.xpath("//div[@class='overlay']")).click();
        driver.findElement(By.xpath("//div[@class='chckbox'][1]")).click();
        driver.findElement(By.xpath("//div[@class='image-overlay-body'][1]")).click();
        //driver.findElement(By.xpath("//div[@class='slc-txt'][1]")).click();
        //driver.findElement(By.xpath("//button[@class='add-to-basket']")).click();










    }

}
