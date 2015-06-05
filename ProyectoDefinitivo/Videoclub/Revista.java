package Videoclub;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Clase Revista.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Revista extends Producto {

	/**
	 * Tema de la revista.
	 */
	private TituloRevista temaRevista;
	private ContenidoRevista contenido;
	/**
	 * C&oacute;digo de compra de la revista.
	 */
	private String compra;
	/**
	 * Paternn del C&oacute;digo de compra.
	 */
	static final private Pattern patternCompra = Pattern
			.compile("^[A-Z]{4}[0-9][X-Z]");

	/**
	 * Constructor de la clase Revista.
	 * 
	 * @param codigo
	 *            C&oacute;digo del revista.
	 * @param nombre
	 *            Nombre del revista.
	 * @param contenido
	 *            Contenido del revista.
	 * @param tipo
	 *            Tipo del revista.
	 * @param revista
	 *            Titulo de la revista.
	 * @param compra
	 *            C&oacute;digo de compra.
	 * @throws NoEscritoException
	 */
	public Revista(String codigo, String nombre, ContenidoRevista contenido, int tipo,
			TituloRevista revista, String compra) throws NoEscritoException {
		super(codigo, nombre, tipo);
		setTemaRevista(revista);
		setCompra(compra);
		setContenido(contenido);
	}

	/**
	 * Constructor de la clase Revista.
	 * 
	 * @param codigo
	 *            C&oacute;digo del audio.
	 */
	public Revista(String codigo) {
		super(codigo);
		setCodigo(codigo);
	}

	/**
	 * Constructor de la clase Revista.
	 * 
	 * @param codigo
	 *            C&oacute;digo del revista.
	 * @param nombre
	 *            Nombre del revista.
	 * @param contenido
	 *            Contenido del revista.
	 * @param tipo
	 *            Tipo del revista.
	 * @param pAlquiler
	 *            Precio de compra de la revista.
	 * @param temaRevista
	 *            Tema de la revista.
	 * @param compra
	 *            C&oacute;digo de compra.
	 * @throws NoEscritoException
	 */
	public Revista(String codigo, String nombre, ContenidoRevista contenido, int tipo,
			int pAlquiler, TituloRevista temaRevista, String compra)
			throws NoEscritoException {
		super(codigo, nombre, tipo, pAlquiler);
		setTemaRevista(temaRevista);
		setCompra(compra);
		setContenido(contenido);
	}

	/**
	 * M&eacute;todo instanciarRevista que instancia una revista.
	 * 
	 * @param codigo
	 *            C&oacute;digo del revista.
	 * @param nombre
	 *            Nombre del revista.
	 * @param contenido
	 *            Contenido del revista.
	 * @param tipo
	 *            Tipo del revista.
	 * @param revista
	 *            Titulo de la revista
	 * @param compra
	 *            C&oacute;digo de la revista.
	 * @return Devuelve la creaci&oacute;n de la revista si es valida y sino
	 *         devuelve null.
	 * @throws NoEscritoException
	 */
	public static Revista instanciarRevista(String codigo, String nombre,
			ContenidoRevista contenido, int tipo, TituloRevista revista, String compra)
			throws NoEscritoException {
		if (esValida(codigo) && compraValida(compra)) {
			return new Revista(codigo, nombre, contenido, 4, revista, compra);
		} else
			return null;
	}

	static Revista instanciarRevista(String codigo, String compra) {
		if (esValida(codigo) && compraValida(compra)) {
			return new Revista(codigo);
		} else
			return null;
	}

	/**
	 * M&eacute;todo comprarRevista.
	 * 
	 * @param codigo
	 *            C&oacute;digo del revista.
	 * @param nombre
	 *            Nombre del revista.
	 * @param contenido
	 *            Contenido del revista.
	 * @param tipo
	 *            Tipo del revista.
	 * @param pAlquiler
	 *            Precio de compra de la revista.
	 * @param temaRevista
	 *            Tema de la revista.
	 * @param compra
	 *            C&oacute;digo de compra.
	 * @return Devuelve la creaci&oacute;n de la revista si es valida y sino
	 *         devuelve null.
	 * @throws NoEscritoException
	 */
	public static Revista comprarRevista(String codigo, String nombre,
			ContenidoRevista contenido, int tipo, int pAlquiler,
			TituloRevista temaRevista, String compra) throws NoEscritoException {
		if (esValida(codigo) && compraValida(compra)) {
			return new Revista(codigo, nombre, contenido, 4, pAlquiler,
					temaRevista, compra);
		} else
			return null;
	}

	/**
	 * M&eacute;todo get de TemaRevista.
	 * 
	 * @return Devuelve Tema de la revista.
	 */
	public TituloRevista getTemaRevista() {
		return temaRevista;
	}

	/**
	 * M&eacute;todo set de TemaRevista.
	 * 
	 * @param temaRevista
	 *            Tema de la revista.
	 */
	public void setTemaRevista(TituloRevista temaRevista) {
		this.temaRevista = temaRevista;
	}

	/**
	 * M&eacute;todo CompraValida que comprueba si el C&oacute;digo de la compra
	 * es valido.
	 * 
	 * @param compra
	 *            C&oacute;digo de la compra.
	 * @return
	 */
	public static boolean compraValida(String compra) {
		return patternCompra.matcher(compra).matches();
	}

	/**
	 * M&eacute;todo get de Compra.
	 * 
	 * @return Devuelve la compra.
	 */
	public String getCompra() {
		return compra;
	}

	/**
	 * M&eacute;todo set de Compra.
	 * 
	 * @param compra
	 *            La compra.
	 */
	public void setCompra(String compra) {
		this.compra = compra;
	}

	public ContenidoRevista getContenido() {
		return contenido;
	}

	public void setContenido(ContenidoRevista contenido) {
		this.contenido = contenido;
	}
	

}
