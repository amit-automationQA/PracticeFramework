package com.w2a.pages;

import org.openqa.selenium.WebDriver;

import com.w2a.base.TestBase;

public class BankManagerLogin extends TestBase{
	
	WebDriver driver;
	public BankManagerLogin(WebDriver driver) {
		this.driver=driver;
	}

	public AddCustomer loginBM() {
		click("bmlBtn_XPATH");
		explicitWait("openAccountBtn_CSS");
		return new AddCustomer(driver);
	}
}
