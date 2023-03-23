package com.POS.PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.POS.BaseClass.BaseClass;

public class Login extends BaseClass {
	@FindBy(css = "img[alt='logo']")
	private WebElement Logo;
	@FindBy(xpath = "//h1[text()='Login']")
	private WebElement lblLogin;
	@FindBy(css = "input[name='username']")
	private WebElement txtUsername;
	@FindBy(css = "input[name='password']")
	private WebElement txtPswrd;
	@FindBy(css = "input[name='submit']")
	private WebElement btnLogin;

	public Login() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement dispLogo() {
		return Logo;
	}

	public WebElement lblLogin() {		
		objWait.explicitWaitVisible(getDriver(), lblLogin, Duration.ofSeconds(10));
		return lblLogin;
	}

	public WebElement txtUsername() {
		return txtUsername;
	}

	public WebElement txtPswrd() {
		return txtPswrd;
	}

	public WebElement btnLogin() {
		return btnLogin;
	}

	public Boolean isLogoPresent() {
		return act.isDisplayed(getDriver(), Logo);
	}

	public void loginFn() {
		act.type(txtUsername, prop.getProperty("Username"));
		act.type(txtPswrd, prop.getProperty("Password"));
		act.click1(btnLogin, "Login Button");
	}

}
