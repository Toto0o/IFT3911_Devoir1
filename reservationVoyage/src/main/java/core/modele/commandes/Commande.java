package core.modele.commandes;

public interface Commande {

	void executer();

	void annuler();

	String getDescription();

}