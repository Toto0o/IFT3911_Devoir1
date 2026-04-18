package core.voyage.terminaux;

public class Aeroport extends Terminal {

	private int pistes;

	public Aeroport(String code, String ville, int pistes) {
		super(code, ville);
		this.pistes = pistes;
	}

	public int getPistes() {
		return pistes;
	}

	public void setPistes(int pistes) {
		this.pistes = pistes;
	}
}