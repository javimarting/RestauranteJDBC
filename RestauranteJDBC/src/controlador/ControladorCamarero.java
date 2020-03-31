package controlador;

import javax.swing.JOptionPane;

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
}
