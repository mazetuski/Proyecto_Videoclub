package Videoclub;

import java.util.Calendar;

/**
 * Clase Audio que hereda de Producto.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Audio extends Producto {
	/**
	 * Autor del audio.
	 */
	private String autor;
	private ContenidoAudio contenido;
	/**
	 * Dias que se alquila un audio.
	 */
	private Calendar diasAlquiler;

	/**
	 * Constructor de la clase Audio
	 * 
	 * @param codigo
	 *            C&oacute;digo del audio.
	 * @param nombre
	 *            Nombre del audio
	 * @param contenido
	 *            Contenido del audio
	 * @param tipo
	 *            Tipo del audio
	 * @param autor
	 *            Autor del Audio
	 * @throws NoEscritoException
	 */
	public Audio(String codigo, String nombre, ContenidoAudio contenido, int tipo,
			String autor) throws NoEscritoException {
		super(codigo, nombre, tipo);
		setAutor(autor);
		setContenido(contenido);
	}

	/**
	 * Constructor de la clase Audio
	 * 
	 * @param codigo
	 *            C&oacute;digo del audio.
	 * @param nombre
	 *            Nombre del audio
	 * @param contenido
	 *            Contenido del audio
	 * @param tipo
	 *            Tipo del audio
	 * @param diasAlquiler
	 *            Dias de alquiler del audio
	 * @param pAlquiler
	 *            precio de alquiler del audio
	 * @param autor
	 *            autor del audio
	 * @throws NoEscritoException
	 */
	public Audio(String codigo, String nombre, ContenidoAudio contenido, int tipo,
			Calendar diasAlquiler, int pAlquiler, String autor)
			throws NoEscritoException {
		super(codigo, nombre, tipo, pAlquiler);
		setAutor(autor);
		setDiasAlquiler(diasAlquiler);
		setContenido(contenido);
	}

	/**
	 * Constructor de la clase Audio
	 * 
	 * @param codigo
	 *            C&oacute;digo del audio.
	 */
	public Audio(String codigo) {
		super(codigo);
		setCodigo(codigo);
	}

	public Audio(String codigo, String nombre, ContenidoAudio contenido, int tipo)
			throws NoEscritoException {
		super(codigo, nombre, tipo);
		setContenido(contenido);
	}

	/**
	 * M&eacute;todo instanciarCD que instancia un audio en caso de ser
	 * v&aacute;lido.
	 * 
	 * @param codigo
	 *            C&oacute;digo del audio.
	 * @param nombre
	 *            Nombre del audio
	 * @param contenido
	 *            Contenido del audio
	 * @param tipo
	 *            Tipo del audio
	 * @param autor
	 *            Autor del Audio
	 * 
	 * @return Devuelve la creacion de un audio en caso de ser v&aacute;lido, en
	 *         caso contrario devuelve null
	 * @throws NoEscritoException
	 */
	public static Audio instanciarCD(String codigo, String nombre,
			ContenidoAudio contenido, int tipo, String autor)
			throws NoEscritoException {
		if (esValida(codigo) && (nombre != null) && (contenido != null)
				&& (autor != null)) {
			return new Audio(codigo, nombre, contenido, 1, autor);
		} else
			return null;
	}

	/**
	 * M&eacute;todo alquilarCD que alquilar un audio.
	 * 
	 * @param codigo
	 *            C&oacute;digo del audio.
	 * @param nombre
	 *            Nombre del audio
	 * @param contenido
	 *            Contenido del audio
	 * @param tipo
	 *            Tipo del audio
	 * @param diasAlquiler
	 *            Dias de alquiler del audio
	 * @param pAlquiler
	 *            precio de alquiler del audio
	 * @param autor
	 *            autor del audio
	 * 
	 * @return Devuelve la creaci&oacute;n de un audio
	 * @throws NoEscritoException
	 */
	public static Audio alquilarCD(String codigo, String nombre,
			ContenidoAudio contenido, int tipo, Calendar diasAlquiler,
			int pAlquiler, String autor) throws NoEscritoException {
		return new Audio(codigo, nombre, contenido, 1, diasAlquiler, pAlquiler,
				autor);
	}

	static Audio instanciarCD(String codigo) {
		if (esValida(codigo)) {
			return new Audio(codigo);
		} else
			return null;
	}

	/**
	 * M&eacute;todo get de Autor
	 * 
	 * @return Devuelve el autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * M&eacute;todo get de Autor.
	 * 
	 * @param autor
	 *            Autor del audio.
	 * @throws NoEscritoException
	 */
	public void setAutor(String autor) throws NoEscritoException {
		if (esValidaEscrito(autor))
			this.autor = autor;
		else
			throw new NoEscritoException("No has escrito el autor");
	}

	/**
	 * M&eacute;todo get de DiasAlquiler.
	 */
	public Calendar getDiasAlquiler() {
		return diasAlquiler;
	}

	/**
	 * M&eacute;todo set de Autor.
	 */
	public void setDiasAlquiler(Calendar diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

	public ContenidoAudio getContenido() {
		return contenido;
	}

	public void setContenido(ContenidoAudio contenido) {
		this.contenido = contenido;
	}
	

}
