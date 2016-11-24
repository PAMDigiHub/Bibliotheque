/**
 *
 */
package controleur;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.util.ArrayList;

/**
 * 
 * @author ycourteau
 *
 */
public final class Fichier {

	private static String sep = FileSystems.getDefault().getSeparator();
	private static String path = System.getProperty("user.home") + sep
			+ "BibliothequeTP";

	/**
	 * 
	 * @return
	 */
	public static ArrayList<ArrayList<?>> OnLoad() {

		ObjectInputStream ois;
		ArrayList<ArrayList<?>> al = new ArrayList<ArrayList<?>>();

		// lister les fichiers du repertoire
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		// pour chaque fichier
		for (int i = 0; i < listOfFiles.length; i++) {

			File file = listOfFiles[i];

			if (file.isFile() && file.getName().endsWith(".txt")) {

				try {

					ois = new ObjectInputStream(new BufferedInputStream(
							new FileInputStream(file)));
					Object obj;

					// lire le contenu de (arraylist d'objets)
					obj = ois.readObject();

					al.add((ArrayList<?>) obj); // ajouter l'arraylist dans une
					// arraylist
					ois.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} // fin if
		} // fin for
		return al;
	} // ******************* fin fonction OnLoad

	public static void Ecriture(ArrayList<?> listeObj) {
		String type = listeObj.get(0).getClass().getSimpleName();

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(new File(path + sep + type + ".txt"))));
			oos.writeObject(listeObj);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // ******************* fin fonction Ecriture
}
