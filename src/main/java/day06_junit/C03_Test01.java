package day06_junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_Test01 {

       // http://gcreddy.com/project/admin/login.php
       // Username : gcreddy
       // Password : Temp@2020
       // Aşağıdaki manuel testcase’in steplerini otomate ediniz.
       // TESTCASE STEPLERİ:

    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        // 1. Kullanıcı http://gcreddy.com/project/admin/login.php sayfasına gider.
        driver.get("http://gcreddy.com/project/admin/login.php");
        // 2. Username textbox kutusuna kullanıcı adını girer.
        // 3. Password textbox kutusuna kullanıcı şifresini girer.
        // 4. Login butonuna tıklar.
        WebElement login=driver.findElement(By.id("tdb1"));
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//input[@name='username']")).click();
        actions.sendKeys("gcreddy")
                .sendKeys(Keys.TAB)
                .sendKeys("Temp@2020")
                .sendKeys(Keys.TAB)
                .click(login).perform();
        // 5. Sol menü bar üzerniden Customers sekmesine tıklar.
        driver.findElement(By.id("ui-accordion-adminAppMenu-header-2")).click();
        // 6. Açılan alt menüden Customers linkine tıklar.
        driver.findElement(By.xpath("(//a[text()='Customers'])[2]")).click();
        // 7. Sag menü kutusnudaki Edit butonuna tıklar.
        driver.findElement(By.id("tdb1")).click();
        // 8. Personal bilgileri içindeki Firstname textbox kutsuna ismini girer.
        // 9. Personal bilgileri içindeki Lastname textbox kutsuna soyismini girer.
        // 10. Personal bilgileri içindeki Date of Birth textbox kutsuna doğum tarihini girer.
        // 11. Personal bilgileri içindeki E-Mail Address textbox kutsuna e-mail adresini girer.
        // 12. Company bilgileri içindeki Company name textbox kutusuna şirket ismini girer.
        // 13. Adres bilgileri içindeki Street textbox kutsuna sokak ismini girer.
        // 14. Adres bilgileri içindeki Suburb textbox kutsuna belediye ismini girer.
        // 15. Adres bilgileri içindeki Post Code textbox kutsuna posta kutusu numarasını girer.
        // 16. Adres bilgileri içindeki City textbox kutsuna Şehir ismini girer.
        // 17. Adres bilgileri içindeki State textbox kutsuna posta kutusu Eyalet ismini girer.
        driver.findElement(By.xpath("//input[@name='customers_firstname']")).click();
        actions.sendKeys("Kemal")
                .sendKeys(Keys.TAB)
                .sendKeys("Sunal")
                .sendKeys(Keys.TAB)
                .sendKeys("03/25/1995")
                .sendKeys(Keys.TAB)
                .sendKeys("email@mail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("salman khan")
                .sendKeys(Keys.TAB)
                .sendKeys("blok 38 cpu")
                .sendKeys(Keys.TAB)
                .sendKeys("Gönülkahvesi")
                .sendKeys(Keys.TAB)
                .sendKeys("34400")
                .sendKeys(Keys.TAB)
                .sendKeys("Toronto")
                .sendKeys(Keys.TAB)
                .sendKeys("Quebec").perform();
        // 18. Adres bilgileri içindeki Country dropdown menüsünden ülkesini seçer.
        WebElement ddm= driver.findElement(By.xpath("//select[@name='entry_country_id']"));
        Select option=new Select(ddm);
        option.selectByValue("38");
        // 19. Contact bilgileri içindeki Telephone Number textbox kutsuna telefon numarasını girer.
        driver.findElement(By.xpath("//input[@name='customers_telephone']")).sendKeys("");
        // 20. Contact bilgileri içindeki Fax Number textbox kutsuna fax numarasını girer.
        driver.findElement(By.xpath("//input[@name='customers_fax']")).sendKeys("9876543210");
        // 21. Options bilgileri içindeki Newsletter dropdown menüsünden abonelik durumunu seçer.
        WebElement ddm2=driver.findElement(By.xpath("//select[@name='customers_newsletter']"));
        Select option2=new Select(ddm2);
        option2.selectByValue("0");
        // 22. Save butonuna tıklar.
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        // 23. Sağ üst köşedeki SEARCH kutusuna kullanıcı ismini girer ve ENTER’a basar.
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("TestingKemal"+Keys.ENTER);
        // 24. Tablodan çıkan kullanıcı ismi ve soy isminin doğruluğu teyit edilir.
        WebElement nameTest=driver.findElement(By.xpath("//td[text()='TestingKemal']"));
        Assert.assertTrue(nameTest.isDisplayed());
        // 25. Sağ üst köşedeki Logoff tuşuna basılarak sayfadan çıkılır.
        driver.findElement(By.xpath("//a[text()='Logoff']")).click();
    }
    @After
    public void teardown(){
        driver.close();

    }
}
