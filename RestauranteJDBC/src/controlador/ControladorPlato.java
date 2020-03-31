package controlador;

import modelo.Bebida;
import modelo.Plato;
import vista.VistaBebida;
import vista.VistaPlato;

public class ControladorPlato extends ControladorEntidad{

	public ControladorPlato(VistaPlato vistaPlato) {
		super(vistaPlato);
	}
	
	public void actualizarTabla() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarPlatos());
	}
	
	public void buscar() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarPlato(vistaEntidad.getOpcionBuscar(), vistaEntidad.getTxtBuscar()));
	}
	
	public Plato getEntidad() {
		String nombre = ((VistaPlato) vistaEntidad).getTxtNombre().getText();
		Double precio = Double.valueOf(((VistaPlato) vistaEntidad).getTxtPrecio().getText());
		Plato plato = new Plato(nombre, precio);
		return plato;
	}
}
