package Videoclub;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * Clase Producto
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public abstract class Producto implements Serializable {

	/**
	 * Dias que se alquila un producto.
	 */
	Calendar diasAlquiler = new GregorianCalendar();
	/**
	 * Precio de un producto.
	 */
	int pAlquiler;
	/**
	 * Nombre del producto.
	 */
	protected String nombre;
	/**
	 * C&oacute;digo del producto.
	 */
	private String codigo;
	/**
	 * Tipo del producto.
	 */
	public int tipo;
	/**
	 * Pattern del c&oacute;digo de un producto.
	 */
	static final private Pattern patternCodigo = Pattern
			.compile("^[0-9][A-Z]");
	/**
	 * Pattern para que se pueda escribir frases sin n&uacute;meros ni
	 * caracteres especiales.
	 */
	static final private Pattern patternEscrito = Pattern
			.compile("^[A-Za-z\\s]+$");

	/**
	 * Constructor de la clase Producto.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Producto.
	 * @param nombre
	 *            Nombre del Producto.
	 * @param contenido
	 *            Contenido del Producto.
	 * @param tipo
	 *            Tipo del Producto.
	 * @throws NoEscritoException
	 */
	public Producto(String codigo, String nombre, int tipo)
			throws NoEscritoException {
		setCodigo(codigo);
		setNombre(nombre);
		setTipo(tipo);
	}

	/**
	 * Constructor de la clase Producto.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Producto.
	 * @param nombre
	 *            Nombre del Producto.
	 * @param contenido
	 *            Contenido del Producto.
	 * @param tipo
	 *            Tipo del Producto.
	 * @param pAlquiler
	 *            precio de alquiler del Producto.
	 * @throws NoEscritoException
	 */
	public Producto(String codigo, String nombre,
			int tipo, int pAlquiler) throws NoEscritoException {
		setCodigo(codigo);
		setNombre(nombre);
		setTipo(tipo);
		setpAlquiler(pAlquiler);
	}

	/**
	 * * Constructor de la clase Producto.
	 * 
	 * @param codigo
	 *            C&oacute;digo del Producto.
	 */
	public Producto(String codigo) {
		setCodigo(codigo);
	}

	/**
	 * M&eacute;todo get de DiasAlquiler.
	 * 
	 * @return Devuelve los dias de alquiler.
	 */
	public Calendar getDiasAlquiler() {
		return diasAlquiler;
	}

	/**
	 * M&eacute;todo set de DiasAlquiler.
	 * 
	 * @param diasAlquiler
	 *            Los dias de alquiler.
	 */
	public void setDiasAlquiler(Calendar diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

	/**
	 * M&eacute;todo get del precio de alquiler.
	 * 
	 * @return Devuelve el precio de Alquiler.
	 */
	public int getpAlquiler() {
		return pAlquiler;
	}

	/**
	 * M&eacute;todo set del precio de alquiler.
	 * 
	 * @param pAlquiler
	 *            El precio del alquiler.
	 */
	public void setpAlquiler(int pAlquiler) {
		this.pAlquiler = pAlquiler;
	}

	/**
	 * M&eacute;todo get del Nombre.
	 * 
	 * @return Devuelve el nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M&eacute;todo set del Nombre.
	 * 
	 * @param nombre
	 *            El nombre.
	 * @throws NoEscritoException
	 */
	public void setNombre(String nombre) throws NoEscritoException {
		if (esValidaEscrito(nombre))
			this.nombre = nombre;
		else
			throw new NoEscritoException("No has escrito el nombre.");
	}
	
	/**
	 * M&eacute;todo get del C&oacute;digo.
	 * 
	 * @return Devuelve el c&oacute;digo.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M&eacute;todo get del Tipo.
	 * 
	 * @return Devuelve el tipo.
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * M&eacute;todo set del Tipo.
	 * 
	 * @param tipo El tipo.
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * M&eacute;todo set del C&oacute;digo.
	 * 
	 * @param codigo El c&oacute;digo.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static boolean esValida(String codigo) {
		return patternCodigo.matcher(codigo).matches();
	}

	public static boolean esValidaEscrito(String cadena) {
		return patternEscrito.matcher(cadena).matches();
	}

	@Override
	public String toString() {
		return "Discos [tAlquiler=" + diasAlquiler + ", pAlquiler=" + pAlquiler
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
