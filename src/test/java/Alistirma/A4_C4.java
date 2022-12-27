package Alistirma;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class A4_C4 extends TestBase {
    @Test
    public void alistirma(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("halı"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[11]")).click();
    }
}
