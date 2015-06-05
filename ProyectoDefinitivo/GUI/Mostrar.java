package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

import Videoclub.Audio;
import Videoclub.Producto;
import Videoclub.Revista;
import Videoclub.VacioException;
import Videoclub.Video;
import Videoclub.Videojuego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class Mostrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JButton buttonAnterior;
	private JButton buttonSiguiente;
	private int indice;
	private JComboBox comboBoxRevista;
	private JComboBox comboBoxVideojuego;
	private JComboBox comboBoxVideo;
	private JComboBox comboBoxAudio;


	/**
	 * Create the dialog.
	 * 
	 * @throws VacioException
	 */
	public Mostrar() throws VacioException {
		setResizable(false);
		setModal(true);
		setTitle("Mostrar audios");
		setBounds(100, 100, 306, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		textCodigo.setBounds(70, 11, 86, 20);
		contentPanel.add(textCodigo);

		JLabel label = new JLabel("C\u00F3digo");
		label.setForeground(Color.BLACK);
		label.setBounds(10, 14, 46, 14);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(10, 42, 46, 14);
		contentPanel.add(label_1);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(70, 39, 86, 20);
		contentPanel.add(textNombre);

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
		Icon ant = new ImageIcon(this.getClass().getResource(
				"flechaizq.png"));
		buttonAnterior.setIcon(ant);
		buttonAnterior.setBounds(123, 181, 61, 21);
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
		Icon sig = new ImageIcon(this.getClass().getResource(
				"flechader.png"));
		buttonSiguiente.setIcon(sig);
		buttonSiguiente.setBounds(190, 181, 61, 21);
		contentPanel.add(buttonSiguiente);
		
		JLabel label_4 = new JLabel("Audio");
		label_4.setForeground(Color.BLACK);
		label_4.setBounds(50, 67, 46, 14);
		contentPanel.add(label_4);
		
		comboBoxAudio = new JComboBox();
		comboBoxAudio.setEnabled(false);
		comboBoxAudio.setBounds(10, 90, 128, 22);
		contentPanel.add(comboBoxAudio);
		
		comboBoxVideo = new JComboBox();
		comboBoxVideo.setEnabled(false);
		comboBoxVideo.setBounds(148, 90, 128, 22);
		contentPanel.add(comboBoxVideo);
		
		JLabel label_5 = new JLabel("Video");
		label_5.setForeground(Color.BLACK);
		label_5.setBounds(186, 67, 46, 14);
		contentPanel.add(label_5);
		
		comboBoxVideojuego = new JComboBox();
		comboBoxVideojuego.setEnabled(false);
		comboBoxVideojuego.setBounds(10, 146, 128, 22);
		contentPanel.add(comboBoxVideojuego);
		
		JLabel label_6 = new JLabel("Videojuego");
		label_6.setForeground(Color.BLACK);
		label_6.setBounds(47, 123, 66, 14);
		contentPanel.add(label_6);
		
		comboBoxRevista = new JComboBox();
		comboBoxRevista.setEnabled(false);
		comboBoxRevista.setBounds(148, 146, 128, 22);
		contentPanel.add(comboBoxRevista);
		
		JLabel label_7 = new JLabel("Revista");
		label_7.setForeground(Color.BLACK);
		label_7.setBounds(185, 123, 66, 14);
		contentPanel.add(label_7);
		Image img = new ImageIcon(this.getClass().getResource("cd.jpg"))
				.getImage();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

	protected void mostrar(Producto producto) throws VacioException{
		textNombre.setText(producto.getNombre());
		textCodigo.setText(producto.getCodigo());
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
	 * M&eacute;todo que resta 1 al &iacute;ndice que se muestra.
	 * @throws VacioException 
	 * 
	 */
	private void anterior() throws VacioException{
		mostrar(Generar.videoclub.get(--indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que suma 1 al &iacute;ndice que se muestra.
	 * @throws VacioException 
	 * 
	 */
	private void siguiente() throws VacioException {
		mostrar(Generar.videoclub.get(++indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que muestra el primer &iacute;ndice.
	 * @throws VacioException 
	 * 
	 */
	private void empieza() throws VacioException{
		if (Generar.videoclub.size() == 0) {
			return;
		}
		indice = 0;
		mostrar(Generar.videoclub.get(indice));
		comprobarBoton();
	}

	/**
	 * M&eacute;todo que comprueba si un indice es null.
	 * @throws VacioException 
	 */
	private void comprobarBoton() throws VacioException {
		if ((Generar.videoclub.get(indice - 1) == null)
				|| (Generar.videoclub.size() == 1))
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
		if (Generar.videoclub.get(indice + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);
	}
}
