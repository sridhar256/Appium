package com.telemed.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVReader;
import com.telemed.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "C:\\Data\\EMR5LoginPage.xlsx";

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// ################################################################## Take Screenshot ##################################################################

	/*
	 * public static void takeScreenshotAtEndOfTest() throws IOException { File
	 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * currentDir = System.getProperty("user.dir"); FileUtils.copyFile(scrFile, new
	 * File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")); }
	 */
	// ################################################################# Wait for Page Load #################################################################

	public static void waitForPageLoad(WebDriver driver) 
	{
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}
	
	public static HashMap<String, String> readDataFromTC(String tcID)
			throws FileNotFoundException, IOException {
		String flPath = "C:\\Users\\sridhar.j\\eclipse-workspace\\emr\\src\\main\\java\\com\\emr5\\testdata\\EMR5LoginPage.xls";

		// open work book
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(flPath));
		// get sheet
		HSSFSheet sht = wb.getSheet("Sheet1");

		// get row count
		int rc = sht.getLastRowNum();
		HashMap<String, String> tcData = new HashMap<String, String>();
		for (int r = 1; r <= rc; r++) {
			int cc = sht.getRow(r).getLastCellNum();
			if (sht.getRow(r).getCell(0).toString().equalsIgnoreCase(tcID)) {
				for (int c = 0; c < cc; c++) {
					String kName = sht.getRow(0).getCell(c).toString();
					String kVal = sht.getRow(r).getCell(c).toString();
					tcData.put(kName, kVal);
				}
				break;
			}
		}
		wb.close();
		return tcData;

	}

}
