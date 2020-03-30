package vista;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import modelo.Entidad;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VistaEntidad extends JPanel {

	
	private static final long serialVersionUID = -5506562014929062558L;
	private JScrollPane scroll;
	protected ModeloTabla modeloTabla;
	private JTable tabla;
	private JLabel lblTitulo;
	private JPanel pnlBotones;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	
	public VistaEntidad(String titulo, String[] columnas) {
		setBackground(new Color(130, 171, 212));
		setBounds(170, 0, 530, 578);
		setLayout(null);
		
		scroll = new JScrollPane();
		modeloTabla = new ModeloTabla(columnas);
        tabla = new JTable(modeloTabla);        
        scroll.setViewportView(tabla); 
        add(scroll);
		scroll.setBounds(19, 130, 492, 360);
		
		lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 20));		
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(185, 42, 160, 30);
		add(lblTitulo);
		
		pnlBotones = new JPanel();
		pnlBotones.setOpaque(false);
		pnlBotones.setBounds(19, 512, 492, 42);
		pnlBotones.setLayout(null);
		add(pnlBotones);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.setBounds(26, 6, 118, 29);
		btnInsertar.setOpaque(true);
		btnInsertar.setForeground(Color.WHITE);
		btnInsertar.setBorder(null);
		btnInsertar.setBackground(new Color(51, 102, 153));
		pnlBotones.add(btnInsertar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setOpaque(true);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(51, 102, 153));
		btnModificar.setBounds(187, 7, 118, 29);
		pnlBotones.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setOpaque(true);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(51, 102, 153));
		btnEliminar.setBounds(348, 7, 118, 29);
		pnlBotones.add(btnEliminar);		
		
	}
	
	public ModeloTabla getModeloTabla() {
		return modeloTabla;
	}
	
	public Entidad getEntidadSeleccionada() {
		return modeloTabla.getEntidad(tabla.getSelectedRow());
	}
	
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
			return filas.size();		
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
