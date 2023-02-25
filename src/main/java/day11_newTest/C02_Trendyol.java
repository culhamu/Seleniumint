package day11_newTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Trendyol extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.trendyol.com");

        Actions actions=new Actions(driver);
        actions.click(driver.findElement(By.id("onetrust-accept-btn-handler"))).perform();

        actions.moveToElement(driver.findElement(By.xpath("(//*[text()='Elektronik'])[2]")))
                .click(driver.findElement(By.xpath("//*[text()='Süpürge']"))).perform();

        actions.click(driver.findElement(By.xpath("//*[text()='Torbasız Süpürge']"))).perform();

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        actions.click(driver.findElement(By.xpath("//*[text()='Kargo Bedava']"))).perform();

        actions.click(driver.findElement(By.xpath("(//span[@class='prdct-desc-cntnr-name hasRatings'])[4]"))).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.click(driver.findElement(By.xpath("//*[text()='Sepete Ekle']"))).perform();

        actions.moveToElement(driver.findElement(By.xpath("(//*[text()='Sepetim'])[1]")))
                .click(driver.findElement(By.xpath("//*[text()='Siparişi Tamamla']"))).perform();




    }
}
