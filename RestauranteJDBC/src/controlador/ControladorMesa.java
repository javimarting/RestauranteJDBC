package controlador;

import modelo.Mesa;
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
	
	public Mesa getEntidad() {
		Integer num_personas = Integer.valueOf(((VistaMesa)vistaEntidad).getTxtNumPersonas().getText());
		Mesa mesa = new Mesa(num_personas);
		return mesa;
	}
}
