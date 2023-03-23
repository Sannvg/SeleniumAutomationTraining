package com.POS.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POS.BaseClass.BaseClass;

public class Category extends BaseClass {
	@FindBy(css = "select[name='Table_length']")
	private WebElement drpShowCategory;
	@FindBy(css = "input[type='search']")
	private WebElement txtSearchCategory;
	@FindBy(css = "table[id='Table']")
	private WebElement tblCategory;
	@FindBy(css = "table[id='Table']")
	private List<WebElement> listtblCategory;
	@FindBy(xpath = "//table[@id='Table']//th")
	private List<WebElement> tblCatHeaders;
	@FindBy(xpath = "//button[@data-target='#Addcategory']")
	private WebElement btnAddCat;
	@FindBy(xpath = "//ul[@class='pagination']//li")
	private List<WebElement> tblPaginationCat;
	@FindBy(css = "#Table_info")
	private WebElement lblTblInfo;
	@FindBy(xpath = "//li[@class='paginate_button active']//a")
	private WebElement pageActive;
	@FindBy(xpath = "(//a[@data-original-title='Delete'])[1]")
	private WebElement deleteCat;
	@FindBy(xpath = "(//a[@data-original-title='Edit'])[1]")
	private WebElement editCat;
	@FindBy(xpath = "//th[@aria-sort='ascending']")
	private WebElement btnascendingCat;
	@FindBy(xpath = "//th[@aria-sort='descending']")
	private WebElement btndescendingCat;
	@FindBy(xpath = "//td[@class='sorting_1']")
	private WebElement firstelement;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement noRecords;
	// Add Category
	@FindBy(id = "CategoryName")
	private WebElement txtCatName;
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement btnCloseAddCat;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement btnSubmitAddCat;

	public Category() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement drpShowCategory() {
		return drpShowCategory;
	}

	public WebElement txtSearchCategory() {
		return txtSearchCategory;
	}

	public WebElement tblCategory() {
		objWait.fluentWait(getDriver(), tblCategory, 5);
		return tblCategory;
	}

	public List<WebElement> listtblCategory() {
		return listtblCategory;
	}

	public List<WebElement> tblCatHeaders() {
		return tblCatHeaders;
	}

	public WebElement btnascendingCat() {
		return btnascendingCat;
	}

	public WebElement btndescendingCat() {
		return btndescendingCat;
	}

	public WebElement btnAddCat() {
		return btnAddCat;
	}

	public List<WebElement> pageIndexCat() {
		return tblPaginationCat;
	}

	public WebElement lblTblPages() {
		return lblTblInfo;
	}

	public WebElement pageActive() {
		return pageActive;
	}

	public WebElement deleteCat() {
		return deleteCat;
	}

	public WebElement editCat() {
		return editCat;
	}

	public WebElement txtCatName() {
		return txtCatName;
	}

	public WebElement btnCloseAddCat() {
		return btnCloseAddCat;
	}

	public WebElement btnSubmitAddCat() {
		return btnSubmitAddCat;
	}
	
	public void beforeCatfn() {
		objHome.btnMenuVisible();		
		act.click1(objHome.menuCategory(), "Category Menu");
		act.click1(objHome.menuCatPdt(), "Category Pdt");
	}

}
