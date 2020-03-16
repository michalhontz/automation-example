package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class DockerControl {

	int readTime = 45; // Should be called from a constants of config file
	int waitTime = 3000; // Should be called from a constants of config file
	String log = "docker-compose-output.log"; // Should be called from a constants of config file

	public void controlScale(String command) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(command);
		} catch (IOException e) {
			System.out.println("[ERROR] IOException was found when running runtime.exec(exeCommand)");
			e.printStackTrace();
		}
	}

	public void controlFile(String command, String message) {

		try {
			boolean flag = false;
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(command);
			Calendar cal = Calendar.getInstance(); // recording the current time
			cal.add(Calendar.SECOND, readTime); // creating the time when reading the file should end
			long stopReadingLog = cal.getTimeInMillis();

			try {
				Thread.sleep(waitTime); // Wait until file is created (we may want to have a dynamic wait here)
			} catch (InterruptedException e) {
				System.out.println("[ERROR] InterruptedException was found when running Thread.sleep(waitTime)");
				e.printStackTrace();
			}

			while (System.currentTimeMillis() < stopReadingLog) {
				if (flag) { // if the flag is true end the time early
					break;
				}

				BufferedReader reader = new BufferedReader(new FileReader(log));
				String currentLine = reader.readLine();

				// Loop through the log file for the completion of the node container
				while (currentLine != null && !flag) {
					if (currentLine.contains(message)) {
						flag = true;
						break;
					}
					currentLine = reader.readLine();
				}
				reader.close();
			}
		} catch (Exception e) {
			System.out.println(
					"[ERROR] Exception was found when running while (System.currentTimeMillis() < stopReadingLog)");
			e.printStackTrace();
		}
	}
}
