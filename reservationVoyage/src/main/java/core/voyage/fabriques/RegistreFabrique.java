package core.voyage.fabriques;

import java.util.HashMap;

public class RegistreFabrique {

	private RegistreFabrique instance;
	private HashMap<String, FabriqueVoyage> fabriques;

	private void RegisteFabriques() {
		fabriques = new HashMap<>();
		instance = this;
		enregisterFabrique("train", new FabriqueTrain());
		enregisterFabrique("avion", new FabriqueAvion());
		enregisterFabrique("bateau", new FabriqueBateau());
	}

	public RegistreFabrique getInstance() {
		if (instance == null) {
			new RegistreFabrique();
		}
		return instance;
	}

	public FabriqueVoyage obtenirFabrique(String type) {
		return fabriques.get(type);
	}

	public void enregisterFabrique(String type, FabriqueVoyage fabrique) {
		fabriques.put(type, fabrique);
	}

}