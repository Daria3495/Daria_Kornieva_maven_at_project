package automation.tests.testng;

import automation.pages.GoogleMainPage;
import automation.pages.GoogleSearchResultPage;
import automation.pages.TutorialMainPage;
import automation.tests.BaseTestsTestNg;
import org.testng.annotations.Test;

public class TutorialTestsTestNg extends BaseTestsTestNg {
    TutorialMainPage tutorialMainPage = new TutorialMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();

    @Test
    public void checkTutorialTitleCopyPasteAction() {
        tutorialMainPage.openTutorialPage();
        tutorialMainPage.copyTitleText();
        googleMainPage.openMainPage();
        googleMainPage.chooseSearchField();
        googleMainPage.pasteTitleText();
        googleMainPage.enterKeyboard();
    }
}
