package modelo;

import java.util.ArrayList;

public class Plato extends NombrePrecio{

private ArrayList<Cuenta> cuentas;
	
	public Plato() {
		
	}
	
	public Plato(String nombre, Double precio) {
		super(nombre, precio);
		cuentas = new ArrayList<>();
	}
}
