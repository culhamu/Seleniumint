package day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
    driver.get("https://www.amazon.com");
    WebElement ddm= driver.findElement(By.xpath("//select[@title='Search in']"));
    Select select=new Select(ddm);
        List<WebElement> optionlist=select.getOptions();
        for (WebElement each:optionlist) {
            System.out.println("Tümlist = " + each.getText());
        }
    select.selectByIndex(4);
    WebElement serachBox=driver.findElement(By.id("twotabsearchtextbox"));
    serachBox.sendKeys("beauty products for women"+ Keys.ENTER);



    }
    @After
    public void teardown(){

        driver.close();
    }
}
