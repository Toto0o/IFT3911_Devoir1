package core.voyage.terminaux;

import core.voyage.ElementVoyage;
import core.voyage.visiteurs.Visiteur;

public abstract class Terminal implements ElementVoyage {

	private String code;
	private String ville;

	public Terminal(String code, String ville) {
		this.code = code;
		this.ville = ville;
	}

	public String getCode() {
		return code;
	}

	public String getVille() {
		return ville;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}



}