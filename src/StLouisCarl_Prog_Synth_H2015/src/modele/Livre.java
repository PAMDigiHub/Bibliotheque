/**
 *
 */
package modele;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl St-Louis
 *
 */
public class Livre implements Serializable {

	private int id;
	private String isbn;
	private String titre;
	private Auteur auteur = new Auteur();
	private Editeur editeur = new Editeur();
	private Date dateParution = new Date();
	private int statut;
	private int nbrPages;

	public Livre() {

	}

	public Livre(int id, String isbn, String titre, Auteur auteur,
			Editeur editeur, Date dateParution, int statut, int nbrPages) {

		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.statut = statut;
		this.nbrPages = nbrPages;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getNbrPages() {
		return nbrPages;
	}

	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}

}
