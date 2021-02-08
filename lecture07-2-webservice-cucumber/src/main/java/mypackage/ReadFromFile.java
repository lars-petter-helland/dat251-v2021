package mypackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFromFile {

	Map<String, Poststed> fetchPoststeder() {
		
		Map<String, Poststed> poststeder = new HashMap<>();

	    String filePath = new File(".").getAbsolutePath();
		String fileName = filePath + "/Postnummerregister_ansi.txt";

		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Poststed poststed = line2Poststed(line);
				poststeder.put(poststed.postnummer, poststed);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return poststeder;
	}

	private Poststed line2Poststed(String line) {
		String[] fields = line.split("\t");
//		System.out.println(Arrays.toString(fields));
		Poststed poststed = new Poststed(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim(), fields[4].trim());
		return poststed;
	}

}
