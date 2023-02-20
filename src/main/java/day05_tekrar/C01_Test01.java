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

public class C01_Test01 {


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
        // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Ömer Faruk");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("email1@mail.com");
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement account= driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(account.isDisplayed());
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.xpath("//option[text()='7']")).click();
        driver.findElement(By.xpath("//option[text()='April']")).click();
        driver.findElement(By.xpath("//option[text()='1990']")).click();
        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();
        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']")).click();
        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Ömer Faruk");
        driver.findElement(By.id("last_name")).sendKeys("Doğan");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Wisequarter");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("yeni mahalle 3. sokak nur sitesi A blok kat:5 daire:14");
        driver.findElement(By.xpath("//option[text()='United States']")).click();
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Texas");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Houston");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("77070");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("+12815553890");
        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated= driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        // 16. Verify that 'Logged in as username' is visible
       driver.manage().deleteAllCookies();
        WebElement username=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(username.isDisplayed());
        // 17. Click 'Delete Account' button
        driver.findElement(By.linkText(" Delete Account")).click();
        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeleted.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    }
}
