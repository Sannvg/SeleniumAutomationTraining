package com.POS.TestCases;

import java.util.ArrayList;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.Log;

public class VerifySettingsTest extends BaseClass {
	@Test(priority = 1)
	public void validateAddUser() throws Exception {
		Log.startTestCase("VerifySettingsTest--validateAddUser");
		objLogin.loginFn();
		objHome.btnMenuVisible();
		act.click1(objHome.menuSettings(), "Settings Menu");
		act.click1(objSettings.btnUsers(), "Users");
		act.click1(objSettings.btnAddUser(), "Add User");
		Random objRan = new Random();		
		ArrayList excelData = data.getData("User");
		act.type(objSettings.txtUserName(), (String) excelData.get(0));
		act.type(objSettings.txtFirstNm(), (String) excelData.get(1)+""+objRan.nextInt());
		act.type(objSettings.txtLastNm(), (String) excelData.get(2)+""+objRan.nextInt());
		act.click1(objSettings.rbtnSales(), "Sales");
		act.type(objSettings.txtEmail(), (String) excelData.get(3));
		act.type(objSettings.txtPassword(), (String) excelData.get(4));
		act.type(objSettings.txtCPassword(), (String) excelData.get(5));
		act.click1(objSettings.btnInputFile(), "Choose File");
		act.type(objSettings.btnInputFile(), System.getProperty("user.dir") + "\\Files\\Test User.jpg");
		act.click1(objSettings.btnSubmit(), "Add User Submit");
		Log.info("User Details entered");
		Assert.assertTrue(objSettings.btnUsers().isDisplayed());
		objHome.logOutFn();
		Log.endTestCase("VerifySettingsTest--validateAddUser");
	}
}

