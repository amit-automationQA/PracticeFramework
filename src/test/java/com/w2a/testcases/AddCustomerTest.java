package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;
import com.w2a.pages.AddCustomer;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomer(Hashtable<String,String> data) throws InterruptedException {
		explicitWait("addCustomerOption_XPATH");
		if(!data.get("Runmode").equals("Y")) {
			throw new SkipException("Skipping the test data as the runmode is No!!");
		}
		AddCustomer addcm= new AddCustomer(driver);
		addcm.addcs(data.get("firstname"), data.get("lastname"), data.get("postcode"), data.get("alerttext"));
		}

}
