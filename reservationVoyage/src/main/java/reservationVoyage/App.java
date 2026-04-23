package reservationVoyage;

import core.modele.ControleurAdmin;
import core.modele.ModeleVoyage;
import core.vues.VueAdministrateur;
import core.vues.VueClient;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        ModeleVoyage modele = new ModeleVoyage();
        ControleurAdmin controleur = new ControleurAdmin(modele);

        VBox vbox = new VBox();
        Button client = new Button("Vue Client");
        client.setOnAction(e -> {
            VueClient vueClient = new VueClient(modele, controleur);
            modele.attacher(vueClient);
            vueClient.start();
        });

        Button admin = new Button("Vue Admin");
        admin.setOnAction(e -> {
            VueAdministrateur vueAdministrateur = new VueAdministrateur(modele, controleur);
            modele.attacher(vueAdministrateur);
            vueAdministrateur.start();
        });
        vbox.getChildren().addAll(client, admin);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Réservation de voyage");
        primaryStage.show();
    }


}
