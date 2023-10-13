package com.obsqura.SevenRMart.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.obsqura.SevenRMart.utilities.GeneralUtility;
import com.obsqura.SevenRMart.utilities.ScreenshotUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	WaitUtility waitutility;
	ScreenshotUtility scrshot;
	public Properties prop;
	public FileInputStream fs;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intializeBrowser(String browser) throws Exception {
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(GeneralUtility.CONFIGfILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("url"));
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
