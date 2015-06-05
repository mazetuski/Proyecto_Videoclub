package Videoclub;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Videoclub.Videoclub;

/**
 * Clase Fichero.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 */
/**
 * Clase Fichero.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Fichero implements Serializable {
	public static File fichero = new File("Sin-titulo.obj");

	/**
	 * M&eacute;todo guardar que guarda un fichero.
	 * 
	 * @param file
	 *            Fichero que se guarda.
	 * @param videoclub
	 *            Objeto videoclub que se guarda en el fichero.
	 * @throws IOException
	 */
	public static void guardar(File file, Videoclub videoclub)
			throws IOException {
		file = annadirExtension(file);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			objectOutputStream.writeObject(videoclub);
		}
	}

	/**
	 * M&eacute;todo leer que abre un fichero.
	 *
	 * @param archivo
	 *            archivo que se abre.
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object leer(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				archivo))) {
			return (Object) ois.readObject();
		}
	}

	/**
	 * M&eacute;todo annadirExtension que a&nacute; la extensi&oacute;n .obj a
	 * un archivo en caso de no tenerla.
	 * 
	 * @param archivo
	 *            Fichero al que se le a&nacute;ade la extensi&oacute;n
	 * @return Devuelve el fichero.
	 */
	public static File annadirExtension(File archivo) {
		String extension = archivo.getPath();
		if (!extension.endsWith(".obj"))
			return new File(archivo + ".obj");
		return archivo;
	}

	/**
	 * M&eacute:todo confirmarSiExiste que devuelve True si el archivo existe.
	 * 
	 * @param archivo Fichero que se confirma si existe.
	 * @return
	 */
	public static boolean confirmarSiExiste(File archivo) {
		archivo = annadirExtension(archivo);
		return archivo.exists();
	}
}
