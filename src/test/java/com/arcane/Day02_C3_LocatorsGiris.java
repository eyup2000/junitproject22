package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_C3_LocatorsGiris {

    /*Bir class olustur : LocatorsGiris
Main method olustur ve asagidaki gorevi (task) yap.

Kullanici "https://www.testyou.in/Login.aspx" gider
username textbox, password textbox, and signin button icin locator bul
Kullanici adi and password'i gir ve sign in button click et
Username : aykut.arcanedata@gmail.com
Password : Aykut123!
Kullanici adini verify et (USE getText() method to get the text from the page)
Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
Sayfada bulunan toplam link sayisini bul
Sayfadan log out yapiniz
Logged out basarili oldugunu verify edin
 */

    WebDriver chrome;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

@Test
    public void locatorGiris(){

        chrome.get("https://www.testyou.in/Login.aspx");

        //kullanıcı adını locate ettik ve kullanıcı adını gonderdik
 // WebElement emailBox = chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
  //emailBox.sendKeys("aykut.arcanedata@gmail.com");
    chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).
            sendKeys("aykut.arcanedata@gmail.com");

    //password için yapın
    chrome.findElement(By.name("ctl00$CPHContainer$txtPassword")).
            sendKeys("Aykut123!");

    //sing in buttoun locate et ve tıkla (click yap)
    chrome.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();

    //kullanıcı adını doğrula
  WebElement kullaniciAdi =  chrome.findElement(By.id("ctl00_headerTopStudent_username"));
  //getText() WebElemetin kendisinin string olarak dondürüyor
   String kullaniciAdiText = kullaniciAdi.getText();
    System.out.println(kullaniciAdiText);

    //Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
  WebElement homeElement = chrome.findElement(By.linkText("Home"));
//    WebElement homeElement1 = chrome.findElement(By.partialLinkText("ome"));

    //linkText() ile partialLinkText() arasındaki farklar:
 //   --linkText mutlaka txt veya metnin tamami bosluk ve noktalama işaretleri dahil yazılır
 //   -- partialLinkText() metnin text'in tamamını yazabildiginiz gibi bir kısmını yazdırabilirsiniz
 //   -- linkText() daha guvenilir cunku butun metni eksiksiz ekledigimizde hata payı azalır


    Assert.assertTrue(homeElement.isDisplayed());
// isDisplayed() bir elementin sayafada bulunup bulunulmadıgına dogrular
// return tipi boolendır => element bulunursa true bulunmassa false


    //log out sekmelerinin sayfada gosterildigini dogrula/verify et
   WebElement logoutElement = chrome.findElement(By.className("signout"));
    Assert.assertTrue(logoutElement.isDisplayed());

    //Sayfada bulunan toplam link sayisini bul
    //linkler a tagı ile olışturulur dolayısıyla butun "a" tag ile oluşturulan elementleri bulursam
    //tum linkkeri bulmuş olurum
    List<WebElement> tumLinkler = chrome.findElements(By.tagName("a"));
int linksayisi = tumLinkler.size();
    System.out.println("Tum Linklerin Sayısı : " + linksayisi);

    //Sayfadan log out yapiniz
    chrome.findElement(By.className("signout")).click();

    //Logged out basarili oldugunu verify edin
  Boolean loggedout = chrome.getCurrentUrl().equals("http://testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx%3faction%3dlogout&action=logout");

  Assert.assertTrue(loggedout);


}
@After
    public void tearDown(){
        chrome.close();
}


}
