package Alistirma;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Alistirma_C5 extends TestBase {
    @Test
    public void surukleme(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        //BAŞKENTLER
        WebElement Oslo = driver.findElement(By.id("box1"));
        WebElement Stockholm = driver.findElement(By.id("box2"));
        WebElement Washington = driver.findElement(By.id("box3"));
        WebElement Copenhagen = driver.findElement(By.id("box4"));
        WebElement Seoul = driver.findElement(By.id("box5"));
        WebElement Rome =  driver.findElement(By.id("box6"));
        WebElement Madrid =  driver.findElement(By.id("box7"));

        //ÜLKELER
        WebElement Italy = driver.findElement(By.id("box106"));
        WebElement Spain = driver.findElement(By.id("box107"));
        WebElement Norway = driver.findElement(By.id("box101"));
        WebElement Denmark = driver.findElement(By.id("box104"));
        WebElement SouthKorea = driver.findElement(By.id("box105"));
        WebElement Sweden = driver.findElement(By.id("box102"));
        WebElement UnitedStates =  driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);

        //SÜRÜKLEME
        actions.dragAndDrop(Washington,UnitedStates).perform();
        actions.dragAndDrop(Oslo,Norway).perform();
        actions.dragAndDrop(Stockholm,Sweden).perform();
        actions.dragAndDrop(Copenhagen,Denmark).perform();
        actions.dragAndDrop(Seoul,SouthKorea).perform();
        actions.dragAndDrop(Rome,Italy).perform();
        actions.dragAndDrop(Madrid,Spain).perform();



    }
}
