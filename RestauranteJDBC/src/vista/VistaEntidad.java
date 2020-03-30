package vista;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import modelo.Entidad;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VistaEntidad extends JPanel {

	private JScrollPane scroll;
	protected ModeloTabla modeloTabla;
	private JTable tabla;
	
	
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
		
		JLabel lblTitulo = new JLabel(titulo);
		
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(210, 42, 110, 30);
		add(lblTitulo);
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
