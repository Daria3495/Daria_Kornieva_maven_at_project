package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemoQaPage {

    private WebElement multiSelectorDropdown;
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
    WebDriver driver = Driver.getWebDriver();

    public DemoQaPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void chooseValueFromFirstDropDown(int groupNumber, int optionNumber) {
        driver.findElement(By.id(VALUE_DROPDOWN_ID)).click();
        String groupDynamicXpath = String.format(GROUP_OPTION_XPATH, groupNumber, optionNumber);
        driver.findElement(By.xpath(groupDynamicXpath)).click();
    }

    public void chooseValueFromSelectOneDropDown(String oneValue) {
        driver.findElement(By.id(SELECT_ONE_DROPDOWN_ID)).click();
        String oneDynamicXpath = String.format(SELECT_ONE_VALUE_XPATH, oneValue);
        driver.findElement(By.xpath(oneDynamicXpath)).click();
    }

    //TODO ен пропадает дропдаун, попробовать кликнуть в свободную эрию
    public void chooseValueFromOldSelectMenu(String color) {
        driver.findElement(By.id(OLD_SELECT_MENU_DROPDOWN_ID)).click();
        String oldDynamicXpath = String.format(OLD_SELECT_MENU_VALUE_XPATH, color);
        driver.findElement(By.xpath(oldDynamicXpath)).click();
    }

    public void clickAnywhereToHideDropdown() {
        driver.findElement(By.id(SELECT_MENU_CONTAINER_ID)).click();
    }

    public void scrollToElement() {
        multiSelectorDropdown = driver.findElement(By.xpath(MULTISELECT_DROPDOWN_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",multiSelectorDropdown);
    }

    public void chooseColorFromMultiSelectDropdown(String color) {
        multiSelectorDropdown.click();
        String multiselectDynamicXpath = String.format(SELECT_MULTISELECT_COLOR_XPATH, color);
        driver.findElement(By.xpath(multiselectDynamicXpath)).click();

//        multiSelectorDropdown.click();
//        Select select = new Select(multiSelectorDropdown);
//        select.selectByValue("Green");
    }

    //TODO сделать на вход список из машин? и рандомно выбирать машину?
    public void chooseCarFromList(String car) {
        driver.findElement(By.id(CARS_DROPDOWN_ID));
        String carDynamicXpath = String.format(CAR_XPATH, car);
        driver.findElement(By.xpath(carDynamicXpath)).click();
    }

}
