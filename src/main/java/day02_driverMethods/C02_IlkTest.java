package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) {
        /*
        Gerekli ayarlamaları yaptıktan sonra
        1- sayfa başlığı "amazon" kelimesi içermeli
        2- sayfa url'inde "Amazon" kelimesi içermeli
         */
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        String expectedTitleIcerik="amazon";
        String expectedUrlIcerik="Amazon";

        String actualUrl=driver.getCurrentUrl();
        String actualTitle=driver.getTitle();

        //Url test yapalim...
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url test PASSED");
        }else {
            System.out.println("Url test FAILED");
            System.out.println("actual url : "+actualUrl);
            System.out.println("actual url "+expectedUrlIcerik+" kelimesini içermiyor");
        }
        //Title test yapalım...
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title test PASSED");

        }else {
            System.out.println("Title test FAILED");
            System.out.println("actual title : "+actualTitle);
            System.out.println("actual title "+expectedTitleIcerik+" kelimesini içermiyor...");
        }

        driver.quit();
    }
}
