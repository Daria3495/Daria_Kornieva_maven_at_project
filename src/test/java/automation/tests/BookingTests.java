package automation.tests;

import automation.pages.BookingHotelsPage;
import automation.pages.BookingMainPage;
import automation.utils.DateCreatorUtil;
import org.junit.Assert;
import org.junit.Test;


public class BookingTests extends BaseTests {
    BookingMainPage mainPage = new BookingMainPage();
    BookingHotelsPage bookingHotelsPage = new BookingHotelsPage();
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
        bookingHotelsPage.chooseSixHotelReviewScore();
        bookingHotelsPage.openSortingDropDown();
        bookingHotelsPage.chooseSortingOption();
        bookingHotelsPage.findHotelReviewScore();
        Assert.assertEquals("Hotel score is less than 6", true, bookingHotelsPage.getScore() > 6);
    }

    @Test
    public void bookHotelInPrague() {

        mainPage.enterValueToWhereToGoField("Prague");
        mainPage.fillStartDateField(DateCreatorUtil.calculateStartDate(2));
        mainPage.fillEndDateField(DateCreatorUtil.calculateEndDate(5));
        mainPage.clickSearchButton();

        bookingHotelsPage.chooseNineHotelReviewScore();
        bookingHotelsPage.chooseHotelFromTheList();
        bookingHotelsPage.findHotelReviewScore();
    }

}

