package core.modele;

import core.modele.fabriques.*;
import core.reservations.Reservation;
import core.reservations.StatutReservation;
import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Section;
import core.voyage.vehicules.Vehicule;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;

public class ModeleVoyage extends Sujet {

	private List<SegmentVoyage> voyages;
	private List<Reservation> reservations;

	public ModeleVoyage() {
		init();
	}

	private void init() {
		voyages = new ArrayList<>(getSegmentVoyage());
		reservations = new ArrayList<>(getReservation());
	}

	public List<SegmentVoyage> getAllSegmentVoyage() {
		return voyages;
	}

	public List<Reservation> getAllReservation() {
		return reservations;
	}

	private List<SegmentVoyage> getSegmentVoyage() {
		List<SegmentVoyage> segmentVoyages = new ArrayList<>();


		Scanner scanner = new Scanner(
				new InputStreamReader(
						getClass().getResourceAsStream("/segments.csv")
				)
		);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(",");


			FabriqueVoyage fabrique = RegistreFabrique.getInstance().obtenirFabrique(parts[0]);
			System.out.println("Parts 11 : " + parts[11]);
			System.out.println("Parts 12 : " + parts[12]);

			Terminal origine = fabrique.creerTerminal(parts[1], parts[2]);
			Terminal destination = fabrique.creerTerminal(parts[3], parts[4]);
			Vehicule vehicule = fabrique.creerVehicule(parts[5], Integer.parseInt(parts[6]));
			SegmentVoyage voyage = fabrique.creerSegementVoyage(parts[7],parts[8],origine,destination,vehicule,
					parts[9], parts[10], parts[11], parts[12]);
			segmentVoyages.add(voyage);
		}
		return segmentVoyages;
	}

	private List<Reservation> getReservation() {
		List<Reservation> reservations = new ArrayList<>();

		/*Scanner scanner = new Scanner(
				new InputStreamReader(
						getClass().getResourceAsStream("/reservations.csv")
				)
		);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(",");

			Reservation reservation = new Reservation(
					UUID.fromString(parts[0]), parts[1], StatutReservation.valueOf(parts[2]), Boolean.parseBoolean(parts[3])
			);
			reservations.add(reservation);
		}*/
		return reservations;
	}


	public void ajouterSegment(SegmentVoyage segment) {
		voyages.add(segment);
	}

	public void updateSegement(SegmentVoyage old, SegmentVoyage newSegment) {
		voyages.remove(old);
		voyages.add(newSegment);
	}

	public void supprimerSegement(SegmentVoyage segement) {
		voyages.remove(segement);
	}

	public void ajouterReservation(Reservation res) {
		reservations.add(res);
	}

	public void updateReservation(Reservation old, Reservation newRes) {
		reservations.remove(old);
		reservations.add(newRes);
	}

	public void supprimerReservation(Reservation res) {
		reservations.remove(res);
	}

	public void mettreAJourDisponibilites() {
		// TODO - implement core.modele.ModeleVoyage.mettreAJourDisponibilites
		throw new UnsupportedOperationException();
	}

}