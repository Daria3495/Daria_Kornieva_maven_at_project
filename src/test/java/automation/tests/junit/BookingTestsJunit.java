package automation.tests.junit;

import automation.driver.Driver;
import automation.pages.BookingHotelsPage;
import automation.pages.BookingMainPage;
import automation.pages.BookingSeparateHotelPage;
import automation.tests.BaseTestsJunit;
import automation.utils.DateCreatorUtil;
import org.junit.Assert;
import org.junit.Test;


public class BookingTestsJunit extends BaseTestsJunit {
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
        Assert.assertEquals("Hotel score is less than 6", true, bookingHotelsPage.getScore() >= 6.0);
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
        Assert.assertEquals("Hotel score is less than 9", true, separateHotelPage.getScore() >= 9.0);
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
        Assert.assertEquals("Text is not 'Select your language'","Select your language" ,mainPage.checkLanguageTooltip().getText());
    }

    @Test
    public void checkCurrencyTooltip() {
        mainPage.checkCurrencyTooltip().getText();
        Assert.assertEquals("Text is not 'Select your currency'","Select your currency" ,mainPage.checkCurrencyTooltip().getText());
    }

}

