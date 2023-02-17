package day04_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C07_RadioButton {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
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
        // a. Verilen web sayfasına gidin.
        // https://facebook.com
        driver.get("https://facebook.com");
        // b. Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // c. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kaydol= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(kaydol)
                .sendKeys("ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Adiguzel")
                .sendKeys(Keys.TAB)
                .sendKeys("5548976536")
                .sendKeys(Keys.TAB)
                .sendKeys("12346798")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("30")
                .sendKeys(Keys.TAB)
                .sendKeys("Haz")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


    }


}
