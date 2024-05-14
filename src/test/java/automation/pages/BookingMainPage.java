package automation.pages;

import automation.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class BookingMainPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = LogManager.getLogger(BookingMainPage.class);
    public static final String CALENDAR_FIELD_XPATH = "//span[@data-date='%s']";
    private static final String WHERE_TO_GO_FIELD_XPATH = "//input[@aria-label='Where are you going?']";
    private static final String START_DATE_FIELD_XPATH = "//button[@data-testid='date-display-field-start']";
    public static final String ADULTS_QUANTITY_BUTTON_XPATH = "//input[@id='group_adults']/./following-sibling::div/button[2]";
    public static final String ROOM_QUANTITY_BUTTON_XPATH = "//input[@id='no_rooms']/./following-sibling::div/button[2]";
    public static final String DONE_BUTTON_XPATH = "//span[contains(text(),'Done')]";
    public static final String ADDTIONAL_FILTERS_BUTTON_XPATH = "//button[@data-testid='occupancy-config']";
    public static final String SEARCH_BUTTON_XPATH = "//span[contains(text(),'Search')]";
    public static final String LANGUAGE_TOOLTIP_ICON_XPATH = "//button[@data-testid='header-language-picker-trigger']";
    public static final String LANGUAGE_TOOLTIP_TEXT_XPATH ="//div[contains(text(),'Select your language')]";
    public static final String CURRENCY_TOOLTIP_ICON_XPATH = "//button[@data-testid='header-currency-picker-trigger']";
    public static final String CURRENCY_TOOLTIP_TEXT_XPATH ="//div[contains(text(),'Select your currency')]";
    public BookingMainPage() {
        driver.get("https://booking.com");
        LOGGER.info("Redirection to Booking main page");
        driver.findElement(By.id("onetrust-reject-all-handler")).click();
        LOGGER.info("Cookies alert is skipped");

        List<WebElement> signInAlert = driver.findElements(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        if (!signInAlert.isEmpty()) {
            signInAlert.get(0).click();
        }
        LOGGER.info("Sign in alert is displayed");
    }

    public void enterValueToWhereToGoField(String city) {
        driver.findElement(By.xpath(WHERE_TO_GO_FIELD_XPATH)).sendKeys(city);
        LOGGER.info("City value of {} not entered to 'Where to go field'", city);
    }

    public void fillStartDateField(String date) {
        driver.findElement(By.xpath(START_DATE_FIELD_XPATH)).click();
        LOGGER.info("Date option is found");
        driver.findElement(By.xpath(String.format(CALENDAR_FIELD_XPATH, date))).click();
        LOGGER.info("Start date is filled with date {}", date);
    }

    public void fillEndDateField(String date) {
        driver.findElement(By.xpath(String.format(CALENDAR_FIELD_XPATH, date))).click();
        LOGGER.info("End date is filled with date {}", date);
    }

    public void chooseAdditionalFilters() {
        driver.findElement(By.xpath(ADDTIONAL_FILTERS_BUTTON_XPATH)).click();
        LOGGER.info("Additional filters option is opened");
    }

    public void addAdultsQuantity(int peopleQuantity) {
        for (int i = 0; i < peopleQuantity; i++) {
            driver.findElement
                    (By.xpath(ADULTS_QUANTITY_BUTTON_XPATH)).click();
        }
        LOGGER.info("People quantity {} are added to the field", peopleQuantity);
    }

    public void addRoomQuantity(int roomQuantity) {
        for (int i = 0; i < roomQuantity; i++) {
            driver.findElement(By.xpath(ROOM_QUANTITY_BUTTON_XPATH))
                    .click();
        }
        LOGGER.info("Room quantity {} are added to the field", roomQuantity);
    }

    public void clickDoneButton() {
        driver.findElement(By.xpath(DONE_BUTTON_XPATH)).click();
        LOGGER.info("Done button is chosen");
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
        LOGGER.info("Search button is chosen");
    }

    public WebElement checkLanguageTooltip() {
        WebElement languageIcon = driver.findElement(By.xpath(LANGUAGE_TOOLTIP_ICON_XPATH));
        LOGGER.info("Language tooltip icon is found");
        Actions actions = new Actions(driver);
        actions.moveToElement(languageIcon);
        LOGGER.info("Cursor is moved to Language tooltip button");
        actions.build().perform();
        WebElement languageTooltipText = driver.findElement(By.xpath(LANGUAGE_TOOLTIP_TEXT_XPATH));
        LOGGER.info("Text is displayed for Language tooltip");
        return languageTooltipText;
    }

    public WebElement checkCurrencyTooltip() {
        WebElement currencyIcon = driver.findElement(By.xpath(CURRENCY_TOOLTIP_ICON_XPATH));
        LOGGER.info("Currency tooltip icon is found");
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyIcon);
        LOGGER.info("Cursor is moved to Currency tooltip button");
        actions.build().perform();
        WebElement currencyTooltipText = driver.findElement(By.xpath(CURRENCY_TOOLTIP_TEXT_XPATH));
        LOGGER.info("Text is displayed for Currency tooltip");
        return currencyTooltipText;
    }

}

