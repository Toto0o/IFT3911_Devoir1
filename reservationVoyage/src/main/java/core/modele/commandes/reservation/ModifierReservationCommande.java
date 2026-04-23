package core.modele.commandes.reservation;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.reservations.Reservation;


public class ModifierReservationCommande implements Commande {


    private ModeleVoyage modele;
    private Reservation ancienneReservation;
    private Reservation nouvelleReservation;

    public ModifierReservationCommande(ModeleVoyage modele, Reservation ancienneReservation, Reservation nouvelleReservation) {
        this.modele = modele;
        this.ancienneReservation = ancienneReservation;
        this.nouvelleReservation = nouvelleReservation;
    }

    @Override
    public void executer() {
        this.modele.supprimerReservation(ancienneReservation);
        this.modele.ajouterReservation(nouvelleReservation);
        modele.notifier();
    }

    @Override
    public void annuler() {
        modele.ajouterReservation(ancienneReservation);
        modele.supprimerReservation(nouvelleReservation);
        modele.notifier();
    }

    public String getDescription() {
        return "Modifier une reservation";
    }
}
