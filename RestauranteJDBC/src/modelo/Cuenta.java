package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Cuenta extends Entidad{

	private LocalDate fecha;
	private Double importe;
	private String metodo_pago;
	private boolean pago_recibido;
	private Camarero camarero;
	private Mesa mesa;
	
	public Cuenta() {
		
	}
	
	public Cuenta(Camarero camarero, Mesa mesa) {
		this.camarero = camarero;
		this.mesa = mesa;
		fecha = LocalDate.now();
		importe = 0.;
		metodo_pago = "tarjeta";
		pago_recibido = false;
	}
	
	public Object getColumna(int columna) {
		return null;
	}
}
