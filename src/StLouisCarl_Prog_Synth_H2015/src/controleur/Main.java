package controleur;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import modele.Auteur;
import modele.Bd;
import modele.Dictionnaire;
import modele.Editeur;
import modele.Livre;
import modele.Membre;
import modele.Revue;
import modele.Roman;
import vue.Menu;

// FIXME
/**
 * @author Carl St-Louis
 *
 */
public class Main {

	/**
	 * Point d'entree de l'application Bibliotheque
	 *
	 * @param args
	 */

	public static void main(String[] args) {

		ArrayList<ArrayList<?>> mesObjets = new ArrayList<ArrayList<?>>();

		ArrayList<Pret> listPret = new ArrayList<Pret>();
		ArrayList<Reservation> listReservation = new ArrayList<Reservation>();
		ArrayList<Auteur> listAuteur = new ArrayList<Auteur>();
		ArrayList<Bd> listBd = new ArrayList<Bd>();
		ArrayList<Dictionnaire> listDictionnaire = new ArrayList<Dictionnaire>();
		ArrayList<Editeur> listEditeur = new ArrayList<Editeur>();
		ArrayList<Livre> listLivre = new ArrayList<Livre>();
		ArrayList<Membre> listMembre = new ArrayList<Membre>();
		ArrayList<Roman> listRoman = new ArrayList<Roman>();
		ArrayList<Revue> listRevue = new ArrayList<Revue>();

		Auteur auteur1 = new Auteur();
		Bd bd = new Bd();
		Dictionnaire dictionnaire = new Dictionnaire();
		Editeur editeur1 = new Editeur();
		Revue revue = new Revue();
		Roman roman = new Roman();

		listAuteur.add(auteur1);
		listBd.add(bd);
		listDictionnaire.add(dictionnaire);
		listEditeur.add(editeur1);
		listRevue.add(revue);
		listRoman.add(roman);

		Fichier.Ecriture(listAuteur);
		Fichier.Ecriture(listBd);
		Fichier.Ecriture(listDictionnaire);
		Fichier.Ecriture(listEditeur);
		Fichier.Ecriture(listRevue);
		Fichier.Ecriture(listRoman);

		int menuSelect = 0;
		String isbn;

		// lecture des fichiers de donnees au demarrage de l'application
		mesObjets = Fichier.OnLoad();

		// separer les arraylists par type d'objets
		for (int i = 0; i < mesObjets.size(); i++) {

			ArrayList<?> maListeObjets = new ArrayList();
			maListeObjets = mesObjets.get(i);

			switch (maListeObjets.get(0).getClass().getSimpleName()) {

			case "Pret":
				listPret = (ArrayList<Pret>) maListeObjets;
				break;
			case "Reservation":
				listReservation = (ArrayList<Reservation>) maListeObjets;
				break;
			case "Auteur":
				listAuteur = (ArrayList<Auteur>) maListeObjets;
				break;
			case "Bd":
				listBd = (ArrayList<Bd>) maListeObjets;
				break;
			case "Dictionnaire":
				listDictionnaire = (ArrayList<Dictionnaire>) maListeObjets;
				break;
			case "Editeur":
				listEditeur = (ArrayList<Editeur>) maListeObjets;
				break;
			case "Livre":
				listLivre = (ArrayList<Livre>) maListeObjets;
				break;
			case "Membre":
				listMembre = (ArrayList<Membre>) maListeObjets;
				break;
			case "Roman":
				listRoman = (ArrayList<Roman>) maListeObjets;
				break;
			case "Revue":
				listRevue = (ArrayList<Revue>) maListeObjets;
				break;
			default:
				break;
			} // fin switch ma liste d'objets
		} // fin for

		while (true) {
			Scanner scanner = new Scanner(System.in);
			int menuPrincipal = Menu.MenuPrincipal();
			switch (menuPrincipal) {

			case 1: // Debut Menu Membres
				int menuMembre = Menu.MenuMembre();
				do {
					switch (menuMembre) {

					case 1: // Ajouter un nouveau membre

						Membre addMembre = new Membre();

						addMembre.setId((int) (Math.random() * 1000));
						System.out.print("Entrez le nom du membre : ");
						addMembre.setNom(scanner.nextLine());
						System.out.print("Entrez le prenom du membre : ");
						addMembre.setPrenom(scanner.nextLine());
						System.out.print("Entrez l'adresse du membre : ");
						addMembre.setAdresse(scanner.nextLine());
						System.out.print("Entrez la ville du membre : ");
						addMembre.setVille(scanner.nextLine());
						System.out.print("Entrez le code postal du membre : ");
						addMembre.setCodePostal(scanner.nextLine());
						System.out
						.print("Entrez le numero de telephone du membre : ");
						addMembre.setTelephone(scanner.nextLine());
						addMembre.setStatut(0);

						listMembre.add(addMembre);
						Fichier.Ecriture(listMembre);
						menuMembre = Menu.MenuMembre();
						break;

					case 2: // ***** Debut Menu Supprimer un membre
						int menuMembreSupprimer = Menu.MenuMembreSupprimer();

						do {
							switch (menuMembreSupprimer) {

							case 1: // Supprimer un membre par numero de membre

								menuSelect = Menu.MenuMembreSupprimerId();
								boucle: for (Membre membre : listMembre) {
									if (membre.getId() == menuSelect) {
										listMembre.remove(membre);
										break boucle;
									}
								}
								Fichier.Ecriture(listMembre);
								menuMembreSupprimer = Menu
										.MenuMembreSupprimer();
								break;

							case 2: // Supprimer un membre Afficher liste

								menuSelect = Menu
								.MenuMembreSupprimerListe(listMembre);
								boucle: for (Membre membre : listMembre) {
									if (membre.getId() == menuSelect) {
										listMembre.remove(membre);
										break boucle;
									}
								}
								Fichier.Ecriture(listMembre);
								menuMembreSupprimer = Menu
										.MenuMembreSupprimer();
								break;

							case 3:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuMembreSupprimer
								break;

							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU MEMBRE - SUPPRIMER. \r\n");
								menuMembreSupprimer = Menu
										.MenuMembreSupprimer();
								break;
							}

						} while (menuMembreSupprimer != 3);
						menuMembre = Menu.MenuMembre();
						break; // Fin Menu Supprimer un membre

					case 3: // Debut Menu Modifier un membre

						int menuMembreModifier = Menu.MenuMembreModifier();
						do {
							switch (menuMembreModifier) {

							case 1: // Modifier un membre Par numero de ID

								menuSelect = Menu.MenuMembreModifierID();
								boucle: for (Membre membre : listMembre) {
									if (membre.getId() == menuSelect) {

										// System.out
										// .print("Entrez le nom du membre : ");
										// membre.setNom(scanner.nextLine());
										System.out
										.print("Entrez le prenom du membre : ");
										membre.setPrenom(scanner.nextLine());
										// System.out
										// .print("Entrez l'adresse du membre : ");
										// membre.setAdresse(scanner.nextLine());
										// System.out
										// .print("Entrez la ville du membre : ");
										// membre.setVille(scanner.nextLine());
										// System.out
										// .print("Entrez le code postal du membre : ");
										// membre.setCodePostal(scanner.nextLine());
										// System.out
										// .print("Entrez le numero de telephone du membre : ");
										// membre.setTelephone(scanner.nextLine());
										break boucle;
									}
								}
								Fichier.Ecriture(listMembre);
								menuMembreModifier = Menu.MenuMembreModifier();
								break;

							case 2: // Modifier un membre par Id liste

								menuSelect = Menu
								.MenuMembreModifierListe(listMembre);
								boucle: for (Membre membre : listMembre) {
									if (membre.getId() == menuSelect) {

										// System.out
										// .print("Entrez le nom du membre : ");
										// membre.setNom(scanner.nextLine());
										System.out
										.print("Entrez le prenom du membre : ");
										membre.setPrenom(scanner.nextLine());
										// System.out
										// .print("Entrez l'adresse du membre : ");
										// membre.setAdresse(scanner.nextLine());
										// System.out
										// .print("Entrez la ville du membre : ");
										// membre.setVille(scanner.nextLine());
										// System.out
										// .print("Entrez le code postal du membre : ");
										// membre.setCodePostal(scanner.nextLine());
										// System.out
										// .print("Entrez le numero de telephone du membre : ");
										// membre.setTelephone(scanner.nextLine());

										break boucle;
									}
								}
								Fichier.Ecriture(listMembre);
								menuMembreModifier = Menu.MenuMembreModifier();
								break;

							case 3:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuMembreModifier
								break;

							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU MEMBRE - MODIFIER. \r\n");
								menuMembreModifier = Menu.MenuMembreModifier();
								break;
							}
						} while (menuMembreModifier != 3);
						menuMembre = Menu.MenuMembre();
						break; // Fin Menu Modifier un membre

					case 4:
						// Aucune action ici, seulement pour sortir de
						// la boucle do - while menuMembre
						break;

					default:
						System.out
						.println("Votre choix est invalide, veuillez selectionner un item valide du MENU MEMBRES. \r\n");
						menuMembre = Menu.MenuMembre();
						break;
					}
				} while (menuMembre != 4);
				break; // Fin Menu Membres

			case 2: // Debut Menu Livres

				int menuLivre = Menu.MenuLivre();
				do {
					switch (menuLivre) {

					case 1: // Ajouter un livre

						Livre addLivre = new Livre();

						addLivre.setId((int) (Math.random() * 1000));
						System.out.print("Entrez le ISBN du livre : ");
						addLivre.setIsbn(scanner.nextLine());
						scanner.nextLine();
						System.out.print("Entrez le titre du livre : ");
						addLivre.setTitre(scanner.nextLine());
						Auteur auteur = new Auteur();
						addLivre.setAuteur(auteur);
						Editeur editeur = new Editeur();
						addLivre.setEditeur(editeur);
						Date dateParution = new Date();
						addLivre.setDateParution(dateParution);
						System.out
						.print("Entrez le nombre de page du livre : ");
						addLivre.setNbrPages(scanner.nextInt());
						addLivre.setStatut(0);

						listLivre.add(addLivre);
						Fichier.Ecriture(listLivre);
						menuLivre = Menu.MenuLivre();
						break;

					case 2: // debut menu supprimer un livre

						int menuLivreSupprimer = Menu.MenuLivreSupprimer();
						do {
							switch (menuLivreSupprimer) {

							case 1: // Supprimer un livre par ISBN

								isbn = Menu.MenuLivreSupprimerISBN();
								boucle: for (Livre liv : listLivre) {
									if (liv.getIsbn().equalsIgnoreCase(isbn)) {
										listLivre.remove(liv);
										break boucle;
									}
								}
								Fichier.Ecriture(listLivre);
								menuLivreSupprimer = Menu.MenuLivreSupprimer();
								break;

							case 2: // Supprimer un livre Afficher liste

								menuSelect = Menu
								.MenuLivreSupprimerListe(listLivre);
								boucle: for (Livre liv : listLivre) {
									if (liv.getId() == menuSelect) {
										listLivre.remove(liv);
										break boucle;
									}
								}
								Fichier.Ecriture(listLivre);
								menuLivreSupprimer = Menu.MenuLivreSupprimer();
								break;

							case 3:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuLivreSupprimer
								break;

							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU LIVRE - SUPPRIMER. \r\n");
								menuLivreSupprimer = Menu.MenuLivreSupprimer();
								break;
							}
						} while (menuLivreSupprimer != 3);
						menuLivre = Menu.MenuLivre();
						break; // fin menu supprimer un livre

					case 3: // debut menu modifier un livre

						int menuLivreModifier = Menu.MenuLivreModifier();
						do {
							switch (menuLivreModifier) {

							case 1: // Modifier un livre par numero ISBN

								isbn = Menu.MenuLivreModifierISBN();
								boucle: for (Livre liv : listLivre) {
									if (liv.getIsbn().equalsIgnoreCase(isbn)) {

										// System.out.print("Entrez le ISBN du livre : ");
										// liv.setIsbn(scanner.nextLine());
										scanner.nextLine();
										System.out
										.print("Entrez le titre du livre : ");
										liv.setTitre(scanner.nextLine());

										// System.out.print("Entrez l'auteur du livre : ");
										// liv.setAuteur(scanner.nextLine());

										// System.out.print("Entrez l'editeur du livre : ");
										// liv.setEditeur(scanner.nextLine());

										// System.out.print("Entrez la date de parution : ");
										// liv.setDateParution(scanner.nextLine());

										System.out
										.print("Entrez le statut du livre : ");
										liv.setStatut(scanner.nextInt());
										break boucle;
									}

								}
								Fichier.Ecriture(listLivre);
								menuLivreModifier = Menu.MenuLivreModifier();
								break;

							case 2: // Modifier un livre par ID de la liste

								menuSelect = Menu
								.MenuLivreModifierListe(listLivre);
								boucle: for (Livre liv : listLivre) {
									if (liv.getId() == menuSelect) {

										scanner.nextLine();
										System.out
										.print("Entrez le titre du livre : ");
										liv.setTitre(scanner.nextLine());
										System.out
										.print("Entrez le statut du livre : ");
										liv.setStatut(scanner.nextInt());
										break boucle;
									}

								}

								Fichier.Ecriture(listLivre);
								menuLivreModifier = Menu.MenuLivreModifier();
								break;

							case 3:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuLivreModifier
								break;

							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU LIVRE - MODIFIER. \r\n");
								menuLivreModifier = Menu.MenuLivreModifier();
								break;
							}
						} while (menuLivreModifier != 3);
						menuLivre = Menu.MenuLivre();
						break;

					case 4:
						// Aucune action ici, seulement pour sortir de
						// la boucle do - while menuLivre
						break;

					default:
						System.out
						.println("Votre choix est invalide, veuillez selectionner un item valide du MENU LIVRES. \r\n");
						menuLivre = Menu.MenuLivre();
						break;
					}
				} while (menuLivre != 4);

				break; // Fin Menu Livres

			case 3: // Debut Menu Reservation

				int menuReservation = Menu.MenuReservation();
				do {
					switch (menuReservation) {

					case 1: // Ajouter une reservation

						Livre livreRes = null;
						Membre membreRes = null;

						int id = (int) (Math.random() * 1000);
						Date dateReservation = new Date();
						Calendar cal = Calendar.getInstance();
						cal.setTime(dateReservation);
						cal.add(Calendar.DATE, 15); // ajouter 15 jours
						Date dateFinReservation = cal.getTime();

						// Selectionner le membre pour reservation
						int idMembreRes = Menu
								.MenuReservationAjouterMembre(listMembre);

						Membre: for (Membre membre : listMembre) {

							if (membre.getId() == idMembreRes) {
								membreRes = membre;
								break Membre;
							}
						}

						// Selectionner livre e reserver
						int idLivreRes = Menu
								.MenuReservationAjouterLivre(listLivre);

						Livre: for (Livre livre : listLivre) {
							if (livre.getId() == idLivreRes) {
								livre.setStatut(2);
								Fichier.Ecriture(listLivre);
								livreRes = livre;
								break Livre;
							}
						} // fin boucle for

						// Instancier une nouvelle reservation
						Reservation addRes = new Reservation(id,
								dateReservation, dateFinReservation, livreRes,
								membreRes);
						listReservation.add(addRes);
						Fichier.Ecriture(listReservation);
						menuReservation = Menu.MenuReservation();
						break;

					case 2: // Menu Supprimer une reservation
						int menuReservationSupprimer = Menu
						.MenuReservationSupprimer();
						do {
							switch (menuReservationSupprimer) {
							case 1:
								System.out
								.println("Supprimer par numero de reservation");
								menuReservationSupprimer = Menu
										.MenuReservationSupprimer();
								break;
							case 2: // Supprimer reservation par numero de
								// membre
								menuSelect = Menu
								.MenuReservationSupprimerNoMembre(listReservation);
								boucle: for (Reservation reservation : listReservation) {
									if (reservation.getMembre().getId() == menuSelect) {

										int suppRes = reservation.getLivre()
												.getId();

										Livre: for (Livre livre : listLivre) {
											if (livre.getId() == suppRes
													&& reservation.getLivre()
															.getStatut() == 2) {
												livre.setStatut(0);
												Fichier.Ecriture(listLivre);
												break Livre;
											}
										} // fin boucle for Livre

										listReservation.remove(reservation);
										break boucle;
									} // fin if

								} // fin boucle for Reservation
								Fichier.Ecriture(listReservation);
								menuReservationSupprimer = Menu
										.MenuReservationSupprimer();
								break;
							case 3:
								System.out
								.println("Supprimer une reservation - Afficher liste");
								menuReservationSupprimer = Menu
										.MenuReservationSupprimer();
								break;
							case 4:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuReservationSupprimer
								break;
							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU ReSERVATION - SUPPRIMER. \r\n");
								menuReservationSupprimer = Menu
										.MenuReservationSupprimer();
								break;
							}
						} while (menuReservationSupprimer != 4);
						menuReservation = Menu.MenuReservation();
						break;

					case 3: // Menu modifier une reservation
						int menuReservationModifier = Menu
						.MenuReservationModifier();
						do {
							switch (menuReservationModifier) {
							case 1: // Modifier reservation par numero de
								// reservation
								menuSelect = Menu
								.MenuReservationModifierNoRes(listReservation);
								boucle: for (Reservation res : listReservation) {
									if (res.getId() == menuSelect) {
										Date dateResMod = new Date();
										Calendar calMod = Calendar
												.getInstance();
										calMod.setTime(dateResMod);
										calMod.add(Calendar.DATE, 15);
										Date dateFinMod = calMod.getTime();
										res.setDateReservation(dateResMod);
										res.setDateFinReservation(dateFinMod);
										break boucle;
									}
								}
								Fichier.Ecriture(listReservation);
								System.out
								.println("La date de reservation a ete modifiee.");
								menuReservationModifier = Menu
										.MenuReservationModifier();
								break;
							case 2:
								System.out
								.println("Modifier par numero de membre");
								menuReservationModifier = Menu
										.MenuReservationModifier();
								break;
							case 3:
								System.out
								.println("Modifier une reservation - Afficher liste");
								for (Reservation res : listReservation) {
									System.out.println(res.getId() + "\t"
											+ res.getLivre().getTitre());
								}
								menuReservationModifier = Menu
										.MenuReservationModifier();
								break;
							case 4:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuReservationModifier
								break;
							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU ReSERVATION - MODIFIER. \r\n");
								menuReservationModifier = Menu
										.MenuReservationModifier();
								break;
							}
						} while (menuReservationModifier != 4);
						menuReservation = Menu.MenuReservation();
						break;

					case 4:
						// Aucune action ici, seulement pour sortir de
						// la boucle do - while menuReservation
						break;
					default:
						System.out
						.println("Votre choix est invalide, veuillez selectionner un item valide du MENU ReSERVATION. \r\n");
						menuReservation = Menu.MenuReservation();
						break;
					}
				} while (menuReservation != 4);

				break; // Fin Menu Reservation

			case 4: // Debut Menu Pret

				int menuPret = Menu.MenuPret();
				do {
					switch (menuPret) {
					case 1: // Ajouter un nouveau pret

						Livre livrePret = null;
						Membre membrePret = null;
						int idMembre = Menu.MenuPretAjouterMembre(listMembre);
						int idLivrePret = Menu.MenuPretAjouterLivre(listLivre);
						int disponible = 0;
						int nbrPret = 0;

						// Obtenir le statut du livre
						for (Livre livre : listLivre) {
							if (livre.getId() == idLivrePret) {
								disponible = livre.getStatut();
							}
						}

						switch (disponible) {

						case 0: // livre disponible

							// Verifier le nombre de livre emprunte par le
							// membre
							for (Pret pret : listPret) {
								if (pret.getMembre().getId() == idMembre) {
									nbrPret = nbrPret + 1;
								}
							}

							if (nbrPret < 5) {
								// changer statut du livre
								for (Livre livre : listLivre) {
									if (livre.getId() == idLivrePret) {
										livre.setStatut(1);
										Fichier.Ecriture(listLivre);
										livrePret = livre;
									}
								} // fin boucle for

								for (Membre membre : listMembre) {
									if (membre.getId() == idMembre) {
										membrePret = membre;
									}
								}

								int idPret = (int) (Math.random() * 1000);
								Date datePret = new Date();
								Calendar cal = Calendar.getInstance();
								cal.setTime(datePret);
								cal.add(Calendar.DATE, 21);
								Date dateRetourPrevu = cal.getTime();

								// Instancier un nouveau pret
								Pret pret = new Pret(idPret, datePret,
										dateRetourPrevu, livrePret, membrePret);
								listPret.add(pret);
								Fichier.Ecriture(listPret);
								System.out.println("Vous pouvez emprunter "
										+ (4 - nbrPret)
										+ " livre(s) avant la limite");

							} else {

								System.out
										.println("Vous avez atteint la limite de "
												+ nbrPret + " livres.");
							}

							menuPret = Menu.MenuPret();
							break;

						case 1: // Livre deje emprunte
							System.out
									.println("Livre non disponible, deje emprunte par un autre membre.");
							menuPret = Menu.MenuPret();
							break;

						case 2: // verifier si le livre est deje reserve
							boucle: for (Reservation res : listReservation) {

								if (res.getLivre().getId() == idLivrePret) {

									// Si reservation appartient a ce membre
									if (res.getMembre().getId() == idMembre) {
										res.getLivre().setStatut(0);
										listReservation.remove(res);
										Fichier.Ecriture(listLivre);
										Fichier.Ecriture(listReservation);
										System.out
												.println("Veuillez refaire le pret. ");
										break boucle;
									}

									else {
										System.out
										.println("Ce livre est deje reserve par le membre "
												+ res.getMembre()
												.getNom()
												+ " "
												+ res.getMembre()
												.getPrenom());
										menuPret = Menu.MenuPret();
									}
								}
							} // fin boucle for verifier reservation
							break;

						case 3:
							System.out
									.println("Livre non disponible, livre en preparation.");
							menuPret = Menu.MenuPret();
							break;

						case 4:
							System.out
									.println("Livre non disponible, livre perdu ou incertain.");
							menuPret = Menu.MenuPret();
							break;

						case 5:
							System.out
									.println("Livre non disponible, livre hors service.");
							menuPret = Menu.MenuPret();
							break;
						default:
							System.out
							.println("Le statut de ce livre n'est pas defini.");
							menuPret = Menu.MenuPret();
							break;

						} // fin switch disponible

						break;

					case 2: // Menu Supprimer un pret

						int menuPretSupprimer = Menu.MenuPretSupprimer();
						do {
							switch (menuPretSupprimer) {
							case 1:
								System.out
								.println("Supprimer par numero de pret");
								menuPretSupprimer = Menu.MenuPretSupprimer();
								break;

							case 2: // Supprimer un pret par numero de membre
								menuSelect = Menu
										.MenuPretSupprimerNoMembre(listPret);
								boucle: for (Pret pretS : listPret) {
									if (pretS.getMembre().getId() == menuSelect) {
										int suppPret = pretS.getLivre().getId();

										// Remettre statut du livre e 0
										Livre: for (Livre livre : listLivre) {
											if (livre.getId() == suppPret
													&& pretS.getLivre()
															.getStatut() == 1) {
												livre.setStatut(0);
												Fichier.Ecriture(listLivre);
												break Livre;
											}
										} // fin boucle for Livre

										listPret.remove(pretS);
										break boucle;
									}

								}

								Fichier.Ecriture(listPret);
								menuPretSupprimer = Menu.MenuPretSupprimer();
								break;
							case 3: // Supprimer un pret par la liste

								menuSelect = Menu
										.MenuPretSupprimerListe(listPret);
								boucle: for (Pret pretS : listPret) {

									if (pretS.getId() == menuSelect) {
										int suppPret = pretS.getLivre().getId();

										// Remettre statut du livre e 0
										Livre: for (Livre livre : listLivre) {
											if (livre.getId() == suppPret
													&& pretS.getLivre()
															.getStatut() == 1) {
												livre.setStatut(0);
												Fichier.Ecriture(listLivre);
												break Livre;
											}
										} // fin boucle for Livre

										listPret.remove(pretS);
										break boucle;
									}
								}

								Fichier.Ecriture(listPret);
								menuPretSupprimer = Menu.MenuPretSupprimer();
								break;
							case 4:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuPretSupprimer
								break;
							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU PReT - SUPPRIMER. \r\n");
								menuPretSupprimer = Menu.MenuPretSupprimer();
								break;
							}
						} while (menuPretSupprimer != 4);
						menuPret = Menu.MenuPret();
						break;

					case 3: // Menu Modifier un Pret

						int menuPretModifier = Menu.MenuPretModifier();
						do {
							switch (menuPretModifier) {

							case 1: // Modifier un pret par numero de ID livre
								menuSelect = Menu
								.MenuPretModifierNoLivre(listPret);
								for (Pret pretM : listPret) {
									if (pretM.getLivre().getId() == menuSelect) {
										Date date = new Date();
										pretM.setDateEmprunt(date);
									}

								}
								Fichier.Ecriture(listPret);
								menuPretModifier = Menu.MenuPretModifier();
								break;
							case 2:
								System.out
								.println("Modifier un pret par numero de membre");
								menuPretModifier = Menu.MenuPretModifier();
								break;
							case 3:
								System.out
								.println("Modifier un pret - Afficher liste");
								menuPretModifier = Menu.MenuPretModifier();
								break;
							case 4:
								// Aucune action ici, seulement pour sortir de
								// la boucle do - while menuPretModifier
								break;
							default:
								System.out
								.println("Votre choix est invalide, veuillez selectionner un item valide du MENU PReT - MODIFIER. \r\n");
								menuPretModifier = Menu.MenuPretModifier();
								break;
							}
						} while (menuPretModifier != 4);
						menuPret = Menu.MenuPret();
						break;

					case 4:
						// Aucune action ici, seulement pour sortir de
						// la boucle do - while menuPret
						break;
					default:
						System.out
						.println("Votre choix est invalide, veuillez selectionner un item valide du MENU PReT. \r\n");
						menuPret = Menu.MenuPret();
						break;
					}
				} while (menuPret != 4);

				break; // ************************* Fin Menu Pret

			case 5: // ************************* Quitter l'application
				System.out.println("Au revoir! \r\n");
				System.exit(0);
				break;
			default:
				System.out
				.println("Votre choix est invalide, veuillez selectionner un item valide du MENU BIBLIOTHeQUE. \r\n");
				break;

			}
		}
	}
}
