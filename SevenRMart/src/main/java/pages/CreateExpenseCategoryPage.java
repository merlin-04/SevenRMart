package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class CreateExpenseCategoryPage {
	public WebDriver driver;
	public PageUtility pageutility;
	public WaitUtility waitutitlity;

	public CreateExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[contains(@class,'fa-money-bill-alt')]//following-sibling::p")private WebElement manageExpenseMenu;
	@FindBy(xpath = "//a[@class='nav-link']//child::p[text()='Expense Category']")private WebElement expenseCategoryMenu;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")private WebElement titleTextField;
	@FindBy(name = "Create")private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement successAlert;
	
	public CreateExpenseCategoryPage clickOnManageExpenseMenu() {
		manageExpenseMenu.click();
		return this;
	}

	public CreateExpenseCategoryPage clickOnExpenseCategoryMenu() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForElementToBeClickable(driver, expenseCategoryMenu);
		expenseCategoryMenu.click();
		return this;

	}

	public CreateExpenseCategoryPage clickOnNewButton() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForVisibilityOfElement(driver, newButton);
		pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(newButton, driver);
		return this;
	}

	public CreateExpenseCategoryPage enterTitleOnTilteField(String title) {
		titleTextField.sendKeys(title);
		return this;
	}

	public CreateExpenseCategoryPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean successAlert() {
		boolean isDisplayedSuccessAlert = successAlert.isDisplayed();
		return isDisplayedSuccessAlert;
	}
}
