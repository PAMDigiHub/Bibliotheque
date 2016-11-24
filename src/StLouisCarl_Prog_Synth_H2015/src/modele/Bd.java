/**
 *
 */
package modele;

import java.io.Serializable;

/**
 * @author Carl St-Louis
 *
 */
public class Bd extends Livre implements Serializable {

	private String dessinateur;

	public String getDessinateur() {
		return dessinateur;
	}

	public void setDessinateur(String dessinateur) {
		this.dessinateur = dessinateur;
	}

}
