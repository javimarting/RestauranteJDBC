package app;

import controlador.Controlador;
import controlador.SQLConexion;
import controlador.SQLCrearTablas;
import vista.MainFrame;

public class App {

	public static void main(String[] args) {
		
		SQLConexion conexion = new SQLConexion();
		MainFrame frame = new MainFrame();
		Controlador controlador = new Controlador(frame);
		frame.conectarControlador(controlador);
		frame.setVisible(true);
		
		
		
	}

}
