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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JRadioButton;

import Videoclub.ContenidoVideo;
import Videoclub.Director;
import Videoclub.NoEscritoException;
import Videoclub.ProductoExisteException;
import Videoclub.Video;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Clase a&nacute;adirVideo.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AñadirVideo extends JDialog {

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
	 * Bot&oacute;on Pelicula.
	 */
	private JRadioButton rdbtnPelicula;
	/**
	 * Bot&oacute;on Serie
	 */
	private JRadioButton rdbtnSerie;
	/**
	 * Bot&oacute;on Corto
	 */
	private JRadioButton rdbtnCorto;
	/**
	 * Grupo de botones buttonGroup.
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * ComboBox Director.
	 */
	private JComboBox comboBoxDirector;
	/**
	 * Imagen Director.
	 */
	private Image imgDirector;
	private JLabel label_3;

	/**
	 * Crea el Dialogo.
	 */
	public AñadirVideo() {
		setTitle("Añadir Video");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 403, 243);
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
			public void focusLost(FocusEvent arg0) {
				if (!Videoclub.Producto.esValida(textCodigo.getText())) {
					textCodigo.setForeground(Color.RED);
				} else
					textCodigo.setForeground(Color.GREEN);
			}

		});

		label_3 = new JLabel("");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(286, 14, 86, 104);
		contentPanel.add(label_3);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setBounds(50, 14, 46, 14);
		contentPanel.add(lblCdigo);

		JLabel lblDirector = new JLabel("Director");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setBounds(50, 77, 46, 14);
		contentPanel.add(lblDirector);
		textCodigo.setColumns(10);
		textCodigo.setBounds(110, 11, 86, 20);
		contentPanel.add(textCodigo);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(110, 42, 86, 20);
		contentPanel.add(textNombre);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(50, 45, 46, 14);
		contentPanel.add(label_1);
		label_1.setForeground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), null), "Contenido", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

		panel.setBounds(10, 106, 244, 45);
		contentPanel.add(panel);

		rdbtnPelicula = new JRadioButton("Pelicula");
		rdbtnPelicula.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnPelicula);
		rdbtnPelicula.setSelected(true);
		rdbtnPelicula.setBounds(6, 16, 77, 23);
		
		panel.add(rdbtnPelicula);

		rdbtnSerie = new JRadioButton("Serie");
		rdbtnSerie.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnSerie);
		rdbtnSerie.setBounds(85, 16, 69, 23);
		panel.add(rdbtnSerie);

		rdbtnCorto = new JRadioButton("Corto");
		rdbtnCorto.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnCorto);
		rdbtnCorto.setBounds(156, 16, 77, 23);
		panel.add(rdbtnCorto);


		comboBoxDirector = new JComboBox();
		imgDirector = new ImageIcon(this.getClass().getResource(
				"tim-burton.jpg")).getImage();
		label_3.setIcon(new ImageIcon(imgDirector));
		comboBoxDirector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxDirector.getSelectedItem().equals(
						Director.TIM_BURTON)) {
					imgDirector = new ImageIcon(this.getClass().getResource(
							"tim-burton.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgDirector));
				} else if (comboBoxDirector.getSelectedItem().equals(
						Director.SCORSESE)) {
					imgDirector = new ImageIcon(this.getClass().getResource(
							"scorsese.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgDirector));
				} else if (comboBoxDirector.getSelectedItem().equals(
						Director.SPIELBERG)) {
					imgDirector = new ImageIcon(this.getClass().getResource(
							"spielberg.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgDirector));

				} else if (comboBoxDirector.getSelectedItem().equals(
						Director.TARANTINO)) {
					imgDirector = new ImageIcon(this.getClass().getResource(
							"tarantino.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgDirector));

				} else if (comboBoxDirector.getSelectedItem().equals(
						Director.WOODY_ALLEN)) {
					imgDirector = new ImageIcon(this.getClass().getResource(
							"woody-allen.jpg")).getImage();
					label_3.setIcon(new ImageIcon(imgDirector));

				}
			}
		});
		comboBoxDirector.setModel(new DefaultComboBoxModel(Director.values()));
		comboBoxDirector.setSelectedIndex(0);
		comboBoxDirector.setBounds(106, 73, 101, 22);
		contentPanel.add(comboBoxDirector);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 395, 183);
		contentPanel.add(label_2);
		Image img = new ImageIcon(this.getClass().getResource("video1.jpg"))
				.getImage();

		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(0, 0, 395, 183);
		contentPanel.add(label);
		label.setIcon(new ImageIcon(img));
		label.setForeground(Color.WHITE);

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
								if (Generar.videoclub.annadir(new Video(
										textCodigo.getText(), textNombre
												.getText(), getContenido(), 2,
										(Director) comboBoxDirector
												.getSelectedItem()))) {
									JOptionPane.showMessageDialog(contentPanel,
											"Video almacenado con exito.");
								} else {
									textCodigo.setForeground(Color.RED);
									JOptionPane.showMessageDialog(contentPanel,
											"El Video no ha podido almacenarse.",
											"Error", JOptionPane.ERROR_MESSAGE);
								}

							} else
								JOptionPane.showMessageDialog(contentPanel,
										"Has dejado el código en blanco.",
										"Error", JOptionPane.ERROR_MESSAGE);
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
	private ContenidoVideo getContenido() {
		if (rdbtnPelicula.isSelected() == true) {
			return ContenidoVideo.PELICULA;
		} else if (rdbtnSerie.isSelected() == true) {
			return ContenidoVideo.SERIE;
		} else
			return ContenidoVideo.CORTO;
	}
}
