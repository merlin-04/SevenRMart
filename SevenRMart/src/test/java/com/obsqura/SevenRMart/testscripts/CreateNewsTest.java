package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.LoginPage;
import retry.Retry;
import pages.CreateNewsPage;

public class CreateNewsTest extends Base{
	public CreateNewsPage createnewspage;
	public LoginPage loginpage;

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to create a News")
	public void verifyUserIsAbleToCreateANews() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String newNews = ExcelUtility.getString(1, 0, "CreateNewsPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		createnewspage = new CreateNewsPage(driver);
		createnewspage.clickOnManageNews().clickOnNewButton().enterNewsOnNewsField(newNews).clickOnSaveButton();
		boolean actual = createnewspage.alertSuccess();
		assertTrue(actual, "User is unable to create a News");
	}
}
