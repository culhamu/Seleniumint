package day10_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverBox= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);

        actions.moveToElement(hoverBox).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]")).click();


        //4. Popup mesajini yazdirin
        System.out.println("Popup Mesajı : "+driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickButton= driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(clickButton).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickButton.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();
        Assert.assertTrue(doubleClick.isDisplayed());
    }
}
