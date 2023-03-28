package com.POS.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.POS.Actions.Action;
import com.POS.PageObjects.AddProduct;
import com.POS.PageObjects.EditPeople;
import com.POS.PageObjects.HomePage;
import com.POS.PageObjects.Login;
import com.POS.PageObjects.Product;
import com.POS.PageObjects.Settings;
import com.POS.PageObjects.Store;
import com.POS.PageObjects.StoreManage;
import com.POS.PageObjects.Waiter;
import com.POS.PageObjects.Category;
import com.POS.Utilities.ExcelRead;
import com.POS.Utilities.ExtentReport;
import com.POS.Utilities.Waits;

public class BaseClass {
	public static Properties prop;
	public static Action act;
	public static ExtentReport ext;
	public static ExcelRead data;
	public static Login objLogin;
	public static HomePage objHome;
	public static Product objPdt;
	public static AddProduct objAddPdt;
	public static Store objStore;
	public static StoreManage objMngStore;
	public static Waiter objWaiter;
	public static EditPeople objEditPeople;
	public static Category objCategory;
	public static Settings objSettings;
	public static Waits objWait;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite(groups = { "Smoke" })
	public void loadFiles() {
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();
	}

	@BeforeTest(groups = { "Smoke" })
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters("Browser")
	@BeforeMethod(groups = { "Smoke" })
	public void beforeMethods(String strBrowser) {
		launchApp(strBrowser);		
		objLogin = new Login();
		objHome = new HomePage();
		data= new ExcelRead();
		objWait = new Waits();
		objPdt = new Product();
		objAddPdt = new AddProduct();
		objStore = new Store();
		objMngStore = new StoreManage();
		objWaiter = new Waiter();
		objEditPeople = new EditPeople();
		objCategory = new Category();
		objSettings = new Settings();		
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(opt));		
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();	
		objWait = new Waits();
		objWait.implicitWait(getDriver(), 10);
		act = new Action();
		act.pageLoadTimeOut(getDriver(), 30); // PageLoad TimeOuts
		getDriver().get(prop.getProperty("Url"));
	}

	@AfterMethod(groups = { "Smoke" })
	public void afterMethod() {
		getDriver().quit();
	}

	@AfterSuite
	public void tearDown() {
		ExtentReport.endReport();
	}

}
