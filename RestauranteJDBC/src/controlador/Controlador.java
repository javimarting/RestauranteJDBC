package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vista.MainFrame;

public class Controlador extends MouseAdapter{

	private MainFrame frame;
	
	public Controlador(MainFrame frame) {
		this.frame = frame;
		ControladorEntidad controladorBebida = new ControladorBebida(frame.getVistaBebida());
		frame.getVistaBebida().conectarControlador(controladorBebida);
		ControladorEntidad controladorCamarero = new ControladorCamarero(frame.getVistaCamarero());
		frame.getVistaCamarero().conectarControlador(controladorCamarero);
		ControladorEntidad controladorIngrediente = new ControladorIngrediente(frame.getVistaIngrediente());
		frame.getVistaIngrediente().conectarControlador(controladorIngrediente);
		ControladorEntidad controladorPlato = new ControladorPlato(frame.getVistaPlato());
		frame.getVistaPlato().conectarControlador(controladorPlato);
		ControladorEntidad controladorMesa = new ControladorMesa(frame.getVistaMesa());
		frame.getVistaMesa().conectarControlador(controladorMesa);
		
		frame.mostrarVista(frame.getVistaHome());
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == frame.getVistaMenu().getPnlHome()) {
			frame.mostrarVista(frame.getVistaHome());
		}
		else if(e.getSource() == frame.getVistaMenu().getPnlBebidas()){
			frame.mostrarVista(frame.getVistaBebida());
			frame.getVistaBebida().getModeloTabla().setFilas(SQLConsulta.consultarBebidas());
		}
		else if(e.getSource() == frame.getVistaMenu().getPnlPlatos()){
			frame.mostrarVista(frame.getVistaPlato());
			frame.getVistaPlato().getModeloTabla().setFilas(SQLConsulta.consultarPlatos());
		}
		else if(e.getSource() == frame.getVistaMenu().getPnlIngredientes()){
			frame.mostrarVista(frame.getVistaIngrediente());
			frame.getVistaIngrediente().getModeloTabla().setFilas(SQLConsulta.consultarIngredientes());
		}
		else if(e.getSource() == frame.getVistaMenu().getPnlCamareros()){
			frame.mostrarVista(frame.getVistaCamarero());
			frame.getVistaCamarero().getModeloTabla().setFilas(SQLConsulta.consultarCamareros());
		}
		else if(e.getSource() == frame.getVistaMenu().getPnlMesas()){
			frame.mostrarVista(frame.getVistaMesa());
			frame.getVistaMesa().getModeloTabla().setFilas(SQLConsulta.consultarMesas());
		}
		else if(e.getSource() == frame.getVistaHome().getBotonCrearTablas()) {
			SQLCrearTablas.crearTablas();
		}
		else if(e.getSource() == frame.getVistaHome().getBotonInsertarDatos()) {
			SQLInsertar.insertarDatosPrueba();
		}
		else if(e.getSource() == frame.getVistaHome().getBotonEliminarTablas()) {
			SQLEliminar.eliminarTablas();
		}
		
	}
}
