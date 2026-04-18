package core.voyage.fabriques;

import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Gare;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Section;
import core.voyage.vehicules.Train;
import core.voyage.vehicules.Vehicule;
import core.voyage.vehicules.unites.UniteReservable;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class FabriqueTrain extends FabriqueVoyage {

	private Random rand = new Random();

	@Override
	public Gare creerTerminal(String nom, String ville) {
		int gare = 3 + rand.nextInt(2);
		return new Gare(nom, ville, gare);
	}
	@Override
	public Train creerVehicule(String modele, int capaciteTotale) {
		int vitesse = 80 + rand.nextInt(20);
		Train train = new Train(modele, capaciteTotale, vitesse);

		Section sectionREG = new Section("regulier");
		sectionREG.addUnite(new UniteReservable("1", 0, 200));
		sectionREG.addUnite(new UniteReservable("2",0, 200));

		Section sectionPROMO = new Section("promo");
		sectionPROMO.addUnite(new UniteReservable("3", 0, 200));
		sectionPROMO.addUnite(new UniteReservable("4", 0, 200));

		Section sectionDYN = new Section("Dynamique");
		sectionDYN.addUnite(new UniteReservable("5", 0, 200));
		sectionDYN.addUnite(new UniteReservable("6", 0, 200));

		train.setSections(Arrays.asList(sectionREG, sectionPROMO, sectionDYN));

		return train;
	}

	@Override
	public SegmentVoyage creerSegementVoyage(String code, Terminal origine, Terminal destination, Vehicule train) {
		return new SegmentVoyage(code, origine, destination, train);
	}

}