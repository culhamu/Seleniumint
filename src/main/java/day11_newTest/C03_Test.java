package day11_newTest;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C03_Test extends TestBase {
    static List<WebElement> allProduct;
    static WebElement searchBox;
    @Test
    public void test01(){


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Click on 'Products' button
        Actions actions=new Actions(driver);
        actions.click(driver.findElement(By.xpath("//i[@class='material-icons card_travel']"))).perform();

         //WebElement cookie=driver.findElement(By.xpath("//span[text()='Close']"));
        // cookie.click();


        JavascriptExecutor jsx=(JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,100)","");

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        allProduct=driver.findElements(By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/div/div/p"));
        int expectedProduct=36;
        Assert.assertEquals(expectedProduct,allProduct.size());

        //5. Enter product name in search input and click search button
        searchBox= driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.sendKeys("Green Side Placket Detail T-Shirt");

        WebElement clickButton=driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        clickButton.click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searched= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searched.isDisplayed());

        //7. Verify all the products related to search are visible

        WebElement searchedProduct=driver.findElement(By.xpath("//*[@alt='ecommerce website products']"));
        Assert.assertTrue(searchedProduct.isDisplayed());

        //8. Add those products to cart
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='product-overlay']")))
                .click(driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"))).perform();

        //9. Click 'Cart' button and verify that products are visible in cart
        WebElement addCart=driver.findElement(By.xpath("//*[text()='View Cart']"));
        addCart.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Green Side Placket Detail T-Shirt']")).isDisplayed());

        //10. Click 'Signup / Login' button and submit login details

        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        WebElement signup=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        Faker faker=new Faker();
        actions.click(signup)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        WebElement gender=driver.findElement(By.xpath("//input[@id='id_gender1']"));

        actions.click(gender)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                        .sendKeys(faker.internet().password())
                                .sendKeys(Keys.TAB)
                                        .sendKeys("15")
                                                .sendKeys(Keys.TAB)
                                                        .sendKeys("March")
                                                                .sendKeys(Keys.TAB)
                                                                        .sendKeys("1995")
                                                                                .sendKeys(Keys.TAB)
                                                                                .sendKeys(Keys.TAB)
                                                                                .sendKeys(Keys.TAB)
                                                                                        .sendKeys(faker.name().firstName())
                                                                                                .sendKeys(Keys.TAB)
                                                                                                        .sendKeys(faker.name().lastName())
                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                        .sendKeys(faker.address().fullAddress())
                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                        .sendKeys("Canada")
                                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                                        .sendKeys(faker.address().state())
                                                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                                                        .sendKeys(faker.address().cityName())
                                                                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                                                                        .sendKeys(faker.address().zipCode())
                                                                                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                                                                                        .sendKeys(faker.phoneNumber().cellPhone())
                                                                                                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                                                                                                .sendKeys(Keys.TAB)
                                                                                                                                                                                                                .sendKeys(Keys.ENTER).perform();



        //11. Again, go to Cart page
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();

        //12. Verify that those products are visible in cart after login as well
        WebElement urun=driver.findElement(By.xpath("//a[text()='Green Side Placket Detail T-Shirt']"));
        Assert.assertTrue(urun.isDisplayed());
    }


}
