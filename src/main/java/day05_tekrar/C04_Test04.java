package day05_tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Test04 {


    WebDriver driver;
    @Before
    public void setup(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
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
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("email@mail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement username= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(username.isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.cssSelector("a[href='/logout']")).click();
        //10. Verify that user is navigated to login page
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/login";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Login test PASSED");
        }else {
            System.out.println("Login Test FAILED \n"+"expectedUrl = " + expectedUrl);
        }


    }
}
