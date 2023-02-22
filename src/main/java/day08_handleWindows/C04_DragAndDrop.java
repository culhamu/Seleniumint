package day08_handleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {
    //Yeni bir class olusturalim: MouseActions2

    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragTarget= driver.findElement(By.xpath("(//div[@id='draggable'])[1]"));
        WebElement dropTarget= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragTarget,dropTarget).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText="Dropped!";
        String actualText=driver.findElement(By.xpath("(//div[@id='droppable'])[1]")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
