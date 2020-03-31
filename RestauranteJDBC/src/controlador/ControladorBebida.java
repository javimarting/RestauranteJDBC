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
	
	public void cargarCampos() {
		Bebida bebida = (Bebida)vistaEntidad.getEntidadSeleccionada();
		((VistaBebida) vistaEntidad).getTxtNombre().setText((bebida.getNombre()));
		((VistaBebida) vistaEntidad).getTxtPrecio().setText(String.valueOf((bebida.getPrecio())));
	}
	
	public Bebida getEntidadModificada() {
		Bebida bebida = (Bebida)vistaEntidad.getEntidadSeleccionada();
		String nombre = ((VistaBebida) vistaEntidad).getTxtNombre().getText();
		Double precio = Double.valueOf(((VistaBebida) vistaEntidad).getTxtPrecio().getText());
		bebida.setNombre(nombre);
		bebida.setPrecio(precio);
		return bebida;
	}
}
