package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethods {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        System.out.println(driver.getWindowHandle());//CDwindow-8C95DE7E3AF291A05A208D9D2C1EF907
        System.out.println(driver.getWindowHandles());//[CDwindow-8C95DE7E3AF291A05A208D9D2C1EF907]

        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());
        driver.close();

    }
}
