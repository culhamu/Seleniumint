package day06_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void test(){
      //  ● Bir class oluşturun: DropDown
      //  ● https://the-internet.herokuapp.com/dropdown adresine gidin.
      //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
      //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      //  4.Tüm dropdown değerleri(value) yazdırın
      //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
      //  degilse False yazdırın.
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm= driver.findElement(By.id("dropdown"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Option 1");
        WebElement selectElement=select.getFirstSelectedOption();
        System.out.println(selectElement);

        select.selectByVisibleText("Option 2");
        WebElement selectElement2=select.getWrappedElement();
        System.out.println(selectElement2.getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getAllSelectedOptions());


    }
    @After
    public void teardown(){

        driver.close();

    }
}
