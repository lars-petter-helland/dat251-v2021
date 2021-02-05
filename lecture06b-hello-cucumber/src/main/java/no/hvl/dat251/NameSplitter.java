package no.hvl.dat251;

public class NameSplitter {

	public static String getFirstName(String fulltNavn) {
		String[] names = fulltNavn.split(" ");
		int numberOfNames = names.length;
		
		if (numberOfNames == 2) {
			return names[0];
		} else {
			return names[0] + " " + names[1];
		}
	}

	public static String getLastName(String fulltNavn) {
		String[] names = fulltNavn.split(" ");
		int numberOfNames = names.length;
		
		if (numberOfNames == 2) {
			return names[1];
		} else {
			return names[2];
		}
	}

}
