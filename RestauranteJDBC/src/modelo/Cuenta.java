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
	
	
	
	public LocalDate getFecha() {
		return fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public boolean isPago_recibido() {
		return pago_recibido;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public void setPago_recibido(boolean pago_recibido) {
		this.pago_recibido = pago_recibido;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Object getColumna(int columna) {
		return null;
	}
	
	
}
