package com.saucelab.Sort;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductPageObject;
import commons.BaseTest;
import commons.Environment;

public class TC01_Sort extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	ProductPageObject productPage;
	String username,password;
	Environment env;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Open Sauce Lab page");
		String environment = System.getProperty("environment");
		System.out.println("Server name on command line" + environment.toLowerCase());
		
		ConfigFactory.setProperty("environment", environment);
		env = ConfigFactory.create(Environment.class);
		System.out.println("Url" + env.url());
		System.out.println("HostName" + env.getDBHostName());
		System.out.println("UserName" + env.getDBUserName());
		System.out.println("Password" + env.getDBPassword());
		
		driver = getBrowserName(browserName,env.url());
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Input value to user name textbox");
		homePage.inputValueToUserNameTextBox(env.getDBUserName());
		
		log.info("Input value to password textbox");
		homePage.inputValueToPasswordTextBox(env.getDBPassword());
		
		log.info("Click on Log In button");
		productPage = homePage.clickOnLogInButton();
	}

	@Description("TC01 - Sort Z-A")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC01_SortZA(){
		productPage.sleepInSecond(3);
		
		log.info("Select Name (Z to A) combobox");
		productPage.selectSortCombobox("Name (Z to A)");
		
		log.info("Verify product name sort desc");
		verifyTrue(productPage.isProdductNameSortDesc());
	}
	
	@Description("TC02 - Sort A-Z")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void TC02_SortAZ(){
		productPage.sleepInSecond(3);
		log.info("Select Name (A to Z) combobox");
		productPage.selectSortCombobox("Name (A to Z)");
		
		log.info("Verify product name sort asc");
		verifyTrue(productPage.isProdductNameSortAsc());
	}
	
	@Description("TC03 - Sort Price (low to high)")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void TC03_SortPriceLowToHigh(){
		productPage.sleepInSecond(3);
		log.info("Select Price (low to high) combobox");
		productPage.selectSortCombobox("Price (low to high)");
		
		log.info("Verify product name sort Price (low to high)");
		verifyTrue(productPage.isProdductPriceSortAsc());
	}
	
	@Description("TC04 - Sort Price (low to high)")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void TC04_SortPriceHighToLow(){
		productPage.sleepInSecond(3);
		log.info("Select Price (high to low) combobox");
		productPage.selectSortCombobox("Price (high to low)");
		
		log.info("Verify product name sort Price (high to low)");
		verifyTrue(productPage.isProdductPriceSortDesc());
	}
	
	
	@Step("TC05 - Sort Price (low to high)")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC05_SortPriceHighToLow(){
		productPage.sleepInSecond(3);
		log.info("Select Price (high to low) combobox");
		productPage.selectSortCombobox("Price (high to low)");
		
		log.info("Verify product name sort Price (high to low)");
		verifyTrue(productPage.isProdductPriceSortDesc());
	}
	
	
	@Step("TC06 - Sort Price (low to high)")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void TC06_SortPriceHighToLow(){
		productPage.sleepInSecond(3);
		log.info("Select Price (high to low) combobox");
		productPage.selectSortCombobox("Price (high to low)");
		
		log.info("Verify product name sort Price (high to low)");
		verifyTrue(productPage.isProdductPriceSortDesc());
	}
	
	@Step("TC07 - Sort Price (low to high)")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void TC07_SortPriceHighToLow(){
		productPage.sleepInSecond(3);
		log.info("Select Price (high to low) combobox");
		productPage.selectSortCombobox("Price (high to low)");
		
		log.info("Verify product name sort Price (high to low)");
		verifyFalse(productPage.isProdductPriceSortDesc());
	}
	
	@Step("TC08 - Sort Price (low to high)")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void TC08_SortPriceHighToLow(){
		productPage.sleepInSecond(3);
		log.info("Select Price (high to low) combobox");
		productPage.selectSortCombobox("Price (high to low)");
		
		log.info("Verify product name sort Price (high to low)");
		verifyTrue(productPage.isProdductPriceSortDesc());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
