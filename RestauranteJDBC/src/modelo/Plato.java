package modelo;

import java.util.ArrayList;

public class Plato extends EntidadNombrePrecio{

private ArrayList<Cuenta> cuentas;
	
	public Plato() {
		
	}
	
	public Plato(String nombre, Double precio) {
		super(nombre, precio);
		cuentas = new ArrayList<>();
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	
}
