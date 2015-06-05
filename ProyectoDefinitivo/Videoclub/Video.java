package Videoclub;

import java.util.Calendar;

/**
 * Clase Video que hereda de Producto.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Video extends Producto {

	/**
	 * Director del video.
	 */
	private Director director;
	/**
	 * 
	 */
	private ContenidoVideo contenido;
	/**
	 * Dias que se alquila un video.
	 */
	private Calendar diasAlquiler;

	/**
	 * Constructor de la clase Video.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Video.
	 * @param nombre
	 *            Nombre del Video.
	 * @param contenido
	 *            Contenido del Video.
	 * @param tipo
	 *            Tipo del Video.
	 * @param director
	 *            Director del Video.
	 * @throws NoEscritoException
	 */
	public Video(String codigo, String nombre, ContenidoVideo contenido, int tipo,
			Director director) throws NoEscritoException {
		super(codigo, nombre, tipo);
		setDirector(director);
		setContenido(contenido);
	}

	/**
	 * /** Constructor de la clase Video
	 * 
	 * @param codigo
	 *            C&oacute;digo del Video.
	 */
	public Video(String codigo) {
		super(codigo);
		setCodigo(codigo);
	}

	/**
	 * Constructor de la clase Video.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Video.
	 * @param nombre
	 *            Nombre del Video.
	 * @param contenido
	 *            Contenido del Video.
	 * @param tipo
	 *            Tipo del Video.
	 * @throws NoEscritoException
	 */
	public Video(String codigo, String nombre, ContenidoVideo contenido, int tipo)
			throws NoEscritoException {
		super(codigo, nombre, tipo);
		setContenido(contenido);
	}

	/**
	 * Constructor de la clase Video.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Video.
	 * @param nombre
	 *            Nombre del Video.
	 * @param contenido
	 *            Contenido del Video.
	 * @param tipo
	 *            Tipo del Video.
	 * @param diasAlquiler
	 *            Dias de alquiler del Video.
	 * @param pAlquiler
	 *            precio de alquiler del Video.
	 * @param director
	 *            Director del video.
	 * @throws NoEscritoException
	 */
	public Video(String codigo, String nombre, ContenidoVideo contenido, int tipo,
			Calendar diasAlquiler, int pAlquiler, Director director)
			throws NoEscritoException {
		super(codigo, nombre, tipo, pAlquiler);
		setDirector(director);
		setDiasAlquiler(diasAlquiler);
		setContenido(contenido);
	}

	/**
	 * M6eacute;todo instanciarDVD que instancia un video en caso de ser
	 * v&aacute;lido.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Video.
	 * @param nombre
	 *            Nombre del Video.
	 * @param contenido
	 *            Contenido del Video.
	 * @param tipo
	 *            Tipo del Video.
	 * @param director
	 *            Director del Video.
	 * @return Devuelve la creaci&oacuten; del video si es valido, en caso
	 *         contrario devuelve null.
	 * @throws NoEscritoException
	 */
	public static Video instanciarDVD(String codigo, String nombre,
			ContenidoVideo contenido, int tipo, Director director)
			throws NoEscritoException {
		if (esValida(codigo) && (nombre != null) && (contenido != null)
				&& (director != null)) {
			return new Video(codigo, nombre, contenido, 2, director);
		} else
			return null;
	}

	static Video instanciarDVD(String codigo) {
		if (esValida(codigo)) {
			return new Video(codigo);
		} else
			return null;
	}

	/**
	 * M6eacute;todo alquilarVideo que alquila un Video.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Video.
	 * @param nombre
	 *            Nombre del Video.
	 * @param contenido
	 *            Contenido del Video.
	 * @param tipo
	 *            Tipo del Video.
	 * @param diasAlquiler
	 *            Dias de alquiler del Video.
	 * @param pAlquiler
	 *            precio de alquiler del Video.
	 * @param director
	 *            Director del Video.
	 * @return Devuelve la creaci&oacute;n del Video.
	 * @throws NoEscritoException
	 */
	public static Video alquilarVideo(String codigo, String nombre,
			ContenidoVideo contenido, int tipo, Calendar diasAlquiler,
			int pAlquiler, Director director) throws NoEscritoException {
		return new Video(codigo, nombre, contenido, 2, diasAlquiler, pAlquiler,
				director);
	}

	/**
	 * M6eacute;todo get del Director.
	 * 
	 * @return Devuelve el Director.
	 */
	public Director getDirector() {
		return director;
	}
	

	public ContenidoVideo getContenido() {
		return contenido;
	}

	public void setContenido(ContenidoVideo contenido) {
		this.contenido = contenido;
	}

	/**
	 * M6eacute;todo set del Director.
	 * 
	 * @param director
	 *            El director.
	 */
	public void setDirector(Director director) {
		this.director = director;
	}
	
	/**
	 * M6eacute;todo get de Dias de Alquiler.
	 * 
	 * @return Devuelve dias de alquiler.
	 */
	public Calendar getDiasAlquiler() {
		return diasAlquiler;
	}

	/**
	 * M6eacute;todo set de Dias de Alquiler.
	 */
	public void setDiasAlquiler(Calendar diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

}
