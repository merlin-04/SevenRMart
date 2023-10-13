package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.SevenRMart.utilities.PageUtility;
import com.obsqura.SevenRMart.utilities.WaitUtility;


public class DisplayAllCategoriesPage {
	public WebDriver driver;
	public WaitUtility waitutility;
	public PageUtility pageutitlity;
	
	public DisplayAllCategoriesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='icon']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")private WebElement categoryCard;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Category']")private WebElement categoryTextField;
	@FindBy(name = "Search")private WebElement searchButtonInSearchForm;
	@FindBy(xpath = "//form[@method = 'get']")private WebElement searchCategoryForm;

     public DisplayAllCategoriesPage clickOnCategoryCard()
     {
    	 categoryCard.click();
    	 return this;
     }
     public DisplayAllCategoriesPage clickOnSearchButton()
     {
    	 pageutitlity = new PageUtility();
    	 pageutitlity.clickUsingJavaScriptExecutor(searchButton, driver);
    	 return this;
     }
     public DisplayAllCategoriesPage enterSearchValueInCategoryTextField(String categoryText)
     {
    	 categoryTextField.sendKeys(categoryText);
    	 return this;
     }
     public DisplayAllCategoriesPage clickOnSearchButtonInSearchForm()
     {
    	 searchButtonInSearchForm.click();
    	 return this;
     }
     public boolean searchCategoryFormIsDisplayed()
     {
    	 waitutility = new WaitUtility();
    	 waitutility.explicitWaitForElementToBeClickable(driver, searchButtonInSearchForm);
    	 boolean isDisplayedSearchForm = searchCategoryForm.isDisplayed();
    	 return isDisplayedSearchForm;
     }
}
