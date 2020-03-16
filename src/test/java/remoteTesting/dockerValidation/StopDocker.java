package remoteTesting.dockerValidation;

import org.testng.annotations.Test;

public class StopDocker {
	
	DockerControl dockerControl;
	DeleteLogFile deleteLogFile;
	
	//should be passed into the class
	String commandDown = "cmd /c start docker-down.bat";
	String nodeComplete = "stopped: selenium-hub";
	int readTime = 45; //this should be passed from a constants file
	
	@Test
	public void stopDockerContainer() {
		DockerControl dockerControl = new DockerControl();
		dockerControl.controlFile(commandDown, nodeComplete);
	}
}