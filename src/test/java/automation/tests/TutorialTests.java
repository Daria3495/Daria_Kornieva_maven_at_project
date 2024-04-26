package automation.tests;

import automation.pages.GoogleMainPage;
import automation.pages.GoogleSearchResultPage;
import automation.pages.TutorialMainPage;
import org.junit.Test;

public class TutorialTests {
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
