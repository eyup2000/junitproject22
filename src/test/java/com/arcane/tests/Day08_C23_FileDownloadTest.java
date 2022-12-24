package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_C23_FileDownloadTest extends TestBase {

    @Test
    public void fileDowloadTest() throws InterruptedException {

        /*
FileDownloadTest() olustur
1- https://the-internet.herokuapp.com/download adresine git
2- flower.png download et
3- Dosyanin download edildigini verify et
 */
        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("image.png")).click();

        Thread.sleep(10000);

       String homePath = System.getProperty("user.home");
        Thread.sleep(10000);

        String fotoPath = homePath + "\\Downloads\\image.jpg";
        System.out.println(fotoPath);
        boolean downloadedMi = Files.exists(Paths.get(fotoPath));
        ////Assert.assertEquals(downloadedMi, true);

        Assert.assertTrue(downloadedMi);


    }
}
