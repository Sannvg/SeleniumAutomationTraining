package com.POS.Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.POS.BaseClass.BaseClass;

public class ExcelRead extends BaseClass {
	public ArrayList<String> getData(String Testcase) throws Exception {

		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "\\Files\\QALegend.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		int sheets = 0;
		sheets = wb.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (wb.getSheetName(i).equalsIgnoreCase("Smoke")) {

				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();

				Row firstrow = rows.next();

				Iterator<Cell> cel = firstrow.cellIterator();
				int k = 0;
				int col = 0;

				while (cel.hasNext()) {
					Cell value = cel.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						col = k;
					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(col).getStringCellValue().equalsIgnoreCase(Testcase)) {
						Iterator<Cell> cell = r.cellIterator();
						cell.next();
						while (cell.hasNext()) {
							Cell c = cell.next();
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return a;
	}
}
