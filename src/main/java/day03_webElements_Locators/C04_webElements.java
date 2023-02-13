package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_webElements {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        WebElement emailLogin= driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        emailLogin.sendKeys("qweeretredfs@mail.com");

        WebElement facePassword= driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        facePassword.sendKeys("naber");

        WebElement girisButton=driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"));
        girisButton.submit();
        WebElement actualResult=driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String endResult=actualResult.getText();
        String expectedResult="Girdiğin e-posta bir hesaba bağlı değil. Hesabını bul ve giriş yap.";

        if (endResult.contains(expectedResult)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        driver.close();
    }
}
