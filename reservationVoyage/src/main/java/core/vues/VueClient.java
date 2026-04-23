package core.vues;

import core.modele.ControleurAdmin;
import core.modele.ModeleVoyage;
import core.modele.Sujet;
import core.modele.commandes.reservation.AjouterReservationCommande;
import core.prix.Paiement;
import core.reservations.Reservation;
import core.reservations.StatutReservation;
import core.voyage.SegmentVoyage;
import core.voyage.vehicules.Section;
import core.voyage.visiteurs.Visiteur;
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
		List<String> segmentsToString = new ArrayList<>();
		for (SegmentVoyage segmentVoyage : segmentVoyageList) {
			for (Section section : segmentVoyage.getVehicule().getSections()) {
				visiteurClient.visiter(segmentVoyage);
				visiteurClient.visiter(section);
				segmentsToString.add(visiteurClient.obtenirAffichage());
			}
		}

		TableView<String> table = new TableView<>();
		table.getItems().addAll(segmentsToString);

		TableColumn<String, String> colseg = new TableColumn<>("Segments de voyages");
		colseg.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

		TableColumn<String, Void> colRes = new TableColumn<>("");
		colseg.setCellFactory(col -> new TableCell<>() {
			private final Button res = new Button("Res");
			{
				res.setOnAction(event -> {
					Reservation res = new Reservation(
							UUID.randomUUID(),
							LocalDateTime.now().toString(),
							StatutReservation.EN_ATTENTE
					);
					controleurAdmin.executerCommande(
							new AjouterReservationCommande( sujet, res )
					);
					Paiement.payer(res);
				});
			}
		}
		);

		table.getColumns().add(colseg);
		scrollPane.setContent(table);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		root.setCenter(scrollPane);
	}

	public void mettreAJour() {
		segmentVoyageList = sujet.getAllSegmentVoyage();
	}

	@Override
	public void start() {
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();
	}

}