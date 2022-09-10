package com.w2a.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.w2a.base.TestBase;
import com.w2a.pages.BankManagerLogin;

public class BankManagerLoginTest extends TestBase{
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		BankManagerLogin bmlogin = new BankManagerLogin(driver);
		bmlogin.loginBM();
	}


}
