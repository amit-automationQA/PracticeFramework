package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.pages.OpenAccount;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase{
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void verifyOpenAccount(Hashtable<String,String> data) throws InterruptedException {
if(!(TestUtil.isTestRunnable("verifyOpenAccount", excel))){
			
			throw new SkipException("Skipping the test "+"verifyOpenAccount".toUpperCase()+ "as the Run mode is NO");
		}
		OpenAccount op = new OpenAccount(driver);
		op.openacc(data.get("customer"), data.get("currency"));	
	}

}
