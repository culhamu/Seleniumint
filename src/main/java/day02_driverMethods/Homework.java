package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        String expectedTitle= "facebook";
        String expectedUrl="facebook";

        String actualUrl=driver.getCurrentUrl();
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
            System.out.println("Sayfanın başlığı : "+driver.getTitle());
            System.out.println("actual title "+expectedTitle+" kelimesini içermiyor...");
        }if (actualUrl.contains(expectedUrl)){
            System.out.println("Url test PASSED");
        }else { System.out.println("Url test FAILED");
        System.out.println("Sayfanın Url'i : "+driver.getCurrentUrl());
        System.out.println("actual Url "+expectedUrl+" kelimesini içermiyor...");
        }

        driver.get("https://www.walmart.com/");
        String expectedTitle2="Walmart.com";
        String actualTitle2=driver.getTitle();

        if (actualTitle2.contains(expectedTitle2)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
            System.out.println("Sayfanın başlığı : " + driver.getTitle());
            System.out.println("actual title " + expectedTitle2 + " kelimesini içermiyor...");
        }
        driver.navigate().back();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.close();
    }
}
