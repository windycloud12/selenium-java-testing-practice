package common.listeners;

import common.utils.LoggerManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogListener implements ITestListener {

    public String getTestName(ITestResult iTestResult) {
        return iTestResult.getTestName() != null ? iTestResult.getTestName()
                : iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult iTestResult) {
        LoggerManager.getLogger().info(getTestName(iTestResult) + ": Test started");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        LoggerManager.getLogger().info(getTestName(iTestResult) + ": Test passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        Throwable throwable = iTestResult.getThrowable();
        String errMsg = throwable != null ? throwable.getMessage() : "";
        LoggerManager.getLogger().error(getTestName(iTestResult) + " : Test Failed : " + errMsg);
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        LoggerManager.getLogger().info("====== " + iTestContext.getName() + " Start ======");
    }

    public void onFinish(ITestContext iTestContext) {
        LoggerManager.getLogger().info("====== " + iTestContext.getName() + " Finish ======");
    }
}
