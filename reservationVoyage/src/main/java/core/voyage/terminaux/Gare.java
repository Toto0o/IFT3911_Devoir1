package core.voyage.terminaux;

public class Gare extends Terminal {

	private int voies;

	public Gare(String code, String ville, int voies) {
		super(code, ville);
		this.voies = voies;
	}

	public int getVoies() {
		return voies;
	}

	public void setVoies(int voies) {
		this.voies = voies;
	}

}