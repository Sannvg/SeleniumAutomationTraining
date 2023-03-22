package com.POS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class AddProduct extends BaseClass {
	@FindBy(id = "Type")
	private WebElement drpPdtType;
	@FindBy(id = "ProductCode")
	private WebElement txtPdtCode;
	@FindBy(id = "ProductName")
	private WebElement txtPdtName;
	@FindBy(id = "Category")
	private WebElement drpCategory;
	@FindBy(id = "Supplier")
	private WebElement drpSupplier;
	@FindBy(id = "PurchasePrice")
	private WebElement drpPurchasePrice;
	@FindBy(id = "Tax")
	private WebElement txtTax;
	@FindBy(id = "taxType")
	private WebElement drpTaxType;
	@FindBy(id = "Price")
	private WebElement drpPrice;
	@FindBy(id = "Unit")
	private WebElement txtUnit;
	@FindBy(id = "AlertQt")
	private WebElement drpAlertQT;
	@FindBy(id = "ProductOptions")
	private WebElement txtPdtOptions;
	@FindBy(id = "ImageInput")
	private WebElement btnPdtImg;
	@FindBy(css = ".note-editable.panel-body")
	private WebElement txtPdtDesc;
	// Product Description
	@FindBy(css = "button[data-original-title='Bold (CTRL+B)']")
	private WebElement btnPdtDescBold;
	@FindBy(css = "button[data-original-title='Italic (CTRL+I)']")
	private WebElement btnPdtDescItalic;
	@FindBy(css = "button[data-original-title='Underline (CTRL+U)']")
	private WebElement btnPdtDescUnderline;
	@FindBy(css = "button[data-original-title='Remove Font Style (CTRL+\\)']")
	private WebElement btnPdtDescRemoveFS;
	@FindBy(css = "button[data-original-title='Font Size']")
	private WebElement btnPdtDescFontS;
	@FindBy(css = "button[data-original-title='Recent Color']")
	private WebElement btnPdtDescRClr;
	@FindBy(css = "button[data-original-title='More Color']")
	private WebElement btnPdtDescMClr;
	@FindBy(css = "button[data-original-title='Unordered list (CTRL+SHIFT+NUM7)']")
	private WebElement btnPdtDescUL;
	@FindBy(css = "button[data-original-title='Ordered list (CTRL+SHIFT+NUM8)']")
	private WebElement btnPdtDescOL;
	@FindBy(css = "button[data-original-title='Paragraph']")
	private WebElement btnPdtDescPara;
	@FindBy(css = "button[data-original-title='Line Height']")
	private WebElement btnPdtDescLH;
	// Display Color
	@FindBy(id = "option1")
	private WebElement rbtnClr1;
	@FindBy(id = "option2")
	private WebElement rbtnClr2;
	@FindBy(id = "option3")
	private WebElement rbtnClr3;
	@FindBy(id = "option4")
	private WebElement rbtnClr4;
	@FindBy(id = "option5")
	private WebElement rbtnClr5;
	@FindBy(id = "option6")
	private WebElement rbtnClr6;
	@FindBy(id = "option7")
	private WebElement rbtnClr7;
	@FindBy(id = "option8")
	private WebElement rbtnClr8;

	@FindBy(xpath = "(//button[@data-dismiss='modal' and text()='Close'])[2]")
	private WebElement btnPdtClose;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement btnPdtSubmit;

	public AddProduct() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement drpPdtType() {
		return drpPdtType;
	}

	public WebElement txtPdtCode() {
		return txtPdtCode;
	}

	public WebElement txtPdtName() {
		return txtPdtName;
	}

	public WebElement drpCategory() {
		return drpCategory;
	}

	public WebElement drpSupplier() {
		return drpSupplier;
	}

	public WebElement drpPurchasePrice() {
		return drpPurchasePrice;
	}

	public WebElement txtTax() {
		return txtTax;
	}

	public WebElement drpTaxType() {
		return drpTaxType;
	}

	public WebElement drpPrice() {
		return drpPrice;
	}

	public WebElement txtUnit() {
		return txtUnit;
	}

	public WebElement drpAlertQT() {
		return drpAlertQT;
	}

	public WebElement txtPdtOptions() {
		return txtPdtOptions;
	}

	public WebElement pdtImageInput() {
		return btnPdtImg;
	}

	public WebElement txtPdtDesc() {
		return txtPdtDesc;
	}

	public WebElement btnPdtDescBold() {
		return btnPdtDescBold;
	}

	public WebElement btnPdtDescItalic() {
		return btnPdtDescItalic;
	}

	public WebElement btnPdtDescUnderline() {
		return btnPdtDescUnderline;
	}

	public WebElement btnPdtDescRemoveFS() {
		return btnPdtDescRemoveFS;
	}

	public WebElement btnPdtDescFontS() {
		return btnPdtDescFontS;
	}

	public WebElement btnPdtDescRClr() {
		return btnPdtDescRClr;
	}

	public WebElement btnPdtDescMClr() {
		return btnPdtDescMClr;
	}

	public WebElement btnPdtDescUL() {
		return btnPdtDescUL;
	}

	public WebElement btnPdtDescOL() {
		return btnPdtDescOL;
	}

	public WebElement btnPdtDescPara() {
		return btnPdtDescPara;
	}

	public WebElement btnPdtDescLH() {
		return btnPdtDescLH;
	}

	public WebElement rbtnClr1() {
		return rbtnClr1;
	}

	public WebElement rbtnClr2() {
		return rbtnClr2;
	}

	public WebElement rbtnClr3() {
		return rbtnClr3;
	}

	public WebElement rbtnClr4() {
		return rbtnClr4;
	}

	public WebElement rbtnClr5() {
		return rbtnClr5;
	}

	public WebElement rbtnClr6() {
		return rbtnClr6;
	}

	public WebElement rbtnClr7() {
		return rbtnClr7;
	}

	public WebElement rbtnClr8() {
		return rbtnClr8;
	}

	public WebElement btnPdtClose() {
		return btnPdtClose;
	}

	public WebElement btnPdtSubmit() {
		return btnPdtSubmit;
	}

}
