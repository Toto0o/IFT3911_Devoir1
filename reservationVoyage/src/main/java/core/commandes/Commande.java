package core.commandes;

public interface Commande {

	void executer();

	void annuler();

	string getDescription();

}