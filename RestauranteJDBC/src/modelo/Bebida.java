package modelo;

import java.util.ArrayList;

public class Bebida extends NombrePrecio{

	private ArrayList<Cuenta> cuentas;
	
	public Bebida() {
		
	}
	
	public Bebida(String nombre, Double precio) {
		super(nombre, precio);
		cuentas = new ArrayList<>();
	}
	
	
}
