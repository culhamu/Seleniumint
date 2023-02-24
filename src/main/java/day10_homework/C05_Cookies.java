package day10_homework;


import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;
import org.junit.Assert;
import java.util.Set;

public class C05_Cookies extends TestBase {

    @Test
    public void test01(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet=driver.manage().getCookies();
        int siraNo=1;
        for (Cookie eachCookie:cookieSet) {
            System.out.println(siraNo+"-->"+eachCookie.toString());
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualCookieSayisi=cookieSet.size();
        int expectedCookieSayisi=5;
        Assert.assertTrue(actualCookieSayisi>expectedCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue="USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie newAddCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newAddCookie);
        siraNo=1;
        Set<Cookie> allCookieList=driver.manage().getCookies();
        for (Cookie eachCookie:allCookieList) {

            System.out.println(siraNo+"-->"+eachCookie.toString());
            siraNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String expectedCookieName="en sevdigim cookie";
        Assert.assertEquals(expectedCookieName,driver.manage().getCookieNamed("en sevdigim cookie").getName());

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(driver.manage().getCookies().contains(driver.manage().getCookieNamed("skin")));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookieSet= driver.manage().getCookies();

        Assert.assertTrue(cookieSet.size()==0);

    }
}
