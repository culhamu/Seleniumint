package day09_actions_fileUpload;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {

    //Yeni Class olusturun ActionsClassHomeWork
    @Test
    public void test01(){


        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverElementi=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        WebElement linkElementi= driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"));
        //3- Link 1" e tiklayin
        actions.moveToElement(hoverElementi)
                .click(linkElementi).perform();

        //4- Popup mesajini yazdirin
        String popupText=driver.switchTo().alert().getText();
        System.out.println("Popup mesajı : "+popupText);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickButton= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickButton).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String ClickBoxText=driver.findElement(By.xpath("//div[@id='click-box']")).getText();
        System.out.println("ClickBoxText = " + ClickBoxText);

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();

    }
}
