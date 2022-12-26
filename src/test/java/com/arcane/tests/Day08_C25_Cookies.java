package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_C25_Cookies extends TestBase {
    @Test
    public void handleCookies(){
        driver.get("https://www.amazon.com/");
        //1. toplam cooking sayisini bul
     Set<Cookie> tumCookies = driver.manage().getCookies();

        int cookiesSayisi = tumCookies.size();
        System.out.println(cookiesSayisi);

        for (Cookie herbirEleman : tumCookies){
            System.out.println("Cookies ismi : "+ herbirEleman.getName());
        }
    }
}
