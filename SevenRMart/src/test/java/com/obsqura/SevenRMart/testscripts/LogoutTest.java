package com.obsqura.SevenRMart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	public LoginPage loginpage;
	public LogoutPage logoutpage;

	@Test
	public void verifyUserIsAbleToLogout() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String signPageTextExpected = ExcelUtility.getString(1, 0, "LogoutPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		logoutpage = new LogoutPage(driver);
		logoutpage.clickOnAdminButton().clickOnLogoutButton();
		String signInPageTextActual = logoutpage.signInPageTextInLoginPage();
		Assert.assertEquals(signPageTextExpected, signInPageTextActual, "User is unable to Logout");
	}
}
