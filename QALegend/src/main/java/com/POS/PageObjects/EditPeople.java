package com.POS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POS.BaseClass.BaseClass;

public class EditPeople extends BaseClass {
	// Waiter
	@FindBy(css = "input[id='WaiterName']")
	private WebElement txtEditWNm;
	@FindBy(css = "input[id='WaiterPhone']")
	private WebElement txtEditWPhn;
	@FindBy(css = "input[id='WaiterEmail']")
	private WebElement txtEditWEm;
	@FindBy(css = "select[id='WaiterStore']")
	private WebElement drpEditWStore;
	@FindBy(css = "button[class='btn btn-add']")
	private WebElement btnEditWSubmit;
	@FindBy(xpath = ".fa.fa-arrow-left")
	private WebElement btnEditWBk;

	public EditPeople() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement txtEditWNm() {
		return txtEditWNm;
	}

	public WebElement txtEditWPhn() {
		return txtEditWPhn;
	}

	public WebElement txtEditWEm() {
		return txtEditWEm;
	}

	public WebElement drpEditWStore() {
		return drpEditWStore;
	}

	public WebElement btnEditWSubmit() {
		return btnEditWSubmit;
	}

	public WebElement btnEditWBk() {
		return btnEditWBk;
	}

}
