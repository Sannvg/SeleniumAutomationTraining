package com.POS.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.ExcelRead;
import com.POS.Utilities.Log;

public class VerifyUserLoginTest extends BaseClass {
	@Test(priority = 1)
	public void validateLogin() {
		Log.startTestCase("VerifyUserLoginTest-validateLogin");
		objLogin.loginFn();
		Assert.assertEquals(objHome.storeMenu().getText(), "CHOOSE A STORE");
		Log.info("User logged in");
		Log.endTestCase("VerifyUserLoginTest-validateLogin");
		objHome.logOutFn();
	}

	@Test(dataProvider = "getLoginUsers", priority = 2)
	public void validateAllLogin(String userNm, String psWrd) {
		Log.startTestCase("VerifyUserLoginTest-validateAllLogin");
		act.type(objLogin.txtUsername(), userNm);
		Log.info("UserName Entered");
		act.type(objLogin.txtPswrd(), psWrd);
		Log.info("Password Entered");
		act.click1(objLogin.btnLogin(), "Login Button");
		Log.endTestCase("VerifyUserLoginTest-validateAllLogin");
		Assert.assertEquals(objLogin.lblLogin().getText(), "Login");
	}

	@DataProvider
	public Object[][] getLoginUsers()  throws Exception {
		Object[][] logindata = new Object[3][2];
		ExcelRead data = new ExcelRead();
		ArrayList excelData = data.getData("InvalidUser");		
		logindata[0][0] = excelData.get(0);
		logindata[0][1] = excelData.get(1);
		logindata[1][0] = excelData.get(2);
		logindata[1][1] = excelData.get(1);
		logindata[2][0] = excelData.get(0);
		logindata[2][1] = excelData.get(3);
		return logindata;
	}

}

