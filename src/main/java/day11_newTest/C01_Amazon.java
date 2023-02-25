package day11_newTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_Amazon extends TestBase {

    @Test
    public void test01(){
        //amazon sayfasına gidin
        driver.get("https://www.amazon.com.tr");

        //cookie kabul edin
        WebElement cookie= driver.findElement(By.id("sp-cc-accept"));
        Actions actions=new Actions(driver);
        actions.click(cookie).perform();

        //arama kutusunu "Airpods" yazılır ve aratılır
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Airpods"+ Keys.ENTER);

        //Ürün sadece amazon tarafından gönderilir filitresi seçilir
        actions.click(driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]"))).perform();
        JavascriptExecutor jsx=(JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,250)","");
        bekle(3);

        //marka apple seçilir
        actions.click(driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]"))).perform();

        //ilk ürün seçilir
        actions.click(driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]"))).perform();

        //Sepete eklenir
        actions.click(driver.findElement(By.id("add-to-cart-button"))).perform();

        //Sepete gidilir
        actions.click(driver.findElement(By.id("nav-cart-text-container"))).perform();

        //ürünün sepete geldiği kontrol edilir
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-truncate-cut']")));
    }
}
