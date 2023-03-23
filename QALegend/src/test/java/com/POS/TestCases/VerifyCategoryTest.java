package com.POS.TestCases;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.POS.BaseClass.BaseClass;
import com.POS.Utilities.Log;

public class VerifyCategoryTest extends BaseClass {
	@Test(priority = 0)
	public void validateCatTblHeaders() {
		Log.startTestCase("VerifyCategoryTest--validateCatTblHeaders");
		objLogin.loginFn();
		act.click1(objHome.btnMenu(), "Menu");
		act.click1(objHome.menuCategory(), "Category Menu");
		act.click1(objHome.menuCatPdt(), "Category Pdt");
		List<WebElement> lstCattblHdr = objCategory.tblCatHeaders();
		List<String> lstCatHdr = new ArrayList<String>();
		boolean flag = false;
		lstCatHdr.add("Category Name");
		lstCatHdr.add("Ceated At");
		lstCatHdr.add("Action");
		for (int m = 0; m < lstCatHdr.size(); m++) {
			for (WebElement hdr : lstCattblHdr) {
				if ((lstCatHdr.get(m).equalsIgnoreCase(hdr.getText()))) {
					flag = true;
					break;
				}
			}
			flag = false;
		}
		SoftAssert sasst = new SoftAssert();
		sasst.assertFalse(flag);
		sasst.assertAll();
		objHome.logOutFn();
		Log.endTestCase("VerifyCategoryTest--validateCatTblHeaders");
	}

	@Test(priority = 2)
	public void validateAddCategory() throws Exception {
		Log.startTestCase("VerifyCategoryTest--validateAddCategory");
		objLogin.loginFn();
		act.click1(objHome.btnMenu(), "Menu");
		act.click1(objHome.menuCategory(), "Category Menu");
		act.click1(objHome.menuCatPdt(), "Category Pdt");
		act.click1(objCategory.btnAddCat(), "Add Category");
		ArrayList excelData = data.getData("Category");
		act.type(objCategory.txtCatName(), (String) excelData.get(0));
		act.click1(objCategory.btnSubmitAddCat(), "Add Category Submit");
		Log.info("Catgeory Added");
		act.click1(objCategory.txtSearchCategory(), "Search Category");
		act.type(objCategory.txtSearchCategory(), (String) excelData.get(0));
		int tblRowCnt = act.getRowCount(objCategory.tblCategory());
		Assert.assertTrue(tblRowCnt > 0, "Category Added");
		objHome.logOutFn();
		Log.endTestCase("VerifyCategoryTest--validateAddCategory");
	}

}
