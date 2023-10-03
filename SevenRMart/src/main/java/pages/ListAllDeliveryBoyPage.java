package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ListAllDeliveryBoyPage {
	public WebDriver driver;
	public PageUtility pageutility;
	
	public ListAllDeliveryBoyPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='icon']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")private WebElement manageDeliveryBoyCard;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton ;
	@FindBy(xpath = "//a[contains(@class,'btn-warning')]")private WebElement resetButton ;
	@FindBy(xpath = "//h4[text()='Search List Delivery Boy']")private WebElement searchFormHeading ;
	
	public ListAllDeliveryBoyPage clickOnDeliveryBoyCard()
	{
		manageDeliveryBoyCard.click();
		return this;
	}
	public ListAllDeliveryBoyPage clickOnSearchButton()
	{
		pageutility = new PageUtility();
		pageutility.clickUsingJavaScriptExecutor(searchButton, driver);
		return this;
	}
	public ListAllDeliveryBoyPage clickOnResetButton()
	{
		resetButton.click();
		return this;
	}
	public boolean IsDisplayedSearchForm()
	{
		boolean searchForm = searchFormHeading.isDisplayed();
		return searchForm;
	}
}
