package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.DisplayAllCategoriesPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class DisplayAllCategoriesTest extends Base {
	public LoginPage loginpage;
	public DisplayAllCategoriesPage displayallcategoriespage;

	@Test
	public void verifyUserIsAbleToSearchCategoryThatIsAlreadyCreated() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String category = ExcelUtility.getString(1, 0, "DisplayAllCategoriesPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		displayallcategoriespage = new DisplayAllCategoriesPage(driver);
		displayallcategoriespage.clickOnCategoryCard().clickOnSearchButton().enterSearchValueInCategoryTextField(category).clickOnSearchButtonInSearchForm();
		boolean isDisplayedSearchForm = displayallcategoriespage.searchCategoryFormIsDisplayed();
		assertTrue(isDisplayedSearchForm, "User is unable to search a category in Category listing page");
	}
}
