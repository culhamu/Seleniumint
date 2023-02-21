package day07_dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_IFrame extends TestBase {
    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi=driver.findElements(By.tagName("iframe"));
        System.out.println(iframeSayisi.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız

        WebElement eleman2=driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(eleman2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        bekle(3);


    }
}
