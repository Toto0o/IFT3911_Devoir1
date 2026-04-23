package core.modele.commandes.reservation;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.reservations.Reservation;


public class AjouterReservationCommande implements Commande {


    private ModeleVoyage modele;
    private Reservation reservation;

    public AjouterReservationCommande(ModeleVoyage modele, Reservation reservation) {
        this.modele = modele;
        this.reservation = reservation;
    }

    @Override
    public void executer() {
        this.modele.ajouterReservation(this.reservation);
        modele.notifier();
    }

    @Override
    public void annuler() {
        this.modele.supprimerReservation(reservation);
        modele.notifier();
    }

    public String getDescription() {
        return "Ajouter une reservation";
    }
}
