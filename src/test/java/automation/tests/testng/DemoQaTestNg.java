package automation.tests.testng;

import automation.pages.DemoQaPage;
import org.junit.Test;

public class DemoQaTestNg {

    DemoQaPage qaPage = new DemoQaPage();

    @Test
    public void chooseValuesFromDropDowns() {
        qaPage.scrollToElement();
        qaPage.chooseValueFromFirstDropDown(1,1);
        qaPage.chooseValueFromSelectOneDropDown("Mrs.");
        qaPage.chooseValueFromOldSelectMenu("Yellow");
        qaPage.clickAnywhereToHideDropdown();
        qaPage.scrollToElement();
        qaPage.chooseColorFromMultiSelectDropdown("Green");
        qaPage.clickAnywhereToHideDropdown();
        qaPage.chooseCarFromList("opel");

//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertEquals(qaPage.getFirstDropDownValue(), expectedValueForFirstDropDown, "Incorrect value chosen from first dropdown");
//        softAssert.assertEquals(qaPage.getSelectOneDropDownValue(), expectedValueForSelectOneDropDown, "Incorrect value chosen from select one dropdown");
//        softAssert.assertEquals(qaPage.getOldSelectMenuValue(), expectedValueForOldSelectMenu, "Incorrect value chosen from old select menu");
//        softAssert.assertEquals(qaPage.getMultiSelectDropdownValue(), expectedColorFromMultiSelectDropdown, "Incorrect color chosen from multi-select dropdown");
//        softAssert.assertEquals(qaPage.getSelectedCar(), expectedCarFromList, "Incorrect car selected from list");
//
//        softAssert.assertAll();
    }
}
