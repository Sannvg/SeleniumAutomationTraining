package com.POS.PageObjects;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class StoreManage extends BaseClass {
	@FindBy(css = ".fa.fa-plus")
	private WebElement btnAddZone;
	@FindBy(id = "ZonesName")
	private WebElement txtaddZoneName;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement btnaddZoneSubmit;
	@FindBy(xpath = "(//button[text()='Close'])[2]")
	private WebElement btnaddZoneClose;
	@FindBy(css = ".fa.fa-pencil.editzone")
	private WebElement btnEditZone;
	@FindBy(css = "#ZoneName")
	private WebElement txtEditZoneName;
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement btnEditZoneSubmit;
	@FindBy(xpath = "(//button[text()='Close'])[3]")
	private WebElement btnEditZoneClose;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement editStoreTblSubmit;
	@FindBy(xpath = "(//i[@class='fa fa-times deletezone'])[1]")
	private WebElement btndeleteZone;
	@FindBy(xpath = "//button[@class='confirm']")
	private WebElement btndltZoneConfirm;
	@FindBy(xpath = "//button[@data-target='#Addtable']")
	private WebElement btnaddStoreTable;
	@FindBy(css = "table[class='table table-striped table-bordered']")
	private WebElement tblStore;
	@FindBy(xpath = "//input[@id='TableName']")
	private WebElement txtAddStoreTblNm;
	@FindBy(xpath = "//select[@id='Zones']")
	private WebElement drpAddStoreZone;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement btnAddStoreTblSubmit;
	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btnAddStoreTblClose;
	@FindBy(xpath = "//h2[text()='Store Zones']")
	private WebElement lblStoreZone;
	@FindBy(xpath = "(//a[@data-original-title='Delete'])[1]")
	private WebElement btndltStrTbl;
	@FindBy(xpath = "(//a[@data-original-title='Edit'])[1]")
	private WebElement btnStrTblEdit;

	public StoreManage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement btnaddZone() {
		return btnAddZone;
	}

	public WebElement AddZoneName() {
		return txtaddZoneName;
	}

	public WebElement addZoneSubmit() {
		return btnaddZoneSubmit;
	}

	public WebElement addZoneClose() {
		return btnaddZoneClose;
	}

	public WebElement btnEditZone() {
		return btnEditZone;
	}

	public WebElement editZoneName() {
		return txtEditZoneName;
	}

	public WebElement editZoneSubmit() {
		return btnEditZoneSubmit;
	}

	public WebElement editZoneClose() {
		return btnEditZoneClose;
	}

	public WebElement btndeleteZone() {
		return btndeleteZone;
	}

	public WebElement btndltZoneConfirm() {
		return btndltZoneConfirm;
	}

	public WebElement btnaddStoreTable() {
		return btnaddStoreTable;
	}

	public WebElement tblStore() {
		return tblStore;
	}

	public WebElement txtAddStoreTblNm() {
		return txtAddStoreTblNm;
	}

	public WebElement drpAddStoreZone() {
		return drpAddStoreZone;
	}

	public WebElement btnAddStoreTblSubmit() {
		return btnAddStoreTblSubmit;
	}

	public WebElement btnAddStoreTblClose() {
		return btnAddStoreTblClose;
	}

	public WebElement lblStoreZone() {
		return lblStoreZone;
	}

	public WebElement btndltStrTbl() {
		return btndltStrTbl;
	}

	public WebElement btnStrTblEdit() {
		return btnStrTblEdit;
	}

	public WebElement btnEditStoreTblSubmit() {
		return editStoreTblSubmit;
	}

	public void beforefn() throws Exception {
		objLogin.loginFn();
		act.click1(objStore.menuStore(), "Store Menu");
		act.click1(objStore.txtSearchStore(), "Search Store");
		ArrayList excelData = data.getData("EStore");
		act.type(objStore.txtSearchStore(), (String) excelData.get(0));
		act.explicitWait(getDriver(), objStore.btnmanageStore(), Duration.ofSeconds(10));
		act.click1(objStore.btnmanageStore(), "Manage Store ");
	}
}
