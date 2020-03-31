package vista;


public class VistaCamarero extends VistaEntidad {

	private static final long serialVersionUID = 1712130150097074006L;

	public VistaCamarero() {
		super("CAMAREROS", new String[] {"id", "Nombre", "Apellido", "DNI", "Sueldo"}, new String[] {"id", "Nombre", "Apellido"});
	}

	
}
