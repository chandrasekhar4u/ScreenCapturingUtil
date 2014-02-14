package fileUtil;

import java.io.File;

public class FileUtil {
	private static String filePath = createFilePath(); 
	public static String folderName;

	public static File createFile(String fileName) {
		try {
			File file = new File(filePath);
			file.mkdirs();
			file = new File(filePath, fileName + ".png");
			file.createNewFile();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String createFilePath() {
		folderName = "Public";
		File file = new File("C:\\Users");
		String [] directory = file.list();
		for(String dir : directory) {
			if(!dir.toLowerCase().contains("default") && !dir.toLowerCase().contains("desktop") &&
					!dir.toLowerCase().contains("public") && !dir.toLowerCase().contains("user")) {
				folderName = dir;
			}
		}
		return "C:\\Users\\Default\\" + folderName + "\\AppData\\Local\\JavaFX";
	}
	
}
