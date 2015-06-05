package Videoclub;

import java.util.Calendar;

/**
 * Clase Videojuego
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Videojuego extends Producto {

	/**
	 * Empresa del videojuego.
	 */
	private Empresa empresa;
	private ContenidoVideojuego contenido;
	/**
	 * Dias que se alquila el videojuego.
	 */
	private Calendar diasAlquiler;

	/**
	 * Constructor de la clase Videojuego.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Videojuego.
	 * @param nombre
	 *            Nombre del Videojuego.
	 * @param contenido
	 *            Contenido del Videojuego.
	 * @param tipo
	 *            Tipo del Videojuego.
	 * @param empresa
	 *            Empresa del Videojuego.
	 * @throws NoEscritoException
	 */
	public Videojuego(String codigo, String nombre, ContenidoVideojuego contenido,
			int tipo, Empresa empresa) throws NoEscritoException {
		super(codigo, nombre, tipo);
		setEmpresa(empresa);
		setContenido(contenido);
	}

	Videojuego(String codigo) {
		super(codigo);
		setCodigo(codigo);
	}

	/**
	 * Constructor de la clase Videojuego.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Videojuego.
	 * @param nombre
	 *            Nombre del Videojuego.
	 * @param contenido
	 *            Contenido del Videojuego.
	 * @param tipo
	 *            Tipo del Videojuego.
	 * @throws NoEscritoException
	 */
	public Videojuego(String codigo, String nombre, ContenidoVideojuego contenido,
			int tipo) throws NoEscritoException {
		super(codigo, nombre, tipo);
		setContenido(contenido);
	}

	/**
	 * Constructor de la clase Videojuego.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Videojuego.
	 * @param nombre
	 *            Nombre del Videojuego.
	 * @param contenido
	 *            Contenido del Videojuego.
	 * @param tipo
	 *            Tipo del Videojuego.
	 * @param diasAlquiler
	 *            Dias de alquiler del Videojuego.
	 * @param pAlquiler
	 *            precio de alquiler del Videojuego.
	 * @param empresa
	 *            Empresa del Videojuego.
	 * @throws NoEscritoException
	 */
	public Videojuego(String codigo, String nombre, ContenidoVideojuego contenido,
			int tipo, Calendar diasAlquiler, int pAlquiler, Empresa empresa)
			throws NoEscritoException {
		super(codigo, nombre, tipo, pAlquiler);
		setEmpresa(empresa);
		setDiasAlquiler(diasAlquiler);
		setContenido(contenido);
	}

	/**
	 * M&eacute;todo instanciarVideojuego que instancia un videojuego.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Videojuego.
	 * @param nombre
	 *            Nombre del Videojuego.
	 * @param contenido
	 *            Contenido del Videojuego.
	 * @param tipo
	 *            Tipo del Videojuego.
	 * @param empresa
	 *            Empresa del Videojuego.
	 * @return Devuelve la creacion de un videojuego en caso de ser valido, en
	 *         caso contrario devuelve null.
	 * @throws NoEscritoException
	 */
	public static Videojuego instanciarVideojuego(String codigo, String nombre,
			ContenidoVideojuego contenido, int tipo, Empresa empresa)
			throws NoEscritoException {
		if (esValida(codigo) && (nombre != null) && (contenido != null)
				&& (empresa != null)) {
			return new Videojuego(codigo, nombre, contenido, 3, empresa);
		} else
			return null;
	}

	static Videojuego instanciarVideojuego(String codigo) {
		if (esValida(codigo)) {
			return new Videojuego(codigo);
		} else
			return null;
	}

	/**
	 * M&eacute;todo alquilarVideojuego que alquila un videojuego.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Videojuego.
	 * @param nombre
	 *            Nombre del Videojuego.
	 * @param contenido
	 *            Contenido del Videojuego.
	 * @param tipo
	 *            Tipo del Videojuego.
	 * @param diasAlquiler
	 *            Dias de alquiler del Videojuego.
	 * @param pAlquiler
	 *            precio de alquiler del Videojuego.
	 * @param empresa
	 *            Empresa del Videojuego.
	 * @returnDevuelve la creaci&oacute;n de un videojuego.
	 * @throws NoEscritoException
	 */
	public static Videojuego alquilarVideojuego(String codigo, String nombre,
			ContenidoVideojuego contenido, int tipo, Calendar diasAlquiler,
			int pAlquiler, Empresa empresa) throws NoEscritoException {
		return new Videojuego(codigo, nombre, contenido, 3, diasAlquiler,
				pAlquiler, empresa);
	}

	/**
	 * M&eacute;todo get de Empresa.
	 * 
	 * @return Devuelve la empresa.
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * M&eacute;todo set de Empresa.
	 * 
	 * @param empresa
	 *            La empresa.
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * M&eacute;todo get de los dias de alquiler..
	 */
	public Calendar getDiasAlquiler() {
		return diasAlquiler;
	}

	/**
	 * M&eacute;todo set de los dias de alquiler.
	 */
	public void setDiasAlquiler(Calendar diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

	public ContenidoVideojuego getContenido() {
		return contenido;
	}

	public void setContenido(ContenidoVideojuego contenido) {
		this.contenido = contenido;
	}
	
}
