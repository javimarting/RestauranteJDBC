package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import modelo.Entidad;
import vista.VistaEntidad;

public abstract class ControladorEntidad extends MouseAdapter{

	protected VistaEntidad vistaEntidad;
	
	public ControladorEntidad(VistaEntidad vistaEntidad) {
		this.vistaEntidad = vistaEntidad;
		this.vistaEntidad.mostrarPnlPrincipal();
	}
	
	public abstract void actualizarTabla();
	public abstract void buscar();
	public abstract Entidad getEntidad();
	
	public void eliminar() {
		SQLEliminar.eliminar(vistaEntidad.getEntidadSeleccionada());
		actualizarTabla();			
	}
	
	public void insertar() {
		SQLInsertar.insertar(getEntidad());
		actualizarTabla();
		vistaEntidad.vaciarCampos();
		vistaEntidad.mostrarPnlPrincipal();
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
		else if(e.getSource() == vistaEntidad.getBtnInsertar()) {
			vistaEntidad.mostrarPnlInsertar();
		}
		else if(e.getSource() == vistaEntidad.getBtnCancelar()) {
			vistaEntidad.mostrarPnlPrincipal();
		}
		else if(e.getSource() == vistaEntidad.getBtnAceptarInsertar()) {
			try {
				insertar();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Alguno de los valores no es válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
