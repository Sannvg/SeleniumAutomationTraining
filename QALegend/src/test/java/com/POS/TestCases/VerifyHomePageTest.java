package com.POS.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.Log;

public class VerifyHomePageTest extends BaseClass {
	@Test(priority = 1, groups = { "Smoke" })
	public void validateElementsDisplay() {
		Log.startTestCase("VerifyHomePageTest--displayElements");
		objLogin.loginFn();
		act.findElement(getDriver(), objHome.logoImage());
		Assert.assertTrue(objHome.logoImage().isDisplayed());
		act.findElement(getDriver(), objHome.loginLabel());
		Assert.assertTrue(objHome.loginLabel().isDisplayed());
		act.findElement(getDriver(), objHome.loginImage());
		Assert.assertTrue(objHome.logoImage().isDisplayed());
		act.findElement(getDriver(), objHome.logout());
		Assert.assertTrue(objHome.logout().isDisplayed());
		Log.info("Home Page Elements Display");
		objHome.logOutFn();
		Log.endTestCase("VerifyHomePageTest--displayElements");
	}

	@Test(priority = 2, groups = { "Smoke" })
	public void validateLanguageSelection() {
		Log.startTestCase("VerifyHomePageTest--languageListed");
		objLogin.loginFn();
		objHome.btnMenuVisible();
		act.click1(objHome.btnMenu(), "Menu");
		act.click1(objHome.languageSelected(), "Language Dropdown");
		objHome.languageSelection(" Spanish");		
		Log.info("Home Page Menu Check");
		JavascriptExecutor objJSE = (JavascriptExecutor)getDriver();
		objJSE.executeScript("arguments[0].click()", objHome.languageSelected());	
		objHome.languageSelection(" English");
		Assert.assertTrue(objHome.languageSelected().isDisplayed());
		objHome.logOutFn();
		Log.endTestCase("VerifyHomePageTest--languageListed");
	}

	@Test(priority = 3, groups = { "Smoke" })
	public void validateMenuDisplay() {
		Log.startTestCase("VerifyHomePageTest--menuElements");
		objLogin.loginFn();
		objHome.btnMenuVisible();
		List<WebElement> menuHome = objHome.menuList();
		List<String> menuList = new ArrayList<String>();
		menuList.add("POS");
		menuList.add("Product");
		menuList.add("Stores");
		menuList.add("People");
		menuList.add("Sales");
		menuList.add("Expense");
		menuList.add("Categories");
		menuList.add("Setting");
		menuList.add("Reports");
		boolean flag = false;
		for (int m = 0; m < menuList.size(); m++) {
			for (WebElement w : menuHome) {
				if ((menuList.get(m).equalsIgnoreCase(w.getText()))) {
					flag = true;
					break;
				}
			}
			flag = false;
		}
		Assert.assertFalse(flag);
		objHome.logOutFn();
		Log.endTestCase("VerifyHomePageTest--menuElements");

	}

	@Test(priority = 4, groups = { "Smoke" })
	public void validateMenuClick() {
		Log.startTestCase("VerifyHomePageTest--menuElementsClick");
		objLogin.loginFn();
		objHome.btnMenuVisible();
		Log.info("Home Page Menu Click");		
		act.click1(objHome.menuPdt(), "Product Menu");
		Assert.assertTrue(objPdt.tableProduct().isDisplayed());
		objHome.btnMenuVisible();
		act.click1(objHome.menuStore(), "Store Menu");
		Assert.assertTrue(objStore.tableStore().isDisplayed());
		objHome.btnMenuVisible();
		act.click1(objHome.menuPeople(), "People Menu");
		objHome.btnMenuVisible();
		act.click1(objHome.menuWaiter(), "Waiter Menu");
		Assert.assertTrue(objWaiter.tableWaiter().isDisplayed());
		objHome.logOutFn();
		Log.endTestCase("VerifyHomePageTest--menuElementsClick");
	}
}
