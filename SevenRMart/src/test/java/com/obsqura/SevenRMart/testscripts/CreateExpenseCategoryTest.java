package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CreateExpenseCategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CreateExpenseCategoryTest extends Base {
	public LoginPage loginpage;
	public CreateExpenseCategoryPage createexpensecategory;
	
	@Test(description="Verify User is able to create Expense Category")
	public void verifyUserIsAbleToCreateExpenseCategory() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(1, 0, "CreateExpenseCategoryPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		createexpensecategory = new CreateExpenseCategoryPage(driver);
		createexpensecategory.clickOnManageExpenseMenu().clickOnExpenseCategoryMenu().clickOnNewButton().enterTitleOnTilteField(title).clickOnSaveButton();
		boolean succesAlertIsDisplayed = createexpensecategory.successAlert();
		assertTrue(succesAlertIsDisplayed, "User is unable to create Expense Category");
	}
}
