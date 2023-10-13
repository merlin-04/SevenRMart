package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.CreateSubCategoryPage;
import pages.LoginPage;
import retry.Retry;

public class CreateSubCategoryTest extends Base {
	public LoginPage loginpage;
	public CreateSubCategoryPage createsubcategorypage;

	@Test(retryAnalyzer = Retry.class,description="Verify User is able to create Sub Category")
	public void verifyUserIsAbleToCreateSubCategory() throws AWTException {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String category = ExcelUtility.getString(1, 0, "CreateSubCategoryPage");
		String subCategory = ExcelUtility.getString(1, 1, "CreateSubCategoryPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		createsubcategorypage = new CreateSubCategoryPage(driver);
		createsubcategorypage.clickOnManageCategoryMenu().clickOnManageSubCategoryMenu().clickOnNewButton().selectCategoryTypeOnCategoryDropdown(category).enterValueOnSubCategoryTextField(subCategory).uploadImageInImageField().clickOnSaveButton();
		boolean isDisplayedSuccessMessage = createsubcategorypage.successAlert();
		assertTrue(isDisplayedSuccessMessage, "User is unable to create Sub Category");
	}
}
