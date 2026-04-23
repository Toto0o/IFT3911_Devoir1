package core.vues;

import core.modele.ControleurAdmin;
import core.modele.ModeleVoyage;
import core.modele.commandes.reservation.SupprimerReservationCommande;
import core.modele.fabriques.FabriqueVoyage;
import core.modele.fabriques.RegistreFabrique;
import core.reservations.Reservation;
import core.reservations.StatutReservation;
import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Vehicule;
import core.voyage.visiteurs.VisiteurAdmin;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VueAdministrateur implements Observateur {

	private ModeleVoyage sujet;
	private BorderPane root;
	private Stage stage;

	private List<Reservation> reservations;
	private List<SegmentVoyage> segmentVoyages;

	private VisiteurAdmin visiteurAdmin;

	private ControleurAdmin controleurAdmin;

	private char state;

	public VueAdministrateur(ModeleVoyage sujet, ControleurAdmin controleurAdmin) {
		this.sujet = sujet;
		root = new BorderPane();
		stage = new Stage();
		stage.setMaximized(true);
		sujet.attacher(this);
		reservations = sujet.getAllReservation();
		segmentVoyages = sujet.getAllSegmentVoyage();

		this.controleurAdmin = controleurAdmin;

		HBox header = new HBox();
		Button segsBtn = new Button("Afficher voyage");
		segsBtn.setOnAction(e -> {
			afficherTousSegements();
		});
		header.getChildren().add(segsBtn);
		Button resBtn = new Button("Afficher reservation");
		resBtn.setOnAction(e -> {
			afficherTousReservations();
		});
		header.getChildren().add(resBtn);
		root.setTop(header);
		header.setSpacing(10);
	}

	public void afficherTousSegements() {
		state = 's';
		ScrollPane scrollPane = new ScrollPane();
		List<String> segmentsToString = new ArrayList<>();
		for (SegmentVoyage segmentVoyage : segmentVoyages) {
			visiteurAdmin = new VisiteurAdmin();
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


		Button newBtn = new Button("Nouveaux Segment");
		root.setTop(newBtn);
		newBtn.setOnAction(e -> {
			Stage stage = new Stage();
			VBox vbox = new VBox();
			BorderPane root = new BorderPane(vbox);
			Scene scene = new Scene(root, 400, 600);
			stage.setScene(scene);
			stage.setTitle("Nouvelle reservation");


			Label ltype = new Label("Type de voyage (bateau, train, avion)");
			ChoiceBox<String> choiceBox = new ChoiceBox<>();
			choiceBox.getItems().addAll(
					"bateau", "train", "avion"
			);
			vbox.getChildren().addAll(new VBox(ltype, choiceBox));

			Label lcode = new Label("Code");
			TextField tcode = new TextField();
			tcode.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lcode, tcode));

			Label lcompagnie = new Label("Compagnie");
			TextField tcompagnie = new TextField();
			tcompagnie.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lcompagnie, tcompagnie));

			Label lcodeTerminalO = new Label("Code Terminal Origine");
			TextField tcodeTerminalO = new TextField();
			tcodeTerminalO.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lcodeTerminalO, tcodeTerminalO));

			Label lvilleTerminalO = new Label("Ville Terminal Origine");
			TextField tvilleTerminalO = new TextField();
			tvilleTerminalO.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lvilleTerminalO, tvilleTerminalO));

			Label lcodeTerminalD = new Label("Code Terminal Destination");
			TextField tcodeTerminalD = new TextField();
			tcodeTerminalD.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lcodeTerminalD, tcodeTerminalD));

			Label lvilleTerminalD = new Label("Ville Terminal Destination");
			TextField tvilleTerminalD = new TextField();
			tvilleTerminalD.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lvilleTerminalD, tvilleTerminalD));

			Label lvehiculeMod = new Label("Modele Vehicule");
			TextField tvehiculeMod = new TextField();
			tvehiculeMod.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lvehiculeMod, tvehiculeMod));

			Label lvehiculeCap = new Label("Vehicule Capacite");
			TextField tvehiculeCap = new TextField();
			tvehiculeCap.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lvehiculeCap, tvehiculeCap));

			Label lheureDepart = new Label("Heure depart (HH:mm)");
			TextField theureDepart = new TextField();
			theureDepart.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lheureDepart, theureDepart));

			Label lheureArrive = new Label("Heure arrive (HH:mm)");
			TextField theureArrive = new TextField();
			theureArrive.setMaxWidth(200);
			vbox.getChildren().add(new VBox(lheureArrive, theureArrive));

			Label ldateDepart = new Label("Date depart (AAAA.MM.JJ)");
			TextField theDateDepart = new TextField();
			theDateDepart.setMaxWidth(200);
			vbox.getChildren().add(new VBox(ldateDepart, theDateDepart));

			Label ldateArrive = new Label("Date arrive (AAAA.MM.JJ)");
			TextField theDateArrive = new TextField();
			theDateArrive.setMaxWidth(200);
			vbox.getChildren().add(new VBox(ldateArrive, theDateArrive));

			Button createBtn = new Button("Creer");
			createBtn.setOnAction(ev -> {
				FabriqueVoyage fabrique = RegistreFabrique.getInstance().obtenirFabrique(
					choiceBox.getValue()
				);
				Terminal origine = fabrique.creerTerminal(
						tcodeTerminalO.getText().trim(),
						tvilleTerminalO.getText().trim()
				);
				Terminal destination = fabrique.creerTerminal(
						tcodeTerminalD.getText().trim(),
						tvilleTerminalD.getText().trim()
				);
				Vehicule vehicule = fabrique.creerVehicule(
						tvehiculeMod.getText().trim(),
						Integer.parseInt(tvehiculeCap.getText().trim())
				);
				SegmentVoyage segement = fabrique.creerSegementVoyage(
						tcode.getText().trim(),
						tcompagnie.getText().trim(),
						origine,
						destination,
						vehicule,
						theureDepart.getText().trim(),
						theureArrive.getText().trim(),
						theDateDepart.getText().trim(),
						theDateArrive.getText().trim()
				);
				sujet.ajouterSegment(segement);
				sujet.notifier();
				afficherTousSegements();
				stage.close();
			});
			vbox.getChildren().add(createBtn);
			stage.show();
		});

	}

	public void afficherTousReservations() {
		state = 'r';
		ScrollPane scrollPane = new ScrollPane();

		TableView<Reservation> table = new TableView<>();
		table.getItems().addAll(reservations);

		TableColumn<Reservation, UUID> colreservation = new TableColumn<>("Reservation");
		colreservation.setCellValueFactory(new PropertyValueFactory<>("numero"));

		TableColumn<Reservation, String> coldate = new TableColumn<>("Date");
		coldate.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

		TableColumn<Reservation, StatutReservation> colstatus = new TableColumn<>("Status");
		colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));

		TableColumn<Reservation, Void> del = new TableColumn<>();

		del.setCellFactory(col -> new TableCell<>() {
			private final Button delete = new Button("Delete");

			{
				delete.setOnAction(event -> {
					Reservation reservation = table.getSelectionModel().getSelectedItem();
					controleurAdmin.executerCommande(
							new SupprimerReservationCommande(sujet, reservation)
					);
				});

			}

			@Override
			protected void updateItem(Void item, boolean empty) {
				super.updateItem(item, empty);

				if (empty) {
					setGraphic(null);
				} else {
					setGraphic(delete);
				}
			}
		});

		table.getColumns().addAll(colreservation,coldate,colstatus, del);
		scrollPane.setContent(table);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		root.setCenter(scrollPane);
	}

	@Override
	public void mettreAJour() {
		reservations = sujet.getAllReservation();
		segmentVoyages = sujet.getAllSegmentVoyage();
		if (state == 'r') {
			afficherTousReservations();
		} else if (state == 's') {
			afficherTousSegements();
		}
	}

	@Override
	public void start() {
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Vue Administrateur");
		stage.show();
	}
}