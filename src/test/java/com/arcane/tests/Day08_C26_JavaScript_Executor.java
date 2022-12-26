package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day08_C26_JavaScript_Executor extends TestBase {
    @Test
    public void javaScriptExecutor(){
    driver.get("https://www.carettahotel.com/");
    driver.findElement(By.id("details-button")).click();
    driver.findElement(By.id("proceed-link")).click();

    //elementi asagıya kaydır
     WebElement question = driver.findElement(By.xpath("//*[.='Have a Questions?']"));
        Assert.assertTrue(question.isDisplayed());
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",question);
        Assert.assertEquals(question.getText(),"Have a Questions?");
    }
}
