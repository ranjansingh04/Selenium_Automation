package com.devzery.scenes.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.devzery.scenes.Utilities.TestUtility;
import com.devzery.scenes.BaseClass.TestBase;

public class ExtentReportSetup extends TestBase {
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports extentReportSetup() {
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/ScenesExtentResults/ScenesExtentReport" + TestUtility.getSystemDate() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Test Automation Report");
		sparkReport.config().setDocumentTitle("Test Automation Report");
		
		return extent;
	}
}
