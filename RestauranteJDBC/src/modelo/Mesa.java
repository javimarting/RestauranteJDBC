package modelo;

import java.util.ArrayList;

public class Mesa extends Entidad{

	private Integer num_personas;
	private ArrayList<Cuenta> cuentas;
	
	public Mesa() {
		
	}
	
	public Mesa(Integer num_personas) {
		this.num_personas = num_personas;
		cuentas = new ArrayList<>();
	}
	
	public Object getColumna(int columna) {
		switch(columna) {
		case 0:
			return id;
		case 1:
			return num_personas;
		}
		return null;
	}

	public Integer getNumPersonas() {
		return num_personas;
	}

	public void setNumPersonas(Integer num_personas) {
		this.num_personas = num_personas;
	}
	
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return id + " --> " + num_personas + " personas";
	}
}
