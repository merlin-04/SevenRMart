package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.CreateExpenseCategoryUsingWebTablesPage;
import pages.LoginPage;
import retry.Retry;

public class CreateExpenseCategoryUsingWebTablesTest extends Base {
	public LoginPage loginpage;
	public CreateExpenseCategoryUsingWebTablesPage createxepensecategoryusingwebtablespage;
	
	@Test(retryAnalyzer = Retry.class,description="Verify User is able to create Expense Category and Check whether created Category is present in Expense Category List")
	public void verifyUserCanCheckCreatedExpenseCategoryIsPresentInExpenseCategoryList() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(1, 0, "CreateExpenseCategoryPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		createxepensecategoryusingwebtablespage = new CreateExpenseCategoryUsingWebTablesPage(driver);
		createxepensecategoryusingwebtablespage.clickOnManageExpenseMenu().clickOnExpenseCategoryMenu().clickOnNewButton().enterTitleOnTilteField(title).clickOnSaveButton();
		boolean isPresentExpenseCategory = createxepensecategoryusingwebtablespage.verifyCreatedCategoryPresentInTable(title);
		assertTrue(isPresentExpenseCategory,"User created Expense Category is not present in Expense Category List");
	}
}

