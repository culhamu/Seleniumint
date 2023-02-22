package day08_handleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Menu extends TestBase {
    //Yeni bir class olusturalim: MouseActions3

    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement menuTarget= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(menuTarget).perform();
        //3- “Create a list” butonuna basin
        WebElement listTarget= driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(listTarget).perform();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualText=driver.findElement(By.xpath("(//div[@role='heading'])[1]")).getText();
        String expectedText="Your Lists";
        Assert.assertEquals(expectedText,actualText);
    }
}
