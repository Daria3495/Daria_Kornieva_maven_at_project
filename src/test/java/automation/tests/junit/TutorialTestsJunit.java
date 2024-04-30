package automation.tests.junit;

import automation.pages.GoogleMainPage;
import automation.pages.GoogleSearchResultPage;
import automation.pages.TutorialMainPage;
import automation.tests.BaseTestsJunit;
import org.junit.Test;

public class TutorialTestsJunit extends BaseTestsJunit {
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
