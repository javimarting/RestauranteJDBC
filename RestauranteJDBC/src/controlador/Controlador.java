package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Entidad;
import vista.MainFrame;

public class Controlador extends MouseAdapter{

	private MainFrame frame;
	
	public Controlador(MainFrame frame) {
		this.frame = frame;
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
		
	}
}
