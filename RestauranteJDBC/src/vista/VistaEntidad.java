package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import controlador.ControladorEntidad;
import modelo.Entidad;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

//Determina el aspecto de los distintos paneles (a excepción del menú y del panel home)
public abstract class VistaEntidad extends JPanel {
	
	private static final long serialVersionUID = -5506562014929062558L;
	private JPanel pnlPrincipal;
	private JPanel pnlSecundario;
	private JScrollPane scroll;
	protected ModeloTabla modeloTabla;
	protected JTable tabla;
	private JLabel lblTitulo;
	private JPanel pnlBotonesPrincipal;
	protected JPanel pnlBotonesSecundario;
	protected JPanel pnlDatos;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptarInsertar;
	private JButton btnAceptarModificar;
	private JButton btnCancelar;
	protected JPanel pnlBuscar;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JComboBox<String> cbBuscar;
	protected Hashtable<String, String> busqueda;
	private Image img_buscar = 
			new ImageIcon(VistaCamarero.class.getResource("../res/search.png")).
			getImage().getScaledInstance(14, 14, Image.SCALE_SMOOTH);
	
	//Constructor
	public VistaEntidad(String titulo, String[] columnas, String[] opciones) {
	
		setOpaque(false);
		setBounds(170, 0, 530, 578);
		setLayout(null);
		
		//Hashtable para asociar los nombres de las opciones de búsqueda con el nombre real en la base de datos
		busqueda = new Hashtable<>();
		busqueda.put("id", "id");
		
		//Panel principal donde se encuentran la JTable, el panel de buscar y los botones de insertar, modificar y eliminar
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBounds(0, 0, 530, 578);
		pnlPrincipal.setLayout(null);
		pnlPrincipal.setOpaque(false);
		add(pnlPrincipal);
		
		//Tabla para mostrar contenido
		scroll = new JScrollPane();
		modeloTabla = new ModeloTabla(columnas);
        tabla = new JTable(modeloTabla);
        tabla.setShowGrid(false);
        scroll.setViewportView(tabla);
        pnlPrincipal.add(scroll);
		scroll.setBounds(19, 130, 492, 360);
		scroll.getViewport().setBackground(Color.white);
		
		//Título del panel
		lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 20));		
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(185, 42, 160, 30);
		pnlPrincipal.add(lblTitulo);
		
		//Panel donde se encuentran los botones insertar, modificar y eliminar
		pnlBotonesPrincipal = new JPanel();
		pnlBotonesPrincipal.setOpaque(false);
		pnlBotonesPrincipal.setBounds(19, 512, 492, 42);
		pnlBotonesPrincipal.setLayout(null);
		pnlPrincipal.add(pnlBotonesPrincipal);
		
		btnInsertar = new JButton("INSERTAR");
		crearBoton(btnInsertar, 26, 6, pnlBotonesPrincipal);
		
		btnModificar = new JButton("MODIFICAR");
		crearBoton(btnModificar, 187, 6, pnlBotonesPrincipal);
		
		btnEliminar = new JButton("ELIMINAR");
		crearBoton(btnEliminar, 348, 6, pnlBotonesPrincipal);
		
		//Panel con distintos elementos para buscar
		pnlBuscar = new JPanel();
		pnlBuscar.setBounds(19, 96, 310, 30);
		pnlPrincipal.add(pnlBuscar);
		pnlBuscar.setLayout(null);
		
		cbBuscar = new JComboBox<>(opciones);
		cbBuscar.setBounds(2, 3, 103, 27);
		cbBuscar.setSelectedItem(null);
		pnlBuscar.add(cbBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(111, 3, 112, 26);
		pnlBuscar.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(235, 7, 61, 16);
		lblBuscar.setIcon(new ImageIcon(img_buscar));
		pnlBuscar.add(lblBuscar);
		mouseListen(lblBuscar);
		
		//Panel secundario donde se encuentran los campos para rellenar los datos de un objeto nuevo o modificar uno ya existente
		pnlSecundario = new JPanel();
		pnlSecundario.setBounds(0, 0, 530, 578);
		pnlSecundario.setLayout(null);
		pnlSecundario.setOpaque(false);
		add(pnlSecundario);	
		
		//Panel dentro del panel secundario donde se encuentran los campos para rellenar
		pnlDatos = new JPanel();
		pnlDatos.setOpaque(false);
		pnlDatos.setBounds(115, 110, 295, 260);
		pnlDatos.setLayout(null);
		pnlSecundario.add(pnlDatos);
		
		//Panel donde se encuentran los botones del panel secundario, que son aceptarInsertar, aceptarModificar y cancelar
		pnlBotonesSecundario = new JPanel();
		pnlBotonesSecundario.setOpaque(false);
		pnlBotonesSecundario.setBounds(115, 330, 300, 42);
		pnlBotonesSecundario.setLayout(null);
		pnlSecundario.add(pnlBotonesSecundario);
		
		btnAceptarInsertar = new JButton("ACEPTAR");
		crearBoton(btnAceptarInsertar, 16, 6, pnlBotonesSecundario);
		
		btnAceptarModificar = new JButton("ACEPTAR");
		crearBoton(btnAceptarModificar, 16, 6, pnlBotonesSecundario);
		
		btnCancelar = new JButton("CANCELAR");
		crearBoton(btnCancelar, 166, 6, pnlBotonesSecundario);
				
		
	}
	
	//Getters
	public JPanel getPnlPrincipal() {
		return pnlPrincipal;
	}
	
	public JPanel getPnlSecundario() {
		return pnlSecundario;
	}
	
	public JPanel getPnlDatos() {
		return pnlDatos;
	}
	
	public ModeloTabla getModeloTabla() {
		return modeloTabla;
	}
	
	public Entidad getEntidadSeleccionada(){
		return modeloTabla.getEntidad(tabla.getSelectedRow());
	}
	
	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public JButton getBtnAceptarInsertar() {
		return btnAceptarInsertar;
	}
	
	public JButton getBtnAceptarModificar() {
		return btnAceptarModificar;
	}
	
	public JLabel getLblBuscar() {
		return lblBuscar;
	}
	
	public JComboBox<String> getCbBuscar() {
		return cbBuscar;
	}

	public void setCbBuscar(JComboBox<String> cbBuscar) {
		this.cbBuscar = cbBuscar;
	}

	
	public String getOpcionBuscar() {
		if(cbBuscar.getSelectedItem() == null) {
			throw new NullPointerException();
		}
		return busqueda.get(cbBuscar.getSelectedItem());
	}
	
	public String getTxtBuscar() {
		return txtBuscar.getText();
	}
	
	//Se cambiará el nombre de este método
	public JTextField getTxtBuscar2() {
		return txtBuscar;
	}
	
	//Vacía los distintos campos para rellenar
	public abstract void vaciarCampos();

	public void crearBoton(JButton boton, int x, int y, JPanel panel) {
		boton.setOpaque(true);
		boton.setForeground(Color.WHITE);
		boton.setBorder(null);
		boton.setBackground(new Color(51, 102, 153));
		boton.setBounds(x, y, 118, 29);
		panel.add(boton);
		mouseListen(boton);
	}
	
	
	public void mouseListen(JComponent boton) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
	
	//Conecta un controlador que se ocupará de llevar a cabo las acciones destinadas para cada botón o elemento
	public void conectarControlador(ControladorEntidad c) {
		btnInsertar.addMouseListener(c);
		btnModificar.addMouseListener(c);
		btnEliminar.addMouseListener(c);
		btnCancelar.addMouseListener(c);
		btnAceptarInsertar.addMouseListener(c);
		btnAceptarModificar.addMouseListener(c);
		lblBuscar.addMouseListener(c);
		cbBuscar.addActionListener(c);
	}
	
	//Muestra el panel principal, haciendo invisible el secundario
	public void mostrarPnlPrincipal() {
		pnlPrincipal.setVisible(true);
		pnlSecundario.setVisible(false);
		vaciarCampos();
	}
	
	//Muestra el panel secundario para insertar un nuevo objeto
	public void mostrarPnlInsertar() {
		pnlPrincipal.setVisible(false);
		pnlSecundario.setVisible(true);
		btnAceptarInsertar.setVisible(true);
		btnAceptarModificar.setVisible(false);
	}
	
	//Muestra el panel secundario para modificar un objeto ya existente (difiere con el método mostrarPnlInsertar() en que este muestra el 
	//botón aceptarModificar mientras que el otro muestra el botón aceptarInsertar)
	public void mostrarPnlModificar() {
		pnlPrincipal.setVisible(false);
		pnlSecundario.setVisible(true);
		btnAceptarInsertar.setVisible(false);
		btnAceptarModificar.setVisible(true);
	}
	
	//Modelo de tabla personalizado
	public class ModeloTabla extends AbstractTableModel{
		
		private static final long serialVersionUID = -1169766261068554864L;
		private ArrayList<Entidad> filas;
		private String[] columnas;
		
		
		public ModeloTabla(String[] columnas) {
			this.columnas=columnas;
			filas = new ArrayList<>();
		}
		
		@Override
		public int getRowCount() {
			try {
				return filas.size();
			}catch(NullPointerException e) {
				return 0;
			}
		}
		
		@Override
		public int getColumnCount() {
			return columnas.length;
		}
		
		public String getColumnName(int columna) {
			return columnas[columna];
		}
		
		@Override
		public Object getValueAt(int fila, int columna) {		
			return filas.get(fila).getColumna(columna);					
		}
		
		public void setFilas(ArrayList<Entidad> filas) {
			this.filas = filas;
			fireTableDataChanged();
		}
		
		public void setColumnas(String[] columnas) {
			this.columnas = columnas;
		}
		
		public ArrayList<Entidad> getFilas(){
			return filas;
		}
		
		public Entidad getEntidad(int fila) {
			return filas.get(fila);
		}
		
		
	}
}
