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
public class Reservation implements Serializable {

	private int id;
	private Date dateReservation = new Date();
	private Date dateFinReservation = new Date();
	private Livre livre = new Livre();
	private Membre membre = new Membre();

	public Reservation() {

	}

	public Reservation(int id, Date dateReservation, Date dateFinReservation,
			Livre livre, Membre membre) {

		this.id = id;
		this.dateReservation = dateReservation;
		this.dateFinReservation = dateFinReservation;
		this.livre = livre;
		this.membre = membre;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDateFinReservation() {
		return dateFinReservation;
	}

	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
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
