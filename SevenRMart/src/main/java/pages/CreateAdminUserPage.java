package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.SevenRMart.utilities.PageUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;

public class CreateAdminUserPage {
	public WebDriver driver;
	public PageUtility pageutitlity;
	public WaitUtility waitutility;

	public CreateAdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='icon']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement manageAdminUsers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//input[@id ='username']")private WebElement usernameField;
	@FindBy(xpath = "//input[@id ='password']")private WebElement passwordField;
	@FindBy(xpath = "//select[@id ='user_type']")private WebElement userTypeField;
	@FindBy(name = "Create")private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement alertMessage;
	
	public CreateAdminUserPage clickOnManageAdminUsersCard() {
		manageAdminUsers.click();
		return this;
	}
	public CreateAdminUserPage clickOnNewButton()
	{
		waitutility = new WaitUtility();
		waitutility.explicitWaitForVisibilityOfElement(driver, newButton);
		pageutitlity = new PageUtility();
		pageutitlity.clickUsingJavaScriptExecutor(newButton, driver);
		return this;
	}
	public CreateAdminUserPage enterUsernameOnUsernameField(String userName)
	{
		usernameField.sendKeys(userName);
		return this;
	}
	public CreateAdminUserPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public CreateAdminUserPage selectUserTypeOnUserTypeField(String userType)
	{
		pageutitlity = new PageUtility();
		pageutitlity.selectDropdownbyValue(userTypeField, userType);
		return this;
	}
	public CreateAdminUserPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean successAlert() {
		boolean isDisplayedManageAdminText = alertMessage.isDisplayed();
		return isDisplayedManageAdminText;
	}
}
