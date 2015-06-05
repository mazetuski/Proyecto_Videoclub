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
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import Videoclub.ContenidoVideojuego;
import Videoclub.Director;
import Videoclub.NoEscritoException;
import Videoclub.ProductoExisteException;
import Videoclub.Videojuego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Videoclub.Empresa;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Clase A&nacute;adirVideojuego.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AñadirVideojuego extends JDialog {

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
	 * Grupo de botones buttonGroup.
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Bot&oacute;on Acci&oacute;n.
	 */
	private JRadioButton rdbtnAccin;
	/**
	 * Bot&oacute;on Aventura.
	 */
	private JRadioButton rdbtnAventura;
	/**
	 * Bot&oacute;on Baile.
	 */
	private JRadioButton rdbtnBaile;
	/**
	 * ComboBox Empresa.
	 */
	private JComboBox comboBoxEmpresa;
	/**
	 * Imagen Empresa.
	 */
	private Image imgEmpresa;
	/**
	 * Etiqueta Empresa.
	 */
	private JLabel labelEmpresa;

	/**
	 * Crea el Dialogo.
	 */
	public AñadirVideojuego() {
		setTitle("Añadir Videojuego");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 371, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
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
			{
				labelEmpresa = new JLabel("");
				labelEmpresa.setForeground(Color.WHITE);
				labelEmpresa.setBounds(237, 12, 118, 50);
				contentPanel.add(labelEmpresa);
			}
			textCodigo.setColumns(10);
			textCodigo.setBounds(103, 11, 86, 20);
			contentPanel.add(textCodigo);
		}
		{
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBounds(103, 42, 86, 20);
			contentPanel.add(textNombre);
		}
		{
			JLabel label = new JLabel("Nombre");
			label.setForeground(Color.WHITE);
			label.setBounds(31, 49, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("C\u00F3digo");
			label.setForeground(Color.WHITE);
			label.setBounds(31, 18, 46, 14);
			contentPanel.add(label);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), null), "Contenido", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			
			panel.setBounds(10, 114, 255, 45);
			contentPanel.add(panel);
			{
				rdbtnAccin = new JRadioButton("Acci\u00F3n");
				rdbtnAccin.setForeground(Color.BLACK);
				buttonGroup.add(rdbtnAccin);
				rdbtnAccin.setSelected(true);
				rdbtnAccin.setBounds(6, 16, 77, 23);
				panel.add(rdbtnAccin);
			
			}
			{
				rdbtnAventura = new JRadioButton("Aventura");
				rdbtnAventura.setForeground(Color.BLACK);
				buttonGroup.add(rdbtnAventura);
				rdbtnAventura.setBounds(81, 16, 89, 23);
				panel.add(rdbtnAventura);
				
			}
			{
				rdbtnBaile = new JRadioButton("Baile");
				rdbtnBaile.setForeground(Color.BLACK);
				buttonGroup.add(rdbtnBaile);
				rdbtnBaile.setBounds(172, 16, 77, 23);
				panel.add(rdbtnBaile);
				
			}
		}
		{
			JLabel lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setForeground(Color.WHITE);
			lblEmpresa.setBounds(31, 81, 62, 14);
			contentPanel.add(lblEmpresa);
		}
		{
			comboBoxEmpresa = new JComboBox();
			imgEmpresa = new ImageIcon(this.getClass().getResource(
					"nintendo.png")).getImage();
			labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
			comboBoxEmpresa.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (comboBoxEmpresa.getSelectedItem().equals(
							Empresa.NINTENDO)) {
						imgEmpresa = new ImageIcon(this.getClass().getResource(
								"nintendo.png")).getImage();
						labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
					} else if (comboBoxEmpresa.getSelectedItem().equals(
							Empresa.BLIZZARD)) {
						imgEmpresa = new ImageIcon(this.getClass().getResource(
								"blizzard.jpg")).getImage();
						labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
					} else if (comboBoxEmpresa.getSelectedItem().equals(
							Empresa.RIOT)) {
						imgEmpresa = new ImageIcon(this.getClass().getResource(
								"riot.jpg")).getImage();
						labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
					} else if (comboBoxEmpresa.getSelectedItem().equals(
							Empresa.ROCKSTAR)) {
						imgEmpresa = new ImageIcon(this.getClass().getResource(
								"rockstar.jpg")).getImage();
						labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
					} else if (comboBoxEmpresa.getSelectedItem().equals(
							Empresa.VALVE)) {
						imgEmpresa = new ImageIcon(this.getClass().getResource(
								"valve.jpg")).getImage();
						labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
					} else {
						imgEmpresa = new ImageIcon(this.getClass().getResource(
								"sega.jpg")).getImage();
						labelEmpresa.setIcon(new ImageIcon(imgEmpresa));
					}
				}
			});
			comboBoxEmpresa
					.setModel(new DefaultComboBoxModel(Empresa.values()));
			comboBoxEmpresa.setSelectedIndex(4);
			comboBoxEmpresa.setBounds(103, 73, 103, 22);
			contentPanel.add(comboBoxEmpresa);
		}
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(0, -14, 363, 220);
			contentPanel.add(lblNewLabel);
			Image img = new ImageIcon(this.getClass().getResource(
					"videojuego.jpg")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							annadirVideojuego();
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
					public void actionPerformed(ActionEvent e) {
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
	private ContenidoVideojuego getContenido() {
		if (rdbtnBaile.isSelected() == true) {
			return ContenidoVideojuego.BAILE;
		} else if (rdbtnAventura.isSelected() == true) {
			return ContenidoVideojuego.AVENTURA;
		} else
			return ContenidoVideojuego.ACCION;
	}
	private void annadirVideojuego()
			throws ProductoExisteException, NoEscritoException {
		if (Videoclub.Producto.esValida(textCodigo
				.getText())) {
			textCodigo.setForeground(Color.BLACK);
			if (Generar.videoclub.annadir(new Videojuego(
					textCodigo.getText(), textNombre
							.getText(), getContenido(), 3,
					(Empresa) comboBoxEmpresa
							.getSelectedItem()))) {
				JOptionPane.showMessageDialog(contentPanel,
						"Videojuego almacenado con exito.");
			} else
				JOptionPane.showMessageDialog(contentPanel,
						"El videojuego no ha podido almacenarse.",
						"Error", JOptionPane.ERROR_MESSAGE);
		} else {
			textCodigo.setForeground(Color.RED);
			JOptionPane.showMessageDialog(contentPanel,
					"Codigo invalido",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
