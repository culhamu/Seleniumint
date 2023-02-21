package day07_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C06_HandleWindows extends TestBase {
    //● Yeni bir class olusturun: WindowHandle
    @Test
    public void test01(){

        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkWHD= driver.getWindowHandle();
        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        //● Sayfa title’nin “wisequarter” icerdigini test edin
        expectedTitle="Wise Quarter";
        actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        expectedTitle="Walmart";
        actualTitle=driver.getTitle();
       Assert.assertTrue(actualTitle.contains(expectedTitle));
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(ilkWHD);
        String expectedUrl="https://www.amazon.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}
