package automation.tests.testng;

import automation.pages.DemoQaPage;
import automation.tests.BaseTestsTestNg;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class DemoQaTestNg extends BaseTestsTestNg {

    DemoQaPage qaPage = new DemoQaPage();

    @Test
    public void chooseValuesFromDropDowns() {
        qaPage.scrollToElement();
        qaPage.chooseValueFromFirstDropDown(1,1);
        qaPage.chooseValueFromSelectOneDropDown("Mr.");
        qaPage.chooseValueFromOldSelectMenu("Black");
        qaPage.clickAnywhereToHideDropdown();
        qaPage.scrollToElement();
        qaPage.chooseColorFromMultiSelectDropdown("Green");
        qaPage.clickAnywhereToHideDropdown();
        qaPage.chooseCarFromList("audi");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(qaPage.getTextInFirstDropDown(), " option Group 1, option 1, selected.\n" +
                "Group 1, option 1", "Incorrect value chosen from first dropdown");
        softAssert.assertEquals(qaPage.getTextInSelectOneDropdown(), " option Mr., selected.\n" +
                "Mr.", "Incorrect value chosen from select one dropdown");
        softAssert.assertEquals(qaPage.getTextInOldDropdown(), "Black", "Incorrect value chosen from old select menu");
        //softAssert.assertEquals(qaPage.getMultiSelectDropdownValue(), expectedColorFromMultiSelectDropdown, "Incorrect color chosen from multi-select dropdown");
        softAssert.assertEquals(qaPage.getTextInCarDropdown(), "Audi", "Incorrect car selected from list");

        softAssert.assertAll();
    }
}
