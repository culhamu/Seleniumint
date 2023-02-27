package day01;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Ebay extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.ebay.com/");
        driver.navigate().refresh();
        Actions actions=new Actions(driver);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement electronics= driver.findElement(By.linkText("Electronics"));
        actions.moveToElement(electronics).perform();
        actions.click(driver.findElement(By.linkText("Computers and tablets"))).perform();

        WebElement pcLaptop= driver.findElement(By.xpath("//div[text()='PC Laptops']"));
        jse.executeScript("arguments[0].scrollIntoView();",pcLaptop);
        jse.executeScript("arguments[0].click();",pcLaptop);

        actions.click(driver.findElement(By.xpath("//p[text()='32 GB']"))).perform();
        jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Intel Core i7 12th Gen.']")));

        driver.findElement(By.xpath("//span[text()='Brand']")).click();

        WebElement msi=driver.findElement(By.xpath("//span[text()='MSI']"));
        jse.executeScript("arguments[0].scrollIntoView();",msi);
        jse.executeScript("arguments[0].click();",msi);

        WebElement resultText= driver.findElement(By.xpath("//h2[@class='srp-controls__count-heading']"));
        File recordLocate=new File("target/test-classes/day01/sonuc.jpeg");
        File geciciDosya=resultText.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,recordLocate);
        } catch (IOException e) {

        }

        driver.findElement(By.xpath("//span[text()='Buying Format']")).click();
        actions.click(driver.findElement(By.xpath("//span[text()='Buy It Now']"))).perform();
        String ilkWHD=driver.getWindowHandle();
        jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[@class='s-item__title'])[4]")));

        String ikinciWHD="";

        Set<String> tumWHD=driver.getWindowHandles();

        for (String each:tumWHD) {

            if (!each.equals(ilkWHD)){
                ikinciWHD=each;
            }
        }
        driver.switchTo().window(ikinciWHD);

        TakesScreenshot tss= (TakesScreenshot) driver;
        File tumSayfaSS=new File("target/test-classes/day01/tumsayfa.png");
        geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {

        }

        WebElement sonuc= driver.findElement(By.xpath("//h1[@class='product-title']"));
        Assert.assertTrue(sonuc.isDisplayed());

    }
}
