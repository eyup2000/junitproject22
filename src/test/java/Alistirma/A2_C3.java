package Alistirma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class A2_C3 {
    /*
    test method olustur : hoverOver() and test the following scenario:
            1- Given kullanici  https://www.amazon.com/ adresine gider
            2- When kullanici “Account” linkini click eder
            3- Then page title'in “Your Account” icerdigini verify et
            */

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
//        1- Given kullanici  https://www.amazon.com/ adresine gider
        driver.get("https://www.amazon.com/");
//        2- When kullanici “Account” linkini click eder
        Actions actions = new Actions(driver);
       WebElement actionsElemet = driver.findElement(By.id("nav_ya_signin"));
       actions.moveToElement(actionsElemet).perform();
       driver.findElement(By.linkText("Account")).click();
//        3- Then page title'in “Your Account” icerdigini verify et
    }
}
