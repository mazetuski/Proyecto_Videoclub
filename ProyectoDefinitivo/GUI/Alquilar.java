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

import Videoclub.Alquilable;
import Videoclub.Audio;
import Videoclub.NoEscritoException;
import Videoclub.Producto;
import Videoclub.Rentable;
import Videoclub.Revista;
import Videoclub.VacioException;
import Videoclub.Video;
import Videoclub.Videojuego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;

import Videoclub.DiaEntregaAudio;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

/**
 * Clase AlquilarAudio
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Alquilar extends JDialog implements Rentable, Fechable,
		Alquilable {

	/**
	 * Bot&oacute;on Siguiente.
	 */
	protected JButton buttonSiguiente;
	/**
	 * Bot&oacute;on Anterior.
	 */
	protected JButton buttonAnterior;
	/**
	 * Entero &iacute;ndice.
	 */
	protected int indice;
	/**
	 * Entero precioAlquiler.
	 */
	protected int precioAlquiler;
	/**
	 * Calendar fechaEntrega.
	 */
	protected Calendar fechaEntrega = new GregorianCalendar();
	/**
	 * Caja de texto del Precio.
	 */
	protected JTextField textEuro;
	/**
	 * Caja de texto textFecha.
	 */
	protected JTextField textFecha;

	/**
	 * Caja de texto del C&oacute;digo.
	 */
	protected JTextField textCodigo;
	/**
	 * Caja de texto del Nombre.
	 */
	protected JTextField textNombre;

	protected JComboBox comboBox;

	protected JComboBox comboBox2;
	/**
	 * Jpanel contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();

	private JComboBox comboBoxAudio;
	/**
	 * Entero &iacute;ndice.
	 */
	/**
	 * Bot&oacute;on OK.
	 */
	private JButton okButton;
	/**
	 * Etiqueta Fecha.
	 */
	private JLabel lblFecha;
	/**
	 * ComboBox de Entrega.
	 */
	private JComboBox comboBoxEntrega;
	private JComboBox comboBoxVideo;
	private JLabel label_3;
	private JLabel label_4;
	private JComboBox comboBoxVideojuego;

	/**
	 * Crea el Dialogo.
	 * 
	 * @throws VacioException
	 */
	public Alquilar() throws VacioException {
		setTitle("Alquilar Audio");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 407, 283);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBoxAudio = new JComboBox();
		comboBoxAudio.setEnabled(false);
		comboBoxAudio.setBounds(15, 129, 128, 22);
		contentPanel.add(comboBoxAudio);

		textNombre = new JTextField();
		textNombre.setText((String) null);
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(233, 11, 111, 20);
		contentPanel.add(textNombre);

		textCodigo = new JTextField();
		textCodigo.setText((String) null);
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		textCodigo.setBounds(87, 11, 71, 20);
		contentPanel.add(textCodigo);

		JLabel label = new JLabel("C\u00F3digo");
		label.setForeground(Color.BLACK);
		label.setBounds(22, 14, 46, 14);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(168, 14, 46, 14);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("Audio");
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(52, 103, 46, 14);
		contentPanel.add(label_2);

		buttonAnterior = new JButton("");
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					anterior();
				} catch (VacioException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
				}
			}
		});

		Icon ant = new ImageIcon(this.getClass().getResource("flechaizq.png"));
		buttonAnterior.setIcon(ant);
		buttonAnterior.setEnabled(false);
		buttonAnterior.setBounds(184, 185, 71, 23);
		contentPanel.add(buttonAnterior);

		buttonSiguiente = new JButton("");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					siguiente();
				} catch (VacioException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
				}
			}
		});
		Icon sig = new ImageIcon(this.getClass().getResource("flechader.png"));
		buttonSiguiente.setIcon(sig);
		buttonSiguiente.setEnabled(false);
		buttonSiguiente.setBounds(268, 185, 65, 24);
		contentPanel.add(buttonSiguiente);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Alquilar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (alquilar(Generar.videoclub.getParaAlquilar(indice))
									&& eliminar(Generar.videoclub.getParaAlquilar(indice))) {
								JOptionPane
										.showMessageDialog(contentPanel,
												"El disco se ha alquilado correctamente");
								actualizar();
							} else
								JOptionPane.showMessageDialog(contentPanel,
										"El disco no se ha podido alquilar",
										"Error", JOptionPane.ERROR_MESSAGE);
						} catch (NoEscritoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									e1.getMessage());
						} catch (VacioException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									e1.getMessage());
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
		okButton.setEnabled(false);
		buttonSiguiente.setEnabled(false);
		buttonAnterior.setEnabled(false);

		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setBounds(23, 45, 46, 14);
		contentPanel.add(lblFecha);

		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setBounds(88, 42, 111, 20);
		contentPanel.add(textFecha);
		textFecha.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = sdf.format(Generar.videoclub.getDiasAlquiler().getTime());
		textFecha.setText(str);

		JLabel lblEntrega = new JLabel("Entrega");
		lblEntrega.setForeground(Color.BLACK);
		lblEntrega.setBounds(23, 74, 59, 14);
		contentPanel.add(lblEntrega);

		comboBoxEntrega = new JComboBox();
		comboBoxEntrega.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxEntrega.getSelectedItem().equals(
						DiaEntregaAudio.CINCO_DIAS)) {
					textEuro.setText("8€");
				} else if (comboBoxEntrega.getSelectedItem().equals(
						DiaEntregaAudio.SIETE_DIAS)) {
					textEuro.setText("10€");
				} else {
					textEuro.setText("11€");
				}
			}
		});
		comboBoxEntrega.setModel(new DefaultComboBoxModel(DiaEntregaAudio
				.values()));
		comboBoxEntrega.setBounds(88, 70, 96, 22);
		contentPanel.add(comboBoxEntrega);

		textEuro = new JTextField();
		textEuro.setEditable(false);
		textEuro.setBounds(184, 71, 32, 20);
		contentPanel.add(textEuro);
		textEuro.setColumns(10);
		textEuro.setText("8€");

		comboBoxVideo = new JComboBox();
		comboBoxVideo.setEnabled(false);
		comboBoxVideo.setBounds(153, 129, 128, 22);
		contentPanel.add(comboBoxVideo);

		label_3 = new JLabel("Video");
		label_3.setForeground(Color.BLACK);
		label_3.setBounds(191, 106, 46, 14);
		contentPanel.add(label_3);

		label_4 = new JLabel("Videojuego");
		label_4.setForeground(Color.BLACK);
		label_4.setBounds(52, 162, 66, 14);
		contentPanel.add(label_4);

		comboBoxVideojuego = new JComboBox();
		comboBoxVideojuego.setEnabled(false);
		comboBoxVideojuego.setBounds(15, 185, 128, 22);
		contentPanel.add(comboBoxVideojuego);
		Image img = new ImageIcon(this.getClass().getResource(
				"alquilarVideo.jpg")).getImage();
		empieza();
	}

	/**
	 * M&eacute;todo que muestra los atributos de un audio.
	 * 
	 * @param producto
	 *            Audio que se muestra.
	 */
	protected void mostrar(Producto producto) throws VacioException {
		textNombre.setText(producto.getNombre());
		textCodigo.setText(producto.getCodigo());
		okButton.setEnabled(true);
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
	 * M&eacute;todo que elimina un Producto.
	 * 
	 * @param audio
	 *            audio que se elimina.
	 * @return Devuelve la eliminaci&oacute;n del audio.
	 */
	private boolean eliminar(Producto producto) {
		return Generar.videoclub.eliminarProducto(producto,
				textCodigo.getText());
	}

	/**
	 * M&eacute;todo que resta 1 al &iacute;ndice que se muestra.
	 * 
	 * @throws VacioException
	 */
	private void anterior() throws VacioException {
		mostrar(Generar.videoclub.getParaAlquilar(--indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que suma 1 al &iacute;ndice que se muestra.
	 * 
	 * @throws VacioException
	 */
	private void siguiente() throws VacioException {
		mostrar(Generar.videoclub.getParaAlquilar(++indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que muestra el primer &iacute;ndice.
	 * 
	 * @throws VacioException
	 */
	private void empieza() throws VacioException {
		if (Generar.videoclub.sizeParaAlquilar() == 0) {
			buttonAnterior.setEnabled(false);
			buttonSiguiente.setEnabled(false);
			return;
		}
		indice = 0;
		mostrar(Generar.videoclub.getParaAlquilar(indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que comprueba si un indice es null.
	 * 
	 * @throws VacioException
	 */
	private void comprobarBoton() throws VacioException {
		if ((Generar.videoclub.getParaAlquilar(indice - 1) == null)
				|| (Generar.videoclub.size() == 1))
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
		if (Generar.videoclub.getParaAlquilar(indice + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);
	}

	/**
	 * M&eacute;todo que actualiza la pantalla dependiendo del tama&nacute;o del
	 * almacen.
	 * 
	 * @throws VacioException
	 */
	private void actualizar() throws VacioException {
		if (Generar.videoclub.sizeParaAlquilar() == 1) {
			indice = 0;
			mostrar(Generar.videoclub.get(0));
			buttonAnterior.setEnabled(false);
		} else {
			textCodigo.setText("");
			textNombre.setText("");
			comboBoxAudio.removeAllItems();
			comboBoxVideo.removeAllItems();
			comboBoxVideojuego.removeAllItems();
			textFecha.setText("");
			textEuro.setText("");
			comboBoxEntrega.setVisible(false);
		}
		if (Generar.videoclub.sizeParaAlquilar() == 0) {
			okButton.setEnabled(false);
		} else
			okButton.setEnabled(true);
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que asigna una fecha.
	 */
	@Override
	public Calendar fechaAlquiler(Calendar fechaAlquiler) {
		if (comboBoxEntrega.getSelectedItem()
				.equals(DiaEntregaAudio.CINCO_DIAS)) {
			fechaAlquiler = new GregorianCalendar(Generar.videoclub
					.getDiasAlquiler().get(Calendar.YEAR), Generar.videoclub
					.getDiasAlquiler().get(Calendar.MONTH), Generar.videoclub
					.getDiasAlquiler().get(Calendar.DAY_OF_MONTH) + 5);
		} else if (comboBoxEntrega.getSelectedItem().equals(
				DiaEntregaAudio.SIETE_DIAS)) {
			fechaAlquiler = new GregorianCalendar(Generar.videoclub
					.getDiasAlquiler().get(Calendar.YEAR), Generar.videoclub
					.getDiasAlquiler().get(Calendar.MONTH), Generar.videoclub
					.getDiasAlquiler().get(Calendar.DAY_OF_MONTH) + 7);
		} else {
			fechaAlquiler = new GregorianCalendar(Generar.videoclub
					.getDiasAlquiler().get(Calendar.YEAR), Generar.videoclub
					.getDiasAlquiler().get(Calendar.MONTH), Generar.videoclub
					.getDiasAlquiler().get(Calendar.DAY_OF_MONTH) + 9);
		}
		return fechaAlquiler;
	}

	/**
	 * M&eacute;todo que asigna un precio.
	 * 
	 * @return Devuelve el precio.
	 */
	@Override
	public int precio() {
		if (comboBoxEntrega.getSelectedItem()
				.equals(DiaEntregaAudio.CINCO_DIAS)) {
			precioAlquiler = 8;
		} else if (comboBoxEntrega.getSelectedItem().equals(
				DiaEntregaAudio.SIETE_DIAS)) {
			precioAlquiler = 10;
		} else {
			precioAlquiler = 11;
		}
		return precioAlquiler;
	}

	/**
	 * M&eacute;todo alquilar que alquila un producto.
	 * 
	 * @param producto
	 *            Producto que se alquila.
	 * @return Devuelve el alquiler del producto.
	 * @throws NoEscritoException
	 **/
	@Override
	public boolean alquilar(Producto producto) throws NoEscritoException {
		if (Audio.class == producto.getClass()) {
			Audio audio = (Audio) producto;
			return Generar.videoclub.annadirAlquiler(new Audio(textCodigo
					.getText(), textNombre.getText(), audio.getContenido(), 1,
					fechaEntrega = fechaAlquiler(fechaEntrega),
					precioAlquiler = precio(), ((Audio) producto).getAutor()));
		} else if (Video.class == producto.getClass()) {
			Video video = (Video) producto;
			return Generar.videoclub
					.annadirAlquiler(new Video(textCodigo.getText(), textNombre
							.getText(), video.getContenido(), 2,
							fechaEntrega = fechaAlquiler(fechaEntrega),
							precioAlquiler = precio(), ((Video) producto)
									.getDirector()));
		} else {
			Videojuego videojuego = (Videojuego) producto;
			return Generar.videoclub.annadirAlquiler(new Videojuego(textCodigo
					.getText(), textNombre.getText(),
					videojuego.getContenido(), 3,
					fechaEntrega = fechaAlquiler(fechaEntrega),
					precioAlquiler = precio(), ((Videojuego) producto)
							.getEmpresa()));
		}
	}
}
