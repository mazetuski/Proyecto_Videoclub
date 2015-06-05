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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import Videoclub.Audio;
import Videoclub.CodigoInvalidoException;
import Videoclub.Producto;
import Videoclub.Revista;
import Videoclub.VacioException;
import Videoclub.Video;
import Videoclub.Videojuego;

import javax.swing.JComboBox;

/**
 * Clase EliminarAudio que elimina un audio.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Eliminar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int indice;
	private JComboBox comboBoxAudio;
	private JButton okButton;
	private JComboBox comboBoxVideo;
	private JLabel lblVideo;
	private JComboBox comboBoxVideojuego;
	private JLabel lblVideojuego;
	private JButton btnMostrar;
	private JComboBox comboBoxRevista;
	private JLabel lblRevista;

	/**
	 * Crea el di&aacute;logo.
	 */
	public Eliminar() {
		setTitle("Eliminar Audio");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 328, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textCodigo = new JTextField();
		textCodigo.setBounds(78, 22, 86, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.BLACK);
		lblCdigo.setBounds(22, 25, 46, 14);
		contentPanel.add(lblCdigo);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(78, 53, 86, 20);
		contentPanel.add(textNombre);

		JLabel label = new JLabel("Nombre");
		label.setForeground(Color.BLACK);
		label.setBounds(22, 56, 46, 14);
		contentPanel.add(label);
		Icon ant = new ImageIcon(this.getClass().getResource(
				"flechaizq.png"));
		Icon sig = new ImageIcon(this.getClass().getResource(
				"flechader.png"));

		comboBoxAudio = new JComboBox();
		comboBoxAudio.setEnabled(false);
		comboBoxAudio.setBounds(10, 107, 128, 22);
		contentPanel.add(comboBoxAudio);

		JLabel label_1 = new JLabel("Audio");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(50, 84, 46, 14);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Eliminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (eliminar(Generar.videoclub.get(indice)) == true) {
								JOptionPane.showMessageDialog(contentPanel,
										"El disco se ha eliminado correctamente");
							} else
								JOptionPane.showMessageDialog(contentPanel,
										"El disco no se ha podido eliminar",
										"Error", JOptionPane.ERROR_MESSAGE);
						} catch (VacioException e1) {
							JOptionPane.showMessageDialog(contentPanel, "El almacen esta Vacio");
						}
					}
				});
				
				btnMostrar = new JButton("Mostrar");
				btnMostrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							mostrar();
						} catch (CodigoInvalidoException e) {
							JOptionPane.showMessageDialog(contentPanel, e.getMessage());
						}
					}
				});
				buttonPane.add(btnMostrar);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		okButton.setEnabled(false);
		
		comboBoxVideo = new JComboBox();
		comboBoxVideo.setEnabled(false);
		comboBoxVideo.setBounds(148, 107, 128, 22);
		contentPanel.add(comboBoxVideo);
		
		lblVideo = new JLabel("Video");
		lblVideo.setForeground(Color.BLACK);
		lblVideo.setBounds(186, 84, 46, 14);
		contentPanel.add(lblVideo);
		
		comboBoxVideojuego = new JComboBox();
		comboBoxVideojuego.setEnabled(false);
		comboBoxVideojuego.setBounds(10, 163, 128, 22);
		contentPanel.add(comboBoxVideojuego);
		
		lblVideojuego = new JLabel("Videojuego");
		lblVideojuego.setForeground(Color.BLACK);
		lblVideojuego.setBounds(47, 140, 66, 14);
		contentPanel.add(lblVideojuego);
		
		comboBoxRevista = new JComboBox();
		comboBoxRevista.setEnabled(false);
		comboBoxRevista.setBounds(148, 163, 128, 22);
		contentPanel.add(comboBoxRevista);
		
		lblRevista = new JLabel("Revista");
		lblRevista.setForeground(Color.BLACK);
		lblRevista.setBounds(185, 140, 66, 14);
		contentPanel.add(lblRevista);;
		Image img = new ImageIcon(this.getClass().getResource("eliminarcd.jpg"))
				.getImage();
	}

	/**
	 * M&eacute;todo que muestra los atributos de un audio.
	 * 
	 * @param audio
	 *            audio que se muestra.
	 * @throws CodigoInvalidoException 
	 */
	private void mostrar() throws CodigoInvalidoException {
		Producto producto=Generar.videoclub.get(textCodigo.getText());
		textNombre.setText(producto.getNombre());
		textCodigo.setText(producto.getCodigo());
		okButton.setEnabled(true);
		if (producto.tipo == 1) {
			comboBoxAudio.setVisible(true);
			comboBoxVideo.removeAllItems();
			comboBoxVideojuego.removeAllItems();
			comboBoxRevista.removeAllItems();
			comboBoxAudio.addItem(((Audio) producto).getContenido());
			comboBoxAudio.setSelectedItem(((Audio) producto).getContenido());
		}else if(producto.tipo==2){
			comboBoxAudio.removeAllItems();
			comboBoxVideo.setVisible(true);
			comboBoxVideojuego.removeAllItems();
			comboBoxRevista.removeAllItems();
			comboBoxVideo.addItem(((Video) producto).getContenido());
			comboBoxVideo.setSelectedItem(((Video) producto).getContenido());
		}else if(producto.tipo==3){
			comboBoxVideojuego.setVisible(true);
			comboBoxAudio.removeAllItems();
			comboBoxVideo.removeAllItems();
			comboBoxRevista.removeAllItems();
			comboBoxVideojuego.addItem(((Videojuego) producto).getContenido());
			comboBoxVideojuego.setSelectedItem(((Videojuego) producto).getContenido());
		}else if(producto.tipo==4){
			comboBoxVideojuego.removeAllItems();
			comboBoxAudio.removeAllItems();
			comboBoxVideo.removeAllItems();
			comboBoxRevista.setVisible(true);
			comboBoxRevista.addItem(((Revista) producto).getContenido());
			comboBoxRevista.setSelectedItem(((Revista) producto).getContenido());
		}
	}

	/**
	 * M&eacute;todo que elimina un audio.
	 * 
	 * @param audio
	 *            audio que se elimina.
	 * 
	 * @return Devuelve la eliminaci&oacute;n del audio.
	 * @throws VacioException 
	 */
	private boolean eliminar(Producto producto) throws VacioException {
		return Generar.videoclub.eliminarProducto(producto, textCodigo.getText());
	}
}
