package day09_actions_fileUpload;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01(){
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        //3. “firstName” giris kutusuna bir isim yazin
        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String fakeEmail=faker.internet().emailAddress();
        WebElement actionElement= driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(actionElement)
                .sendKeys(faker.name().firstName()+ Keys.TAB)
                .sendKeys(faker.name().lastName()+Keys.TAB)
                .sendKeys(fakeEmail+Keys.TAB)
                .sendKeys(fakeEmail+Keys.TAB)
                .sendKeys(faker.internet().password()+Keys.TAB+Keys.TAB)
                .sendKeys("15"+Keys.TAB+"Haziran"+Keys.TAB+"1995"+Keys.TAB+Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        bekle(3);

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement selectedCheckBox= driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        Assert.assertTrue(selectedCheckBox.isSelected());

        WebElement unselectedCheckBox=driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        Assert.assertFalse(unselectedCheckBox.isSelected());


        //13. Sayfayi kapatin
        driver.findElement(By.xpath("(//button[text()='Kaydol'])[1]")).click();
    }
}
