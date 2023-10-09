package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.DisplayAllProductsPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class DisplayAllProductsTest extends Base {
	public LoginPage loginpage;
	public DisplayAllProductsPage displayallproductspage;

	@Test(retryAnalyzer = Retry.class,description="Verify User is able to Click on Manage Products Sidebar")
	public void verifyUserIsAbleToClickOnManageProductInSidebarMenu() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username);
		loginpage.enterPasswordOnPasswordTextField(password);
		loginpage.clickOnSignInButton();
		displayallproductspage = new DisplayAllProductsPage(driver);
		displayallproductspage.clickOnManageProduct();
		boolean listProductsHeadingTextIsDisplayed = displayallproductspage.isDisplayedListProductsText();
		assertTrue(listProductsHeadingTextIsDisplayed, "User is unable to click on Manage Products menu in sidebar");
	}
}
