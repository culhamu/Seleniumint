package day08_handleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C02_GTT extends TestBase {
    @Test
    public void test01(){
        // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
        driver.get("https://www.amazon.com");
        WebElement amazonsearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(amazonsearchBox.isEnabled());
        String ilkWHD=driver.getWindowHandle();

        // yeni bir tab olarak wisequarter.com'a gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edin
        String expectedWiseUrl="wisequarter";
        String actualWiseUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualWiseUrl.contains(expectedWiseUrl));
        String ikinciWHD="";
        Set<String> tumWHD=driver.getWindowHandles();
        for (String each:tumWHD) {
            if (!each.equals(ilkWHD)){
                ikinciWHD=each;
            }
        }
        // amazon'un acik oldugu tab'a geri donup
        driver.switchTo().window(ilkWHD);

        // Nutella icin arama yapin
        amazonsearchBox.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        String actualResultText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        String expectedResultText="Nutella";
        Assert.assertTrue(actualResultText.contains(expectedResultText));

        // yeni bir window olarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        // wisequarter'in acik oldugu sayfaya donun
        driver.switchTo().window(ikinciWHD);

        // Title'in Wise Quarter icerdigini test edin
        String actualWiseTitle=driver.getTitle();
        String expectedWiseTitle="Wise Quarter";
    }
}
