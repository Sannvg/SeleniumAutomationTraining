package com.POS.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.Log;

public class VerifyStoreManageTest extends BaseClass {
	
	@Test(priority = 1)
	public void validateAddZone() throws Exception {
		Log.startTestCase("VerifyStoreManageTest-validateAddZone");
		objMngStore.beforefnStoreManage();
		act.click1(objMngStore.btnaddZone(), "Add Zone");
		act.click1(objMngStore.AddZoneName(), "Zone Name");
		ArrayList excelData = data.getData("Zone");
		act.type(objMngStore.AddZoneName(), (String) excelData.get(0));
		Log.info("Entered Zone");
		act.click1(objMngStore.addZoneSubmit(), "Add Zone Submit");
		Assert.assertEquals(objMngStore.lblStoreZone().getText(), "Store Zones");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreManageTest-validateAddZone");
	}

	@Test(priority = 2)
	public void validateEditZone() throws Exception {
		Log.startTestCase("VerifyStoreManageTest-validateEditZone");
		objMngStore.beforefnStoreManage();
		act.click1(objMngStore.btnEditZone(), "Edit Zone");
		ArrayList excelData = data.getData("EZone");
		act.click1(objMngStore.editZoneName(), "Edit Zone Name");
		act.type(objMngStore.editZoneName(), (String) excelData.get(0));
		Log.info("Edited Zone");
		act.click1(objMngStore.editZoneSubmit(), "Edit Zone Submit");
		Assert.assertEquals(objMngStore.lblStoreZone().getText(), "Store Zones");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreManageTest-validateEditZone");
	}

	@Test(priority = 3)
	public void validateAddStoreTable() throws Exception {
		Log.startTestCase("VerifyStoreManageTest-validateAddStoreTable");
		objMngStore.beforefnStoreManage();
		act.click1(objMngStore.btnaddStoreTable(), "Add Store Table");
		ArrayList excelData = data.getData("StoreTable");
		act.click1(objMngStore.txtAddStoreTblNm(), "Store Table Name");
		act.type(objMngStore.txtAddStoreTblNm(), (String) excelData.get(0));
		Log.info("Entered table name");
		act.selectByVisibleText((String) excelData.get(1), objMngStore.drpAddStoreZone());
		Log.info("Selected zone");
		act.click1(objMngStore.btnAddStoreTblSubmit(), "Add Store Table Submit");
		Log.info("Store Table is Added");
		Assert.assertEquals(objMngStore.lblStoreZone().getText(), "Store Zones");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreManageTest-validateAddStoreTable");
	}

	@Test(priority = 4)
	public void validateEditStoreTable() throws Exception {
		Log.startTestCase("VerifyStoreManageTest-validateEditStoreTable");
		objMngStore.beforefnStoreManage();
		ArrayList excelData = data.getData("EStoreTable");
		act.click1(objMngStore.btnStrTblEdit(), "Store Table Edit");
		act.type(objMngStore.txtAddStoreTblNm(),(String) excelData.get(0));
		Log.info("Edit Store Table Name");
		act.click1(objMngStore.btnEditStoreTblSubmit(), "Edit StoreTbl Submit");
		Log.info("Store Table is Edited");
		Assert.assertEquals(objMngStore.lblStoreZone().getText(), "Store Zones");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreManageTest-validateEditStoreTable");
	}

	@Test(priority = 5)
	public void validateDeleteStoreTbl() throws Exception  {
		Log.startTestCase("VerifyStoreManageTest-validateDeleteStoreTbl");
		objMngStore.beforefnStoreManage();
		act.click1(objMngStore.btndltStrTbl(), "Delete Store Table");
		Log.info("Deleted table");
		Assert.assertEquals(objMngStore.lblStoreZone().getText(), "Store Zones");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreManageTest-validateDeleteStoreTbl");
	}

	@Test(priority = 6)
	public void validateDeleteZone() throws Exception  {
		Log.startTestCase("VerifyStoreManageTest-validateDeleteZone");
		objMngStore.beforefnStoreManage();
		act.click1(objMngStore.btndeleteZone(), "Delete Zone");
		act.click1(objMngStore.btndltZoneConfirm(), "Confirm Delete");
		Log.info("Deleted Zone");
		Assert.assertEquals(objMngStore.lblStoreZone().getText(), "Store Zones");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreManageTest-validateDeleteZone");
	}

	@Test(priority = 7)
	public void validateDeleteStore() throws Exception {
		Log.startTestCase("VerifyStoreTest--validateDeleteStore");
		objLogin.loginFn();
		act.click1(objHome.menuStore(), "Store Menu");
		ArrayList excelData = data.getData("EStore");
		act.type(objStore.txtSearchStore(), (String) excelData.get(0));
		act.click1(objStore.btndeleteStore(), "Delete Store");
		act.click1(objStore.txtSearchStore(), "Search Store");
		act.type(objStore.txtSearchStore(), (String) excelData.get(0));
		Assert.assertEquals(objStore.noRecords().getText(), "No matching records found");
		objHome.logOutFn();
		Log.endTestCase("VerifyStoreTest--validateDeleteStore");
	}

}
