package automation.tests.testng.testrail;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {

    public void onTestSuccess(ITestResult result) {
//        System.out.printf("Des: " + result.getMethod().getDescription());
//        System.out.printf("Implemented test success" + result.getStatus());
        TestrailReporter.reportResult("2353", result.getMethod().getDescription(), new Result(1));
    }

    public void onTestFailure(ITestResult result) {
        System.out.printf("Des: " + result.getMethod().getDescription());
        System.out.printf("Implemented test failed" + result.getStatus());
        TestrailReporter.reportResult("2353", result.getMethod().getDescription(), new Result(5));
    }

}
