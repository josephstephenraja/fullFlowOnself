package api.utilies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToReadJson {
	public static String readJson() throws Throwable {
		byte[] input =Files.readAllBytes(Paths.get("admin.json"));
		String inputJson = new String(input);
		return inputJson;
	}
	
	public static String createGuideLine() throws Throwable {
		byte[] input =Files.readAllBytes(Paths.get("CreateGuideLine.json"));
		String inputJson = new String(input);
		return inputJson;

	}
	 public static String toView() throws Throwable {
		 byte[] input =Files.readAllBytes(Paths.get("view.json"));
			String inputJson = new String(input);
			return inputJson;

	}

	 public static String toUpdate() throws Throwable {
		 byte[] input =Files.readAllBytes(Paths.get("Updated.json"));
			String inputJson = new String(input);
			return inputJson;

	}
	 
	 public static String toDelete() throws Throwable {
		 byte[] input =Files.readAllBytes(Paths.get("Delete.json"));
			String inputJson = new String(input);
			return inputJson;

	}
}
