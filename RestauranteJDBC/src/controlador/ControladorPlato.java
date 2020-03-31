package controlador;

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
}
