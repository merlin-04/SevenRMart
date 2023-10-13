package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")private WebElement usernameTextField;
	@FindBy(name = "password")private WebElement passwordTextField;
	@FindBy(xpath = "//button[text()='Sign In']")private WebElement signInButton;
	@FindBy(xpath = "//h5[contains(text(),'Alert!')]")private WebElement alertMessage;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")private WebElement dashboardText;

	public LoginPage enterUsernameOnUserNameTextField(String username) {
		usernameTextField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordTextField(String password) {
		passwordTextField.sendKeys(password);
		return this;
	}

	public LoginPage clickOnSignInButton() {
		signInButton.click();
		return this;
	}

	public boolean IsDisplayedDashboardTextOnHomePage() {
		boolean isDisplayedDashboardText = dashboardText.isDisplayed();
		return isDisplayedDashboardText;
	}

	public String warningAlertIsPresent() {
		String warningAlertMessage = alertMessage.getText();
		return warningAlertMessage;
	}
}
