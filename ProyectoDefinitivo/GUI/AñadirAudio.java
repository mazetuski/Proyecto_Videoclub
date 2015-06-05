package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.naming.ldap.Rdn;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import Videoclub.Audio;
import Videoclub.ContenidoAudio;
import Videoclub.Producto;
import Videoclub.NoEscritoException;
import Videoclub.ProductoExisteException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase A&nacute;adirAudio
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AñadirAudio extends JDialog {
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
	 * Caja de texto del Autor
	 */
	private JTextField textAutor;
	/**
	 * Bot&oacute;on M&uacute;sica
	 */
	private JRadioButton rdbtnMusica;
	/**
	 * Bot&oacute;on Narraci&oacute;n
	 */
	private JRadioButton rdbtnNarracin;
	/**
	 * Bot&oacute;on Idioma
	 */
	private JRadioButton rdbtnIdioma;

	/**
	 * Crea el Dialogo.
	 */
	public AñadirAudio() {
		setTitle("Añadir Audio");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 308, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setBounds(48, 33, 46, 14);
		contentPanel.add(lblCdigo);

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
		textCodigo.setBounds(108, 30, 86, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(48, 61, 46, 14);
		contentPanel.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(108, 58, 86, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				new Color(255, 255, 255), null), "Contenido",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

		panel.setBounds(26, 115, 255, 45);
		contentPanel.add(panel);
		panel.setLayout(null);

		rdbtnMusica = new JRadioButton("M\u00FAsica");
		rdbtnMusica.setForeground(Color.BLACK);
		rdbtnMusica.setSelected(true);
		rdbtnMusica.setBounds(6, 16, 77, 23);
		panel.add(rdbtnMusica);
		buttonGroup.add(rdbtnMusica);

		rdbtnNarracin = new JRadioButton("Narraci\u00F3n");
		rdbtnNarracin.setForeground(Color.BLACK);
		rdbtnNarracin.setBounds(81, 16, 89, 23);
		panel.add(rdbtnNarracin);
		buttonGroup.add(rdbtnNarracin);

		rdbtnIdioma = new JRadioButton("Idioma\r\n");
		rdbtnIdioma.setForeground(Color.BLACK);
		rdbtnIdioma.setBounds(172, 16, 77, 23);
		panel.add(rdbtnIdioma);
		buttonGroup.add(rdbtnIdioma);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setForeground(Color.WHITE);
		lblAutor.setBounds(48, 89, 46, 14);
		contentPanel.add(lblAutor);

		textAutor = new JTextField();
		textAutor.setBounds(108, 86, 86, 20);
		contentPanel.add(textAutor);
		textAutor.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 300, 195);
		contentPanel.add(label);
		Image img = new ImageIcon(this.getClass().getResource("cd.jpg"))
				.getImage();
		label.setIcon(new ImageIcon(img));

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							annadirAudio();
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
	private ContenidoAudio getContenido() {
		if (rdbtnMusica.isSelected() == true) {
			return ContenidoAudio.MUSICA;
		} else if (rdbtnIdioma.isSelected() == true) {
			return ContenidoAudio.IDIOMA;
		} else
			return ContenidoAudio.NARRACION;
	}

	private void annadirAudio() throws ProductoExisteException,
			NoEscritoException {
		if (Videoclub.Producto.esValida(textCodigo.getText())) {
			textCodigo.setForeground(Color.BLACK);
			if (Generar.videoclub.annadir(new Audio(textCodigo.getText(),
					textNombre.getText(), getContenido(), 1, textAutor
							.getText()))) {
				JOptionPane.showMessageDialog(contentPanel,
						"CD almacenado con exito.");

			} else
				JOptionPane.showMessageDialog(contentPanel,
						"El CD no ha podido almacenarse.", "Error",
						JOptionPane.ERROR_MESSAGE);
		} else {
			textCodigo.setForeground(Color.RED);
			JOptionPane.showMessageDialog(contentPanel,
					"Codigo invalido", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
