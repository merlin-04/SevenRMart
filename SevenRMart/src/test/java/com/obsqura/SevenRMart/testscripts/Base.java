package com.obsqura.SevenRMart.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	WebDriver driver;
	WaitUtility waitutility;
	ScreenshotUtility scrshot;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intializeBrowser(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		waitutility = new WaitUtility();
		waitutility.implicitWait(driver);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenshotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}
