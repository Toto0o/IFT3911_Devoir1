package core.modele.fabriques;

import core.voyage.terminaux.Port;
import core.voyage.vehicules.Paquebot;
import core.voyage.vehicules.Section;
import core.reservations.unites.UniteReservable;

import java.util.Arrays;
import java.util.Random;

public class FabriqueBateau extends FabriqueVoyage {

	private Random rand = new Random();

	public Port creerTerminal(String nom, String ville) {
		int quais = 8 + rand.nextInt(4);
		return new Port(nom, ville, quais);
	}

	public Paquebot creerVehicule(String modele, int capaciteTotale) {
		int tonnage = (7 + rand.nextInt(13) * 10000);
		Paquebot paquebot = new Paquebot(modele, capaciteTotale, tonnage);

		Section sectionREG = new Section("regulier");
		sectionREG.addUnite(new UniteReservable("1", 0, 200));
		sectionREG.addUnite(new UniteReservable("2",0, 200));

		Section sectionPROMO = new Section("promo");
		sectionPROMO.addUnite(new UniteReservable("3", 0, 200));
		sectionPROMO.addUnite(new UniteReservable("4", 0, 200));

		Section sectionDYN = new Section("Dynamique");
		sectionDYN.addUnite(new UniteReservable("5", 0, 200));
		sectionDYN.addUnite(new UniteReservable("6", 0, 200));

		paquebot.setSections(Arrays.asList(sectionREG, sectionPROMO, sectionDYN));

		return paquebot;

	}


}