package com.commonmethods;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {

	public static WebDriver OpenBrowser(WebDriver driver, String brName,
			String appUrl) {
		return driver;
	}

	public static HashMap<String, String> readDataFromTC(String tcID)
			throws FileNotFoundException, IOException {
		
		//String flPath = "C:\\Data\\Data.xls";
		String flPath = "C:\\Data\\Data.xlsx";

		// open work book
		// HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(flPath));
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(flPath));

		// get sheet
		// HSSFSheet sht = wb.getSheet("Sheet1");
		XSSFSheet sht = wb.getSheet("Sheet1");

		// get row count
		int rc = sht.getLastRowNum();

		HashMap<String, String> tcData = new HashMap<String, String>();
		for (int r = 1; r <= rc; r++) {
			int cc = sht.getRow(r).getLastCellNum();
			if (sht.getRow(r).getCell(0).toString().equalsIgnoreCase(tcID)) {
				for (int c = 0; c < cc; c++) {
					String kName = sht.getRow(0).getCell(c).toString();
					String kVal = sht.getRow(r).getCell(c).toString();
					try {
						if(CellType.NUMERIC.equals (sht.getRow(r).getCell(c).getCellType())) {
							kVal = String.valueOf(((Double)Double.parseDouble(sht.getRow(r).getCell(c).toString())).longValue());
						}
					} catch(Exception ex) {
					}
					tcData.put(kName, kVal);
				}
				break;
			}
		}
		wb.close();
		return tcData;

	}
}



