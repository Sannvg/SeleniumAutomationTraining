package com.POS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POS.BaseClass.BaseClass;

public class Settings extends BaseClass {
	@FindBy(xpath = "//a[@href='#users']")
	private WebElement btnUsers;
	@FindBy(css = "button[data-target='#AddUser']")
	private WebElement btnAddUser;
	@FindBy(id = "username")
	private WebElement txtUserName;
	@FindBy(id = "firstname")
	private WebElement txtFirstNm;
	@FindBy(id = "lastname")
	private WebElement txtLastNm;
	@FindBy(css = "input[value='admin']")
	private WebElement rbtnAdmin;
	@FindBy(css = "input[value='sales']")
	private WebElement rbtnSales;
	@FindBy(css = "input[value='waiter']")
	private WebElement rbtnWaiter;
	@FindBy(css = "input[value='kitchen']")
	private WebElement rbtnKitchen;
	@FindBy(id = "email")
	private WebElement txtEmail;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "confirm_password")
	private WebElement txtCPassword;
	@FindBy(id = "Avatar")
	private WebElement btnInputFile;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement btnSubmit;
	@FindBy(xpath = "(//button[text()='Close'])[1]")
	private WebElement btnClose;

	public Settings() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement btnUsers() {
		return btnUsers;
	}

	public WebElement btnAddUser() {
		return btnAddUser;
	}

	public WebElement txtUserName() {
		return txtUserName;
	}

	public WebElement txtFirstNm() {
		return txtFirstNm;
	}

	public WebElement txtLastNm() {
		return txtLastNm;
	}

	public WebElement rbtnAdmin() {
		return rbtnAdmin;
	}

	public WebElement rbtnSales() {
		return rbtnSales;
	}

	public WebElement rbtnWaiter() {
		return rbtnWaiter;
	}

	public WebElement txtEmail() {
		return txtEmail;
	}

	public WebElement txtPassword() {
		return txtPassword;
	}

	public WebElement txtCPassword() {
		return txtCPassword;
	}

	public WebElement btnInputFile() {
		return btnInputFile;
	}

	public WebElement btnSubmit() {
		return btnSubmit;
	}

	public WebElement btnClose() {
		return btnClose;
	}

}
