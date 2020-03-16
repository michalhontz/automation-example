package remoteTesting.dockerValidation;

import org.testng.annotations.Test;

public class StartDocker {
	
	//should be passed into the class
	String commandUp = "cmd /c start docker-up.bat";
	String commandScale = "cmd /c start docker-scale.bat";
	String nodeComplete = "The node is registered to the hub and ready to use";
	String file = "docker-compose-output.log";
	
	@Test
	public void startDockerContainer() {
		DeleteLogFile deleteLogFile = new DeleteLogFile();
		deleteLogFile.DeleteLog(file);
		DockerControl dockerControl = new DockerControl();
		dockerControl.controlFile(commandUp, nodeComplete);
		dockerControl.controlScale(commandScale);

	}
}