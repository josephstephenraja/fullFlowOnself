package Excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ToReadExcel {
	WebDriver driver;
 XSSFWorkbook wb;
	XSSFSheet Sheet1;

public static String readData(int row, int col, String sheetname) throws Throwable {
 String path = System.getProperty("user.dir") +"\\TestData\\API Testcase.xlsx";
File file = new File(path);
 FileInputStream fis = new FileInputStream(file);
 Workbook W = WorkbookFactory.create(fis);
Sheet S = W.getSheet(sheetname);
Row r = S.getRow(row);
Cell s = r.getCell(col);
String data = s.toString();
return data;

}

}
