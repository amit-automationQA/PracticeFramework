package com.w2a.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.TestBase;

public class AddCustomer extends TestBase {
	WebDriver driver;
	public AddCustomer(WebDriver driver) {
		this.driver=driver;
	}

	public void addcs(String firstname, String lastname, String postcode, String alerttext) {
		click("addCustomerOption_XPATH");
		explicitWait("firstNameTxtbox_XPATH");
		type("firstNameTxtbox_XPATH",firstname);
		type("lastNameTxtbox_XPATH",lastname);
		type("postCodeTxtbox_XPATH",postcode);
		click("addCustomerBtn_XPATH");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		softAssert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		softAssert.assertAll();
	}

}
