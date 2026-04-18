package core.voyage.fabriques;

import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Vehicule;

public abstract class FabriqueVoyage {

	public abstract SegmentVoyage creerSegementVoyage(String code, Terminal origine, Terminal destination, Vehicule vehicule);

	public abstract Terminal creerTerminal(String code, String ville);

	public abstract Vehicule creerVehicule(String modele, int capaciteTotale);

}