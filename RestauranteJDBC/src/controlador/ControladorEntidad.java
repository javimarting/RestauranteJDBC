package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import vista.VistaEntidad;

public abstract class ControladorEntidad extends MouseAdapter{

	protected VistaEntidad vistaEntidad;
	
	public ControladorEntidad(VistaEntidad vistaEntidad) {
		this.vistaEntidad = vistaEntidad;		
	}
	
	public abstract void actualizarTabla();
	public abstract void buscar();
	
	public void eliminar() {
		SQLEliminar.eliminar(vistaEntidad.getEntidadSeleccionada());
		actualizarTabla();			
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == vistaEntidad.getBtnEliminar()) {			
			eliminar();			
		}
		else if(e.getSource() == vistaEntidad.getLblBuscar()) {
			if(vistaEntidad.getTxtBuscar().isEmpty()) {
				try {
					actualizarTabla();
				}catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);			
				}
			}else {	
				try {
					buscar();	
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una opción", "Error", JOptionPane.ERROR_MESSAGE);	
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El valor introducido no es válido", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
