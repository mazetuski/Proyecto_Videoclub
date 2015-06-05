package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;

import Videoclub.DiaEntregaAudio;
import Videoclub.NoEscritoException;
import Videoclub.Producto;
import Videoclub.Rentable;
import Videoclub.Revista;
import Videoclub.TituloRevista;
import Videoclub.Video;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase ComprarRevista
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class ComprarRevista extends JDialog implements Rentable{

	/**
	 * Jpanel contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Caja de texto del C&oacute;digo.
	 */
	private JTextField textCodigo;
	/**
	 * Caja de texto del Nombre.
	 */
	private JTextField textNombre;
	/**
	 * Caja de texto de la Fecha.
	 */
	private JTextField textFecha;
	/**
	 * Caja de texto del Precio.
	 */
	private JTextField textEuro;
	/**
	 * Bot&oacute;on OK.
	 */
	private JButton okButton;
	/**
	 * ComboBox T&iacute;tulo.
	 */
	private JComboBox comboBoxTitulo;
	/**
	 * ComboBox Revista.
	 */
	private JComboBox comboBoxRevista;
	/**
	 * Entero &iacute;ndice.
	 */
	private int indice;
	/**
	 * Formato simple sdf.
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Bot&oacute;on Anterior.
	 */
	private JButton buttonAnterior;
	/**
	 * Bot&oacute;on Siguiente.
	 */
	private JButton buttonSiguiente;
	/**
	 * Caja de texto Ticket.
	 */
	private JTextField textTicket;
	/**
	 * Precio Revista.
	 */
	private int precioAlquiler;
	private JLabel label_1;

	/**
	 * Crea el Dialogo.
	 */
	public ComprarRevista() {
		setTitle("Comprar Revista");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 241, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textCodigo = new JTextField();
			textCodigo.setText((String) null);
			textCodigo.setEditable(false);
			textCodigo.setColumns(10);
			textCodigo.setBounds(73, 11, 61, 20);
			contentPanel.add(textCodigo);
		}
		{
			JLabel label = new JLabel("C\u00F3digo");
			label.setForeground(Color.WHITE);
			label.setBounds(10, 14, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Nombre");
			label.setForeground(Color.WHITE);
			label.setBounds(10, 45, 46, 14);
			contentPanel.add(label);
		}
		{
			textNombre = new JTextField();
			textNombre.setText((String) null);
			textNombre.setEditable(false);
			textNombre.setColumns(10);
			textNombre.setBounds(73, 42, 111, 20);
			contentPanel.add(textNombre);
		}
		{
			comboBoxRevista = new JComboBox();
			comboBoxRevista.setEnabled(false);
			comboBoxRevista.setBounds(73, 70, 128, 22);
			contentPanel.add(comboBoxRevista);
		}
		{
			JLabel lblRevista = new JLabel("Revista");
			lblRevista.setForeground(Color.WHITE);
			lblRevista.setBounds(10, 74, 46, 14);
			contentPanel.add(lblRevista);
		}
		{
			JLabel lblTitulo = new JLabel("Titulo");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setBounds(10, 103, 46, 14);
			contentPanel.add(lblTitulo);
		}
		{
			comboBoxTitulo = new JComboBox();
			comboBoxTitulo.setEnabled(false);
			comboBoxTitulo.setBounds(73, 99, 128, 22);
			contentPanel.add(comboBoxTitulo);
		}
		{
			textFecha = new JTextField();
			textFecha.setEditable(false);
			textFecha.setColumns(10);
			textFecha.setBounds(73, 126, 72, 20);
			contentPanel.add(textFecha);
			String str = sdf.format(Generar.videoclub.getDiasAlquiler()
					.getTime());
			textFecha.setText(str);
		}
		{
			JLabel label = new JLabel("Fecha");
			label.setForeground(Color.WHITE);
			label.setBounds(10, 129, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblPrecio = new JLabel("Precio");
			lblPrecio.setForeground(Color.WHITE);
			lblPrecio.setBounds(10, 160, 46, 14);
			contentPanel.add(lblPrecio);
		}
		{
			textEuro = new JTextField();
			textEuro.setText((String) null);
			textEuro.setEditable(false);
			textEuro.setColumns(10);
			textEuro.setBounds(73, 157, 46, 20);
			contentPanel.add(textEuro);
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
			buttonAnterior.setBounds(73, 188, 61, 24);
			contentPanel.add(buttonAnterior);
		}
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
			buttonSiguiente.setBounds(144, 188, 61, 24);
			contentPanel.add(buttonSiguiente);
		}
		{
			textTicket = new JTextField();
			textTicket.setBounds(172, 132, 12, 3);
			contentPanel.add(textTicket);
			textTicket.setColumns(10);
		}
		{
			label_1 = new JLabel("");
			label_1.setBounds(0, 0, 233, 216);
			contentPanel.add(label_1);
			Image img = new ImageIcon(this.getClass().getResource(
					"comprarRevista.jpg")).getImage();
			label_1.setIcon(new ImageIcon(img));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Comprar\r\n");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							comprarRevista();
						} catch (NoEscritoException e1) {
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
		textTicket.setVisible(false);
		empieza();
	}

	/**
	 * M&eacute;todo que muestra los atributos de una Revista.
	 * 
	 * @param revista
	 *            revista que se muestra.
	 */
	private void mostrar(Producto producto) {
		okButton.setEnabled(true);
		textCodigo.setText(producto.getCodigo());
		textNombre.setText(producto.getNombre());
		textEuro.setText(producto.getpAlquiler() + "€");
		if (producto.tipo == 4) {
			comboBoxRevista.setVisible(true);
			comboBoxRevista.addItem(((Revista) producto).getContenido());
			comboBoxRevista.setSelectedItem(((Revista) producto).getContenido());
			textTicket.setText(((Revista) producto).getCompra());
			comboBoxTitulo.setVisible(true);
			comboBoxTitulo.addItem(((Revista) producto).getTemaRevista());
			comboBoxTitulo.setSelectedItem(((Revista) producto).getTemaRevista());
		}
	}

	/**
	 * M&eacute;todo que resta 1 al &iacute;ndice que se muestra.
	 */
	private void anterior() {
		mostrar(Generar.videoclub.getParaComprar(--indice));
		comprobarBoton();
		asignarPrecio();
	}

	/**
	 * M&eacute;todo que suma 1 al &iacute;ndice que se muestra.
	 */
	private void siguiente() {
		mostrar(Generar.videoclub.getParaComprar(++indice));
		comprobarBoton();
		asignarPrecio();
	}

	/**
	 * M&eacute;todo que elimina una Revista.
	 * 
	 * @param revista
	 *            revista que se elimina.
	 * @return Devuelve la eliminaci&oacute;n de la Revista.
	 */
	private boolean eliminar(Producto producto) {
		return Generar.videoclub.eliminarProducto(producto, textCodigo.getText());
	}

	/**
	 * M&eacute;todo que compra una revista.
	 * 
	 * @param revista
	 *            Revista que se compra.
	 * @return Devuelve la compra de la revista.
	 * @throws NoEscritoException
	 */
	private boolean comprar(Producto producto) throws NoEscritoException {
		return Generar.videoclub.comprarRevista(textCodigo.getText(),
				textNombre.getText(), ((Revista) producto).getContenido(), 4,
				precioAlquiler = precio(), ((Revista) producto).getTemaRevista(),
				textTicket.getText());
	}

	/**
	 * M&eacute;todo que muestra el primer &iacute;ndice.
	 */
	private void empieza() {
		if (Generar.videoclub.sizeParaComprar() == 0) {
			buttonAnterior.setEnabled(false);
			buttonSiguiente.setEnabled(false);
			return;
		}
		indice = 0;
		mostrar(Generar.videoclub.getParaComprar(indice));
		comprobarBoton();
		asignarPrecio();
	}

	/**
	 * M&eacute;todo que comprueba si un indice es null.
	 */
	private void comprobarBoton() {
		if (Generar.videoclub.getParaComprar(indice - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
		if (Generar.videoclub.getParaComprar(indice + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);
	}

	/**
	 * M&eacute;todo que actualiza la pantalla dependiendo del tama&nacute;o del
	 * almacen.
	 */
	private void actualizar() {
		if (Generar.videoclub.sizeParaComprar() == 1) {
			indice=0;
			mostrar(Generar.videoclub.getParaComprar(0));
			asignarPrecio();
			buttonAnterior.setEnabled(false);
		} else {
			textCodigo.setText("");
			textNombre.setText("");
			comboBoxTitulo.removeAllItems();
			comboBoxRevista.removeAllItems();
			textFecha.setText("");
			textEuro.setText("");
			textTicket.setText("");
		}
		if (Generar.videoclub.sizeParaComprar() == 1) {
			okButton.setEnabled(true);
		} else
			okButton.setEnabled(false);
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que asigna un precio.
	 * 
	 * @return Devuelve el precio.
	 */
	@Override
	public int precio() {
		if (comboBoxTitulo.getSelectedItem().equals(TituloRevista.CINEMANIA)) {
			precioAlquiler = 3;
		} else if (comboBoxTitulo.getSelectedItem().equals(TituloRevista.MANGA)) {
			precioAlquiler = 5;
		} else if (comboBoxTitulo.getSelectedItem().equals(
				TituloRevista.NINTENDO_ACCION)) {
			precioAlquiler = 6;
		} else
			precioAlquiler = 4;
		return precioAlquiler;
	}

	/**
	 * M&eacute;todo que asigna un precio.
	 */
	private void asignarPrecio() {
		if (comboBoxTitulo.getSelectedItem().equals(TituloRevista.CINEMANIA)) {
			textEuro.setText("3€");
		} else if (comboBoxTitulo.getSelectedItem().equals(TituloRevista.MANGA)) {
			textEuro.setText("5€");
		} else if (comboBoxTitulo.getSelectedItem().equals(
				TituloRevista.NINTENDO_ACCION)) {
			textEuro.setText("6€");
		} else
			textEuro.setText("4€");
	}
	private void comprarRevista() throws NoEscritoException {
		if (comprar(Generar.videoclub.getParaComprar(indice))
				&& eliminar(Generar.videoclub
						.getParaComprar(indice)) == true) {
			JOptionPane.showMessageDialog(contentPanel,
					"Gracias por comprar la Revista: "
							+ textNombre.getText());
			actualizar();
			Ticket ticket = new Ticket();
			ticket.setVisible(true);
			// eliminarCompra(Generar.videoclub.getRevistaComprada(0));
		} else
			JOptionPane.showMessageDialog(contentPanel,
					"La Revista no se ha podido comprar",
					"Error", JOptionPane.ERROR_MESSAGE);
	}
}
