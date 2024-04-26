package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class BookingMainPage {
    WebDriver driver = Driver.getWebDriver();
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
        driver.findElement(By.id("onetrust-reject-all-handler")).click();

        List<WebElement> signInAlert = driver.findElements(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        if (!signInAlert.isEmpty()) {
            signInAlert.get(0).click();
        }
    }

    public void enterValueToWhereToGoField(String city) {
        driver.findElement(By.xpath(WHERE_TO_GO_FIELD_XPATH)).sendKeys(city);
    }

    public void fillStartDateField(String date) {
        driver.findElement(By.xpath(START_DATE_FIELD_XPATH)).click();
        driver.findElement(By.xpath(String.format(CALENDAR_FIELD_XPATH, date))).click();
    }

    public void fillEndDateField(String date) {
        driver.findElement(By.xpath(String.format(CALENDAR_FIELD_XPATH, date))).click();
    }

    public void chooseAdditionalFilters() {
        driver.findElement(By.xpath(ADDTIONAL_FILTERS_BUTTON_XPATH)).click();
    }

    public void addAdultsQuantity(int peopleQuantity) {
        for (int i = 0; i < peopleQuantity; i++) {
            driver.findElement
                    (By.xpath(ADULTS_QUANTITY_BUTTON_XPATH)).click();
        }
    }

    public void addRoomQuantity(int roomQuantity) {
        for (int i = 0; i < roomQuantity; i++) {
            driver.findElement(By.xpath(ROOM_QUANTITY_BUTTON_XPATH))
                    .click();
        }
    }

    public void clickDoneButton() {
        driver.findElement(By.xpath(DONE_BUTTON_XPATH)).click();
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
    }

    public WebElement checkLanguageTooltip() {
        WebElement languageIcon = driver.findElement(By.xpath(LANGUAGE_TOOLTIP_ICON_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(languageIcon);
        actions.build().perform();
        WebElement languageTooltipText = driver.findElement(By.xpath(LANGUAGE_TOOLTIP_TEXT_XPATH));
        return languageTooltipText;
    }

    public WebElement checkCurrencyTooltip() {
        WebElement currencyIcon = driver.findElement(By.xpath(CURRENCY_TOOLTIP_ICON_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyIcon);
        actions.build().perform();
        WebElement currencyTooltipText = driver.findElement(By.xpath(CURRENCY_TOOLTIP_TEXT_XPATH));
        return currencyTooltipText;
    }

}

