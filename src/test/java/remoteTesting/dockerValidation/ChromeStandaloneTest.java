package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {
 public static void main(String[] args) throws MalformedURLException {
	 
	 //Remote WebDriver Class for running on Docker
	 URL url = new URL("http://localhost:4444/wd/hub");
	 DesiredCapabilities cap = DesiredCapabilities.chrome();
	 RemoteWebDriver driver = new RemoteWebDriver(url, cap);
	 driver.get("http://google.com");
	 System.out.println(driver.getTitle());
 }
}
