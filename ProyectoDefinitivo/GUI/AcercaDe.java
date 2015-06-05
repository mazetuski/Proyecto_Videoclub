package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase AcercaDe
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 *
 */
public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Crea el Dialogo.
	 */
	public AcercaDe() {
		setResizable(false);
		setTitle("Acerca de");
		setModal(true);
		setBounds(100, 100, 302, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAutorMiguelngel = new JLabel("Autor: Miguel \u00C1ngel Zamora Blanco");
			lblAutorMiguelngel.setBounds(10, 11, 260, 14);
			contentPanel.add(lblAutorMiguelngel);
		}
		{
			JLabel lblNombreProyectoVideoclub = new JLabel("Nombre proyecto: Videoclub.");
			lblNombreProyectoVideoclub.setBounds(10, 36, 171, 14);
			contentPanel.add(lblNombreProyectoVideoclub);
		}
		{
			JLabel lblFechaCreacinMayo = new JLabel("Fecha creaci\u00F3n: Mayo/2015");
			lblFechaCreacinMayo.setBounds(10, 61, 186, 14);
			contentPanel.add(lblFechaCreacinMayo);
		}
		{
			JLabel lblVersin = new JLabel("Versi\u00F3n: 3.0");
			lblVersin.setBounds(10, 86, 124, 14);
			contentPanel.add(lblVersin);
		}
		{
			JLabel lblCopyrightTodos = new JLabel("Copyright \u00A9 Todos los derechos reservados.");
			lblCopyrightTodos.setBounds(10, 111, 274, 14);
			contentPanel.add(lblCopyrightTodos);
		}
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
	}

}
