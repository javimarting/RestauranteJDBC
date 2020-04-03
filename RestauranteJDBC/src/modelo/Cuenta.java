package modelo;

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
	
	public Cuenta(Camarero camarero, Mesa mesa, Double importe, String metodo_pago, Boolean pago_recibido) {
		this.camarero = camarero;
		this.mesa = mesa;
		fecha = LocalDate.now();
		this.importe = importe;
		this.metodo_pago = metodo_pago;
		this.pago_recibido = pago_recibido;
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

	public boolean getPago_recibido() {
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
		switch(columna) {
		case 0:
			return id;
		case 1:
			return camarero.getNombre() + " (id: " + camarero.getId() + ")";
		case 2:
			return mesa.getId();
		case 3:
			return importe;
		case 4:
			return metodo_pago;
		case 5:
			if(pago_recibido) {
				return "Sí";
			}else {
				return "No";
			}
		}
		return null;
	}
	
	
}
