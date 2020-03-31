package controlador;

import vista.VistaMesa;

public class ControladorMesa extends ControladorEntidad{

	public ControladorMesa(VistaMesa vistaMesa) {
		super(vistaMesa);
	}
	
	public void actualizarTabla() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarMesas());
	}
	
	public void buscar() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarMesa(vistaEntidad.getOpcionBuscar(), vistaEntidad.getTxtBuscar()));
	}
}
