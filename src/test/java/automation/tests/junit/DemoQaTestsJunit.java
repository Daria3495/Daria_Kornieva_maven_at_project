package automation.tests.junit;

import automation.pages.DemoQaPage;
import automation.tests.BaseTestsJunit;
import org.junit.Test;

public class DemoQaTestsJunit extends BaseTestsJunit {

    DemoQaPage qaPage = new DemoQaPage();

    @Test
    public void chooseValuesFromDropDowns() {
        qaPage.chooseValueFromFirstDropDown(1,1);
        qaPage.chooseValueFromSelectOneDropDown("Mrs.");
        qaPage.chooseValueFromOldSelectMenu("Yellow");
    }
}
