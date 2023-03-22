package com.POS.PageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(css = "img[alt='logo']")
	private WebElement imgLogo;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']")
	private List<WebElement> listMenu;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/products']")
	private WebElement menuPdt;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/stores']")
	private WebElement menuStore;
	@FindBy(xpath = "//i[@class='fa fa-users']")
	private WebElement menuPeople;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/waiters']")
	private WebElement menuWaiter;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/suppliers']")
	private WebElement menuSupplier;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/customers']")
	private WebElement menuCustomer;
	@FindBy(xpath = "//i[@class='fa fa-bookmark']//following-sibling::span[1]")
	private WebElement menuCategory;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/categories']")
	private WebElement menuCatPdt;
	@FindBy(xpath = "//a[@href='https://qalegend.com/restaurant/settings?tab=setting']")
	private WebElement menuSettings;
	@FindBy(css = ".img-circle.topbar-userpic.hidden-xs")
	private WebElement imgLogin;
	@FindBy(xpath = "//span[@class='hidden-xs'][1]")
	private WebElement lblLogin;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li")
	private List<WebElement> lstlanguage;
	@FindBy(xpath = "(//span[@class='caret'])[3]")
	private WebElement drplanguage;
	@FindBy(xpath = "//a[@title='Logout']//i")
	private WebElement btnLogout;
	@FindBy(css = ".text-center.choose_store")
	private WebElement lblStore;
	@FindBy(xpath = "//ul[@id='storeline']")
	private WebElement listStore;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement logoImage() {
		return imgLogo;
	}

	public List<WebElement> menuList() {
		return listMenu;
	}

	public WebElement menuPdt() {
		return menuPdt;
	}

	public WebElement menuStore() {
		return menuStore;
	}

	public WebElement menuPeople() {
		return menuPeople;
	}

	public WebElement menuWaiter() {
		return menuWaiter;
	}

	public WebElement menuCustomer() {
		return menuCustomer;
	}

	public WebElement menuCategory() {
		return menuCategory;
	}

	public WebElement menuCatPdt() {
		return menuCatPdt;
	}

	public WebElement menuSettings() {
		return menuSettings;
	}

	public WebElement menuSupplier() {
		return menuSupplier;
	}

	public WebElement loginImage() {
		return imgLogin;
	}

	public WebElement loginLabel() {
		return lblLogin;
	}

	public List<WebElement> lstlanguage() {
		return lstlanguage;
	}

	public WebElement languageSelected() {
		return drplanguage;
	}

	public WebElement logout() {
		return btnLogout;
	}

	public WebElement storeMenu() {
		return lblStore;
	}

	public WebElement storeList() {
		return listStore;
	}

	public void languageSelection(String language) {
		List<WebElement> languagelist = lstlanguage();
		for (WebElement l : languagelist) {
			if (l.getText().equalsIgnoreCase(language)) {
				act.explicitWait(getDriver(), languageSelected(), Duration.ofSeconds(10));
				act.click1(l, l.getText());
			}
		}
	}

	public void logOutFn() {
		act.click1(objHome.logout(), "User Log Out");
	}
}
