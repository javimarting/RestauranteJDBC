package modelo;

public class NombrePrecio extends Entidad{

	private String nombre;
	private Double precio;
	
	
	public NombrePrecio() {
		
	}
	
	public NombrePrecio(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Object getColumna(int columna) {
		switch(columna) {
		case 0:
			return id;
		case 1:
			return nombre;
		case 2:
			return precio;
		}
		return null;
	}
	
	public String toString() {
		return "Nombre: " + nombre;
	}
}
