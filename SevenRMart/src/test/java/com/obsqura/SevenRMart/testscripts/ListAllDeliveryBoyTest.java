package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ListAllDeliveryBoyPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ListAllDeliveryBoyTest extends Base {
	public LoginPage loginpage;
	public ListAllDeliveryBoyPage listalldeliveryboypage;

	@Test(retryAnalyzer = Retry.class,description= "Verify user is able to reset Search in Delivery Boy Listing")
	public void verifyUserIsAbleToResetTheSearchInDeliveryBoyListing()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		listalldeliveryboypage = new ListAllDeliveryBoyPage(driver);
		listalldeliveryboypage.clickOnDeliveryBoyCard().clickOnSearchButton().clickOnResetButton();
		boolean isDisplayedSearchForm = listalldeliveryboypage.IsDisplayedSearchForm();
		assertFalse(isDisplayedSearchForm,"User is unable to Reset search in Delivery Boy listing");
	}
}
