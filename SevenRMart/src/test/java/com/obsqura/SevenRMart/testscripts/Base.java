package com.obsqura.SevenRMart.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtility;


public class Base {
	WebDriver driver;
	WaitUtility waitutility;

	@BeforeMethod
	public void intializeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91623\\eclipse-workspace\\SevenRMart\\src\\main\\java\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		waitutility = new WaitUtility();
		waitutility.implicitWait(driver);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverQuit() {
		driver.quit();
	}
}
