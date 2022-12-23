package com.arcane;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day07_C18_Actions4 extends TestBase {
/*
    Test method olustur : scrollUpDown()
    1- Amazon'a git : https://www.amazon.com
    2- Sayfayi Scroll down (asagi kaydir) yap
    3- Sayfayi Scroll up (yukari kaydir) yap
    */
@Test
    public void scrollUpDown() throws InterruptedException {

//    1- Amazon'a git : https://www.amazon.com
    driver.get("https://www.amazon.com");
//    2- Sayfayi Scroll down (asagi kaydir) yap
    Actions actions = new Actions(driver);

    actions.sendKeys(Keys.ARROW_DOWN).//sayfayı aşağıya götürür ARROW_DOWN == Scroll down == page down aynıdır
            perform();

    //Başka bir yöntem daha fazla aşgıya indirir "PAGE_DOWN"
    Thread.sleep(3000);
    actions.sendKeys(Keys.PAGE_DOWN).
            perform();
//    3- Sayfayi Scroll up (yukari kaydir) yap
    actions.sendKeys(Keys.ARROW_UP).perform();
    actions.sendKeys(Keys.PAGE_UP).perform();

}

}
