package automation.runner;

import automation.tests.BookingTests;
import automation.tests.DemoQaTests;
import automation.tests.TutorialTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingTests.class, DemoQaTests.class, TutorialTests.class})

public class JUnit4Runner {
}
