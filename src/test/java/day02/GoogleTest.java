package day02;

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

public class GoogleTest {


    WebDriver driver;

    String https="https://www.";

    @Before
    public void setup(){
        // ilgili kurulumlari tamamlayalim
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01(){
        // Kullanici https://www.google.com adresine gider
        driver.get(https+"google.com");
        // Kullanici cookies i kabul eder
        // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
        WebElement searchBox= driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys("Dollar to Euro"+ Keys.ENTER);

        // Para birimlerinin karsilastirmasini alir
        String sonucElementi=driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']")).getText();
        sonucElementi=sonucElementi.replaceAll(",",".");
        double actualSonuc=Double.parseDouble(sonucElementi);
        double expectedSonuc=1.5;
        // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir
        Assert.assertTrue(actualSonuc<expectedSonuc);

    }
}
