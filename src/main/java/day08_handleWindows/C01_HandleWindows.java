package day08_handleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_HandleWindows extends TestBase {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText=driver.findElement(By.xpath("//div[@class='example']")).getText();
        String expectedText="Opening a new window";
        Assert.assertTrue(actualText.contains(expectedText));
        String ilkWHD=driver.getWindowHandle();

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.

        String ikinciWHD="";
        Set<String> tumWHD=driver.getWindowHandles();
        for (String each:tumWHD) {
            if (!each.equals(ilkWHD)){
                ikinciWHD=each;
            }
        }
        driver.switchTo().window(ikinciWHD);
        String expectedWindowTitle="New Window";
        String actualWindowTitle=driver.getTitle();
        Assert.assertEquals(expectedWindowTitle,actualWindowTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedWindowText="New Window";
        String actualWindowText=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        Assert.assertEquals(expectedWindowText,actualWindowText);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        driver.switchTo().window(ilkWHD);
       String actualTitle1=driver.getTitle();
        String expectedTitle1="The Internet";
        Assert.assertEquals(expectedTitle1,actualTitle1);
    }
}
