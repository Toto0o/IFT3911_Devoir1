package ca.umontreal.reservationvoyage;

import ca.umontreal.reservationvoyage.scenes.AppScene;
import ca.umontreal.reservationvoyage.scenes.ClientVue;
import core.modele.ModeleVoyage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class SystemReservation extends Application {

    public static void main(String[] args) {
        SystemReservation.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ModeleVoyage modele = new ModeleVoyage();
        try {
            Pane root = new Pane();
            Scene menu = new Scene(root);

            Button vueClient = new Button("Vue Client");
            vueClient.setOnAction(event -> {
                AppScene client = new ClientVue(modele);
                client.setScene();
                client.show();
            });

            Button vueAdmin = new Button("Vue Admin");
            vueAdmin.setOnAction(event -> {

            });

            primaryStage.setScene(menu);
            primaryStage.setTitle("Kijiji");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}