package controlador;

import java.util.ArrayList;

import modelo.Camarero;
import modelo.Cuenta;
import modelo.Entidad;
import vista.VistaCamarero;
import vista.VistaCuenta;

public class ControladorCuenta extends ControladorEntidad{

	public ControladorCuenta(VistaCuenta vistaCuenta) {
		super(vistaCuenta);
	}
	
	public void actualizarTabla() {
		//vistaEntidad.getModeloTabla().setFilas(SQLConsulta.consultarCuentas());
		cargarCamareros();
		cargarMesas();
	}
	
	public void cargarCampos() {
		/*Cuenta cuenta = (Cuenta)vistaEntidad.getEntidadSeleccionada();
		((VistaCuenta) vistaEntidad).getTxtNombre().setText((camarero.getNombre()));
		((VistaCuenta) vistaEntidad).getTxtApellido().setText((camarero.getApellido()));
		((VistaCuenta) vistaEntidad).getTxtDni().setText((camarero.getDni()));
		((VistaCuenta) vistaEntidad).getTxtSueldo().setText(String.valueOf((camarero.getSueldo())));*/
	}
	
	public Cuenta getEntidadModificada() {
		return null;
	}
	
	public Cuenta getEntidad() {
		return null;
	}
	
	public void buscar() {
		
	}
	
	public void cargarCamareros() {
		ArrayList<Entidad> camareros = SQLConsulta.consultarCamareros();
		for(Entidad camarero : camareros) {
			((VistaCuenta)vistaEntidad).getCbCamareros().addItem(camarero);
		}
		((VistaCuenta)vistaEntidad).getCbCamareros().setSelectedItem(null);
	}
	
	public void cargarMesas() {
		ArrayList<Entidad> mesas = SQLConsulta.consultarMesas();
		for(Entidad mesa : mesas) {
			((VistaCuenta)vistaEntidad).getCbMesas().addItem(mesa);
		}
		((VistaCuenta)vistaEntidad).getCbMesas().setSelectedItem(null);
	}
}
