/**
 *
 */
package modele;

import java.io.Serializable;

/**
 * @author Carl St-Louis
 *
 */
public class Roman extends Livre implements Serializable {

	private String illustrateur;

	public String getIllustrateur() {
		return illustrateur;
	}

	public void setIllustrateur(String illustrateur) {
		this.illustrateur = illustrateur;
	}

}
