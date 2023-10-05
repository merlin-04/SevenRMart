package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class DeleteAdminUserPage {
	public WebDriver driver;
	public PageUtility pageutility;
	public WaitUtility waitutility;

	public DeleteAdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='icon']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement manageAdminUsers;
	@FindAll({ @FindBy(xpath = "//table[contains(@class,'table-bordered')]//following::tbody") })private List<WebElement> searchResultElements;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/user/delete?del=6303&page_ad=1']")private WebElement deleteButton;

	public DeleteAdminUserPage clickOnManageAdminUsersCard() {
		manageAdminUsers.click();
		return this;
	}

	public DeleteAdminUserPage deleteSelectedAdminUser(String expectedUsername) {
		for (WebElement adminUsersList : searchResultElements) {
			String getUsersList = adminUsersList.getText();
			if (getUsersList.contains(expectedUsername)) {
				waitutility = new WaitUtility();
				waitutility.explicitWaitForElementToBeClickable(driver, deleteButton);
				pageutility = new PageUtility();
				pageutility.acceptAlert(deleteButton, driver);
			}
		}
		return this;
	}

	public boolean verifyUserIsRemovedFromTheList(String expectedUsername) {
		boolean flag = false;
		for (WebElement adminUsersList : searchResultElements) {
			String getUsersList = adminUsersList.getText();
			if (getUsersList.contains(expectedUsername)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
