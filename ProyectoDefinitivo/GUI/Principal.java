package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Videoclub.VacioException;
import Videoclub.Videoclub;
import Videoclub.Fichero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLabel;

import java.awt.Toolkit;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * Clase que muestra el Videoclub y todas sus funciones.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 * 
 */
public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926362870516109580L;
	private static JPanel contentPane;
	private File selectedFile;
	private File file;
	private JFrame alquilar = new JFrame();
	private JFrame frame = new JFrame();
	private JFrame frameAbrir = new JFrame();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"Archivos .obj", "obj");
	public static AyudaVideoclub ayudaVideoclub = new AyudaVideoclub();
	public static AyudaAcciones ayudaAcciones = new AyudaAcciones();
	Mostrar mostrarAudio;

	/**
	 * Ejecuta la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane,
							"Ha habido un error en el programa.");
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 */
	public Principal() {
		setTitle("Sin-titulo - Videoclub");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salirDelPrograma();
			}
		});
		/**
		 * Imagen icono.
		 */
		Image icono = new ImageIcon(this.getClass().getResource("icon.png"))
				.getImage();
		setIconImage(icono);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 310);

		/**
		 * Barra de Men&uacute;
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);

		/**
		 * Men&uacute; ficheros.
		 */
		JMenu mnFicheros = new JMenu("Ficheros");
		Icon imgFichero = new ImageIcon(this.getClass().getResource(
				"fichero.png"));
		mnFicheros.setIcon(imgFichero);
		mnFicheros.setMnemonic('F');
		menuBar.add(mnFicheros);

		/**
		 * Men&uacute; Item Nuevo.
		 */
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mntmNuevo.setIcon(null);
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mnFicheros.add(mntmNuevo);
		/**
		 * Men&uacute; Item Abrir.
		 */
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFichero();
			}
		});
		mnFicheros.add(mntmAbrir);

		/**
		 * Men&uacute; Item Guardar.
		 */
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		mnFicheros.add(mntmGuardar);

		/**
		 * Men&uacute; Item Guardar Como.
		 */
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnFicheros.add(mntmGuardarComo);

		/**
		 * Men&uacute; Item Salir.
		 */
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirDelPrograma();
			}
		});

		JSeparator separator = new JSeparator();
		mnFicheros.add(separator);
		mnFicheros.add(mntmSalir);

		/**
		 * Men&uacute; Videoclub.
		 */
		JMenu mnVideoclub = new JMenu("Videoclub");
		mnVideoclub.setMnemonic('V');
		menuBar.add(mnVideoclub);
		Icon imgVideoclub = new ImageIcon(this.getClass().getResource(
				"camara.png"));
		mnVideoclub.setIcon(imgVideoclub);

		/**
		 * Men&uacute; A&nacute;adir Disco.
		 */
		JMenu mnAadirDisco = new JMenu("A\u00F1adir Producto");
		mnVideoclub.add(mnAadirDisco);

		/**
		 * Men&uacute; Item A&nacute;adir Audio.
		 */
		JMenuItem mntmAadirCd = new JMenuItem("A\u00F1adir Audio");
		mnAadirDisco.add(mntmAadirCd);
		mntmAadirCd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.ALT_MASK));

		/**
		 * Men&uacute; Item A&nacute;adir Video.
		 */
		JMenuItem mntmAadirDvd = new JMenuItem("A\u00F1adir Video\r\n");
		mnAadirDisco.add(mntmAadirDvd);
		mntmAadirDvd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.ALT_MASK));

		/**
		 * Men&uacute; Item A&nacute;adir Videojuego.
		 */
		JMenuItem mntmAadirVideojeugo = new JMenuItem("A\u00F1adir Videojuego");
		mnAadirDisco.add(mntmAadirVideojeugo);
		mntmAadirVideojeugo.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_J, InputEvent.ALT_MASK));

		/**
		 * Men&uacute; Item A&nacute;adir Revista.
		 */
		JMenuItem mntmAadirRevista = new JMenuItem("A\u00F1adir Revista");
		mntmAadirRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirRevista añadirRevista = new AñadirRevista();
				añadirRevista.setVisible(true);
			}
		});
		mnAadirDisco.add(mntmAadirRevista);
		mntmAadirVideojeugo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirVideojuego videojuego = new AñadirVideojuego();
				videojuego.setVisible(true);
			}
		});
		mntmAadirDvd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirVideo video = new AñadirVideo();
				video.setVisible(true);
			}
		});
		mntmAadirCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirAudio annadirCD = new AñadirAudio();
				annadirCD.setVisible(true);
			}
		});

		/**
		 * Men&uacute; Eliminar Disco.
		 */
		JMenu mnEliminarDisco = new JMenu("Eliminar Producto");
		mnVideoclub.add(mnEliminarDisco);

		/**
		 * Men&uacute; Item Eliminar Audio.
		 */
		JMenuItem mntmEliminarDisco = new JMenuItem("Eliminar");
		mntmEliminarDisco.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		mnEliminarDisco.add(mntmEliminarDisco);
		mntmEliminarDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar eliminar = new Eliminar();
				try {
					if (Generar.videoclub.size() == 0) {
						JOptionPane.showMessageDialog(alquilar,
								"No hay Productos en el videoclub", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						eliminar.setVisible(true);
				} catch (VacioException e1) {
					JOptionPane.showMessageDialog(alquilar,
							"No hay Productos en el videoclub", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		/**
		 * Men&uacute; Item Mostrar n&uacute;mero de discos.
		 */
		final JMenuItem mntmMostrarNmeroDe = new JMenuItem("N\u00FAmero de Productos");
		mntmMostrarNmeroDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.ALT_MASK));
		mntmMostrarNmeroDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(
							mntmMostrarNmeroDe,
							"El número de discos es: "
									+ Generar.videoclub.size());
				} catch (VacioException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JMenu mnMostrarVideoclub = new JMenu("Mostrar...");
		mnVideoclub.add(mnMostrarVideoclub);

		JMenuItem mntmAudio = new JMenuItem("Productos");
		mntmAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Generar.videoclub.size() != 0) {
						mostrarAudio = new Mostrar();
						mostrarAudio.setVisible(true);
					} else
						JOptionPane.showMessageDialog(contentPane,
								"El almacen esta Vacio", "Error",
								JOptionPane.ERROR_MESSAGE);
				} catch (VacioException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
			}
		});
		mnMostrarVideoclub.add(mntmAudio);
		mnVideoclub.add(mntmMostrarNmeroDe);

		/**
		 * Men&uacute; Acci&oacute;n.
		 */
		JMenu mnAlquilar = new JMenu("Acciones");
		mnAlquilar.setMnemonic('c');
		menuBar.add(mnAlquilar);
		Icon imgAccion = new ImageIcon(this.getClass().getResource("disco.png"));
		mnAlquilar.setIcon(imgAccion);

		/**
		 * Men&uacute; Alquilar Disco.
		 */
		JMenu mnAlquilarDisco = new JMenu("Alquilar");
		mnAlquilar.add(mnAlquilarDisco);

		/**
		 * Men&uacute; Item Alquilar Audio.
		 */
		JMenuItem mntmAlquilarCd = new JMenuItem("Producto\r\n");
		mntmAlquilarCd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_MASK));
		mnAlquilarDisco.add(mntmAlquilarCd);
		mntmAlquilarCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Alquilar alquilar = new Alquilar();
					if (Generar.videoclub.sizeParaAlquilar() == 0) {
						JOptionPane.showMessageDialog(alquilar,
								"No hay Productos en el videoclub", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						alquilar.setVisible(true);
				} catch (VacioException e) {
					JOptionPane.showMessageDialog(contentPane,
							e.getMessage());
				}
			}
		});

		/**
		 * Men&uacute; Devolver Disco.
		 */
		JMenu mnDevolverDisco = new JMenu("Devolver");
		mnAlquilar.add(mnDevolverDisco);

		/**
		 * Men&uacute; Item Devolver Audio.
		 */
		JMenuItem mntmDevolverDisco = new JMenuItem("Producto");
		mnDevolverDisco.add(mntmDevolverDisco);
		mntmDevolverDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Devolver devolverAudio = new Devolver();
				if (Generar.videoclub.sizeAlquilados() == 0) {
					JOptionPane.showMessageDialog(alquilar,
							"No hay Productos alquilados", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else
					devolverAudio.setVisible(true);
			}
		});

		/**
		 * Men&uacute; Item Mostrar Discos Alquilados.
		 */
		JMenuItem mntmMos = new JMenuItem("N\u00FAmero Discos Alquilados ");
		mntmMos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						mntmMostrarNmeroDe,
						"El número de discos es: "
								+ Generar.videoclub.sizeAlquilados());
			}
		});

		/**
		 * Men&uacute; Item Comprar Revista.
		 */
		JMenuItem mntmComprarRevista = new JMenuItem("Comprar Revista");
		mntmComprarRevista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.CTRL_MASK));
		mntmComprarRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComprarRevista comprarRevista = new ComprarRevista();
				if (Generar.videoclub.sizeParaComprar() == 0) {
					JOptionPane.showMessageDialog(alquilar,
							"No hay revistas en el videoclub", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else
					comprarRevista.setVisible(true);
			}
		});
		mnAlquilar.add(mntmComprarRevista);
		mnAlquilar.add(mntmMos);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);
		Icon imgAyuda = new ImageIcon(this.getClass().getResource("ayuda.png"));
		mnAyuda.setIcon(imgAyuda);

		/**
		 * Men&uacute; Item Ayuda Videoclub.
		 */
		JMenuItem mntmAyudaVideoclub = new JMenuItem("Ayuda Videoclub");
		mntmAyudaVideoclub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ayudaVideoclub.setVisible(true);
			}
		});
		mnAyuda.add(mntmAyudaVideoclub);

		/**
		 * Men&uacute; Item Ayuda Acciones.
		 */
		JMenuItem mntmAyudaAcciones = new JMenuItem("Ayuda Acciones");
		mntmAyudaAcciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayudaAcciones.setVisible(true);
			}
		});
		mnAyuda.add(mntmAyudaAcciones);

		/**
		 * Men&uacute; Item Acerca De.
		 */
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca De");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("image2.jpg"))
				.getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 414, 262);
		contentPane.add(label);

	}

	/**
	 * M&eacute;todo que devuelve un File.
	 * 
	 * @return Devuelve un File.
	 */
	public File getSelectedFile() {
		return selectedFile;
	}

	/**
	 * M&eacute;todo que
	 * 
	 * @param selectedFile
	 */
	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	/**
	 * Metodo nuevo que crea un nuevo fichero.
	 */
	private void nuevo() {
		if (Generar.videoclub.isModificado()) {
			gestionarNuevo();
		} else {
			nuevoVideoclub();
		}
	}

	/**
	 * M&eacute;todo abrir que abre un fichero.
	 */
	private void abrirFichero() {
		if (Generar.videoclub.isModificado()) {
			gestionarAbrir();
		} else {
			abrir();
			setTitle(file.getName());
		}
	}

	/**
	 * Metodo GuardarComo que guarda un archivo.
	 */
	private void guardarComo() {
		JFileChooser guardar = new JFileChooser();
		int opcionGuardar = guardar.showSaveDialog(frame);
		if (opcionGuardar == JFileChooser.APPROVE_OPTION) {
			file = guardar.getSelectedFile();
			fileExiste();
		} else
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/**
	 * Metodo Guardar que guarda un archivo.
	 */
	private void guardar() {
		if (getSelectedFile() == null) {
			guardarComo();
		} else {
			try {
				Fichero.guardar(file, Generar.videoclub);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(contentPane, "Error en E/S");
			}
			asignarFile();
		}
	}

	/**
	 * Metodo salirDelPrograma que sale del programa, en caso de no estar
	 * guardado el archivo pregunta si lo guarda.
	 */
	private void salirDelPrograma() {
		if (Generar.videoclub.isModificado()) {
			gestionarSalir();
		}
		if (!Generar.videoclub.isModificado()) {
			System.exit(0);
		}
	}

	
	
	private void gestionarSalir() {
		int opcion = JOptionPane.showConfirmDialog(frame,
				"Desea guardar el videoclub: ");
		if (opcion == 0) {
			guardarComo();
		} else if (opcion == 1) {
			System.exit(0);
		} else
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	private void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);

		int opcion = abrir.showOpenDialog(frame);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = abrir.getSelectedFile();
			try {
				Generar.videoclub = (Videoclub) Fichero.leer(file);
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(contentPane,
						"El archivo no se encuentra.");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(contentPane,
						"No coincide la información");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(contentPane, "Error en E/S");
			}
			setSelectedFile(file);
			asignarFile();
		}
	}

	private void gestionarAbrir() {
		int opcion = JOptionPane.showConfirmDialog(frame,
				"Desea guardar el videoclub: ");
		if (opcion == 0) {
			guardarComo();
		} else if (opcion == 1) {
			abrir();
		} else
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	private void gestionarNuevo() {
		int opcion = JOptionPane.showConfirmDialog(frame,
				"Desea guardar el videoclub: ");
		if (opcion == 0) {
			guardarComo();
		} else if (opcion == 1) {
			nuevoVideoclub();
		} else
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	private void nuevoVideoclub() {
		Generar.videoclub = new Videoclub();
		Generar.videoclub.setModificado(false);
		setSelectedFile(null);
		setTitle("Sin-titulo - Videoclub");
	}

	public void asignarFile() {
		Generar.videoclub.setModificado(false);
		setTitle(file.getName());
	}

	private void guardarAsignar() throws IOException {
		Fichero.guardar(file, Generar.videoclub);
		setSelectedFile(file);
		asignarFile();
	}

	private void fileExiste() {
		if (file.exists()) {
			if (JOptionPane.showConfirmDialog(frame,
					"El archivo ya existe, ¿Desea sobreescribir?",
					"Sobreescribir", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.CANCEL_OPTION) {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			} else {
				try {
					guardarAsignar();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "Error en E/S");
				}
			}
		} else {
			try {
				guardarAsignar();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(contentPane, "Error en E/S");
			}
		}
	}
}
