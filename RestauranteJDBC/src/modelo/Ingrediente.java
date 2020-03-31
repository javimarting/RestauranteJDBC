package modelo;

import java.util.ArrayList;

public class Ingrediente extends EntidadNombrePrecio{

	private ArrayList<Plato> platos;
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(String nombre, Double precio) {
		super(nombre, precio);
		platos = new ArrayList<>();
	}

	public ArrayList<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}
	
	
}
