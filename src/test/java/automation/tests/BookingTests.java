package automation.tests;

import automation.pages.BookingHotelsPage;
import automation.pages.BookingMainPage;
import automation.pages.BookingSeparateHotelPage;
import automation.utils.DateCreatorUtil;
import org.junit.Test;


public class BookingTests extends BaseTests {

    @Test
    public void bookHotelInParis() {
        BookingMainPage mainPage = new BookingMainPage();

        mainPage.enterValueToWhereToGoField("Paris");
        mainPage.fillStartDateField(DateCreatorUtil.calculateStartDate(3));
        mainPage.fillEndDateField(DateCreatorUtil.calculateEndDate(10));
        mainPage.chooseAdditionalFilters();
        mainPage.addAdultsQuantity(2);
        mainPage.addRoomQuantity();
        mainPage.saveAdditionalConditions();
//        mainPage.searchHotelWithChosenConditions();
//        BookingHotelsPage bookingHotelsPage = new BookingHotelsPage();
        BookingHotelsPage bookingHotelsPage = mainPage.searchHotels();
        bookingHotelsPage.chooseSixHotelReviewScore();
        bookingHotelsPage.openSortingDropDown();
        bookingHotelsPage.chooseSortingOption();
        bookingHotelsPage.findHotelReviewScore();
    }

    @Test
    public void bookHotelInPrague() {
        BookingMainPage mainPage = new BookingMainPage();

        mainPage.enterValueToWhereToGoField("Prague");
        mainPage.fillStartDateField(DateCreatorUtil.calculateStartDate(2));
        mainPage.fillEndDateField(DateCreatorUtil.calculateEndDate(5));
        BookingHotelsPage bookingHotelsPage = mainPage.searchHotels();
        bookingHotelsPage.chooseNineHotelReviewScore();
        bookingHotelsPage.chooseHotelFromTheList();
        BookingSeparateHotelPage bookingSeparateHotelPage = new BookingSeparateHotelPage();
        bookingHotelsPage.findHotelReviewScore();
    }

}

