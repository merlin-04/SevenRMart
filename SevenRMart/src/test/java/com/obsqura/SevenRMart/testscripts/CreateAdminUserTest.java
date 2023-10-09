package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CreateAdminUserPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class CreateAdminUserTest extends Base {
	public LoginPage loginpage;
	public CreateAdminUserPage createadminuserpage;

	@Test(retryAnalyzer = Retry.class,description ="Verify User is able to create an Admin User")
	public void verifyUserIsAbleToCreateAnAdminUser() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String adminUsername = ExcelUtility.getString(1, 0, "CreateAdminUserPage");
		String adminPassword = ExcelUtility.getString(1, 1, "CreateAdminUserPage");
		String userType = ExcelUtility.getString(1, 2, "CreateAdminUserPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		createadminuserpage = new CreateAdminUserPage(driver);
		createadminuserpage.clickOnManageAdminUsersCard().clickOnNewButton().enterUsernameOnUsernameField(adminUsername).enterPasswordOnPasswordField(adminPassword).selectUserTypeOnUserTypeField(userType).clickOnSaveButton();
		boolean isAlertMessageIsPresent = createadminuserpage.successAlert();
		assertTrue(isAlertMessageIsPresent, "User is unable to create an admin user");
	}
}
