package modelo;

import java.util.ArrayList;

public class Camarero extends Entidad{

	private String nombre;
	private String apellido;
	private String dni;
	private Integer sueldo;
	private ArrayList<Cuenta> cuentas;
	
	public Camarero() {
		
	}
	
	public Camarero(String nombre, String apellido, String dni, Integer sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sueldo = sueldo;
		cuentas = new ArrayList<>();
	}

	

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Object getColumna(int columna) {
		switch(columna) {
		case 0:
			return id;
		case 1:
			return nombre;
		case 2:
			return apellido;
		case 3:
			return dni;
		case 4:
			return sueldo;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido;
	}
	
	
}
