package pageObjects;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage{
	WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Select Sort combobox with value: {0}")
	public void selectSortCombobox(String value) {
		waitForElementVisible(driver, ProductPageUI.CBB_SORT);
		selectItemInDropDown(driver, ProductPageUI.CBB_SORT, value);
	}
	
	@Step("Verify Product Name sort desc")
	public boolean isProdductNameSortDesc() {
		return isDataTextSortDESC(driver, ProductPageUI.LST_PRODUCT_NAME);
	}
	
	@Step("Verify Product Name sort asc")
	public boolean isProdductNameSortAsc() {
		return isDataTextSortASC(driver, ProductPageUI.LST_PRODUCT_NAME);
	}
	
	@Step("Verify Product price sort desc")
	public boolean isProdductPriceSortDesc() {
		return isDataFloatSortDESC(driver, ProductPageUI.LST_PRODUCT_PRICE);
	}
	
	@Step("Verify Product price sort asc")
	public boolean isProdductPriceSortAsc() {
		return isDataFloatSortASC(driver, ProductPageUI.LST_PRODUCT_PRICE);
	}
}
