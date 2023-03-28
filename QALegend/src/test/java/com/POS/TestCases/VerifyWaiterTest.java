package com.POS.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.ExcelRead;
import com.POS.Utilities.Log;

public class VerifyWaiterTest extends BaseClass {
	@Test(priority = 1)
	public void validateShowCount() {
		Log.startTestCase("VerifyWaiterTest--validateShowCount");
		objWaiter.beforefnWaiter();
		act.selectByVisibleText("50", objWaiter.drpShowWaiter());
		Log.info("Selected show count");
		int rwcount = act.getRowCount(objWaiter.tableWaiter());
		Assert.assertEquals(rwcount, 50);
		objHome.logOutFn();
		Log.endTestCase("VerifyWaiterTest--validateShowCount");
	}

	@Test(priority = 2)
	public void validateAddWaiter() throws Exception {
		Log.startTestCase("VerifyWaiterTest--validateAddWaiter");
		objWaiter.beforefnWaiter();
		act.click1(objWaiter.btnAddWaiter(), "Add Waiter");
		ArrayList excelData = data.getData("Waiter");
		act.type(objWaiter.txtWaiterName(), (String) excelData.get(0));
		act.type(objWaiter.txtWaiterPhone(), (String) excelData.get(1));
		act.type(objWaiter.txtWaiterEmail(), (String) excelData.get(2));
		act.type(objWaiter.drpWaiterStore(), (String) excelData.get(3));
		act.click1(objWaiter.btnSubmitAddWaiter(), "Add Waiter Submit");
		Assert.assertTrue(objWaiter.btnAddWaiter().isDisplayed(), "Waiter is Added");
		objHome.logOutFn();
		Log.endTestCase("VerifyWaiterTest--validateAddWaiter");
	}

	@Test(priority = 3)
	public void validateSearchWaiter() {
		Log.startTestCase("VerifyWaiterTest--validateSearchWaiter");
		objWaiter.beforefnWaiter();
		Assert.assertTrue(objWaiter.btnAddWaiter().isDisplayed());
		act.type(objWaiter.txtSearchWaiter(), "OBS");
		Log.info("Search waiter entered");
		int tblRowCnt = act.getRowCount(objWaiter.tableWaiter());
		Assert.assertTrue(tblRowCnt > 0, "Searched Waiter is displayed");
		objHome.logOutFn();
		Log.endTestCase("VerifyWaiterTest--validateSearchWaiter");
	}

	@Test(priority = 4)
	public void validateEditWaiter()  throws Exception  {
		Log.startTestCase("VerifyWaiterTest--validateEditWaiter");
		objWaiter.beforefnWaiter();
		act.type(objWaiter.txtSearchWaiter(), "OBS");
		act.click1(objWaiter.btneditWaiter(), "Edit Waiter");
		ArrayList excelData = data.getData("EWaiter");
		act.type(objEditPeople.txtEditWNm(), (String) excelData.get(0));
		act.type(objEditPeople.txtEditWPhn(), (String) excelData.get(1));
		act.type(objEditPeople.txtEditWEm(), (String) excelData.get(2));
		act.click1(objEditPeople.btnEditWSubmit(), "Edit Waiter Submit");
		act.click1(objWaiter.txtSearchWaiter(), "Search Waiter");
		act.type(objWaiter.txtSearchWaiter(), (String) excelData.get(0));		
		int tblRowCnt = act.getRowCount(objWaiter.tableWaiter());
		Assert.assertTrue(tblRowCnt > 0, "Waiter is edited");
		objHome.logOutFn();
		Log.endTestCase("VerifyWaiterTest--validateEditWaiter");
	}

}

