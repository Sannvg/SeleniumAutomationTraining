package com.POS.PageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class Product extends BaseClass {
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/products']")
	private WebElement menuPdt;
	@FindBy(css = "select[name='Table_length']")
	private WebElement drpShowProduct;
	@FindBy(css = "#Table_info")
	private WebElement lbltblrows;
	@FindBy(css = "select[name='filtersupp']")
	private WebElement drpFilterSupplier;
	@FindBy(css = "Select[name='filtertype']")
	private WebElement drpFilterPdtType;
	@FindBy(xpath = "//button[text()='Apply Filter']")
	private WebElement btnApplyFilter;
	@FindBy(css = "input[type='search']")
	private WebElement txtSearchPdt;
	@FindBy(css = "table[id='Table']")
	private List<WebElement> lsttblPdts;
	@FindBy(css = "table[id='Table']")
	private WebElement tblProduct;
	@FindBy(xpath = "//button[@data-target='#Addproduct']")
	private WebElement btnAddPdt;
	@FindBy(linkText = "Download CSV")
	private WebElement lnkDownload;
	@FindBy(css = "a[data-target='#ImportProducts']")
	private WebElement lnkUpload;
	@FindBy(css = "a[data-target='#PrintMenu']")
	private WebElement lnkPrintMenu;
	@FindBy(className = "pagination")
	private WebElement tblPaginationPdt;

	// Upload File Window
	@FindBy(xpath = "(//input[@id='ImageInput'])[2]")
	private WebElement btnUploadfile;
	@FindBy(linkText = "Download Sample")
	private WebElement linkDownload;
	@FindBy(xpath = "(//button[@data-dismiss='modal' and text()='Close'])[2]")
	private WebElement btnUFClose;
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement btnUFSubmit;

	// Print Menu
	@FindBy(xpath = "//button[@onclick='PrintTicket()']/preceding-sibling::button")
	private WebElement btnPrintMenuClose;
	@FindBy(xpath = "//button[@onclick='PrintTicket()']")
	private WebElement btnPrintMenu;

	public Product() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement menuPdt() {
		return menuPdt;
	}

	public WebElement drpShowProduct() {
		return drpShowProduct;
	}

	public WebElement lblTblRowdtl() {
		return lbltblrows;
	}

	public WebElement drpFilterSupplier() {
		return drpFilterSupplier;
	}

	public WebElement drpFilterPdtType() {
		return drpFilterPdtType;
	}

	public WebElement btnApplyFilter() {
		return btnApplyFilter;
	}

	public WebElement txtSearchPdt() {
		return txtSearchPdt;
	}

	public List<WebElement> lsttableProducts() {
		return lsttblPdts;
	}

	public WebElement tableProduct() {
		return tblProduct;
	}

	public WebElement btnAddPdt() {
		return btnAddPdt;
	}

	public WebElement lnkDownload() {
		return lnkDownload;
	}

	public WebElement lnkUpload() {
		return lnkUpload;
	}

	public WebElement lnkPrintMenu() {
		return lnkPrintMenu;
	}

	public WebElement tblPaginationPdt() {
		return tblPaginationPdt;
	}

	public WebElement btnUploadfile() {
		return btnUploadfile;
	}

	public WebElement linkDownload() {
		return linkDownload;
	}

	public WebElement btnUFClose() {
		return btnUFClose;
	}

	public WebElement btnUFSubmit() {
		return btnUFSubmit;
	}

	public WebElement btnPrintMenuClose() {
		return btnPrintMenuClose;
	}

	public WebElement btnPrintMenu() {
		return btnPrintMenu;
	}
	
	public void beforefnPdt() {
		objLogin.loginFn();
		objHome.btnMenuVisible();
		act.click1(objHome.btnMenu(), "Menu");
		act.click1(objHome.menuPdt(), "Product Menu");
	}

}
