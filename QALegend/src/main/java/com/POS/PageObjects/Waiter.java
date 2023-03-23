package com.POS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class Waiter extends BaseClass {
	@FindBy(css = "select[name='Table_length']")
	private WebElement drpShowWaiter;
	@FindBy(css = "input[type='search']")
	private WebElement txtSearchWaiter;
	@FindBy(css = "table[id='Table']")
	private WebElement tblWaiter;
	@FindBy(xpath = "//button[@data-target='#AddWaiter']")
	private WebElement btnAddWaiter;
	@FindBy(className = "pagination")
	private WebElement tblPaginationWaiter;
	@FindBy(xpath = "(//a[@data-toggle='popover'])[1]")
	private WebElement deleteWaiter;
	@FindBy(xpath = "//div[@class='popover fade left in']//div//a")
	private WebElement btnDltConfirm;
	@FindBy(xpath = "(//a[@data-original-title='Edit'])[1]")
	private WebElement btneditWaiter;
	// Add Waiter
	@FindBy(id = "WaiterName")
	private WebElement txtWaiterName;
	@FindBy(id = "WaiterPhone")
	private WebElement txtWaiterPhone;
	@FindBy(id = "WaiterEmail")
	private WebElement txtWaiterEmail;
	@FindBy(id = "WaiterStore")
	private WebElement drpWaiterStore;
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement btnCloseAddWaiter;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement btnSubmitAddWaiter;

	public Waiter() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement drpShowWaiter() {
		return drpShowWaiter;
	}

	public WebElement txtSearchWaiter() {
		return txtSearchWaiter;
	}

	public WebElement tableWaiter() {
		return tblWaiter;
	}

	public WebElement btnAddWaiter() {
		return btnAddWaiter;
	}

	public WebElement pageIndexWaiter() {
		return tblPaginationWaiter;
	}

	public WebElement deleteWaiter() {
		return deleteWaiter;
	}

	public WebElement btnDltConfirm() {
		return btnDltConfirm;
	}

	public WebElement btneditWaiter() {
		return btneditWaiter;
	}

	public WebElement txtWaiterName() {
		return txtWaiterName;
	}

	public WebElement txtWaiterPhone() {
		return txtWaiterPhone;
	}

	public WebElement txtWaiterEmail() {
		return txtWaiterEmail;
	}

	public WebElement drpWaiterStore() {
		return drpWaiterStore;
	}

	public WebElement btnCloseAddWaiter() {
		return btnCloseAddWaiter;
	}

	public WebElement btnSubmitAddWaiter() {
		return btnSubmitAddWaiter;
	}

	public void beforefnWaiter() {
		objLogin.loginFn();
		objHome.btnMenuVisible();
		act.click1(objHome.menuPeople(), "People Menu");
		act.click1(objHome.menuWaiter(), "Waiter Menu");
	}
}
