package day04_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C02_Maven {
    WebDriver driver;

        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        @After
    public void teardown(){
            driver.close();
        }
        @Test
    public void test(){
            // 1- C01_TekrarTesti isimli bir class olusturun
            // 2- https://www.google.com/ adresine gidin
            driver.get("https://www.google.com/");
            // 3- cookies uyarisini kabul ederek kapatin
            // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
            String actualResultTitle= driver.getTitle();
            String expectedTitle="Google";
            Assert.assertTrue(actualResultTitle.contains(expectedTitle));

            // 5- Arama cubuguna “Nutella” yazip aratin
            WebElement searchBox=driver.findElement(By.xpath("//input[@title='Ara']"));
            searchBox.sendKeys("Nutella"+ Keys.ENTER);
            // 6- Bulunan sonuc sayisini yazdirin
            WebElement result=driver.findElement(By.id("result-stats"));
            String resultStr=result.getText();
            String[] resultArr=resultStr.split(" ");
            String resultInt=resultArr[1].replaceAll("\\D","");
            Integer integer=Integer.parseInt(resultInt);

            // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

            Assert.assertTrue(integer>10000000);

        }


}
