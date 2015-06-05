package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase AyudaVideoclub
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AyudaVideoclub extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el Dialogo.
	 */
	public AyudaVideoclub() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Principal.ayudaVideoclub=new AyudaVideoclub();
				dispose();
			}
		});
		setResizable(false);
		setTitle("Ayuda Videoclub");
		setBounds(100, 100, 411, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "A\u00F1adir Producto", TitledBorder.LEADING,
				TitledBorder.ABOVE_TOP, null, SystemColor.desktop));
		panel.setBounds(37, 35, 341, 139);
		contentPanel.add(panel);
		

		JLabel label = new JLabel(
				"A\u00F1adir Audio: Sirve para a\u00F1adir un audio al videoclub.");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(6, 16, 270, 14);
		panel.add(label);

		JLabel label_1 = new JLabel(
				"A\u00F1adir V\u00EDdeo: Sirve para a\u00F1adir un v\u00EDdeo al videoclub.");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_1.setBounds(6, 41, 270, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel(
				"A\u00F1adir V\u00EDdeojuego: Sirve para a\u00F1adir un v\u00EDdeojuego al videoclub.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_2.setBounds(6, 66, 324, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel(
				"A\u00F1adir Revista: sirve para a\u00F1adir una revista al videoclub.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_3.setBounds(6, 91, 308, 14);
		panel.add(label_3);
		
		JLabel lblCdigoDel = new JLabel("C\u00F3digo: Del 0-9 y de la A-Z Ticket: 4 letras de la A-Z, \r\nun n\u00FAmero y X-Z.");
		lblCdigoDel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCdigoDel.setBounds(6, 114, 325, 14);
		panel.add(lblCdigoDel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Eliminar Producto",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				SystemColor.desktop));
		panel_1.setBounds(37, 176, 341, 111);
		contentPanel.add(panel_1);

		JLabel label_4 = new JLabel(
				"Eliminar Audio: elimina un audio del videoclub.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_4.setBounds(6, 16, 301, 14);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel(
				"Eliminar V\u00EDdeo: elimina un v\u00EDdeo del videoclub.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_5.setBounds(6, 41, 301, 14);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel(
				"EliminarVideojuego: elimina un videojuego del videoclub.");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_6.setBounds(6, 66, 301, 14);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel(
				"Eliminar Revista: elimina una revista del videoclub.");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_7.setBounds(6, 91, 301, 14);
		panel_1.add(label_7);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Mostrar",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				SystemColor.desktop));
		panel_2.setBounds(37, 290, 341, 61);
		contentPanel.add(panel_2);

		JLabel label_8 = new JLabel(
				"Mostrar Videoclub: muestra todos los productos uno por uno.");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_8.setBounds(6, 16, 301, 14);
		panel_2.add(label_8);

		JLabel label_9 = new JLabel(
				"N\u00FAmero de productos: muestra el n\u00FAmero de productos del videoclub.\r\n");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_9.setBounds(6, 41, 346, 14);
		panel_2.add(label_9);

		JLabel lblVideoclub = new JLabel("VIDEOCLUB");
		lblVideoclub.setForeground(SystemColor.activeCaptionText);
		lblVideoclub.setBounds(176, 11, 202, 14);
		contentPanel.add(lblVideoclub);

		JSeparator separator = new JSeparator();
		separator.setBounds(37, 24, 341, 50);
		contentPanel.add(separator);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 428, 360);
		contentPanel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("AyudaVideoclub.jpg"))
				.getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal.ayudaVideoclub=new AyudaVideoclub();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
