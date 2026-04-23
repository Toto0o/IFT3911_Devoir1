module reservationVoyage {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    exports reservationVoyage;
    exports core.modele;
    exports core.modele.commandes;
    exports core.modele.commandes.reservation;
    exports core.modele.commandes.segments;
    exports core.modele.fabriques;
    exports core.prix;
    exports core.reservations;
    exports core.reservations.unites;
    exports core.reservations.unites.etats;
    exports core.voyage;
    exports core.voyage.composantsVoyage;
    exports core.voyage.terminaux;
    exports core.voyage.vehicules;
    exports core.voyage.visiteurs;
    exports core.vues;

    opens reservationVoyage to javafx.fxml;
    opens core.vues to javafx.fxml;
}