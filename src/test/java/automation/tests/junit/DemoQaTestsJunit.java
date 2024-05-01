package automation.tests.junit;

import automation.pages.DemoQaPage;
import automation.tests.BaseTestsJunit;
import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals("Incorrect value chosen from first dropdown", " option Group 1, option 1, selected.\n" +
                "Group 1, option 1", qaPage.getTextInFirstDropDown());
        Assert.assertEquals("Incorrect value chosen from select one dropdown", " option Mrs., selected.\n" +
                "Mrs.", qaPage.getTextInSelectOneDropdown());
        Assert.assertEquals("Incorrect value chosen from old select menu", "Yellow", qaPage.getTextInOldDropdown());
//        Assert.assertEquals("Incorrect color chosen from multi-select dropdown", "Black", qaPage.getMultiSelectDropdownValue());
        Assert.assertEquals("Incorrect car selected from list", "Opel", qaPage.getTextInCarDropdown());
    }
}
