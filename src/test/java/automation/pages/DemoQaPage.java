package automation.pages;

import automation.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQaPage {

    private static final Logger LOGGER = LogManager.getLogger(DemoQaPage.class);
    public static final String VALUE_DROPDOWN_ID = "withOptGroup";
    public static final String GROUP_OPTION_XPATH = "//*[contains(text(),'Group %s, option %s')]";
    public static final String SELECT_ONE_DROPDOWN_ID = "selectOne";
    public static final String SELECT_ONE_VALUE_XPATH = "//*[contains(text(),'%s')]";
    public static final String OLD_SELECT_MENU_DROPDOWN_ID = "oldSelectMenu";
    public static final String OLD_SELECT_MENU_VALUE_XPATH = "//select[@id='oldSelectMenu']/option[contains(text(),'%s')]";
    public static final String MULTISELECT_DROPDOWN_XPATH = "//*[contains(text(),'Select...')]";
    public static final String SELECT_MULTISELECT_COLOR_XPATH = "//*[contains(text(),'%s')]";
    public static final String SELECT_MENU_CONTAINER_ID = "selectMenuContainer";
    public static final String CARS_DROPDOWN_ID = "cars";
    public static final String CAR_XPATH = "//option[@value='%s']";
    private WebElement multiSelectorDropdown;
    private WebElement elementFirstDropdown;
    private WebElement elementSelectOneDropdown;
    private WebElement elementOldDropdown;
    private WebElement elementCar;
    private String textInFirstDropDown;
    private String textInSelectOneDropdown;
    private String textInOldDropdown;

    private String textInCarDropdown;

    WebDriver driver = Driver.getWebDriver();

    public String getTextInFirstDropDown() {
        return textInFirstDropDown;
    }
    public String getTextInSelectOneDropdown() {
        return textInSelectOneDropdown;
    }
    public String getTextInOldDropdown() {
        return textInOldDropdown;
    }
    public String getTextInCarDropdown() {
        return textInCarDropdown;
    }

    public DemoQaPage() {
        driver.get("https://demoqa.com/select-menu");
        LOGGER.info("Demo qa page is not opened");
    }

    public void chooseValueFromFirstDropDown(int groupNumber, int optionNumber) {
        elementFirstDropdown = driver.findElement(By.id(VALUE_DROPDOWN_ID));
        elementFirstDropdown.click();
        LOGGER.info("{} Group number is not chosen", groupNumber);
        String groupDynamicXpath = String.format(GROUP_OPTION_XPATH, groupNumber, optionNumber);
        driver.findElement(By.xpath(groupDynamicXpath)).click();
        LOGGER.info("{} option number is not chosen", optionNumber);
        textInFirstDropDown = elementFirstDropdown.getText();
    }

    public void chooseValueFromSelectOneDropDown(String oneValue) {
        elementSelectOneDropdown = driver.findElement(By.id(SELECT_ONE_DROPDOWN_ID));
        elementSelectOneDropdown.click();
        String oneDynamicXpath = String.format(SELECT_ONE_VALUE_XPATH, oneValue);
        driver.findElement(By.xpath(oneDynamicXpath)).click();
        textInSelectOneDropdown = elementSelectOneDropdown.getText();
    }

    //TODO ен пропадает дропдаун, попробовать кликнуть в свободную эрию
    public void chooseValueFromOldSelectMenu(String color) {
        driver.findElement(By.id(OLD_SELECT_MENU_DROPDOWN_ID));
        String oldDynamicXpath = String.format(OLD_SELECT_MENU_VALUE_XPATH, color);
        elementOldDropdown = driver.findElement(By.xpath(oldDynamicXpath));
        elementOldDropdown.click();
        textInOldDropdown = elementOldDropdown.getText();
    }

    public void clickAnywhereToHideDropdown() {
        driver.findElement(By.id(SELECT_MENU_CONTAINER_ID)).click();
        LOGGER.info("Drop-down is not skipped since click on the page is not worked");
    }

    public void scrollToElement() {
        multiSelectorDropdown = driver.findElement(By.xpath(MULTISELECT_DROPDOWN_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",multiSelectorDropdown);
        LOGGER.info("Scroll to element {} is not worked", multiSelectorDropdown);
    }

    public void chooseColorFromMultiSelectDropdown(String color) {
        multiSelectorDropdown.click();
        LOGGER.info("Multiselector drop down is not found");
        String multiselectDynamicXpath = String.format(SELECT_MULTISELECT_COLOR_XPATH, color);
        driver.findElement(By.xpath(multiselectDynamicXpath)).click();
        LOGGER.info("{} color is not chosen", color);

//        multiSelectorDropdown.click();
//        Select select = new Select(multiSelectorDropdown);
//        select.selectByValue("Green");
    }

    //TODO сделать на вход список из машин? и рандомно выбирать машину?
    public void chooseCarFromList(String car) {
        driver.findElement(By.id(CARS_DROPDOWN_ID));
        String carDynamicXpath = String.format(CAR_XPATH, car);
        elementCar = driver.findElement(By.xpath(carDynamicXpath));
        elementCar.click();
        LOGGER.info("Car {} is not found", car);
        textInCarDropdown = elementCar.getText();
    }

}
