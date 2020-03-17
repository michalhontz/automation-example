package remoteTesting.dockerValidation;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class chromeTest1 extends BaseTest {
	
	// Data should come from outside of the test
	String fileLocation = "C:\\Development\\eclipse-workspace\\dockerValidation\\Data.xlsx";
	DataFormatter formatter = new DataFormatter();

	@Test
	public void test1() throws MalformedURLException {

		// Remote WebDriver Class for running on Docker
		URL url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}

	@Test(dataProvider = "data")
	public void testData(String greeting, String communication, String id) {
		System.out.println(greeting + ", " + communication + ", " + id);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws Exception {

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
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
	}
}