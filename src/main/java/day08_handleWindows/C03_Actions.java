package day08_handleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1
    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement contentClik= driver.findElement(By.id("hot-spot"));
        actions.contextClick(contentClik).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
            String expectedAlertText="You selected a context menu";
            String actualAlertText=driver.switchTo().alert().getText();
        Assert.assertTrue(actualAlertText.equals(expectedAlertText));

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        String ilkWHD=driver.getWindowHandle();

        //6- Elemental Selenium linkine tiklayalim
        WebElement elementalSeleniumClick= driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(elementalSeleniumClick).perform();
        String ikinciWHD="";
        Set<String> tumWHD=driver.getWindowHandles();
        for (String each:tumWHD) {
            if (!each.equals(ilkWHD)){
                ikinciWHD=each;
            }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciWHD);
        String expectedTagText="Elemental Selenium";
        String actualTagText=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedTagText,actualTagText);
    }
}
