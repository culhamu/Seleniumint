package day09_actions_fileUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class C05_GTT extends TestBaseClass {
    String iphoneUrunTitle;
    String productTitle;

    @Test
    public void test01(){

        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> menu=driver.findElements(By.tagName("option"));
        int siralama=1;
        for (WebElement each:menu) {
            System.out.println(siralama+"-->"+each.getText());
            siralama++;
        }

        //3- dropdown menude 40 eleman olduğunu doğrulayın
        int expectedMenuSayisi=40;
        int actualMenuSayisi=menu.size();
        Assert.assertEquals(expectedMenuSayisi,actualMenuSayisi);

    }
    @Test
    public void test02(){

        //1- dropdown menuden elektronik bölümü seçin
        WebElement ddm=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement serchBox=driver.findElement(By.id("twotabsearchtextbox"));
        serchBox.sendKeys("iphone"+ Keys.ENTER);
        String sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String[] sonucArr=sonucYazisi.split(" ");
        String sonucSayisi=sonucArr[3].replaceAll("\\D","");
        int intSonuc=Integer.parseInt(sonucSayisi);
        System.out.println(intSonuc);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualResultText=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedText="iphone";
        Assert.assertTrue(actualResultText.contains(expectedText));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        WebElement ucuncuUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(birinciUrun).toLeftOf(ucuncuUrun));
        ikinciUrun.click();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        iphoneUrunTitle=driver.getTitle();
        String iphoneFiyat=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();

        driver.findElement(By.id("add-to-cart-button")).click();

        WebElement addToChart=driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertTrue(addToChart.isDisplayed());


    }
    @Test
    public void test03(){

        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm);

        //2-dropdown’dan bebek bölümüne secin
        select.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("bebek puset"+Keys.ENTER);
        String sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String[] sonucArr=sonucYazisi.split(" ");
        String sonucSayisi=sonucArr[2].replaceAll("\\D","");
        int intSonuc=Integer.parseInt(sonucSayisi);
        System.out.println(intSonuc);

        //4-sonuç yazsının puset içerdiğini test edin
        String actualResultText=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String expectedText="puset";
        Assert.assertTrue(actualResultText.contains(expectedText));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement fourthProduct=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[4]"));
        WebElement secondProduct=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        WebElement thirdProduct=driver.findElement(RelativeLocator.with(By.tagName("span")).above(fourthProduct).below(secondProduct));
        thirdProduct.click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        productTitle=driver.getTitle();
        String productPrice=driver.findElement(By.xpath("(//span[@aria-hidden='true'])[7]")).getText();

        driver.findElement(By.id("add-to-cart-button")).click();

        WebElement resultText=driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertTrue(resultText.isDisplayed());

    }
    @Test
    public void test04(){

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.id("nav-cart-count-container")).click();


        String expectedBabyProductTitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[5]")).getText();
        String expectedIphoneTitle=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[7]")).getText();

        Assert.assertEquals(expectedIphoneTitle,iphoneUrunTitle);


    }
}
