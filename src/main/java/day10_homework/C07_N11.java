package day10_homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_N11 extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.n11.com");

        WebElement elektronik= driver.findElement(By.xpath("(//a[@class='itemContainer'])[2]"));
        WebElement bilgisayar= driver.findElement(By.xpath("//a[@title='Bilgisayar']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(elektronik)
                .click(bilgisayar).perform();

        WebElement resultText= driver.findElement(By.xpath("//div[@class='resultText ']"));
        String[] resultArr=resultText.getText().split(" ");
        String strResult=resultArr[2].replaceAll("\\D","");
        int intResult=Integer.parseInt(strResult);
        System.out.println("Bulunan sonuş sayısı : "+intResult);


        driver.findElement(By.xpath("//a[@title='Dizüstü Bilgisayar']")).click();
        driver.manage().deleteAllCookies();

        WebElement i7= driver.findElement(By.xpath("(//span[@class='label'])[2]"));

        actions.click(i7).perform();

        WebElement gb=driver.findElement(By.xpath("(//span[@class='label'])[18]"));
        actions.click(gb).perform();

        actions.click(driver.findElement(By.xpath("(//a[@class='label'])[5]"))).perform();

        actions.click(driver.findElement(By.xpath("//span[@data-pid='552154734']"))).perform();

        driver.findElement(By.xpath("//i[@class='iconsBasketWhite']")).click();
        driver.findElement(By.xpath("//span[@class='btn btnBlack']")).click();

        WebElement resultText2= driver.findElement(By.xpath("//a[@class='prodDescription']"));

        String expectedText="Monster Tulpar T7 V20.5.6 i7-12700H 32 GB 1 TB SSD 6 GB RTX3060 144Hz 17.3\" Dos Dizüstü Bilgisayar";

        Assert.assertEquals(expectedText,resultText2.getText());


    }
}
