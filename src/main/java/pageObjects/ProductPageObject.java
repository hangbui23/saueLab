package pageObjects;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage{
	WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectSortCombobox(String value) {
		waitForElementVisible(driver, ProductPageUI.CBB_SORT);
		selectItemInDropDown(driver, ProductPageUI.CBB_SORT, value);
	}
	
	public boolean isProdductNameSortDesc() {
		return isDataTextSortDESC(driver, ProductPageUI.LST_PRODUCT_NAME);
	}
	
	public boolean isProdductNameSortAsc() {
		return isDataTextSortASC(driver, ProductPageUI.LST_PRODUCT_NAME);
	}
	
	public boolean isProdductPriceSortDesc() {
		return isDataFloatSortDESC(driver, ProductPageUI.LST_PRODUCT_PRICE);
	}
	
	public boolean isProdductPriceSortAsc() {
		return isDataFloatSortASC(driver, ProductPageUI.LST_PRODUCT_PRICE);
	}
}
