package core.vues;

import core.modele.ControleurAdmin;
import core.modele.ModeleVoyage;
import core.modele.Sujet;
import core.reservations.Reservation;
import core.voyage.SegmentVoyage;
import core.voyage.visiteurs.Visiteur;
import core.voyage.visiteurs.VisiteurAdmin;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VueAdministrateur implements Observateur {

	private ModeleVoyage sujet;
	private BorderPane root;
	private Stage stage;

	private List<Reservation> reservations;
	private List<SegmentVoyage> segmentVoyages;

	private VisiteurAdmin visiteurAdmin;

	private ControleurAdmin controleurAdmin;

	public VueAdministrateur(ModeleVoyage sujet, ControleurAdmin controleurAdmin) {
		this.sujet = sujet;
		root = new BorderPane();
		stage = new Stage();
		sujet.attacher(this);
		reservations = sujet.getAllReservation();
		segmentVoyages = sujet.getAllSegmentVoyage();

		visiteurAdmin = new VisiteurAdmin();

		this.controleurAdmin = controleurAdmin;
	}

	public void afficherInfosAdmin() {
		// TODO - implement modele.vues.VueAdministrateur.afficherInfosAdmin
		throw new UnsupportedOperationException();
	}

	public void afficherTousSegements() {
		ScrollPane scrollPane = new ScrollPane();
		List<String> segmentsToString = new ArrayList<>();
		for (SegmentVoyage segmentVoyage : segmentVoyages) {
			visiteurAdmin.visiter(segmentVoyage);
			segmentsToString.add(visiteurAdmin.obtenirAffichage());
		}

		TableView<String> table = new TableView<>();
		table.getItems().addAll(segmentsToString);

		TableColumn<String, String> colseg = new TableColumn<>("Segments de voyages");
		colseg.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

		table.getColumns().add(colseg);
		scrollPane.setContent(table);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		root.setCenter(scrollPane);

	}

	public void afficherTousReservations() {
		// TODO - implement modele.vues.VueAdministrateur.afficherTousReservations
		throw new UnsupportedOperationException();
	}

	public void rafraichir() {
		// TODO - implement modele.vues.VueAdministrateur.rafraichir
		throw new UnsupportedOperationException();
	}

	@Override
	public void mettreAJour() {

	}

	@Override
	public void start() {
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Vue Administrateur");
		stage.show();
	}
}