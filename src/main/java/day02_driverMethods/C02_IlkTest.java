package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) {
        /*
        Gerekli ayarlamaları yaptıktan sonra
        1- sayfa başlığı amazon kelimesi içermeli
        2- sayfa url'inde "Amazon" kelimesi içermeli
         */
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.getTitle();
    }
}
