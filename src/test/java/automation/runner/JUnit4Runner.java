package automation.runner;

import automation.tests.junit.BookingTestsJunit;
import automation.tests.junit.DemoQaTestsJunit;
import automation.tests.junit.TutorialTestsJunit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingTestsJunit.class, DemoQaTestsJunit.class, TutorialTestsJunit.class})

public class JUnit4Runner {
}
