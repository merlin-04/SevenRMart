package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogoutPage {
	public WebDriver driver;
	public WaitUtility waitutility ;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='nav-link']//following-sibling::img")private WebElement adminButton;
	@FindBy(xpath = "//div[@class='dropdown-divider']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logoutButton;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")private WebElement signInPageText;
	
	public LogoutPage clickOnAdminButton() {
		adminButton.click();
		return this;
	}

	public LogoutPage clickOnLogoutButton() {
		waitutility = new WaitUtility();
		waitutility.fluentWaitForElementToBeClickable(driver, logoutButton);
		logoutButton.click();
		return this;
	}

	public String signInPageTextInLoginPage() {
		String signInText = signInPageText.getText();
		return signInText;
	}
}
