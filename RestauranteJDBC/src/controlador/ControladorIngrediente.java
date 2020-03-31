package controlador;

import vista.VistaIngrediente;

public class ControladorIngrediente extends ControladorEntidad{

	public ControladorIngrediente(VistaIngrediente vistaIngrediente) {
		super(vistaIngrediente);
	}
	
	public void actualizarTabla() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarIngredientes());
	}
	
	public void buscar() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarIngrediente(vistaEntidad.getOpcionBuscar(), vistaEntidad.getTxtBuscar()));
	}
}
