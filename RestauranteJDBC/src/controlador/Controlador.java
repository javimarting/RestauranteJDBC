package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vista.MainFrame;

public class Controlador extends MouseAdapter {

	private MainFrame frame;
	private ControladorEntidad controladorCuenta;
	private ControladorEntidad controladorBebida;
	private ControladorEntidad controladorCamarero;
	private ControladorEntidad controladorIngrediente;
	private ControladorEntidad controladorPlato;
	private ControladorEntidad controladorMesa;

	//Constructor
	public Controlador(MainFrame frame) {
		//Crea los controladores para los distintos paneles
		this.frame = frame;
		controladorBebida = new ControladorBebida(frame.getVistaBebida());
		frame.getVistaBebida().conectarControlador(controladorBebida);
		controladorCamarero = new ControladorCamarero(frame.getVistaCamarero());
		frame.getVistaCamarero().conectarControlador(controladorCamarero);
		controladorIngrediente = new ControladorIngrediente(frame.getVistaIngrediente());
		frame.getVistaIngrediente().conectarControlador(controladorIngrediente);
		controladorPlato = new ControladorPlato(frame.getVistaPlato());
		frame.getVistaPlato().conectarControlador(controladorPlato);
		controladorMesa = new ControladorMesa(frame.getVistaMesa());
		frame.getVistaMesa().conectarControlador(controladorMesa);
		controladorCuenta = new ControladorCuenta(frame.getVistaCuenta());
		frame.getVistaCuenta().conectarControlador(controladorCuenta);

		//Muestro el panel "Home" al iniciar 
		frame.mostrarVista(frame.getVistaHome());
		
		//Hago el frame principal visible
		frame.setVisible(true);
	}

	//Método para mostrar el panel seleccionado en el menú y que carga las tablas. 
	//También maneja los botones de creación, inserción y borrado de las tablas
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == frame.getVistaMenu().getPnlHome()) {
			frame.mostrarVista(frame.getVistaHome());
		} else if (e.getSource() == frame.getVistaMenu().getPnlBebidas()) {
			frame.mostrarVista(frame.getVistaBebida());
			controladorBebida.actualizarTabla();
		} else if (e.getSource() == frame.getVistaMenu().getPnlPlatos()) {
			frame.mostrarVista(frame.getVistaPlato());
			controladorPlato.actualizarTabla();
		} else if (e.getSource() == frame.getVistaMenu().getPnlIngredientes()) {
			frame.mostrarVista(frame.getVistaIngrediente());
			controladorIngrediente.actualizarTabla();
		} else if (e.getSource() == frame.getVistaMenu().getPnlCamareros()) {
			frame.mostrarVista(frame.getVistaCamarero());
			controladorCamarero.actualizarTabla();
		} else if (e.getSource() == frame.getVistaMenu().getPnlMesas()) {
			frame.mostrarVista(frame.getVistaMesa());
			controladorMesa.actualizarTabla();
		} else if (e.getSource() == frame.getVistaMenu().getPnlCuentas()) {
			frame.mostrarVista(frame.getVistaCuenta());
			controladorCuenta.actualizarTabla();
		} else if (e.getSource() == frame.getVistaHome().getBotonCrearTablas()) {
			SQLCrearTablas.crearTablas();
		} else if (e.getSource() == frame.getVistaHome().getBotonInsertarDatos()) {
			SQLInsertar.insertarDatosPrueba();
		} else if (e.getSource() == frame.getVistaHome().getBotonEliminarTablas()) {
			SQLEliminar.eliminarTablas();
		}

	}
}
