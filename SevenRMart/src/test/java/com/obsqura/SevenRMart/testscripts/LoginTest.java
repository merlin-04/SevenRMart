package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.LoginPage;
import retry.Retry;

public class LoginTest extends Base {
	public LoginPage loginpage;

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to Login with correct Username and Password",groups = {"regression"})
	public void verifyUserIsAbleToLoginWithCorrectUserNameAndPassword() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		boolean actualValue = loginpage.IsDisplayedDashboardTextOnHomePage();
		assertTrue(actualValue, "User is unable to Login");
	}

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to Login with incorrect Username and correct Password",groups = {"smoke"})
	public void verifyUserIsUnableToLoginWithInCorrectUserNameAndCorrectPassword() {
		String username = ExcelUtility.getString(1, 2, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String expectedAlertMessage = ExcelUtility.getString(1, 4, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username);
		loginpage.enterPasswordOnPasswordTextField(password);
		loginpage.clickOnSignInButton();
		String actualAlertMessage = loginpage.warningAlertIsPresent();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage,"User is able to Login with incorrect Username and correct Password");
	}

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to Login with correct Username and incorrect Password",groups = {"regression","smoke"})
	public void verifyUserIsUnableToLoginWithInCorrectPasswordAndCorrectUsername() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 3, "LoginPage");
		String expectedAlertMessage = ExcelUtility.getString(1, 4, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username);
		loginpage.enterPasswordOnPasswordTextField(password);
		loginpage.clickOnSignInButton();
		String actualAlertMessage = loginpage.warningAlertIsPresent();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage,"User is able to Login with incorrect Password and correct Username");
	}

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to Login with inccorrect Username and incorrect Password")
	public void verifyUserIsUnableToLoginWithInCorrectUserNameAndPassword(String username,String password) {
		String expectedAlertMessage = ExcelUtility.getString(1, 4, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username);
		loginpage.enterPasswordOnPasswordTextField(password);
		loginpage.clickOnSignInButton();
		String actualAlertMessage = loginpage.warningAlertIsPresent();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage,"User is able to Login with incorrect Username and Password");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(1, 2, "LoginPage"), ExcelUtility.getString(1, 3, "LoginPage") },
		};
}
}
