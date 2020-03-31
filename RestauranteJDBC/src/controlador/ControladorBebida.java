package controlador;

import modelo.Bebida;
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
	
	public Bebida getEntidad() {
		String nombre = ((VistaBebida) vistaEntidad).getTxtNombre().getText();
		Double precio = Double.valueOf(((VistaBebida) vistaEntidad).getTxtPrecio().getText());
		Bebida bebida = new Bebida(nombre, precio);
		return bebida;
	}
}
