package remoteTesting.dockerValidation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	@BeforeTest
	public void startDockerInstances() {
		StartDocker startDocker = new StartDocker();
		startDocker.startDockerContainer();
		
	}
	
	@AfterTest
	public void stopDockerIntances() {
		StopDocker stopDocker = new StopDocker();
		stopDocker.stopDockerContainer();
	}

}
