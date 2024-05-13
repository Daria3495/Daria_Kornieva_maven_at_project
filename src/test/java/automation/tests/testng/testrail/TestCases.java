package automation.tests.testng.testrail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class TestCases extends TestNgListener{

    @Test(description = "157937")
    public void testCase1() {
        Assert.assertTrue(true,"Test case not past");
    }

    @Test(description = "157938")
    public void testCase2() {
        Assert.assertTrue(true,"Test case not past");
    }

    @Test(description = "157939")
    public void testCase3() {
        Assert.assertTrue(true,"Test case not past");
    }

    @Test(description = "157940")
    public void testCase4() {
        Assert.assertTrue(false,"Test case not past");
    }

}
