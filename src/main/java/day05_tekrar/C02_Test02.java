package day05_tekrar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Test02 {










    WebDriver driver;
    @Before
    public void setup(){
        // 1. Launch browser
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
       driver.close();
    }
    @Test
    public void test(){
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.cssSelector("img[src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        // 5. Verify 'Login to your account' is visible
        WebElement loginElement=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginElement.isDisplayed());
        // 6. Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("email1@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        // 8. Verify that 'Logged in as username' is visible
        WebElement username=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(username.isDisplayed());
        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deleted.isDisplayed());


    }
}
