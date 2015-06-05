package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase AyudaAcciones.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AyudaAcciones extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el Dialogo.
	 */
	public AyudaAcciones() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Principal.ayudaAcciones=new AyudaAcciones();
				dispose();
			}
		});
		setResizable(false);
		setTitle("Ayuda Acciones");
		setBounds(100, 100, 416, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), "Alquilar Disco",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
					new Color(58, 110, 165)));
			panel.setBounds(41, 35, 340, 96);
			contentPanel.add(panel);
			{
				JLabel lblAlquilarAudioSirve = new JLabel(
						"Alquilar Audio: Sirve para alquilar un audio del videoclub.");
				lblAlquilarAudioSirve
						.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblAlquilarAudioSirve.setBounds(6, 16, 289, 14);
				panel.add(lblAlquilarAudioSirve);
			}
			{
				JLabel lblAlquilarVdeoSirve = new JLabel(
						"Alquilar V\u00EDdeo: Sirve para alquilar un v\u00EDdeo del videoclub.");
				lblAlquilarVdeoSirve
						.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblAlquilarVdeoSirve.setBounds(6, 41, 289, 14);
				panel.add(lblAlquilarVdeoSirve);
			}
			{
				JLabel lblAlquilarVdeojuegoSirve = new JLabel(
						"Alquilar V\u00EDdeojuego: Sirve para alquilar un v\u00EDdeojuego del videoclub.");
				lblAlquilarVdeojuegoSirve.setFont(new Font("Tahoma",
						Font.PLAIN, 10));
				lblAlquilarVdeojuegoSirve.setBounds(6, 66, 342, 14);
				panel.add(lblAlquilarVdeojuegoSirve);
			}
		}
		{
			JLabel label = new JLabel("VIDEOCLUB");
			label.setForeground(Color.WHITE);
			label.setBounds(180, 11, 201, 14);
			contentPanel.add(label);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(41, 24, 340, 50);
			contentPanel.add(separator);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), "Devolver Disco",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
					new Color(58, 110, 165)));
			panel.setBounds(41, 142, 340, 96);
			contentPanel.add(panel);
			{
				JLabel lblDevolverAudioDevuelve = new JLabel(
						"Devolver Audio: devuelve un audio al videoclub.");
				lblDevolverAudioDevuelve.setFont(new Font("Tahoma", Font.PLAIN,
						10));
				lblDevolverAudioDevuelve.setBounds(6, 16, 301, 14);
				panel.add(lblDevolverAudioDevuelve);
			}
			{
				JLabel lblDevolverVdeodevuelveUn = new JLabel(
						"Devolver V\u00EDdeo: devuelve un v\u00EDdeo al videoclub.");
				lblDevolverVdeodevuelveUn.setFont(new Font("Tahoma",
						Font.PLAIN, 10));
				lblDevolverVdeodevuelveUn.setBounds(6, 41, 301, 14);
				panel.add(lblDevolverVdeodevuelveUn);
			}
			{
				JLabel lblDevolverVideojuegoDevuelve = new JLabel(
						"Devolver Videojuego: devuelve un videojuego al videoclub.");
				lblDevolverVideojuegoDevuelve.setFont(new Font("Tahoma",
						Font.PLAIN, 10));
				lblDevolverVideojuegoDevuelve.setBounds(6, 66, 329, 14);
				panel.add(lblDevolverVideojuegoDevuelve);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(

			EtchedBorder.LOWERED, null, null), "Mostrar",

			TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,

			SystemColor.desktop));
			panel.setBounds(41, 298, 340, 50);
			contentPanel.add(panel);
			{
				JLabel lblNmeroDeDiscos = new JLabel(
						"N\u00FAmero de Discos Alquilados: muestra el n\u00FAmero de discos alquilados.\r\n");
				lblNmeroDeDiscos.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNmeroDeDiscos.setBounds(10, 22, 352, 14);
				panel.add(lblNmeroDeDiscos);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), "Comprar Revista",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
					SystemColor.desktop));
			panel.setBounds(41, 247, 340, 40);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblComprarRevistaSirve = new JLabel(
						"Comprar Revista: sirve para comprar una revista del videoclub.");
				lblComprarRevistaSirve.setFont(new Font("Tahoma", Font.PLAIN,
						10));
				lblComprarRevistaSirve.setBounds(6, 16, 342, 14);
				panel.add(lblComprarRevistaSirve);
			}
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(0, 0, 442, 394);
			contentPanel.add(label);
		}

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 410, 370);
		contentPanel.add(label);
		Image img = new ImageIcon(this.getClass().getResource(
				"AyudaVideoclub.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal.ayudaAcciones=new AyudaAcciones();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
