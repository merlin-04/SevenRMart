package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.SevenRMart.utilities.FileUploadUtility;
import com.obsqura.SevenRMart.utilities.GeneralUtility;
import com.obsqura.SevenRMart.utilities.PageUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;


public class CreateMobileSliderPage {
	public WebDriver driver;
	public PageUtility pageutility;
	public WaitUtility waitutitlity;
	public FileUploadUtility fileuploadutility;
	
	public CreateMobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[contains(@class,'fa-window-minimize')]//following-sibling::p")private WebElement mobileSlider;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath ="//select[@id ='cat_id']")private WebElement selectCategoryField;
	@FindBy(xpath = "//input[@type='file']")private WebElement imageUploadFieldButton;
	@FindBy(xpath = "//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement alertMessage;
	
	public CreateMobileSliderPage clickOnMobileSlider() {
		mobileSlider.click();
		return this;
	}

	public CreateMobileSliderPage clickOnNewButton() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForVisibilityOfElement(driver, newButton);
		pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(newButton, driver);
		return this;
	}

	public CreateMobileSliderPage selectCategoryTypeOnCategoryDropdown(String category) {
		pageutility = new PageUtility();
		pageutility.selectDropdownbyText(selectCategoryField, category);
		return this;
	}

	public CreateMobileSliderPage uploadImageInImageField() {
		waitutitlity = new WaitUtility();
		waitutitlity.explicitWaitForElementToBeClickable(driver, imageUploadFieldButton);
		fileuploadutility = new FileUploadUtility();
		fileuploadutility.uploadFileUsingSendKeys(imageUploadFieldButton,GeneralUtility.IMAGEFILEFORMANAGESUBCATEGORYPAGE);
		return this;
	}

	public CreateMobileSliderPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean successAlert() {
		boolean successAlertDisplayed = alertMessage.isDisplayed();
		return successAlertDisplayed;
	}
}
