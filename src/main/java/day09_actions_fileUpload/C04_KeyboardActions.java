package day09_actions_fileUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    //1- Bir Class olusturalim KeyboardActions2
    @Test
    public void test01(){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);


        //3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe= driver.findElement(By.xpath("//iframe[@height='315']"));
        driver.switchTo().frame(iframe);
        WebElement play=driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        play.click();

        //5- videoyu calistirdiginizi test edin

        Assert.assertFalse(play.isDisplayed());

    }
}
