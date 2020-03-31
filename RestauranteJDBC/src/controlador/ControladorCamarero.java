package controlador;

import javax.swing.JOptionPane;

import modelo.Bebida;
import modelo.Camarero;
import vista.VistaBebida;
import vista.VistaCamarero;

public class ControladorCamarero extends ControladorEntidad{

	public ControladorCamarero(VistaCamarero vistaCamarero) {
		super(vistaCamarero);
	}
	
	public void actualizarTabla() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarCamareros());
	}
	
	public void buscar() {		
		String opcion = vistaEntidad.getOpcionBuscar();
		String texto = vistaEntidad.getTxtBuscar();
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarCamarero(opcion, texto));		
	}
	
	public Camarero getEntidad() {
		String nombre = ((VistaCamarero) vistaEntidad).getTxtNombre().getText();
		String apellido = ((VistaCamarero) vistaEntidad).getTxtApellido().getText();
		String dni = ((VistaCamarero) vistaEntidad).getTxtDni().getText();
		Integer sueldo = Integer.valueOf(((VistaCamarero) vistaEntidad).getTxtSueldo().getText());
		Camarero camarero = new Camarero(nombre, apellido, dni, sueldo);
		return camarero;
	}
	
	public void cargarCampos() {
		Camarero camarero = (Camarero)vistaEntidad.getEntidadSeleccionada();
		((VistaCamarero) vistaEntidad).getTxtNombre().setText((camarero.getNombre()));
		((VistaCamarero) vistaEntidad).getTxtApellido().setText((camarero.getApellido()));
		((VistaCamarero) vistaEntidad).getTxtDni().setText((camarero.getDni()));
		((VistaCamarero) vistaEntidad).getTxtSueldo().setText(String.valueOf((camarero.getSueldo())));
	}
	
	public Camarero getEntidadModificada() {
		Camarero camarero = (Camarero)vistaEntidad.getEntidadSeleccionada();
		String nombre = ((VistaCamarero) vistaEntidad).getTxtNombre().getText();
		String apellido = ((VistaCamarero) vistaEntidad).getTxtApellido().getText();
		String dni = ((VistaCamarero) vistaEntidad).getTxtDni().getText();
		Integer sueldo = Integer.valueOf(((VistaCamarero) vistaEntidad).getTxtSueldo().getText());
		camarero.setNombre(nombre);
		camarero.setApellido(apellido);
		camarero.setDni(dni);
		camarero.setSueldo(sueldo);
		return camarero;
	}
}
