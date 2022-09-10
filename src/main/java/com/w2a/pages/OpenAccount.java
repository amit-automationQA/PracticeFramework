package com.w2a.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.TestBase;

public class OpenAccount extends TestBase{
	
	WebDriver driver;
	public OpenAccount(WebDriver driver) {
		this.driver=driver;
	}
	
	public void openacc(String customer, String currency) {
		click("openAccountBtn_CSS");
		explicitWait("customerDropdown_ID");
		select("customerDropdown_ID",customer);
		select("currencyDropdown_ID",currency);
		click("processBtn_XPATH");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

}
