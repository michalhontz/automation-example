package remoteTesting.dockerValidation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	// Data should come from outside of the test
	String fileLocation = "C:\\Development\\eclipse-workspace\\dockerValidation\\Data.xlsx";

	public void getExcel() throws IOException {
		FileInputStream fis = new FileInputStream(fileLocation);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount - 1][columnCount];

		for (int i = 0; i < rowCount; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				row.getCell(j);
			}
		}
	}
}