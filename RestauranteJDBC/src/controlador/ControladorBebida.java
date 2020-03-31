package controlador;

import vista.VistaBebida;

public class ControladorBebida extends ControladorEntidad{

	public ControladorBebida(VistaBebida vistaBebida) {
		super(vistaBebida);
	}
	
	public void actualizarTabla() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarBebidas());
	}
	
	public void buscar() {
		vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarBebida(vistaEntidad.getOpcionBuscar(), vistaEntidad.getTxtBuscar()));
	}
}
