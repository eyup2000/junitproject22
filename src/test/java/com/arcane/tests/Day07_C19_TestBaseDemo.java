package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_C19_TestBaseDemo extends TestBase {

    /*
    test1 google'da “balik kizartma tavasi” ara
    Ardindan sayfanin “balik kizartma tavasi” icerdigini verify et
    ——————————-
    test2 amazon'da “balik kizartma tavasi” ara
    Ardindan sayfanin “balik kizartma tavasi” icerdigini verify et
    */
@Test
    public void a(){
    driver.get("https://www.google.com");

    //test1 google'da “balik kizartma tavasi” ara
    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("balik kizartma tavasi"+Keys.ENTER);

    //Ardindan sayfanin “balik kizartma tavasi” icerdigini verify et
    Assert.assertTrue(driver.getPageSource().contains("balik kizartma tavasi"));
}
@Test
    public void b(){

    //    test2 amazon'da “balik kizartma tavasi” ara
    driver.get("https://www.amazon.com/");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("balik kizartma tavasi"+Keys.ENTER);

    //    Ardindan sayfanin “balik kizartma tavasi” icerdigini verify et
    Assert.assertTrue(driver.getPageSource().contains("balik kizartma tavasi"));

  }
}
