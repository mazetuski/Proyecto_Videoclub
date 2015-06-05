package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import Videoclub.ContenidoRevista;
import Videoclub.Director;
import Videoclub.NoEscritoException;
import Videoclub.ProductoExisteException;
import Videoclub.Revista;
import Videoclub.TituloRevista;
import Videoclub.DiaEntregaAudio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase A&nacute;adirRevista
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AñadirRevista extends JDialog {

	/**
	 * Jpanel contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Caja de texto del Codigo.
	 */
	private JTextField textCodigo;
	/**
	 * Caja de texto del Nombre.
	 */
	private JTextField textNombre;
	/**
	 * Grupo de botones buttonGroup
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Bot&oacute;on Videojuegos.
	 */
	private JRadioButton rdbtnVideojuegos;
	/**
	 * Bot&oacute;on M&uacute;sica.
	 */
	private JRadioButton rdbtnMusica;
	/**
	 * Bot&oacute;on Comic.
	 */
	private JRadioButton rdbtnComic;
	/**
	 * Bot&oacute;on Cine.
	 */
	private JRadioButton rdbtnCine;
	/**
	 * Imagen temaRevista.
	 */
	private Image imgTemaRevista;
	private JLabel label_3;
	/**
	 * Caja de texto Ticket.
	 */
	private JTextField textTicket;

	/**
	 * Crea el Di&aacute;logo.
	 */
	public AñadirRevista() {
		setTitle("Añadir Revista");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 346, 263);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textCodigo = new JTextField();
		textCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textCodigo.setForeground(Color.BLACK);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(!Videoclub.Producto.esValida(textCodigo.getText())){
					textCodigo.setForeground(Color.RED);
					}else
						textCodigo.setForeground(Color.GREEN);
			}
		});
		textCodigo.setColumns(10);
		textCodigo.setBounds(76, 16, 86, 20);
		contentPanel.add(textCodigo);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(76, 47, 86, 20);
		contentPanel.add(textNombre);

		final JComboBox comboBoxTemaRevista = new JComboBox();
		comboBoxTemaRevista.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				label_3.setIcon(new ImageIcon(imgTemaRevista));
				if (comboBoxTemaRevista.getSelectedItem().equals(
						TituloRevista.CINEMANIA)) {
					imgTemaRevista = new ImageIcon(this.getClass().getResource(
							"cinemania1.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgTemaRevista));
				} else if (comboBoxTemaRevista.getSelectedItem().equals(
						TituloRevista.MANGA)) {
					imgTemaRevista = new ImageIcon(this.getClass().getResource(
							"comic1.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgTemaRevista));
				} else if (comboBoxTemaRevista.getSelectedItem().equals(
						TituloRevista.NINTENDO_ACCION)) {
					imgTemaRevista = new ImageIcon(this.getClass().getResource(
							"NintendoMania1.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgTemaRevista));

				} else {
					imgTemaRevista = new ImageIcon(this.getClass().getResource(
							"Playmania1.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgTemaRevista));

				}
			}
		});
		comboBoxTemaRevista.setModel(new DefaultComboBoxModel(TituloRevista
				.values()));
		comboBoxTemaRevista.setSelectedIndex(0);
		comboBoxTemaRevista.setBounds(76, 78, 101, 22);
		contentPanel.add(comboBoxTemaRevista);

		JLabel lblTema = new JLabel("Tema");
		lblTema.setForeground(Color.WHITE);
		lblTema.setBounds(16, 82, 46, 14);
		contentPanel.add(lblTema);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(16, 50, 46, 14);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("C\u00F3digo");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(16, 19, 46, 14);
		contentPanel.add(label_2);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), null), "Contenido", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(16, 132, 177, 71);
		contentPanel.add(panel);
		panel.setLayout(null);

		rdbtnVideojuegos = new JRadioButton("Videojuegos");
		rdbtnVideojuegos.setForeground(Color.BLACK);
		rdbtnVideojuegos.setBounds(6, 16, 92, 23);
		panel.add(rdbtnVideojuegos);
		buttonGroup.add(rdbtnVideojuegos);
		rdbtnVideojuegos.setSelected(true);

		rdbtnCine = new JRadioButton("Cine");
		rdbtnCine.setForeground(Color.BLACK);
		rdbtnCine.setBounds(103, 16, 68, 23);
		panel.add(rdbtnCine);
		buttonGroup.add(rdbtnCine);

		rdbtnComic = new JRadioButton("Comic");
		rdbtnComic.setForeground(Color.BLACK);
		rdbtnComic.setBounds(103, 42, 68, 23);
		panel.add(rdbtnComic);
		buttonGroup.add(rdbtnComic);

		rdbtnMusica = new JRadioButton("Musica");
		rdbtnMusica.setForeground(Color.BLACK);
		rdbtnMusica.setBounds(6, 42, 84, 23);
		panel.add(rdbtnMusica);
		buttonGroup.add(rdbtnMusica);

		JLabel lblCodigo = new JLabel("Ticket");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(16, 110, 46, 14);
		contentPanel.add(lblCodigo);

		textTicket = new JTextField();
		textTicket.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Videoclub.Revista.compraValida(textTicket.getText())) {
					textTicket.setForeground(Color.RED);
				} else
					textTicket.setForeground(Color.GREEN);
			}

			@Override
			public void focusGained(FocusEvent e) {
				textTicket.setForeground(Color.BLACK);
			}
		});
		textTicket.setColumns(10);
		textTicket.setBounds(76, 107, 86, 20);
		contentPanel.add(textTicket);

		label_3 = new JLabel("");
		label_3.setBounds(213, 11, 102, 124);
		contentPanel.add(label_3);
		imgTemaRevista = new ImageIcon(this.getClass().getResource(
				"Playmania1.jpg")).getImage();
		label_3.setIcon(new ImageIcon(imgTemaRevista));

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 338, 203);
		contentPanel.add(label);
		imgTemaRevista = new ImageIcon(this.getClass().getResource(
				"fondoRevista.jpg")).getImage();
		label.setIcon(new ImageIcon(imgTemaRevista));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (Videoclub.Producto.esValida(textCodigo
									.getText())) {
							if (Generar.videoclub.annadir(new Revista(textCodigo
									.getText(), textNombre.getText(),
									getContenido(), 4,
									(TituloRevista) comboBoxTemaRevista
											.getSelectedItem(), textTicket
											.getText()))) {
								JOptionPane.showMessageDialog(contentPanel,
										"Revista almacenada con exito.");

							} else
								JOptionPane.showMessageDialog(contentPanel,
										"La Revista no ha podido almacenarse.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}else {
								textCodigo.setForeground(Color.RED);
								JOptionPane.showMessageDialog(contentPanel,
										"Has dejado el código en blanco.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (NoEscritoException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Hay algún campo inválido.", "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (ProductoExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
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
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * M&eacute;todo getContenido que devuelve el contenido.
	 * 
	 * @return Devuelve el contenido.
	 */
	private ContenidoRevista getContenido() {
		if (rdbtnVideojuegos.isSelected() == true) {
			return ContenidoRevista.VIDEOJUEGOS;
		} else if (rdbtnCine.isSelected() == true) {
			return ContenidoRevista.CINE;
		} else if (rdbtnComic.isSelected() == true) {
			return ContenidoRevista.COMIC;
		} else
			return ContenidoRevista.MUSICA;
	}
}
