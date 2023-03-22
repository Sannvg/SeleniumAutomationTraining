package com.POS.PageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class Store extends BaseClass {
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/stores']")
	private WebElement menuStore;
	@FindBy(css = "select[name='Table_length']")
	private WebElement drpShowStore;
	@FindBy(css = "input[type='search']")
	private WebElement txtSearchStore;
	@FindBy(css = "table[id='Table']")
	private WebElement tblStores;
	@FindBy(css = "table[id='Table']")
	private List<WebElement> listtblStores;
	@FindBy(xpath = "//table[@id='Table']//th")
	private List<WebElement> tblStoreHeaders;
	@FindBy(xpath = "//button[@data-target='#AddStore']")
	private WebElement btnAddStore;
	@FindBy(xpath = "//ul[@class='pagination']//li")
	private List<WebElement> tblPaginationStore;
	@FindBy(css = "#Table_info")
	private WebElement lblTblInfo;
	@FindBy(xpath = "//li[@class='paginate_button active']//a")
	private WebElement pageActive;
	@FindBy(xpath = "(//a[@data-original-title='Delete'])[1]")
	private WebElement btndeleteStore;
	@FindBy(xpath = "(//a[@data-original-title='Edit'])[1]")
	private WebElement btneditStore;
	@FindBy(xpath = "(//a[@data-original-title='manage Tables'])[1]")
	private WebElement btnmanageStore;
	@FindBy(xpath = "//th[@aria-sort='ascending']")
	private WebElement btnAscSort;
	@FindBy(xpath = "//th[@aria-sort='descending']")
	private WebElement btnDescSort;
	@FindBy(xpath = "//td[@class='sorting_1']")
	private WebElement firstelement;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement noRecords;
	// Add Store
	@FindBy(id = "StoreName")
	private WebElement txtStoreName;
	@FindBy(id = "email")
	private WebElement txtStoreEmail;
	@FindBy(id = "StorePhone")
	private WebElement txtStorePhone;
	@FindBy(id = "Country")
	private WebElement txtStoreCountry;
	@FindBy(id = "City")
	private WebElement txtStoreCity;
	@FindBy(id = "Adresse")
	private WebElement txtStoreAdresse;
	@FindBy(id = "CustomeFooter")
	private WebElement txtStoreCustFooter;
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement btnCloseAddStore;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement btnSubmitAddStore;

	public Store() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement menuStore() {
		return menuStore;
	}

	public WebElement drpShowStore() {
		return drpShowStore;
	}

	public WebElement txtSearchStore() {
		return txtSearchStore;
	}

	public WebElement tableStore() {
		return tblStores;
	}

	public List<WebElement> listtblStores() {
		return listtblStores;
	}

	public List<WebElement> tblStoreHeaders() {
		return tblStoreHeaders;
	}

	public WebElement btnAddStore() {
		return btnAddStore;
	}

	public List<WebElement> tblPaginationStore() {
		return tblPaginationStore;
	}

	public WebElement lblTblPages() {
		return lblTblInfo;
	}

	public WebElement pageActive() {
		return pageActive;
	}

	// ----
	public WebElement btndeleteStore() {
		return btndeleteStore;
	}

	public WebElement btneditStore() {
		return btneditStore;
	}

	public WebElement btnmanageStore() {
		return btnmanageStore;
	}

	public WebElement btnAscSort() {
		return btnAscSort;
	}

	public WebElement btnDescSort() {
		return btnDescSort;
	}

	public WebElement firstElement() {
		return firstelement;
	}

	public WebElement noRecords() {
		return noRecords;
	}

//Add Store
	public WebElement storeName() {
		return txtStoreName;
	}

	public WebElement storeEmail() {
		return txtStoreEmail;
	}

	public WebElement storePhone() {
		return txtStorePhone;
	}

	public WebElement storeCountry() {
		return txtStoreCountry;
	}

	public WebElement storeCity() {
		return txtStoreCity;
	}

	public WebElement storeAddress() {
		return txtStoreAdresse;
	}

	public WebElement storeCustFooter() {
		return txtStoreCustFooter;
	}

	public WebElement storeAddClose() {
		return btnCloseAddStore;
	}

	public WebElement storeAddSubmit() {
		return btnSubmitAddStore;
	}
}
