package day10_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void test01(){

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        Actions actions=new Actions(driver);
        WebElement iframe= driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        WebElement productButton= driver.findElement(By.linkText("Our Products"));
        actions.click(productButton).perform();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();

        //4. Popup mesajini yazdirin
        String message=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println("message = " + message);

        //5. “close” butonuna basin
        WebElement closeButton=driver.findElement(By.xpath("//button[text()='Close']"));
        closeButton.click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/index.html";

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
