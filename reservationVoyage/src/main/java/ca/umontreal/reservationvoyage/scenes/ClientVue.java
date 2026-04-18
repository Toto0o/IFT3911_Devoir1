package ca.umontreal.reservationvoyage.scenes;

import core.modele.ModeleVoyage;
import core.voyage.SegmentVoyage;
import core.voyage.visiteurs.Visiteur;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ClientVue extends AppScene {

    private Visiteur visiteur;

    public ClientVue(ModeleVoyage modele, Visiteur visiteur) {
        super(modele);
        this.visiteur = visiteur;
    }

    @Override
    public void setScene() {
        VBox content = new VBox();
        root.setCenter(content);

        List<SegmentVoyage> voyages = new ArrayList<>();



    }
}
