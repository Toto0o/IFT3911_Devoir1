package core.modele.fabriques;

import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Vehicule;

public abstract class FabriqueVoyage {

	public SegmentVoyage creerSegementVoyage(String code, String compagnie, Terminal origine,
											 Terminal destination, Vehicule vehicule, String heureDepart,
											 String heureArrive, String dateDepart, String dateArrive) {
		return new SegmentVoyage(code, compagnie, origine, destination, vehicule,
				heureDepart, heureArrive, dateDepart, dateArrive);
	}

	public abstract Terminal creerTerminal(String code, String ville);

	public abstract Vehicule creerVehicule(String modele, int capaciteTotale);

}