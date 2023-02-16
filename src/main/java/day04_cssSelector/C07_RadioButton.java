package day04_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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
       // driver.close();
    }
    @Test
    public void test(){
        // a. Verilen web sayfasına gidin.
        // https://facebook.com
        driver.get("https://facebook.com");
        // b. Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        // c. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("//*[@id=\"u_2_b_/z\"]")).sendKeys("Ahmet Ali");
        driver.findElement(By.xpath("//*[@id=\"u_2_d_XL\"]")).sendKeys("Varlıbaşlık");
        driver.findElement(By.xpath("//*[@id=\"u_2_g_YM\"]")).sendKeys("maeklsesgıe45@hotmail.com");
        driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("Sananelan.19587ü");
        driver.findElement(By.id("day")).sendKeys("15");
        driver.findElement(By.id("month")).sendKeys("05");
        driver.findElement(By.id("year")).sendKeys("1995");
        driver.findElement(By.xpath("//label[text()='Erkek']")).click();
        driver.findElement(By.id("u_9_s_r2")).click();
    }


}
