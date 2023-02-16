package day04_cssSelector;

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

public class C03_Maven2 {
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
            driver.close();
        }
        @Test
        public void test(){
            //  1. “https://www.saucedemo.com” Adresine gidin
            driver.get("https://www.saucedemo.com");
            //  2. Username kutusuna “standard_user” yazdirin
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            //  3. Password kutusuna “secret_sauce” yazdirin
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            //  4. Login tusuna basin
            driver.findElement(By.id("login-button")).click();
            //  5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
            WebElement result=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
            result.getText();
            result.click();
            //  6. Add to Cart butonuna basin
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            //  7. Alisveris sepetine tiklayin
            driver.findElement(By.className("shopping_cart_badge")).click();
            //  8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
            WebElement basket= driver.findElement(By.id("item_4_title_link"));
            String expected="Sauce Labs Backpack";
            Assert.assertTrue(basket.getText().equals(expected));

        }



}
