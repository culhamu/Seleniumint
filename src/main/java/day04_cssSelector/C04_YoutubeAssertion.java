package day04_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_YoutubeAssertion {
           //1) Bir class oluşturun: YoutubeAssertions
           //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        //2) https://www.youtube.com adresine gidin
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    @Test
    public void test02(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageTest= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(imageTest.isDisplayed());
    }
    @Test
    public void test03(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void test04(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String title=driver.getTitle();
        String expected="youtube";
        Assert.assertFalse(title.equals(expected));
    }

}
