package automation.tests.junit;

import automation.pages.DemoQaPage;
import automation.tests.BaseTestsJunit;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoQaTestsJunit extends BaseTestsJunit {

    DemoQaPage qaPage = new DemoQaPage();

    @Test
    public void chooseValuesFromDropDown() {
        qaPage.scrollToElement();
        qaPage.chooseValueFromFirstDropDown(1,1);
        qaPage.chooseValueFromSelectOneDropDown("Mrs.");
        qaPage.chooseValueFromOldSelectMenu("Yellow");
        qaPage.clickAnywhereToHideDropdown();
        qaPage.scrollToElement();
        qaPage.chooseColorFromMultiSelectDropdown("Green");
        qaPage.clickAnywhereToHideDropdown();
        qaPage.chooseCarFromList("opel");

//        Assert.assertEquals("Incorrect value chosen from first dropdown", "Group 1, option 1", qaPage.getFirstDropDownValue());
//        Assert.assertEquals("Incorrect value chosen from select one dropdown", "Mrs.", qaPage.getSelectOneDropDownValue());
//        Assert.assertEquals("Incorrect value chosen from old select menu", "Yellow", qaPage.getOldSelectMenuValue());
//        Assert.assertEquals("Incorrect color chosen from multi-select dropdown", "Black", qaPage.getMultiSelectDropdownValue());
//        Assert.assertEquals("Incorrect car selected from list", "opel", qaPage.getSelectedCar());
    }
}
