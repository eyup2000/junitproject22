package Alistirma;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Alistirma07 extends TestBase {
    @Test
    public void alistirma() {
        driver.navigate().to("https://demoqa.com/alerts");

        driver.findElement(By.xpath("//button[@id='alertButton']")).click();


        driver.switchTo().alert().accept();
    }
    @Test
    public void Alisitrma2() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/alerts");

        driver.findElement(By.id("timerAlertButton")).click();

        Thread.sleep(6000);
        driver.switchTo().alert().accept();
    }
    @Test
    public void alisitrma3(){
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("confirmButton")).click();

        driver.switchTo().alert().dismiss();

        Assert.assertTrue(driver.findElement(By.className("text-success")).isDisplayed());
    }
}
