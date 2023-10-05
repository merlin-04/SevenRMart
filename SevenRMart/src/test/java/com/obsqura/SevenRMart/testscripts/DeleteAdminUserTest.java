package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.DeleteAdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class DeleteAdminUserTest extends Base {
	public LoginPage loginpage;
	public DeleteAdminUserPage deleteadminuserpage;

	@Test(description ="Verify User is able delete an Admin User")
	public void verifyUserIsAbleToDeleteAnAdminUser() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String adminToBeDeleted = ExcelUtility.getString(1, 0, "DeleteAdminUserPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		deleteadminuserpage = new DeleteAdminUserPage(driver);
		deleteadminuserpage.clickOnManageAdminUsersCard().deleteSelectedAdminUser(adminToBeDeleted);
		boolean userIsRemoved = deleteadminuserpage.verifyUserIsRemovedFromTheList(adminToBeDeleted);
		assertFalse(userIsRemoved,"User is unable to delete a Admin User");
	}
}
