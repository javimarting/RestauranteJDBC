package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import modelo.Entidad;
import vista.VistaEntidad;

public abstract class ControladorEntidad extends MouseAdapter implements ActionListener{

	protected VistaEntidad vistaEntidad;

	public ControladorEntidad(VistaEntidad vistaEntidad) {
		this.vistaEntidad = vistaEntidad;
		this.vistaEntidad.mostrarPnlPrincipal();
	}

	public abstract void actualizarTabla();

	public abstract void buscar();

	public abstract Entidad getEntidad();

	public abstract void cargarCampos();

	public abstract Entidad getEntidadModificada();

	public void eliminar() {
		SQLEliminar.eliminar(vistaEntidad.getEntidadSeleccionada());
		actualizarTabla();
	}

	public void insertar() {
		SQLInsertar.insertar(getEntidad());
		actualizarTabla();
		vistaEntidad.mostrarPnlPrincipal();
	}

	public void modificar() {
		SQLModificar.modificar(getEntidadModificada());
		actualizarTabla();
		vistaEntidad.mostrarPnlPrincipal();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == vistaEntidad.getBtnEliminar()) {
			try {
				eliminar();
			} catch (ArrayIndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == vistaEntidad.getLblBuscar()) {
			if (vistaEntidad.getTxtBuscar().isEmpty()) {
				actualizarTabla();
			} else {
				try {
					buscar();
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Debes seleccionar una opción", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El valor introducido no es válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource() == vistaEntidad.getBtnInsertar()) {
			vistaEntidad.mostrarPnlInsertar();
		} else if (e.getSource() == vistaEntidad.getBtnCancelar()) {
			vistaEntidad.mostrarPnlPrincipal();
		} else if (e.getSource() == vistaEntidad.getBtnModificar()) {
			try {
				cargarCampos();
				vistaEntidad.mostrarPnlModificar();
			} catch (ArrayIndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == vistaEntidad.getBtnAceptarInsertar()) {
			try {
				insertar();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Alguno de los valores no es válido", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == vistaEntidad.getBtnAceptarModificar()) {
			try {
				modificar();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Alguno de los valores no es válido", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
