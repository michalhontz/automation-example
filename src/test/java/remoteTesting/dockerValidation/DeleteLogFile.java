package remoteTesting.dockerValidation;

import java.io.File;

public class DeleteLogFile {
	
	public void DeleteLog(String log) {
		try {
			File file = new File(log);
			file.delete();
			System.out.println("[INFO] Docker output log has been deleted.");
			
		} catch (Exception e) {
			System.out.println("[ERROR] Docker output log has be not been deleted.");
			e.printStackTrace();
		}
	}
}
