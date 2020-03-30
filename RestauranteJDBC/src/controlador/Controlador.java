package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		}
		
	}
}
