package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //Driver objesi oluşturunca Selenium wevdriver
        //bilgisayarımızdaki chrome browser'dan bir boş sayfa açtırır.
        //Eğer firefox vb. başka bir browser'dan sayfa açtırmak istersek
        //Selenium sitesinden o browser'ın WebDriver'ını indirip Projemize yüklememiz gerekir.
        driver.get("https://www.sahibinden.com");
        //Eğer code larımızı biraz bekletmek istersek
        Thread.sleep(1000);
        System.out.println("Syfa url'i : "+driver.getCurrentUrl());
        System.out.println("Sayfa başlığı : "+driver.getTitle());
        driver.close();

    }
}
