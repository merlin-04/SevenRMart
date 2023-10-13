package com.obsqura.SevenRMart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.LoginPage;
import pages.LogoutPage;
import retry.Retry;

public class LogoutTest extends Base {
	public LoginPage loginpage;
	public LogoutPage logoutpage;

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to Logout")
	@Parameters("signPageTextExpected")
	public void verifyUserIsAbleToLogout(String signPageTextExpected) {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		logoutpage = new LogoutPage(driver);
		logoutpage.clickOnAdminButton().clickOnLogoutButton();
		String signInPageTextActual = logoutpage.signInPageTextInLoginPage();
		Assert.assertEquals(signPageTextExpected, signInPageTextActual, "User is unable to Logout");
	}
}
