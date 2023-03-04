package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DestinationsPage;
import pageObjects.HomePage;
import pageObjects.PopularPage;

public class DestinationsTest extends BaseTest {

    @Test
    public void tc01_searchDestination() {
        HomePage hp = new HomePage(driver);
        hp.closePopUp();
        hp.clickGotItBtn();
        hp.clickDestinationsBtn();
        DestinationsPage dp = new DestinationsPage(driver);
        dp.closePopUp();
        dp.searchDestination("vienna");
        dp.sleep(1000);
        Assert.assertTrue(dp.getTitlePage().contains("vienna"));
    }

    @Test
    public void tc02_nextPage() {
        HomePage hp = new HomePage(driver);
        hp.clickDestinationsBtn();
        DestinationsPage dp = new DestinationsPage(driver);
        String allNameDestinationsPage1 = dp.getNameAllDestinations();
        dp.clickNextPage();
        String allNameDestinationsPage2 = dp.getNameAllDestinations();
        Assert.assertTrue(!(allNameDestinationsPage1.contains(allNameDestinationsPage2)));
    }

    @Test
    public void tc03_errorMsgSymbols() {
        HomePage hp = new HomePage(driver);
        hp.clickDestinationsBtn();
        DestinationsPage dp = new DestinationsPage(driver);
        dp.searchDestination("a");
        Assert.assertEquals(dp.getErrorMsgType1(), "Type 2 or more symbols to search");
        dp.clickSearchBtn();
        Assert.assertEquals(dp.getErrorMsgType2(), "Required 2 or more symbols to search");
    }

    @Test
    public void tc04_ClickBookmarkBtn() {
        DestinationsPage dp = new DestinationsPage(driver);
        dp.clickShichorBtn();
        dp.login("pborsud@gmail.com","By0527160957");
        dp.clickDestinationsBtn();
        dp.selectPopular("london");
        PopularPage pp = new PopularPage(driver);
        pp.sleep(4000);
        pp.clickAllBookmarkBtn();
        pp.sleep(5000);
    }

    @Test
    public void tc05_removeBookmarkBtn() {
        DestinationsPage dp = new DestinationsPage(driver);
        dp.clickShichorBtn();
        dp.clickDestinationsBtn();
        dp.selectPopular("london");
        PopularPage pp = new PopularPage(driver);
        pp.removeAllBookmarkBtn();
    }
}
