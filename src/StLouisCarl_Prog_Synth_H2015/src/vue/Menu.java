/**
 *
 */
package vue;

import java.util.ArrayList;
import java.util.Scanner;

import modele.Livre;
import modele.Membre;
import controleur.Pret;
import controleur.Reservation;

/**
 * @author Carl St-Louis
 *
 */
public final class Menu {

	static int menuSelect = 0;
	static Scanner scanner = new Scanner(System.in);

	public static int MenuPrincipal() {
		System.out
		.println("******************** BIBLIOTHeQUE ********************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Membres                                        *");
		System.out
		.println("* 2 - Livres                                         *");
		System.out
		.println("* 3 - Reservation                                    *");
		System.out
		.println("* 4 - Pret                                           *");
		System.out
		.println("* 5 - Quitter                                        *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembre() {
		System.out
		.println("*********************** MEMBRES **********************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Ajouter un membre                              *");
		System.out
		.println("* 2 - Supprimer un membre                            *");
		System.out
		.println("* 3 - Modifier un membre                             *");
		System.out
		.println("* 4 - Retour au menu principal                       *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembreSupprimer() {
		System.out
		.println("***************** MEMBRES - SUPPRIMER ****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par numero de membre                           *");
		System.out
		.println("* 2 - Afficher liste des membres                     *");
		System.out
		.println("* 3 - Retour au menu Membres                         *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembreSupprimerId() {
		System.out.println("\r\nEntrez l'ID du membre e supprimer: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembreSupprimerListe(ArrayList<Membre> liste) {
		System.out
		.println("********** MEMBRE - SUPPRIMER - LISTE ****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("ID        NOM           PReNOM                       *");

		for (Membre membre : liste) {
			System.out.println(membre.getId() + "\t" + membre.getNom() + "\t"
					+ membre.getPrenom());
		}
		System.out.println("\r\nEntrez l'ID du membre e supprimer: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembreModifier() {
		System.out
		.println("***************** MEMBRES - MODIFIER *****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par numero de membre                           *");
		System.out
		.println("* 2 - Afficher liste des membres                     *");
		System.out
		.println("* 3 - Retour au menu Membres                         *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembreModifierID() {
		System.out
		.println("************* MEMBRES - MODIFIER - ID ****************");
		System.out
		.println("*                                                    *");
		System.out.println("Entrez l'ID du membre e modifier: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuMembreModifierListe(ArrayList<Membre> liste) {
		System.out
		.println("*********** MEMBRES - MODIFIER - LISTE ***************");
		System.out
		.println("*                                                    *");
		System.out
		.println("ID MEMBRE     NOM                PReNOM               ");
		for (Membre memb : liste) {
			System.out.println(memb.getId() + "\t" + memb.getNom() + "\t"
					+ memb.getPrenom());
		}
		System.out.println("\r\nEntrez l'ID du membre e modifier: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuLivre() {
		System.out
		.println("*********************** LIVRES ***********************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Ajouter un livre                               *");
		System.out
		.println("* 2 - Supprimer un livre                             *");
		System.out
		.println("* 3 - Modifier un livre                              *");
		System.out
		.println("* 4 - Retour au menu principal                       *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuLivreSupprimer() {
		System.out
		.println("***************** LIVRES - SUPPRIMER *****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par ISBN                                       *");
		System.out
		.println("* 2 - Afficher liste                                 *");
		System.out
		.println("* 3 - Retour au menu Livres                          *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static String MenuLivreSupprimerISBN() {
		System.out
		.println("************ LIVRE - SUPPRIMER - ISBN ****************");
		System.out
		.println("*                                                    *");
		System.out.println("Entrez l'ISBN du livre e supprimer: ");
		String isbn = scanner.next();

		return isbn;
	}

	public static int MenuLivreSupprimerListe(ArrayList<Livre> liste) {
		System.out
		.println("********** LIVRES - SUPPRIMER - LISTE ****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("ID        TITRE                                      *");
		for (Livre liv : liste) {
			System.out.println(liv.getId() + "\t" + liv.getTitre());
		}
		System.out.println("\r\nEntrez l'ID du livre e supprimer: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuLivreModifier() {
		System.out
		.println("***************** LIVRES - MODIFIER ******************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par ISBN                                       *");
		System.out
		.println("* 2 - Afficher liste                                 *");
		System.out
		.println("* 3 - Retour au menu Livres                          *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static String MenuLivreModifierISBN() {
		System.out
		.println("************ LIVRES - MODIFIER - ISBN ****************");
		System.out
		.println("*                                                    *");
		System.out.println("Entrez l'ISBN e modifier: ");
		String isbn = scanner.next();

		return isbn;
	}

	public static int MenuLivreModifierListe(ArrayList<Livre> liste) {
		System.out
		.println("************ LIVRES - MODIFIER - LISTE ***************");
		System.out
		.println("*                                                    *");
		System.out.println("ID       TITRE");
		for (Livre liv : liste) {
			System.out.println(liv.getId() + "\t" + liv.getTitre());
		}
		System.out.println("\r\nEntrez l'ID du livre e modifier: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuReservation() {
		System.out
		.println("********************* ReSERVATIONS *******************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Ajouter une reservation                        *");
		System.out
		.println("* 2 - Supprimer une reservation                      *");
		System.out
		.println("* 3 - Modifier une reservation                       *");
		System.out
		.println("* 4 - Retour au menu principal                       *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuReservationAjouterLivre(ArrayList<Livre> liste) {

		System.out.println("******** ReSERVATION - LIVRE ***********");
		System.out.println("*                                      *");
		System.out.println("ID LIVRE     TITRE");
		for (Livre livre : liste) {
			System.out.println(livre.getId() + "\t" + livre.getTitre());
		}
		System.out
				.println("\r\nEntrez l'ID du livre dont il faut creer la reservation: ");
		menuSelect = scanner.nextInt();
		return menuSelect;

	}

	public static int MenuReservationAjouterMembre(ArrayList<Membre> liste) {

		System.out.println("******** ReSERVATION - NO MEMBRE ***********");
		System.out.println("*                                          *");
		System.out.println("ID MEMBRE    NOM            PReNOM");
		for (Membre membre : liste) {
			System.out.println(membre.getId() + "\t" + membre.getNom() + "\t"
					+ membre.getPrenom());
		}
		System.out
				.println("\r\nEntrez l'ID du membre dont il faut creer la reservation: ");
		menuSelect = scanner.nextInt();
		return menuSelect;

	}

	public static int MenuReservationSupprimer() {
		System.out
		.println("*************** ReSERVATIONS - SUPPRIMER *************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par numero de reservation                      *");
		System.out
		.println("* 2 - Par numero de membre                           *");
		System.out
		.println("* 3 - Afficher liste                                 *");
		System.out
		.println("* 4 - Retour au menu Reservations                    *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuReservationSupprimerNoMembre(
			ArrayList<Reservation> liste) {
		System.out
		.println("****** ReSERVATIONS - SUPPRIMER - NO MEMBRE **********");
		System.out
		.println("*                                                    *");
		System.out
		.println("ID MEMBRE    NOM            PReNOM             ID ReS.");
		for (Reservation reservation : liste) {
			System.out.println(reservation.getMembre().getId() + "\t"
					+ reservation.getMembre().getNom() + "\t"
					+ reservation.getMembre().getPrenom() + "\t"
					+ reservation.getId());
		}
		System.out
		.println("\r\nEntrez l'ID du membre dont il faut supprimer la reservation: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuReservationModifier() {
		System.out
		.println("*************** ReSERVATIONS - MODIFIER **************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par numero de reservation                      *");
		System.out
		.println("* 2 - Par numero de membre                           *");
		System.out
		.println("* 3 - Afficher liste                                 *");
		System.out
		.println("* 4 - Retour au menu Reservations                    *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuReservationModifierNoRes(ArrayList<Reservation> liste) {
		System.out
		.println("****** ReSERVATIONS - MODIFIER - NO ReS **************");
		System.out
		.println("*                                                    *");
		for (Reservation res : liste) {
			System.out.println(res.getId() + "\t" + res.getLivre().getTitre());
		}
		System.out.println("Entrez le numero de reservation e modifier: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuPret() {
		System.out
		.println("************************* PReTS **********************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Ajouter un pret                                *");
		System.out
		.println("* 2 - Supprimer un pret                              *");
		System.out
		.println("* 3 - Modifier un pret                               *");
		System.out
		.println("* 4 - Retour au menu principal                       *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuPretAjouterLivre(ArrayList<Livre> liste) {

		System.out.println("********* PRET AJOUTER LIVRE ***********");
		System.out.println("*                                      *");
		System.out.println("ID LIVRE     TITRE");
		for (Livre livre : liste) {
			System.out.println(livre.getId() + "\t" + livre.getTitre());
		}
		System.out
				.println("\r\nEntrez l'ID du livre dont il faut ajouter au pret: ");
		menuSelect = scanner.nextInt();
		return menuSelect;

	}

	public static int MenuPretAjouterMembre(ArrayList<Membre> liste) {

		System.out.println("****** PReT - AJOUTER - NO MEMBRE **********");
		System.out.println("*                                          *");
		System.out.println("ID MEMBRE    NOM            PReNOM");
		for (Membre membre : liste) {
			System.out.println(membre.getId() + "\t" + membre.getNom() + "\t"
					+ membre.getPrenom());
		}
		System.out
				.println("\r\nEntrez l'ID du membre dont il faut creer le pret: ");
		menuSelect = scanner.nextInt();
		return menuSelect;

	}

	public static int MenuPretSupprimer() {
		System.out
		.println("******************* PReTS - SUPPRIMER ****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par numero de livre                            *");
		System.out
		.println("* 2 - Par numero de membre                           *");
		System.out
		.println("* 3 - Afficher la liste                              *");
		System.out
		.println("* 4 - Retour au menu Prets                           *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuPretSupprimerNoMembre(ArrayList<Pret> liste) {
		System.out
		.println("********* PReTS - SUPPRIMER - NO MEMBRE **************");
		System.out
		.println("*                                                    *");
		System.out
		.println("ID MEMBRE    NOM            PReNOM             ID PReT");
		for (Pret pret : liste) {
			System.out.println(pret.getMembre().getId() + "\t"
					+ pret.getMembre().getNom() + "\t"
					+ pret.getMembre().getPrenom() + "\t" + pret.getId());
		}
		System.out
		.println("\r\nEntrez l'ID du membre dont il faut supprimer le pret: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuPretSupprimerListe(ArrayList<Pret> liste) {
		System.out
		.println("********* PReTS - SUPPRIMER - PAR LISTE **************");
		System.out
		.println("*                                                    *");
		System.out
		.println("ID PReT    ID MEMBRE    NOM            PReNOM             ID LIVRE");
		for (Pret pret : liste) {
			System.out.println(pret.getId() + "\t" + pret.getMembre().getId()
					+ "\t" + pret.getMembre().getNom() + "\t"
					+ pret.getMembre().getPrenom() + "\t"
					+ pret.getLivre().getId());
		}
		System.out
		.println("\r\nEntrez l'ID du pret dont il faut supprimer le pret: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuPretModifier() {
		System.out
		.println("******************* PReTS - MODIFIER *****************");
		System.out
		.println("*                                                    *");
		System.out
		.println("* 1 - Par numero de livre                            *");
		System.out
		.println("* 2 - Par numero de membre                           *");
		System.out
		.println("* 3 - Afficher la liste                              *");
		System.out
		.println("* 4 - Retour au menu Prets                           *");
		System.out
		.println("*                                                    *");
		System.out
		.println("******************************************************");
		System.out.println("VOTRE CHOIX: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

	public static int MenuPretModifierNoLivre(ArrayList<Pret> liste) {
		System.out
		.println("********** PReTS - MODIFIER - NO LIVRE ***************");
		System.out
		.println("*                                                    *");
		System.out.println("ID LIVRE       TITRE                ID PReT");
		for (Pret pret : liste) {
			System.out.println(pret.getLivre().getId() + "\t"
					+ pret.getLivre().getTitre() + "\t" + pret.getId());
		}
		System.out
		.println("\r\nEntrez l'ID du livre dont il faut modifier le pret: ");
		menuSelect = scanner.nextInt();
		return menuSelect;
	}

}
