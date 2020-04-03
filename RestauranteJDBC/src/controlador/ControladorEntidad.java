package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modelo.Entidad;
import vista.VistaEntidad;

//Controlador padre que determina el comportamiento de los controladores de cada vista 
public abstract class ControladorEntidad extends MouseAdapter implements ActionListener{

	protected VistaEntidad vistaEntidad;

	//Constructor
	public ControladorEntidad(VistaEntidad vistaEntidad) {
		this.vistaEntidad = vistaEntidad;
		this.vistaEntidad.mostrarPnlPrincipal();
	}

	//Cargar en la JTable todos los elementos de una tabla
	public abstract void actualizarTabla();

	//Buscar elementos según el criterio elegido y carga los resultados en la JTable
	public abstract void buscar();

	//Devuelve un objeto entidad a partir de los campos rellenados en el panel de insertar
	public abstract Entidad getEntidad();

	//Cargar en los distintos campos el objeto que queremos modificar
	public abstract void cargarCampos();

	//Devuelve el objeto una vez que hemos terminado de modificarlo
	public abstract Entidad getEntidadModificada();

	//Eliminar el objeto seleccionado en la JTable
	public void eliminar() {
		SQLEliminar.eliminar(vistaEntidad.getEntidadSeleccionada());
		actualizarTabla();
	}

	//Insertar en la base de datos el objeto obtenido con el método getEntidad()
	public void insertar() {
		SQLInsertar.insertar(getEntidad());
		actualizarTabla();
		vistaEntidad.mostrarPnlPrincipal();
	}

	//Modificar en la base de datos el objeto obtenido con el método getEntidadModificada()
	public void modificar() {
		SQLModificar.modificar(getEntidadModificada());
		actualizarTabla();
		vistaEntidad.mostrarPnlPrincipal();
	}

	//Asignar una función específica a cada botón cuando es pulsado
	public void mouseClicked(MouseEvent e) {
		
		//Botón eliminar --> llama al método eliminar()
		if (e.getSource() == vistaEntidad.getBtnEliminar()) {
			try {
				eliminar();
			} catch (IndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		//Botón Buscar --> llama al método buscar() (Realmente el botón buscar no es un JButton, es un JLabel)
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
			
		//Botón insertar --> cambia de panel, mostrando los campos para rellenar
		} else if (e.getSource() == vistaEntidad.getBtnInsertar()) {
			vistaEntidad.mostrarPnlInsertar();
			
		//Botón cancelar --> vuelve al panel principal
		} else if (e.getSource() == vistaEntidad.getBtnCancelar()) {
			vistaEntidad.mostrarPnlPrincipal();
			
		//Botón modificar --> cambia de panel, cargando en los campos los datos actuales del objeto
		} else if (e.getSource() == vistaEntidad.getBtnModificar()) {
			try {
				cargarCampos();
				vistaEntidad.mostrarPnlModificar();
			} catch (IndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		//Botón aceptarInsertar --> llama a la función insertar()
		} else if (e.getSource() == vistaEntidad.getBtnAceptarInsertar()) {
			try {
				insertar();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Alguno de los valores no es válido", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
		//Botón aceptarModificar --> llama a la función modificar()
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
