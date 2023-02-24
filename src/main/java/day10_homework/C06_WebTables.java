package day10_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test01(){

        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        WebElement tumElementler=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumElementler.getText());

        //4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> actualSatirSayisi= driver.findElements(By.xpath("//div/table/tbody/tr"));
        int expectedSAtirsayisi=10;
        Assert.assertEquals(expectedSAtirsayisi,actualSatirSayisi.size());

        //5.Tum satirlari yazdirin
        for (WebElement each:actualSatirSayisi) {

            System.out.println(each.getText());
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,sutunSayisi.size());

        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement each:besinciSutun) {

            System.out.println(each.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturun
        getData(3,3);
    }
    public String getData(int satirNo,int sutunNo){

        String path="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        String istenenData=driver.findElement(By.xpath(path)).getText();


        return istenenData;
    }
}
