package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationsPage {
	public WebDriver driver;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Push Notifications']")private WebElement pushNotificationMenu;
	@FindBy(xpath = "//input[@id='title']")private WebElement titleField;
	@FindBy(xpath = "//input[@id='description']")private WebElement descriptionField;
	@FindBy(name = "create")private WebElement sendButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement successAlertMessage;

	public PushNotificationsPage clickOnPushNotificationMenu() {
		pushNotificationMenu.click();
		return this;
	}

	public PushNotificationsPage enterTitleOnTitleField(String title) {
		titleField.sendKeys(title);
		return this;
	}

	public PushNotificationsPage enterDescriptionOnDescriptionField(String description) {
		descriptionField.sendKeys(description);
		return this;
	}

	public PushNotificationsPage clickOnSendButton() {
		sendButton.click();
		return this;
	}

	public boolean successAlert() {
		boolean isDisplayedSuccessAlert = successAlertMessage.isDisplayed();
		return isDisplayedSuccessAlert;
	}
}
