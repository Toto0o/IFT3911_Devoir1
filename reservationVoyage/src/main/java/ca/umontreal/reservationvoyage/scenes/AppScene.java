package ca.umontreal.reservationvoyage.scenes;

import core.modele.ModeleVoyage;
import core.vues.Observateur;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class AppScene {

    protected Observateur observateur;
    protected BorderPane root;
    protected Scene scene;
    protected Stage stage;

    public AppScene(Observateur observateur) {
        this.observateur = observateur;
        root = new BorderPane();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
    }

    public abstract void setScene();

    public Stage getStage() {
        return stage;
    }

    public void show() {
        stage.show();
    }
}
