package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.SevenRMart.utilities.FileUploadUtility;
import com.obsqura.SevenRMart.utilities.GeneralUtility;
import com.obsqura.SevenRMart.utilities.PageUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;

public class CreateSubCategoryPage {
	public WebDriver driver;
	public PageUtility pageutility;
	public WaitUtility waitutitlity;
	public FileUploadUtility fileuploadutility;

	public CreateSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'nav-link')]//child::p[contains(text(), 'Manage Category')]")private WebElement manageCategoryMenu;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//child::p")private WebElement manageSubCategoryMenu;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")private WebElement selectCategoryField;
	@FindBy(xpath = "//input[@id='subcategory']")private WebElement subCategoryTextField;
	@FindBy(xpath = "//input[@type='file']")private WebElement imageUploadFieldButton;
	@FindBy(xpath = "//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement alertMessage;

	public CreateSubCategoryPage clickOnManageCategoryMenu() {
		manageCategoryMenu.click();
		return this;
	}

	public CreateSubCategoryPage clickOnManageSubCategoryMenu() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForElementToBeClickable(driver, manageSubCategoryMenu);
		manageSubCategoryMenu.click();
		return this;
	}

	public CreateSubCategoryPage clickOnNewButton() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForVisibilityOfElement(driver, newButton);
		pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(newButton, driver);
		return this;
	}

	public CreateSubCategoryPage selectCategoryTypeOnCategoryDropdown(String category) {
		pageutility = new PageUtility();
		pageutility.selectDropdownbyText(selectCategoryField, category);
		return this;
	}

	public CreateSubCategoryPage enterValueOnSubCategoryTextField(String subCategory) {
		subCategoryTextField.sendKeys(subCategory);
		return this;
	}

	public CreateSubCategoryPage uploadImageInImageField() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForElementToBeClickable(driver, imageUploadFieldButton);
		fileuploadutility = new FileUploadUtility();
		fileuploadutility.uploadFileUsingSendKeys(imageUploadFieldButton,GeneralUtility.IMAGEFILEFORMANAGESUBCATEGORYPAGE);
		return this;
	}

	public CreateSubCategoryPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean successAlert() {
		boolean successAlertDisplayed = alertMessage.isDisplayed();
		return successAlertDisplayed;
	}
}
