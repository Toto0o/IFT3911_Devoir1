package core.vues;

import core.modele.ControleurAdmin;
import core.modele.ModeleVoyage;
import core.modele.Sujet;
import core.modele.commandes.reservation.AjouterReservationCommande;
import core.prix.Paiement;
import core.reservations.Reservation;
import core.reservations.StatutReservation;
import core.reservations.unites.UniteReservable;
import core.voyage.SegmentVoyage;
import core.voyage.vehicules.Section;
import core.voyage.visiteurs.Visiteur;
import core.voyage.visiteurs.VisiteurClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.stream;

public class VueClient implements Observateur {

	private ModeleVoyage sujet;
	private BorderPane root;
	private Stage stage;

	private List<SegmentVoyage> segmentVoyageList;
	private Visiteur visiteurClient;

	private ControleurAdmin controleurAdmin;

	public VueClient(ModeleVoyage sujet, ControleurAdmin controleurAdmin) {
		this.sujet = sujet;
		root = new BorderPane();
		stage = new Stage();
		segmentVoyageList = sujet.getAllSegmentVoyage();
		this.controleurAdmin = controleurAdmin;

		afficherVolsDispoibles();
	}

	public void afficherVolsDispoibles() {

		ScrollPane scrollPane = new ScrollPane();
		List<Section> sections = new ArrayList<>();

		for (SegmentVoyage segmentVoyage : segmentVoyageList) {
			for (Section section : segmentVoyage.getVehicule().getSections()) {
				sections.add(section);
			}
		}

		TableView<Section> table = new TableView<>();
		table.getItems().addAll(sections);

		TableColumn<Section, String> colseg = new TableColumn<>("Segments de voyages");
		colseg.setCellValueFactory(data -> {
			Section section = data.getValue();
			SegmentVoyage segment = segmentVoyageList.stream()
					.filter(seg -> seg.getVehicule().getSections().contains(section))
					.findFirst()
					.orElse(null);
			visiteurClient = new VisiteurClient();
			visiteurClient.visiter(segment);
			visiteurClient.visiter(section);

			return new SimpleStringProperty(visiteurClient.obtenirAffichage());
		});

		TableColumn<Section, Void> colRes = new TableColumn<>("");

		colRes.setCellFactory(col -> new TableCell<>() {
			private final Button res = new Button("Reserver");

			{
				res.setOnAction(event -> {
					Reservation reservation = new Reservation(
							UUID.randomUUID(),
							LocalDateTime.now().toString(),
							StatutReservation.EN_ATTENTE
					);
					Section section = getTableRow().getItem();
					UniteReservable uniteReservable = null;
					for (UniteReservable unite : section.getUnitesReservables()) {
						if (unite.isAvailable()) {
							uniteReservable = unite;
						}
					}
					reservation.ajouterUnite(uniteReservable);
					controleurAdmin.executerCommande(
							new AjouterReservationCommande(sujet, reservation, uniteReservable)
					);
					char s;
					switch (section.getTypeSection()) {
						case "promo" -> s = 'P';
						case "Dynamique" -> s = 'D';
						default -> s = 'R';
					}
					Paiement.payer(reservation, s);
					sujet.notifier();
					System.out.println("RUnite apres res : " + uniteReservable.isAvailable());
				});
			}

			@Override
			protected void updateItem(Void item, boolean empty) {
				super.updateItem(item, empty);

				if (empty) {
					setGraphic(null);
				} else {
					setGraphic(res);
				}
			}
		});

		table.getColumns().addAll(colseg, colRes);
		scrollPane.setContent(table);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		root.setCenter(scrollPane);
	}

	public void mettreAJour() {
		segmentVoyageList = sujet.getAllSegmentVoyage();
		afficherVolsDispoibles();
	}

	@Override
	public void start() {
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();
	}

}