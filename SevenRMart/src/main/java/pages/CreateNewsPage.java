package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.SevenRMart.utilities.PageUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;


public class CreateNewsPage {
	public WebDriver driver;
	public PageUtility pageutility;
	public WaitUtility waitutitlity;

	public CreateNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")private WebElement addNews;
	@FindBy(name = "news")private WebElement newsTextfield;
	@FindBy(xpath = "//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath = "//div[@class='icon']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement manageNewsMenu;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")private WebElement successAlert;

	public CreateNewsPage clickOnNewButton() {
		addNews.click();
		return this;
	}

	public CreateNewsPage enterNewsOnNewsField(String news) {
		newsTextfield.sendKeys(news);
		return this;
	}

	public CreateNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public CreateNewsPage clickOnManageNews() {
		pageutility = new PageUtility();
		pageutility.scrollByUsingJavaScriptExecutor(manageNewsMenu, driver);
		waitutitlity = new WaitUtility();
		waitutitlity.fluentWaitForElementToBeClickable(driver, manageNewsMenu);
		manageNewsMenu.click();
		return this;
	}

	public boolean alertSuccess() {
		boolean isDisplayedManageNewsText = successAlert.isDisplayed();
		return isDisplayedManageNewsText;
	}
}
