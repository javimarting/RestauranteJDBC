package modelo;

public abstract class Entidad {

	protected Integer id;
	
	public Entidad() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public abstract Object getColumna(int columna);
}
