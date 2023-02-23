package day10_homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Window_Handle extends TestBase {

    @Test
    public void test01(){

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        String ilkWHD=driver.getWindowHandle();
        String ikinciWHD = "";
        driver.findElement(By.xpath("(//div[@class='section-title'])[2]")).click();

        //4.Diger window'a gecin
        Set<String> tumWHD=driver.getWindowHandles();
        for (String eachWHD:tumWHD) {
            if (!eachWHD.equals(ilkWHD)){
                ikinciWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWHD);

        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin

        Faker faker=new Faker();
        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        actions.click(username)
                .sendKeys(faker.name().username()+Keys.TAB)
                .sendKeys(faker.internet().password()+Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String popupYazisi=driver.switchTo().alert().getText();
        String expectedYazi="validation failed";
        Assert.assertEquals(expectedYazi,popupYazisi);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkWHD);

        //10.Ilk sayfaya donuldugunu test edin
        String ilkSayfaUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/";
        Assert.assertEquals(expectedUrl,ilkSayfaUrl);

    }
}
