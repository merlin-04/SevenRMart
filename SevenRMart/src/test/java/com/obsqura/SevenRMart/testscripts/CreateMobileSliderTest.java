package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.CreateMobileSliderPage;
import pages.LoginPage;
import retry.Retry;

public class CreateMobileSliderTest extends Base {
	public LoginPage loginpage;
	public CreateMobileSliderPage createmobilesidebarpage;
	
	@Test(retryAnalyzer = Retry.class,description="Verify User is able to create Mobile Slider")
	public void verifyUserIsAbleToCreateMobileSlider() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String category = ExcelUtility.getString(1, 0, "CreateMobileSidebar");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		createmobilesidebarpage = new CreateMobileSliderPage(driver);
		createmobilesidebarpage.clickOnMobileSlider().clickOnNewButton().selectCategoryTypeOnCategoryDropdown(category).uploadImageInImageField().clickOnSaveButton();
		boolean isAlertPresent = createmobilesidebarpage.successAlert();
		assertTrue(isAlertPresent,"User is unable to create Mobile Slider");
	}

}
