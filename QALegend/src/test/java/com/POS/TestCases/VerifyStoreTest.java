package com.POS.TestCases;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.ExcelRead;
import com.POS.Utilities.Log;

public class VerifyStoreTest extends BaseClass {

	@Test(priority = 1)
	public void validateShowCount() {
		Log.startTestCase("VerifyStoreTest--validateShowCount");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		act.selectByVisibleText("50", objStore.drpShowStore());
		int rwcount = act.getRowCount(objStore.tableStore());
		SoftAssert sasst = new SoftAssert();
		sasst.assertEquals(rwcount, 50);
		sasst.assertAll();
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateShowCount");
	}

	@Test(priority = 0, groups = { "Smoke" })
	public void validateTableHeaders() {
		Log.startTestCase("VerifyStoreTest--validateTableHeaders");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		List<WebElement> storetblHdrs = objStore.tblStoreHeaders();
		List<String> storeList = new ArrayList<String>();
		boolean flag = false;
		storeList.add("Store Name");
		storeList.add("Email");
		storeList.add("Store Phone");
		storeList.add("Country");
		storeList.add("City");
		storeList.add("Action");
		for (int m = 0; m < storeList.size(); m++) {
			for (WebElement hdr : storetblHdrs) {
				if ((storeList.get(m).equalsIgnoreCase(hdr.getText()))) {
					flag = true;
					break;
				}
			}
			flag = false;
		}
		SoftAssert sasst = new SoftAssert();
		sasst.assertFalse(flag);
		sasst.assertAll();
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateTableHeaders");
	}

	@Test(priority = 2)
	public void validateAddStore() throws Exception {
		Log.startTestCase("VerifyStoreTest--validateAddStore");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		act.click1(objStore.btnAddStore(), "Add Store");
		ArrayList excelData = data.getData("Store");
		act.type(objStore.storeName(), (String) excelData.get(0));
		act.type(objStore.storeEmail(), (String) excelData.get(1));
		act.type(objStore.storePhone(), (String) excelData.get(2));
		act.type(objStore.storeCountry(), (String) excelData.get(3));
		act.type(objStore.storeCity(), (String) excelData.get(4));
		act.type(objStore.storeAddress(), (String) excelData.get(5));
		act.type(objStore.storeCustFooter(), (String) excelData.get(6));
		act.click1(objStore.storeAddSubmit(), "Add Store Submit");
		Log.info("Add Store Details entered");
		act.fluentWait(getDriver(), objStore.txtSearchStore(), 5);
		act.click1(objStore.txtSearchStore(), "Search Added Product");
		act.type(objStore.txtSearchStore(), (String) excelData.get(0));
		int tblRowCnt = act.getRowCount(objStore.tableStore());
		Assert.assertTrue(tblRowCnt > 0, "Store Added");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateAddStore");
	}

	@Test(priority = 3)
	public void validateSearchStore() {
		Log.startTestCase("VerifyStoreTest--validateSearchStore");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		act.click1(objStore.txtSearchStore(), "Search Store");
		Log.info("Search Store Details entered");
		act.type(objStore.txtSearchStore(), "Test OBS Store");
		act.fluentWait(getDriver(), objStore.tableStore(), 5);
		int tblRowCnt = act.getRowCount(objStore.tableStore());
		Assert.assertTrue(tblRowCnt > 0, "Search Store is displayed");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateSearchStore");
	}

	@Test(priority = 4)
	public void validateEditStore() throws Exception {
		Log.startTestCase("VerifyStoreTest--validateEditStore");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		act.click1(objStore.txtSearchStore(), "Search Store");
		act.type(objStore.txtSearchStore(), "Test OBS Store");	
		Log.info("Clicked on Edit Store");
		act.click1(objStore.btneditStore(), "Edit Store");
		ArrayList excelData = data.getData("EStore");
		act.type(objStore.storeName(), (String) excelData.get(0));
		act.type(objStore.storePhone(), (String) excelData.get(1));
		Log.info("Edit Store Details entered");
		act.click1(objStore.storeAddSubmit(), "Edit Store Submit");		
		act.click1(objStore.txtSearchStore(), "Search Store");
		act.type(objStore.txtSearchStore(),(String) excelData.get(0));
		Assert.assertTrue(objStore.firstElement().isDisplayed(), "Store is Updated");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateEditStore");
	}

	@Test(priority = 5)
	public void validateStoreSorting() {
		Log.startTestCase("VerifyStoreTest--validateStoreSorting");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		String strFirstNm = objStore.firstElement().getText();
		act.click1(objStore.btnAscSort(), "Ascending Sorting");
		String strFirstNmasc = objStore.firstElement().getText();
		Log.info("Ascending Sort Done");
		SoftAssert sassrt = new SoftAssert();
		sassrt.assertNotEquals(strFirstNm, strFirstNmasc);
		sassrt.assertAll();
		act.click1(objStore.btnDescSort(), "Descending Sorting");
		Log.info("Descending Sort Done");
		String strFirstNmdsc = objStore.firstElement().getText();
		sassrt.assertEquals(strFirstNm, strFirstNmdsc);
		sassrt.assertAll();
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateStoreSorting");
	}
}

