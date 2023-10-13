package com.obsqura.SevenRMart.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.SevenRMart.utilities.ExcelUtility;

import pages.LoginPage;
import pages.PushNotificationsPage;
import retry.Retry;

public class PushNotificationsTest extends Base {
	public LoginPage loginpage;
	public PushNotificationsPage pushnotificationpage;

	@Test(retryAnalyzer = Retry.class,description="Verify user is able to Send Push Notifications")
	public void verifyUserIsAbleToSendPushNotifications() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(1, 0, "PushNotificationPage");
		String description = ExcelUtility.getString(1, 1, "PushNotificationPage");
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserNameTextField(username).enterPasswordOnPasswordTextField(password).clickOnSignInButton();
		pushnotificationpage = new PushNotificationsPage(driver);
		pushnotificationpage.clickOnPushNotificationMenu().enterTitleOnTitleField(title).enterDescriptionOnDescriptionField(description).clickOnSendButton();
		boolean isDisplayedSuccessAlertMessahe = pushnotificationpage.successAlert();
		assertTrue(isDisplayedSuccessAlertMessahe,"User is unable to send a Push Notification");
	}
}
