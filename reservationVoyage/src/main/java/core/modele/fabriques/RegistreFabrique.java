package core.modele.fabriques;

import java.util.HashMap;

public class RegistreFabrique {

	private static RegistreFabrique instance;
	private HashMap<String, FabriqueVoyage> fabriques;

	private void RegisteFabriques() {
		fabriques = new HashMap<>();
		enregisterFabrique("train", new FabriqueTrain());
		enregisterFabrique("avion", new FabriqueAvion());
		enregisterFabrique("bateau", new FabriqueBateau());
	}

	public static RegistreFabrique getInstance() {
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