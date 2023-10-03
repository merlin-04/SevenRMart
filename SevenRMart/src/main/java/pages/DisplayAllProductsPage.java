package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class DisplayAllProductsPage {
	public WebDriver driver;
	public WaitUtility waitutility;

	public DisplayAllProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::p[text()='Manage Product']")private WebElement manageProductMenu;
	@FindBy(xpath = "//h1[text()='List Products']")private WebElement listProductsText;

	public void clickOnManageProduct() {
		waitutility = new WaitUtility();
		waitutility.explicitWaitForElementToBeClickable(driver, manageProductMenu);
		manageProductMenu.click();
	}

	public boolean isDisplayedListProductsText() {
		boolean listProducts = listProductsText.isDisplayed();
		return listProducts;
	}
}
