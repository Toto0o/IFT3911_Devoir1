package core.modele.commandes.reservation;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.reservations.Reservation;
import core.reservations.unites.UniteReservable;


public class AjouterReservationCommande implements Commande {


    private ModeleVoyage modele;
    private Reservation reservation;
    private UniteReservable uniteReservable;

    public AjouterReservationCommande(ModeleVoyage modele, Reservation reservation, UniteReservable unite) {
        this.modele = modele;
        this.reservation = reservation;
        this.uniteReservable = unite;
    }

    @Override
    public void executer() {
        this.modele.ajouterReservation(this.reservation);
        this.uniteReservable.reserver();
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
