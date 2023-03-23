package com.POS.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.ExcelRead;
import com.POS.Utilities.Log;

public class VerifyProductPageTest extends BaseClass {
	@Test(priority = 1, groups = { "Smoke" })
	public void validateShowPdtTblCount() {
		Log.startTestCase("VerifyProductPageTest--validateShowPdtTblCount");		
		objPdt.beforefnPdt();
		act.click1(objPdt.drpShowProduct(), "Show Product");
		act.selectByVisibleText("50", objPdt.drpShowProduct());
		Log.info("Selected show count");
		int rwcount = act.getRowCount(objPdt.tableProduct());
		System.out.println(rwcount);
		String strrowcount = objPdt.lblTblRowdtl().getText();
		int rwcnt = Integer
				.parseInt(strrowcount.substring(strrowcount.indexOf("to") + 3, strrowcount.indexOf("of") - 1));
		Assert.assertEquals(rwcnt, 50);
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--showProduct");
	}

	@Test(priority = 2)
	public void validateFilterBySupplier() {
		Log.startTestCase("VerifyProductPageTest--validateFilterBySupplier");
		objPdt.beforefnPdt();
		act.click1(objPdt.drpFilterSupplier(), "Supplier Filter");
		act.selectByVisibleText("ObsTestSupplier", objPdt.drpFilterSupplier());
		Log.info("Selected Supplier");
		act.click1(objPdt.btnApplyFilter(), "Apply Filter");
		int rwcount = act.getRowCount(objPdt.tableProduct());
		Assert.assertEquals(true, rwcount > 0);
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validateFilterBySupplier");
	}

	@Test(priority = 3)
	public void validateFilterByPdtType() {
		Log.startTestCase("VerifyProductPageTest--validateFilterByPdtType");
		objPdt.beforefnPdt();
		act.click1(objPdt.drpFilterPdtType(), "Product Type Filter");
		act.selectByVisibleText("Standard", objPdt.drpFilterPdtType());
		Log.info("Selected Product Type");
		act.click1(objPdt.btnApplyFilter(), "Apply Filter");
		int rwcount = act.getRowCount(objPdt.tableProduct());
		Assert.assertEquals(true, rwcount > 0);
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--filterByPdtType");
	}

	@Test(priority = 4)
	public void validateFilterBySupPdtType() {
		Log.startTestCase("VerifyProductPageTest--validateFilterBySupPdtType");
		objPdt.beforefnPdt();
		act.click1(objPdt.drpFilterSupplier(), "Supplier Filter");
		act.selectByValue(objPdt.drpFilterSupplier(), "ObsTestSupplier");
		act.click1(objPdt.drpFilterPdtType(), "Product Type Filter");
		act.selectByValue(objPdt.drpFilterPdtType(), "Standard");
		Log.info("Selected Supplier and Product Type");
		act.click1(objPdt.btnApplyFilter(), "Apply Filter");
		int rwcount = act.getRowCount(objPdt.tableProduct());
		Assert.assertEquals(true, rwcount > 0);
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validateFilterBySupPdtType");
	}

	@Test(priority = 5)
	public void validateDownloadCSV() {
		Log.startTestCase("VerifyProductPageTest--validateDownloadCSV");
		objPdt.beforefnPdt();
		act.click1(objPdt.lnkDownload(), "Download File");
		Assert.assertTrue(objPdt.tableProduct().isDisplayed());
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validateDownloadCSV");
	}

	@Test(priority = 6)
	public void validateUploadCSV() {
		Log.startTestCase("VerifyProductPageTest--validateUploadCSV");
		objPdt.beforefnPdt();
		act.click1(objPdt.lnkUpload(), "Upload File");
		act.click1(objPdt.btnUploadfile(), "Choose File to Upload");
		act.type(objPdt.btnUploadfile(), System.getProperty("user.dir") + "\\Files\\TestPdt.jpg");
		Log.info("Entered file to upload");
		act.click1(objPdt.btnUFSubmit(), "File Upload Submit");
		Assert.assertTrue(objPdt.btnAddPdt().isDisplayed());
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validateUploadCSV");
	}

	@Test(priority = 7)
	public void validatePrintMenu() throws Exception {
		Log.startTestCase("VerifyProductPageTest--validatePrintMenu");
		objPdt.beforefnPdt();
		act.click1(objPdt.lnkPrintMenu(), "Print Menu");
		Thread.sleep(3000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		act.switchToOldWindow(getDriver());
		act.click1(objPdt.btnPrintMenuClose(), "Print Menu Close");
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validatePrintMenu");
	}

	@Test(priority = 8)
	public void validateAddProduct() throws Exception {
		Log.startTestCase("VerifyProductPageTest--validateAddProduct");
		objPdt.beforefnPdt();
		act.click1(objPdt.btnAddPdt(), "Add Product");
		ArrayList excelData = data.getData("Product");
		act.selectByValue(objAddPdt.drpPdtType(), (String) excelData.get(0));
		act.type(objAddPdt.txtPdtCode(), (String) excelData.get(1));
		act.type(objAddPdt.txtPdtName(), (String) excelData.get(2));
		act.selectByValue(objAddPdt.drpCategory(), (String) excelData.get(3));
		act.selectByValue(objAddPdt.drpSupplier(), (String) excelData.get(4));
		act.type(objAddPdt.drpPurchasePrice(), (String) excelData.get(5));
		act.type(objAddPdt.txtTax(), (String) excelData.get(6));
		act.selectByValue(objAddPdt.drpTaxType(), (String) excelData.get(7));
		act.selectByVisibleText((String) excelData.get(8),objAddPdt.drpPrice());
		act.type(objAddPdt.txtUnit(), (String) excelData.get(9));
		act.selectByVisibleText((String) excelData.get(10),objAddPdt.drpAlertQT());
		act.type(objAddPdt.txtPdtOptions(), (String) excelData.get(11));
		act.type(objAddPdt.pdtImageInput(), System.getProperty("user.dir") + "\\Files\\TestPdt.jpg");
		act.type(objAddPdt.txtPdtDesc(), (String) excelData.get(12));
		act.click1(objAddPdt.btnPdtSubmit(), "Add Product Submit");	
		act.click1(objPdt.txtSearchPdt(), "Search Product");
		act.type(objPdt.txtSearchPdt(), (String) excelData.get(0));
		int tblRowCnt = act.getRowCount(objPdt.tableProduct());
		Assert.assertTrue(tblRowCnt > 0, "Product is added");
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validateAddProduct");
	}

	@Test(priority = 9)
	public void validateSearchPdt() throws Exception {
		Log.startTestCase("VerifyProductPageTest--validateSearchPdt");
		objPdt.beforefnPdt();
		act.click1(objPdt.txtSearchPdt(), "Search Product");
		ArrayList excelData = data.getData("Product");
		act.type(objPdt.txtSearchPdt(), (String) excelData.get(2));
		Log.info("Search product entered");
		int tblRowCnt = act.getRowCount(objPdt.tableProduct());
		Assert.assertTrue(tblRowCnt > 0, "Search Product is displayed");
		objHome.logOutFn();
		Log.endTestCase("VerifyProductPageTest--validateSearchPdt");
	}
}
