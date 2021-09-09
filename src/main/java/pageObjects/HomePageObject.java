package pageObjects;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Input to username textbox with value: {0}")
	public void inputValueToUserNameTextBox(String value) {
		waitForElementVisible(driver, HomePageUI.TXT_USERNAME);
		senKeyToElement(driver, HomePageUI.TXT_USERNAME, value);
	}
	
	@Step("Input to password textbox with value: {0}")
	public void inputValueToPasswordTextBox(String value) {
		waitForElementVisible(driver, HomePageUI.TXT_PASSWORD);
		senKeyToElement(driver, HomePageUI.TXT_PASSWORD, value);
	}
	
	@Step("Click on Login button")
	public ProductPageObject clickOnLogInButton() {
		waitForElementClickable(driver, HomePageUI.BTN_LOGIN);
		clickToElement(driver, HomePageUI.BTN_LOGIN);
		return PageGeneratorManager.getProductPage(driver);
	}
}
