package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Videoclub.Audio;
import Videoclub.Descontable;
import Videoclub.Producto;
import Videoclub.NoEscritoException;
import Videoclub.Video;
import Videoclub.Videojuego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;

/**
 * Clase DevolverAudio que devuelve un audio.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Devolver extends JDialog implements Descontable {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textCodigo;
	private int indice;
	private JButton okButton;
	private JComboBox comboBoxAudio;
	private JButton buttonAnterior;
	private JButton buttonSiguiente;
	private JLabel lblEntrega;
	private JTextField textEntrega;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private int precioAlquiler;
	private Calendar fechaActual = Calendar.getInstance();
	private Calendar fechaEntrega = new GregorianCalendar();
	private JTextField textEuro;
	private String precio;
	private JComboBox comboBoxVideo;
	private JLabel label_1;
	private JComboBox comboBoxVideojuego;
	private JLabel label_2;

	/**
	 * Crea el di&aacute;logo.
	 */
	public Devolver() {
		setTitle("Devolver Audio");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 365, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			buttonSiguiente = new JButton("");
			buttonSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siguiente();
				}
			});
			Icon sig = new ImageIcon(this.getClass().getResource(
					"flechader.png"));
			buttonSiguiente.setIcon(sig);
			buttonSiguiente.setBounds(288, 192, 61, 24);
			contentPanel.add(buttonSiguiente);
		}
		{
			buttonAnterior = new JButton("");
			buttonAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					anterior();
				}
			});
			Icon ant = new ImageIcon(this.getClass().getResource(
					"flechaizq.png"));
			buttonAnterior.setIcon(ant);
			buttonAnterior.setBounds(219, 192, 61, 24);
			contentPanel.add(buttonAnterior);
		}
		{
			comboBoxAudio = new JComboBox();
			comboBoxAudio.setEnabled(false);
			comboBoxAudio.setBounds(92, 100, 128, 22);
			contentPanel.add(comboBoxAudio);
		}
		{
			textNombre = new JTextField();
			textNombre.setText((String) null);
			textNombre.setEditable(false);
			textNombre.setColumns(10);
			textNombre.setBounds(92, 45, 111, 20);
			contentPanel.add(textNombre);
		}
		{
			textCodigo = new JTextField();
			textCodigo.setText((String) null);
			textCodigo.setEditable(false);
			textCodigo.setColumns(10);
			textCodigo.setBounds(92, 14, 61, 20);
			contentPanel.add(textCodigo);
		}
		{
			JLabel label = new JLabel("C\u00F3digo");
			label.setBounds(10, 14, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Nombre");
			label.setBounds(10, 45, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Audio");
			label.setBounds(10, 104, 46, 14);
			contentPanel.add(label);
		}
		{
			lblEntrega = new JLabel("Entrega");
			lblEntrega.setBounds(10, 74, 46, 14);
			contentPanel.add(lblEntrega);
		}
		{
			textEntrega = new JTextField();
			textEntrega.setEditable(false);
			textEntrega.setBounds(92, 72, 94, 17);
			contentPanel.add(textEntrega);
			textEntrega.setColumns(10);

		}
		{
			textEuro = new JTextField();
			textEuro.setEditable(false);
			textEuro.setBounds(193, 73, 35, 16);
			contentPanel.add(textEuro);
			textEuro.setColumns(10);
		}
		{
			comboBoxVideo = new JComboBox();
			comboBoxVideo.setEnabled(false);
			comboBoxVideo.setBounds(92, 133, 128, 22);
			contentPanel.add(comboBoxVideo);
		}
		{
			label_1 = new JLabel("Video");
			label_1.setForeground(Color.BLACK);
			label_1.setBounds(10, 137, 46, 14);
			contentPanel.add(label_1);
		}
		{
			comboBoxVideojuego = new JComboBox();
			comboBoxVideojuego.setEnabled(false);
			comboBoxVideojuego.setBounds(92, 166, 128, 22);
			contentPanel.add(comboBoxVideojuego);
		}
		{
			label_2 = new JLabel("Videojuego");
			label_2.setForeground(Color.BLACK);
			label_2.setBounds(10, 170, 66, 14);
			contentPanel.add(label_2);
		}
		{
			Image img = new ImageIcon(this.getClass().getResource(
					"devolverAudio1.jpg")).getImage();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Devolver");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (annadirAux(Generar.videoclub
									.getAlquilados(indice))
									&& eliminar(Generar.videoclub
											.getAlquilados(indice)) == true) {
								devolverAudio(Generar.videoclub.getAux(0));
								eliminarAux(Generar.videoclub.getAux(0));
								JOptionPane
										.showMessageDialog(contentPanel,
												"El disco se ha devuelto correctamente");
								actualizar();

							} else
								JOptionPane.showMessageDialog(contentPanel,
										"El disco no se ha podido devolver",
										"Error", JOptionPane.ERROR_MESSAGE);

						} catch (NoEscritoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"El disco no se ha podido devolver");
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		empieza();
	}

	/**
	 * M&eacute;todo que muestra los atributos de un audio.
	 * 
	 * @param producto
	 *            audio que se muestra.
	 */
	private void mostrar(Producto producto) {
		textCodigo.setText(producto.getCodigo());
		textNombre.setText(producto.getNombre());
		fechaEntrega = (producto.getDiasAlquiler());
		precioAlquiler = producto.getpAlquiler();
		String str = sdf.format(producto.getDiasAlquiler().getTime());
		textEntrega.setText(str);
		precioAlquiler = descuento(precioAlquiler);
		precio = String.valueOf(precioAlquiler);
		textEuro.setText(precio + "€");
		if (producto.tipo == 1) {
			comboBoxAudio.setVisible(true);
			comboBoxVideo.removeAllItems();
			comboBoxVideojuego.removeAllItems();
			comboBoxAudio.addItem(((Audio) producto).getContenido());
			comboBoxAudio.setSelectedItem(((Audio) producto).getContenido());
		} else if (producto.tipo == 2) {
			comboBoxAudio.removeAllItems();
			comboBoxVideo.setVisible(true);
			comboBoxVideojuego.removeAllItems();
			comboBoxVideo.addItem(((Video) producto).getContenido());
			comboBoxVideo.setSelectedItem(((Video) producto).getContenido());
		} else if (producto.tipo == 3) {
			comboBoxVideojuego.setVisible(true);
			comboBoxAudio.removeAllItems();
			comboBoxVideo.removeAllItems();
			comboBoxVideojuego.addItem(((Videojuego) producto).getContenido());
			comboBoxVideojuego.setSelectedItem(((Videojuego) producto)
					.getContenido());
		} 
	}

	/**
	 * M&eacute;todo que resta 1 al &iacute;ndice que se muestra.
	 */
	private void anterior() {
		mostrar(Generar.videoclub.getAlquilados(--indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que suma 1 al &iacute;ndice que se muestra.
	 */
	private void siguiente() {
		mostrar(Generar.videoclub.getAlquilados(++indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que a&nacute;ade un audio al almacen auxiliar.
	 * 
	 * @param audio
	 *            audio que se a&nacute;ade.
	 * 
	 * @return Devuelve el video a&nacute;adido.
	 * @throws NoEscritoException
	 */
	private boolean annadirAux(Producto producto) throws NoEscritoException {
		if(Audio.class==producto.getClass()){
		return Generar.videoclub.annadirAux(new Audio(textCodigo.getText(),
				textNombre.getText(), ((Audio) producto).getContenido(), 1,((Audio) producto).getAutor()));
		}else if(Video.class==producto.getClass()){
			return Generar.videoclub.annadirAux(new Video(textCodigo.getText(),
					textNombre.getText(), ((Video) producto).getContenido(), 2,((Video) producto).getDirector()));
		}else
			return Generar.videoclub.annadirAux(new Videojuego(textCodigo.getText(),
					textNombre.getText(), ((Videojuego) producto).getContenido(), 2,((Videojuego) producto).getEmpresa()));
	}

	/**
	 * M&eacute;todo que elimina un audio auxiliar.
	 * 
	 * @param audio
	 *            audio que se elimina.
	 */
	private void eliminarAux(Producto producto) {
		Generar.videoclub.eliminarAux(producto, textCodigo.getText());
	}

	/**
	 * M&eacute;todo que elimina un audio.
	 * 
	 * @param audio
	 *            audio que se elimina.
	 * @return
	 */
	private boolean eliminar(Producto producto) {
		return Generar.videoclub.eliminarAlquilados(producto, textCodigo.getText());
	}

	/**
	 * M&eacute;todo que Devuelve un v&iacute;deo.
	 * 
	 * @param audio
	 *            audio que se devuelve.
	 */
	private void devolverAudio(Producto producto) {
		Generar.videoclub.intercambio(producto);
	}

	/**
	 * M&eacute;todo que muestra el primer &iacute;ndice.
	 */
	private void empieza() {
		if (Generar.videoclub.sizeAlquilados() == 0) {
			buttonAnterior.setEnabled(false);
			buttonSiguiente.setEnabled(false);
			return;
		}
		indice = 0;
		mostrar(Generar.videoclub.getAlquilados(indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que comprueba si un indice es null.
	 */
	private void comprobarBoton() {
		if (Generar.videoclub.getAlquilados(indice - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
		if (Generar.videoclub.getAlquilados(indice + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);
	}

	/**
	 * M&eacute;todo que actualiza la pantalla dependiendo del tama&nacute;o del
	 * almacen.
	 */
	private void actualizar() {
		if (Generar.videoclub.sizeAlquilados() == 1) {
			indice = 0;
			mostrar(Generar.videoclub.getAlquilados(0));
			buttonAnterior.setEnabled(false);
		} else {
			textCodigo.setText("");
			textNombre.setText("");
			comboBoxAudio.removeAllItems();
			comboBoxVideo.removeAllItems();
			comboBoxVideojuego.removeAllItems();
			textEntrega.setText("");
			textEuro.setText("");
		}
		if (Generar.videoclub.sizeAlquilados() == 0) {
			okButton.setEnabled(false);
		} else
			okButton.setEnabled(true);
		comprobarBoton();
	}

	@Override
	public int descuento(int precioAlquiler) {
		if (fechaEntrega.get(Calendar.DAY_OF_MONTH) > fechaActual
				.get(Calendar.DAY_OF_MONTH)) {
			if (fechaEntrega.get(Calendar.DAY_OF_MONTH)
					- fechaActual.get(Calendar.DAY_OF_MONTH) == 1) {
				precioAlquiler = precioAlquiler - 1;

			} else if (fechaEntrega.get(Calendar.DAY_OF_MONTH)
					- fechaActual.get(Calendar.DAY_OF_MONTH) == 2) {
				precioAlquiler = precioAlquiler - 2;

			} else if (fechaEntrega.get(Calendar.DAY_OF_MONTH)
					- fechaActual.get(Calendar.DAY_OF_MONTH) == 3) {
				precioAlquiler = precioAlquiler - 3;

			} else {
				precioAlquiler = precioAlquiler - 5;
			}
		} else if (fechaEntrega.get(Calendar.DAY_OF_MONTH) < fechaActual
				.get(Calendar.DAY_OF_MONTH)) {
			if (fechaEntrega.get(Calendar.DAY_OF_MONTH)
					- fechaActual.get(Calendar.DAY_OF_MONTH) == -1) {
				precioAlquiler = precioAlquiler + 1;

			} else if (fechaEntrega.get(Calendar.DAY_OF_MONTH)
					- fechaActual.get(Calendar.DAY_OF_MONTH) == -2) {
				precioAlquiler = precioAlquiler + 2;

			} else if (fechaEntrega.get(Calendar.DAY_OF_MONTH)
					- fechaActual.get(Calendar.DAY_OF_MONTH) == -3) {
				precioAlquiler = precioAlquiler + 3;

			} else
				precioAlquiler = precioAlquiler + 5;

		} else
			precioAlquiler = precioAlquiler;
		return precioAlquiler;
	}
}
