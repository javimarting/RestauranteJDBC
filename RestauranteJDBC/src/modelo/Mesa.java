package modelo;

public class Mesa extends Entidad{

	private Integer num_personas;
	
	public Mesa() {
		
	}
	
	public Mesa(Integer num_personas) {
		this.num_personas = num_personas;
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
	
}
