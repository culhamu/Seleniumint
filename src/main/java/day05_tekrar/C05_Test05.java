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

public class C05_Test05 {


    WebDriver driver;
    @Before
    public void setup(){
        // 1. Launch browser
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
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
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("//a[text()=' Home']"));
        Assert.assertTrue(homePage.isDisplayed());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        // 5. Verify 'New User Signup!' is visible
        WebElement newUser= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());
        // 6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ahmet");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("email@mail.com");
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        // 8. Verify error 'Email Address already exist!' is visible
        WebElement email= driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        Assert.assertTrue(email.isDisplayed());
    }
}
