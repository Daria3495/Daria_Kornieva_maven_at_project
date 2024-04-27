package automation.pages;

import automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQaPage {
    public static final String VALUE_DROPDOWN_ID = "withOptGroup";
    public static final String GROUP_OPTION_XPATH = "//*[contains(text(),'Group %s, option %s')]";
    public static final String SELECT_ONE_DROPDOWN_ID = "selectOne";
    public static final String SELECT_ONE_VALUE_XPATH = "//*[contains(text(),'%s')]";
    public static final String OLD_SELECT_MENU_DROPDOWN_ID = "oldSelectMenu";
    public static final String OLD_SELECT_MENU_VALUE_XPATH = "//*[contains(text(),'Yellow')]";
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

}
