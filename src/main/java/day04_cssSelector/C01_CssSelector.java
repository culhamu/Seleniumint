package day04_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
      // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
      // 2. Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[type='button']")).click();
      // 3. Login alanine “username” yazdirin
        WebElement loginBox=driver.findElement(By.cssSelector("input[type='text']"));
        loginBox.sendKeys("username");
      // 4. Password alanine “password” yazdirin
        WebElement passwordBox= driver.findElement(By.cssSelector("input[type='password']"));
        passwordBox.sendKeys("password");
      // 5. Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
      // 6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
       driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
      // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountBox=driver.findElement(By.cssSelector("#sp_amount"));
        amountBox.sendKeys("5000");
      // 8. tarih kismina “2020-09-10” yazdirin
        WebElement dateBox=driver.findElement(By.cssSelector("#sp_date"));
        dateBox.sendKeys("2020-09-10");
      // 9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#pay_saved_payees")).click();
      // 10. “The payment was successfully submitted.” mesajinin
      // ciktigini test edin
        String expectedResultElement="The payment was successfully submitted.";
        String actualResultElement=driver.findElement(By.xpath("//span[@title='$ 5000 payed to payee sprint']")).getText();

        if (actualResultElement.equals(expectedResultElement)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED"+
                               "\n Actual Result : "+actualResultElement);
            driver.close();
        }
    }
}
