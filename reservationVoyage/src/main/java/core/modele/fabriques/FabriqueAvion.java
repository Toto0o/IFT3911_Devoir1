package core.modele.fabriques;

import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Aeroport;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Avion;
import core.voyage.vehicules.Section;
import core.voyage.vehicules.Vehicule;
import core.reservations.unites.UniteReservable;

import java.util.Arrays;
import java.util.Random;

public class FabriqueAvion extends FabriqueVoyage {

	private Random rand = new Random();

	@Override
	public Aeroport creerTerminal(String code, String ville) {
		int pistes = 4 + rand.nextInt(4);
		return new Aeroport(code, ville, pistes);
	}

	@Override
	public Avion creerVehicule(String modele, int capaciteTotale) {
		int vitesse = 600 + rand.nextInt(300);
		Avion avion = new Avion(modele, capaciteTotale, vitesse);

		Section sectionREG = new Section("regulier");
		sectionREG.addUnite(new UniteReservable("1", 0, 200));
		sectionREG.addUnite(new UniteReservable("2",0, 200));

		Section sectionPROMO = new Section("promo");
		sectionPROMO.addUnite(new UniteReservable("3", 0, 200));
		sectionPROMO.addUnite(new UniteReservable("4", 0, 200));

		Section sectionDYN = new Section("Dynamique");
		sectionDYN.addUnite(new UniteReservable("5", 0, 200));
		sectionDYN.addUnite(new UniteReservable("6", 0, 200));

		avion.setSections(Arrays.asList(sectionREG, sectionPROMO, sectionDYN));

		return avion;
	}


}