package pageObjects;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputValueToUserNameTextBox(String value) {
		waitForElementVisible(driver, HomePageUI.TXT_USERNAME);
		senKeyToElement(driver, HomePageUI.TXT_USERNAME, value);
	}
	
	public void inputValueToPasswordTextBox(String value) {
		waitForElementVisible(driver, HomePageUI.TXT_PASSWORD);
		senKeyToElement(driver, HomePageUI.TXT_PASSWORD, value);
	}
	
	public ProductPageObject clickOnLogInButton() {
		waitForElementClickable(driver, HomePageUI.BTN_LOGIN);
		clickToElement(driver, HomePageUI.BTN_LOGIN);
		return PageGeneratorManager.getProductPage(driver);
	}
}
