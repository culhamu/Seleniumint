package day07_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Test extends TestBase {

    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedUrl="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //4. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        //6. Verify that cart page is displayed
        String expectedCardUrl="https://automationexercise.com/view_cart";
        String actualCardUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedCardUrl,actualCardUrl);
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        //9. Fill all details in Signup and create account
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).click();
        actions.sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("email2@mail.com").perform();
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("//*[@value='Mr']")).click();
        actions.sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("January")
                .sendKeys(Keys.TAB)
                .sendKeys("1994")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Bulut")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Atatürk mahallesi cengiz topel sokak")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("California")
                .sendKeys(Keys.TAB)
                .sendKeys("Long Beach")
                .sendKeys(Keys.TAB)
                .sendKeys("70770")
                .sendKeys(Keys.TAB)
                .sendKeys("5558976545").perform();
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        driver.manage().deleteAllCookies();
        //11. Verify ' Logged in as username' at top
        String actualLog=driver.findElement(By.xpath("//i[@class='fa fa-user']")).getText();
        String expectedLog="Logged in as Ahmet";
        Assert.assertEquals(expectedLog,actualLog);

        //12.Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        //14. Verify Address Details and Review Your Order
        String actualAdress=driver.findElement(By.xpath("//*[text()='Address Details']")).getText();
        String expectedAdress="Address Details";
        Assert.assertEquals(expectedAdress,actualAdress);

        String actualOrder=driver.findElement(By.xpath("//*[text()='Review Your Order']")).getText();
        String expextedOrder="Review Your Order";
        Assert.assertEquals(expextedOrder,actualOrder);

        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@name='message']")).click();
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@data-qa='name-on-card']"));
        Actions actions1=new Actions(driver);
        actions1.sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567891234567")
                .sendKeys(Keys.TAB)
                .sendKeys("311")
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("1994").perform();

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[text()='Pay and Confirm Order']")).click();
        //18. Verify success message 'Your order has been placed successfully!'
        String expectedMessage="Congratulations! Your order has been confirmed!";
        String actualMessage=driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String actualAccountDelete=driver.findElement(By.xpath("//*[text()='Account Deleted!']")).getText();
        String expectedAccountDelete="ACCOUNT DELETED!";
        Assert.assertEquals(expectedAccountDelete,actualAccountDelete);
    }
}
