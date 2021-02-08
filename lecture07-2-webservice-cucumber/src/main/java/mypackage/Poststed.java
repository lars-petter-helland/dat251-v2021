package mypackage;

public class Poststed {

	public String postnummer;
	public String poststed;
	public String kommunenummer;
	public String kommune;
	public String kategori;

	public Poststed(String postnummer, String poststed, String kommunenummer,
			String kommune, String kategori) {
		this.postnummer = postnummer;
		this.poststed = poststed;
		this.kommunenummer = kommunenummer;
		this.kommune = kommune;
		this.kategori = kategori;
	}

	// @Override
	// public String toString() {
	// return "Poststed [postnummer=" + postnummer + ", poststed=" + poststed +
	// ", kommunenummer=" + kommunenummer
	// + ", kommune=" + kommune + ", kategori=" + kategori + "]";
	// }

	// public String toJson() {
	// return new Gson().toJson(this);
	// }

}
