package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class chromeTest1 extends BaseTest{

	@Test
	 public void test1() throws MalformedURLException {
		 
		 //Remote WebDriver Class for running on Docker
		 URL url = new URL("http://localhost:4444/wd/hub");
		 DesiredCapabilities cap = DesiredCapabilities.chrome();
		 RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		 driver.get("http://google.com");
		 System.out.println(driver.getTitle());
	 }
	
	@Test (dataProvider = "data")
	public void testData(String greeting, String communication, int number) {
		System.out.println(greeting + ", " + communication + ", " + number);
	}
	
	@DataProvider (name = "data")
	public Object[][] getData() {
		Object[][] data = {{"hello", "text", 1},{"bye", "message", 143},{"solo", "call", 453}};
		return data;
	}
}
