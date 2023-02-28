package day01;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Youtube extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.youtube.com");

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        
        String domainName=jse.executeScript("return document.domain").toString();
        System.out.println("domainName = " + domainName);
        
        String pageTitle=jse.executeScript("return document.title").toString();
        System.out.println("pageTitle = " + pageTitle);
        
        String pageUrl=jse.executeScript("return document.URL").toString();
        System.out.println("pageUrl = " + pageUrl);

        String ilkWHD=driver.getWindowHandle();
        String ikinciWHD="";

        WebElement loginButton= driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[4]"));
        jse.executeScript("arguments[0].click()",loginButton);
        actions.click(driver.findElement(By.id("identifierId"))).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        WebElement sonucElement= driver.findElement(By.xpath("//div[@jsname='uybdVe']"));
        File dosyaYolu=new File("target/test-classes/day01/youtubekayıt.jpeg");
        File geciciDosya=sonucElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,dosyaYolu);
        } catch (IOException e) {

        }


    }
}
