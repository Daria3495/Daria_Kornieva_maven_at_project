package automation.tests.testng;

import automation.driver.Driver;
import automation.pages.BookingHotelsPage;
import automation.pages.BookingMainPage;
import automation.pages.BookingSeparateHotelPage;
import automation.tests.BaseTestsTestNg;
import automation.utils.DateCreatorUtil;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookingTestsTestNg extends BaseTestsTestNg {
    BookingMainPage mainPage = new BookingMainPage();
    BookingHotelsPage bookingHotelsPage = new BookingHotelsPage();
    BookingSeparateHotelPage separateHotelPage = new BookingSeparateHotelPage();

    @Test
    public void bookHotelInParis() {

        mainPage.enterValueToWhereToGoField("Paris");
        mainPage.fillStartDateField(DateCreatorUtil.calculateStartDate(3));
        mainPage.fillEndDateField(DateCreatorUtil.calculateEndDate(10));
        mainPage.chooseAdditionalFilters();
        mainPage.addAdultsQuantity(2);
        mainPage.addRoomQuantity(1);
        mainPage.clickDoneButton();
        mainPage.clickSearchButton();
        bookingHotelsPage.chooseHotelReviewScore(6);
        bookingHotelsPage.openSortingDropDown();
        bookingHotelsPage.chooseSortingOption();
        bookingHotelsPage.findHotelReviewScore();
        Assert.assertEquals(bookingHotelsPage.getScore() >= 6.0, true,"Hotel score is less than 6");
    }

    @Test
    public void bookHotelInPrague() {

        mainPage.enterValueToWhereToGoField("Prague");
        mainPage.fillStartDateField(DateCreatorUtil.calculateStartDate(2));
        mainPage.fillEndDateField(DateCreatorUtil.calculateEndDate(5));
        mainPage.clickSearchButton();
        bookingHotelsPage.chooseHotelReviewScore(9);
        bookingHotelsPage.chooseHotelFromTheList();
        separateHotelPage.switchToAnotherTab();
        separateHotelPage.findHotelReviewScore();
        Assert.assertEquals(separateHotelPage.getScore() >= 9.0, true, "Hotel score is less than 9");
    }

    //TODO сделать проверку на скриншот
    @Test
    public void makeScreenshotOfHotelCard() {
        mainPage.enterValueToWhereToGoField("London");
        mainPage.clickSearchButton();
        bookingHotelsPage.findHotelInTheList(10);
        bookingHotelsPage.highlightHotelCard();
        Driver.makeScreenshot();
    }

    @Test
    public void checkLanguageTooltip() {
        mainPage.checkLanguageTooltip().getText();
        Assert.assertEquals(mainPage.checkLanguageTooltip().getText(), "Select your language", "Text is not 'Select your language'");
    }

    @Test
    public void checkCurrencyTooltip() {
        mainPage.checkCurrencyTooltip().getText();
        Assert.assertEquals(mainPage.checkCurrencyTooltip().getText(), "Select your currency", "Text is not 'Select your currency'");
    }

}

