package core.voyage.terminaux;

public class Port extends Terminal {

	private int quais;

	public Port(String code, String ville, int quais) {
		super(code, ville);
		this.quais = quais;
	}

	public int getQuais() {
		return quais;
	}

	public void setQuais(int quais) {
		this.quais = quais;
	}

}