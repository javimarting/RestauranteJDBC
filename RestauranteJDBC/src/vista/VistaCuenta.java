package vista;

import java.sql.Date;

public class VistaCuenta extends VistaEntidad {


	private static final long serialVersionUID = 6013944310181557945L;
	
	
	public VistaCuenta() {
		super("CUENTAS", new String[] {"id", "Fecha", "Importe"}, new String[] {"id", "Camarero"});
	}
	
	public void vaciarCampos() {
		
	}

}
