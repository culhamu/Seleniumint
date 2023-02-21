package day07_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_BasicAuthentication extends TestBase {
    //1- Bir class olusturun : BasicAuthentication
    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak
        //authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String expectedSonucYazisi="Basic Auth";
        String actualSonucYazisi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        driver.findElement(By.linkText("Elemental Selenium")).click();

        String ilkWHD=driver.getWindowHandle();
        String ikinciWHD="";
        Set<String> tumWHD=driver.getWindowHandles();
        for (String each:tumWHD) {
            if (!each.equals(ilkWHD)){
                ikinciWHD=each;
            }
        }
        driver.switchTo().window(ikinciWHD);
        expectedSonucYazisi="Elemental Selenium";
        actualSonucYazisi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }
}
