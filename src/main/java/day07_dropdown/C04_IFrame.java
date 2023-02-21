package day07_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_IFrame extends TestBase {
    @Test
    public void test01(){

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement icerikYazisi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(icerikYazisi.isEnabled());
        System.out.println("icerikYazisi = " + icerikYazisi.getText());
        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe= driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframe);
       WebElement textBox= driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
       textBox.sendKeys("Merhaba Dunya!");
        System.out.println(textBox.getText());
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        driver.switchTo().parentFrame();
        String ilkWDM= driver.getWindowHandle();
        driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).click();
        String ikinciWHD="";
        Set<String> tumWHD=driver.getWindowHandles();
        for (String each:tumWHD) {
            if (!each.equals(ilkWDM)){
                ikinciWHD=each;
            }
        }
        driver.switchTo().window(ikinciWHD);
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        String expectedIcerik="Elemental Selenium";
        String actualIcerik=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);
    }
}
