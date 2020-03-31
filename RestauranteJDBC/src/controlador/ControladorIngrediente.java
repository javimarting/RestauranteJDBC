package controlador;

import modelo.Bebida;
import modelo.Ingrediente;
import vista.VistaBebida;
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
	
	public Ingrediente getEntidad() {
		String nombre = ((VistaIngrediente) vistaEntidad).getTxtNombre().getText();
		Double precio = Double.valueOf(((VistaIngrediente) vistaEntidad).getTxtPrecio().getText());
		Ingrediente ingrediente = new Ingrediente(nombre, precio);
		return ingrediente;
	}
}
