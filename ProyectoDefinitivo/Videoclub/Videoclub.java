package Videoclub;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase Videoclub.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Videoclub implements Serializable {

	private int tipo;
	private Calendar diasAlquiler = new GregorianCalendar();

	/**
	 * ArrayList almacen de Producto.
	 */
	private ArrayList<Producto> almacen = new ArrayList<Producto>();
	/**
	 * ArrayList almacenAux de Producto.
	 */
	private ArrayList<Producto> almacenAux = new ArrayList<Producto>();
	/**
	 * ArrayList almacenAlquilados de Producto.
	 */
	private ArrayList<Producto> almacenAlquilados = new ArrayList<Producto>();
	private ArrayList<Producto> almacenParaAlquilar = new ArrayList<Producto>();
	private ArrayList<Producto> almacenParaComprar = new ArrayList<Producto>();
	/**
	 * ArrayList almacenRevistaComprada de Revista.
	 */
	private ArrayList<Revista> almacenRevistaComprada = new ArrayList<Revista>();

	/**
	 * Atributo modificado.
	 */
	private boolean modificado;

	/**
	 * Almacena un producto en un almac&eacute;n auxiliar.
	 * 
	 * @param producto
	 *            Producto que se almacena
	 * @return El almacenamiento del producto.
	 */
	public boolean annadirAux(Producto producto) {
		if (Audio.class == producto.getClass()) {
			return almacenAux.add((Audio) producto);
		} else if (Video.class == producto.getClass()) {
			return almacenAux.add((Video) producto);
		} else
			return almacenAux.add((Videojuego) producto);
	}

	/**
	 * A&nacute;ade un producto al almacen de alquilados.
	 * 
	 * @param producto
	 *            Producto que se alquila
	 * @return Devuelve el almacenamiento del producto.
	 */
	public boolean annadirAlquiler(Producto producto) {
		if (Audio.class == producto.getClass()) {
			if (almacenAlquilados.contains(producto))
				return false;
			setModificado(true);
			return almacenAlquilados.add(producto);
		} else if (Video.class == producto.getClass()) {
			if (almacenAlquilados.contains(producto))
				return false;
			setModificado(true);
			return almacenAlquilados.add(producto);
		} else {
			if (almacenAlquilados.contains(producto))
				return false;
			setModificado(true);
			return almacenAlquilados.add(producto);
		}
	}

	/**
	 * M&eacute;todo comprar Revista que compra una Revista.
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
	 * @return Devuelve el almacenamiento de la Revista.
	 * @throws NoEscritoException
	 */
	public boolean comprarRevista(String codigo, String nombre,
			ContenidoRevista contenido, int tipo, int pAlquiler,
			TituloRevista temaRevista, String compra) throws NoEscritoException {
		Revista revista = Revista.comprarRevista(codigo, nombre, contenido, 4,
				pAlquiler, temaRevista, compra);
		if ((revista == null) || (almacenRevistaComprada.contains(revista)))
			return false;
		setModificado(true);
		return almacenRevistaComprada.add(revista);
	}

	/**
	 * A&nacute;ade un producto
	 * 
	 * @param producto
	 *            Producto que se a&nacute;ade
	 * @return El almacenamiento del producto.
	 * @throws ProductoExisteException
	 */
	public boolean annadir(Producto producto) throws ProductoExisteException {
		if (productoExiste(producto) || !codigoExiste(producto.getCodigo())) {
			if (Audio.class == producto.getClass()) {
				setModificado(true);
				return almacen.add(producto)
						&& almacenParaAlquilar.add(producto);
			} else if (Video.class == producto.getClass()) {
				setModificado(true);
				return almacen.add(producto)
						&& almacenParaAlquilar.add(producto);
			} else if (Videojuego.class == producto.getClass()) {
				setModificado(true);
				return almacen.add(producto)
						&& almacenParaAlquilar.add(producto);
			} else {
				if (Revista.compraValida(((Revista) producto).getCompra())) {
					setModificado(true);
					return almacen.add(producto)
							&& almacenParaComprar.add(producto);
				} else
					return false;
			}
		} else
			throw new ProductoExisteException("El codigo ya existe...");
	}

	public boolean eliminarAlquilados(Producto producto, String codigo) {
		if (Audio.class == producto.getClass()) {
			return almacenAlquilados.remove(new Audio(codigo));
		} else if (Video.class == producto.getClass()) {
			return almacenAlquilados.remove(new Video(codigo));
		} else {
			return almacenAlquilados.remove(new Videojuego(codigo));
		}
	}

	public boolean eliminarProducto(Producto producto, String codigo) {
		if (Audio.class == producto.getClass()) {
			return almacen.remove(new Audio(codigo))
					&& almacenParaAlquilar.remove(producto);
		} else if (Video.class == producto.getClass()) {
			return almacen.remove(new Video(codigo))
					&& almacenParaAlquilar.remove(producto);
		} else if (Videojuego.class == producto.getClass())
			return almacen.remove(new Videojuego(codigo))
					&& almacenParaAlquilar.remove(producto);
		else
			return almacen.remove(new Revista(codigo))
					&& almacenParaComprar.remove(producto);
	}

	/**
	 * M&eacute;todo eliminarRevista que elimina una Revista.
	 * 
	 * @param codigo
	 *            Codigo de la Revista.
	 * @param compra
	 *            Codigo de compra.
	 * @return Devuelve la eliminacion de la Revista.
	 */
	public boolean eliminarRevista(String codigo, String compra) {
		return almacen.remove(Revista.instanciarRevista(codigo, compra));
	}

	/**
	 * M&eacute;todo eliminarRevistaComprada que elimina una Revista.
	 * 
	 * @param codigo
	 *            Codigo de la Revista.
	 * @param compra
	 *            Codigo de compra.
	 * @return Devuelve la eliminacion de la Revista.
	 */
	public boolean eliminarRevistaComprada(String codigo, String compra) {
		return almacenRevistaComprada.remove(Revista.instanciarRevista(codigo,
				compra));
	}

	/**
	 * M&eacute;todo eliminarDVD que elimina un Video.
	 * 
	 * @param codigo
	 *            Codigo del video
	 * @return Devuelve la eliminacion del video.
	 */
	public boolean eliminarDVD(String codigo) {
		return almacen.remove(Video.instanciarDVD(codigo));
	}

	/**
	 * M&eacute;todo eliminarCD que elimina un Audio.
	 * 
	 * @param codigo
	 *            Codigo del Audio.
	 * @return Devuelve la eliminacion del Audio.
	 */
	public boolean eliminarCD(String codigo) {
		return almacen.remove(Audio.instanciarCD(codigo));
	}

	/**
	 * M&eacute;todo eliminarVideojuegoAux que elimina un Videojuego auxiliar.
	 * 
	 * @param codigo
	 *            Codigo del Videojuego.
	 * @return Devuelve la eliminacion del Videojuego.
	 */
	public boolean eliminarAux(Producto producto, String codigo) {
		if (Audio.class == producto.getClass()) {
			return almacenAux.remove(new Audio(codigo));
		} else if (Video.class == producto.getClass()) {
			return almacenAux.remove(new Video(codigo));
		} else {
			return almacenAux.remove(new Videojuego(codigo));
		}
	}

	/**
	 * M&eacute;todo eliminarVideojuego que elimina un Videojuego.
	 * 
	 * @param codigo
	 *            Codigo del Videojuego.
	 * @return Devuelve la eliminacion del Videojuego.
	 */
	public boolean eliminarVideojuego(String codigo) {
		return almacen.remove(Videojuego.instanciarVideojuego(codigo));
	}

	public static int noEstaVacio(ArrayList almacen) {
		return almacen.size();
	}

	public int size() throws VacioException {
		if (noEstaVacio(almacen) != 0)
			return almacen.size();
		else
			throw new VacioException("El almacen esta vacio.");
	}

	public int sizeAlquilados() {
		return almacenAlquilados.size();
	}

	public int sizeParaAlquilar() {
		return almacenParaAlquilar.size();
	}

	public int sizeParaComprar() {
		return almacenParaComprar.size();
	}

	public void intercambio(Producto producto) {
		almacen.add(producto);
		almacenParaAlquilar.add(producto);
	}

	public Calendar getDiasAlquiler() {
		return diasAlquiler;
	}

	public void setDiasAlquiler(Calendar diasAlquiler) {
		this.diasAlquiler = Calendar.getInstance();
	}

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	public Producto get(int indice) {
		if (almacen.isEmpty())
			return null;
		if (indice < 0 | indice > almacen.size() - 1)
			return null;
		return almacen.get(indice);
	}

	public Producto getParaAlquilar(int indice) {
		if (almacenParaAlquilar.isEmpty())
			return null;
		if (indice < 0 | indice > almacenParaAlquilar.size() - 1)
			return null;
		return almacenParaAlquilar.get(indice);
	}

	public Producto getParaComprar(int indice) {
		if (almacenParaComprar.isEmpty())
			return null;
		if (indice < 0 | indice > almacenParaComprar.size() - 1)
			return null;
		return almacenParaComprar.get(indice);
	}

	public Producto get(String codigo) throws CodigoInvalidoException {
		Producto producto = new Audio(codigo);
		int index = almacen.indexOf(producto);
		if (index != -1)
			return almacen.get(index);
		throw new CodigoInvalidoException("El codigo no existe");
	}

	public ArrayList<Producto> getAlmacenAlquilados() {
		return almacenAlquilados;
	}

	public void setAlmacenAlquilados(ArrayList<Producto> almacenAlquilados) {
		this.almacenAlquilados = almacenAlquilados;
	}

	public Revista getRevistaComprada(int indice) {
		if (almacenRevistaComprada.isEmpty())
			return null;
		if (indice < 0 | indice > almacenRevistaComprada.size() - 1)
			return null;
		return almacenRevistaComprada.get(indice);
	}

	public Producto getAlquilados(int indice) {
		if (almacenAlquilados.isEmpty())
			return null;
		if (indice < 0 | indice > almacenAlquilados.size() - 1)
			return null;
		return almacenAlquilados.get(indice);
	}

	public Producto getAux(int indice) {
		if (almacenAux.isEmpty())
			return null;
		if (indice < 0 | indice > almacenAux.size() - 1)
			return null;
		return almacenAux.get(indice);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean productoExiste(Producto producto)
			throws ProductoExisteException {
		if (almacen.contains(producto) || almacenAlquilados.contains(producto)
				|| almacenRevistaComprada.contains(producto)) {
			throw new ProductoExisteException("El codigo ya existe.");
		} else
			return true;
	}

	boolean codigoExiste(String codigo) {
		Producto m1 = new Audio(codigo);
		for (Producto producto : almacen)
			if (producto.getNombre().equals(m1.getNombre()))
				return true;
		return false;
	}
}
