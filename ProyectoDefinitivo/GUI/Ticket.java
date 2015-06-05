package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JComboBox;

import Videoclub.Revista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase Ticket que muestra un ticket de la compra de una Revista.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class Ticket extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textFecha;
	private JTextField textEuro;
	private JTextField textTicket;
	private JComboBox comboBoxTitulo;
	private int indice;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField textCodigo;

	/**
	 * Crea el di&acute;logo.
	 */
	public Ticket() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				eliminarCompra(Generar.videoclub.getRevistaComprada(0));
			}
		});
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 235, 261);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textNombre = new JTextField();
			textNombre.setText((String) null);
			textNombre.setEditable(false);
			textNombre.setColumns(10);
			textNombre.setBounds(83, 30, 111, 20);
			contentPanel.add(textNombre);
		}
		{
			JLabel label = new JLabel("Nombre");
			label.setForeground(Color.BLACK);
			label.setBounds(20, 33, 46, 14);
			contentPanel.add(label);
		}
		{
			textFecha = new JTextField();
			textFecha.setEditable(false);
			textFecha.setColumns(10);
			textFecha.setBounds(83, 88, 72, 20);
			contentPanel.add(textFecha);
			String str = sdf.format(Generar.videoclub.getDiasAlquiler()
					.getTime());
			textFecha.setText(str);
		}
		{
			JLabel label = new JLabel("Fecha");
			label.setForeground(Color.BLACK);
			label.setBounds(20, 91, 46, 14);
			contentPanel.add(label);
		}
		{
			textEuro = new JTextField();
			textEuro.setText((String) null);
			textEuro.setEditable(false);
			textEuro.setColumns(10);
			textEuro.setBounds(83, 116, 46, 20);
			contentPanel.add(textEuro);
		}
		{
			JLabel label = new JLabel("Precio");
			label.setBounds(20, 119, 46, 14);
			contentPanel.add(label);
		}
		{
			comboBoxTitulo = new JComboBox();
			comboBoxTitulo.setEnabled(false);
			comboBoxTitulo.setBounds(83, 61, 128, 20);
			contentPanel.add(comboBoxTitulo);
		}
		{
			JLabel label = new JLabel("Titulo");
			label.setForeground(Color.BLACK);
			label.setBounds(20, 65, 46, 14);
			contentPanel.add(label);
		}
		{
			textTicket = new JTextField();
			textTicket.setEditable(false);
			textTicket.setBounds(83, 147, 111, 20);
			contentPanel.add(textTicket);
			textTicket.setColumns(10);
		}
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setBounds(20, 141, 46, 14);
			contentPanel.add(lblCdigo);
		}
		{
			JLabel lblCompra = new JLabel("Compra");
			lblCompra.setBounds(20, 153, 46, 14);
			contentPanel.add(lblCompra);
		}
		{
			textCodigo = new JTextField();
			textCodigo.setEnabled(false);
			textCodigo.setEditable(false);
			textCodigo.setBounds(163, 97, 6, 20);
			contentPanel.add(textCodigo);
			textCodigo.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(0, 0, 229, 203);
			contentPanel.add(label);
			Image img = new ImageIcon(this.getClass().getResource("ticket.png"))
					.getImage();
			label.setIcon(new ImageIcon(img));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eliminarCompra(Generar.videoclub.getRevistaComprada(0));
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		empieza();
		textCodigo.setVisible(false);
		setTitle("Ticket de " + textNombre.getText());
	}

	/**
	 * M&eacute;todo que muestra los atributos de una Revista.
	 * 
	 * @param revista
	 *            Revista que muestra.
	 */
	private void mostrar(Revista revista) {
		textCodigo.setText(revista.getCodigo());
		textNombre.setText(revista.getNombre());
		textEuro.setText(revista.getpAlquiler() + "€");
		textTicket.setText(revista.getCompra());
		if (revista.tipo == 4) {
			comboBoxTitulo.setVisible(true);
			comboBoxTitulo.addItem(revista.getTemaRevista());
			comboBoxTitulo.setSelectedItem(revista.getTemaRevista());
		}
	}

	/**
	 * M&eacute;todo que muestra el primer &iacute;ndice.
	 */
	private void empieza() {
		mostrar(Generar.videoclub.getRevistaComprada(0));
	}

	/**
	 * M&eacute;todo que elimina una revista.
	 * 
	 * @param revista
	 *            Revista que se elimina.
	 * @return Devuelve la eliminacion de la revista.
	 */
	private boolean eliminarCompra(Revista revista) {
		return Generar.videoclub.eliminarRevistaComprada(textCodigo.getText(),
				textTicket.getText());
	}
}
