package day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Test02 {



  //  1 AssertFalse ile negatif testcase yazımı (checkbox üzerinden)
  //  1 AssertTrue veya Equal ile pozitif test yazımı.
  //  1 Tane login test case oluşturulması.
  //  Ayrıca bu testlerden negatif testcase'in basamaklarını yani steplerini manuel olarak da yazın lütfen. İlgili testcase in içine yorum satırı olarak en üste ekleyin.
  //  Testcaseleri yeni TestNG Framework üzerinde yazınız.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){

        //  https://courses.ultimateqa.com/
        //  internet sayfasına gidininiz.
        driver.navigate().to("https://courses.ultimateqa.com/");
        //  sign in => create a new account
        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        driver.findElement(By.id("user[email]")).sendKeys("email@mail.com");
        driver.findElement(By.id("user[password]")).sendKeys("12345");
        driver.findElement(By.id("user[remember_me]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @After
    public void teardown(){

        driver.close();
    }
}
