/**
 *
 */
package controleur;

import java.io.Serializable;
import java.util.Date;

import modele.Livre;
import modele.Membre;

/**
 * @author Carl St-Louis
 *
 */
public class Pret implements Serializable {

	private int id;
	private Date dateEmprunt = new Date();
	private Date dateRetourPrevu = new Date();
	private Date dateRetour = new Date();
	private Livre livre = new Livre();
	private Membre membre = new Membre();

	public Pret() {

	}

	public Pret(int id, Date dateEmprunt, Date dateRetourPrevu, Livre livre,
			Membre membre) {
		this.id = id;
		this.dateEmprunt = dateEmprunt;
		this.dateRetourPrevu = dateRetourPrevu;
		this.livre = livre;
		this.membre = membre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetourPrevu() {
		return dateRetourPrevu;
	}

	public void setDateRetourPrevu(Date dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

}
