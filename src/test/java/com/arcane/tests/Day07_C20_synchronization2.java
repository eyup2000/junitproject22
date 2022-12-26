package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day07_C20_synchronization2 extends TestBase {

    /*
    Method olustur: isEnabled
    https://the-internet.herokuapp.com/dynamic_controls adresine git
    enable Button'una tikla
    Mesajin “It's enabled!” oldugunu verify et
    Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
    Disable button'una tikla
    Mesajin “It's disabled!” oldugunu verify et
    Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)

    NOTE: .isEnabled(); bir elementin enabled olup olmadigini check eder
     */
@Test
    public void isEnabled(){
driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
 WebElement test =driver.findElement(By.xpath("//p[@id='message']"));
    Assert.assertTrue(test.getText().equals("It's enabled!"));

}
}
