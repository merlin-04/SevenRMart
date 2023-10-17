package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.SevenRMart.utilities.PageUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;


public class CreateExpenseCategoryUsingWebTablesPage {
	public WebDriver driver;
	public PageUtility pageutility;
	public WaitUtility waitutitlity;

	public CreateExpenseCategoryUsingWebTablesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[contains(@class,'fa-money-bill-alt')]//following-sibling::p")private WebElement manageExpenseMenu;
	@FindBy(xpath = "//a[@class='nav-link']//child::p[text()='Expense Category']")private WebElement expenseCategoryMenu;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")private WebElement titleTextField;
	@FindBy(name = "Create")private WebElement saveButton;
	@FindAll({ @FindBy(xpath = "//table[contains(@class,'table-bordered')]//following::tbody") })private List<WebElement> expenseCategoryTable;

	public CreateExpenseCategoryUsingWebTablesPage clickOnManageExpenseMenu() {
		manageExpenseMenu.click();
		return this;
	}

	public CreateExpenseCategoryUsingWebTablesPage clickOnExpenseCategoryMenu() {
		waitutitlity = new com.obsqura.SevenRMart.utilities.WaitUtility();
		waitutitlity.explicitWaitForElementToBeClickable(driver, expenseCategoryMenu);
		expenseCategoryMenu.click();
		return this;

	}

	public CreateExpenseCategoryUsingWebTablesPage clickOnNewButton() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForVisibilityOfElement(driver, newButton);
		pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(newButton, driver);
		return this;
	}

	public CreateExpenseCategoryUsingWebTablesPage enterTitleOnTilteField(String title) {
		titleTextField.sendKeys(title);
		return this;
	}

	public CreateExpenseCategoryUsingWebTablesPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean verifyCreatedCategoryPresentInTable(String title) {
		boolean flag = false;
		for (WebElement expenseCategory : expenseCategoryTable) {
			String getExpenseCategory = expenseCategory.getText();
			if (getExpenseCategory.contains(title)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
