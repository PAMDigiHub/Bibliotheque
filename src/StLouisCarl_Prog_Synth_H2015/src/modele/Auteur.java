/**
 *
 */
package modele;

import java.io.Serializable;

/**
 * @author Carl St-Louis
 *
 */
public class Auteur implements Serializable {

	private int id;
	private String nom;
	private String prenom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
