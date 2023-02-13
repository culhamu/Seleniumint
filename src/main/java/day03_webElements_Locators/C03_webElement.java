package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_webElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
       WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
      searchBox.sendKeys("Nutella"+ Keys.ENTER);
      WebElement resultElement=driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-normal']"));
        System.out.println(resultElement.getText());
      Thread.sleep(1000);
      driver.close();
    }
}
