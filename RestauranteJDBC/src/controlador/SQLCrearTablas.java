package controlador;

import java.sql.SQLException;
import java.sql.Statement;

public class SQLCrearTablas {

	private static String camarero;
	private static String cuenta;
	private static String mesa;
	private static String bebida;
	private static String plato;
	private static String ingrediente;
	private static String plato_cuenta;
	private static String bebida_cuenta;
	private static String ingrediente_plato;
	
	public static void crearTablas() {
	try {
		Statement s = SQLConexion.getConexion().createStatement();
		
		 camarero = "CREATE TABLE IF NOT EXISTS camareros("
				+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "nombre TEXT NOT NULL,"
				+ "apellido TEXT NOT NULL,"
				+ "dni TEXT,"
				+ "sueldo INTEGER)";
		 
		 mesa = "CREATE TABLE IF NOT EXISTS mesas(" 
		 		+"id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
		 		+"num_personas INTEGER)";
		
		 cuenta = "CREATE TABLE IF NOT EXISTS cuentas("
				 	+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ "camareroId INTEGER,"
					+ "mesaId INTEGER,"
					+ "fecha TEXT,"
					+ "importe REAL,"
					+ "metodo_pago TEXT, "
					+ "pago_recibido NUMERIC,"
					+ "FOREIGN KEY(camareroId) REFERENCES camareros(id),"
					+ "FOREIGN KEY(mesaId) REFERENCES mesas(id))";
		 
		 
		 bebida = "CREATE TABLE IF NOT EXISTS bebidas"
				 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				 + "nombre TEXT NOT NULL,"
				 + "precio INTEGER NOT NULL)";
		 
		 plato = "CREATE TABLE IF NOT EXISTS platos"
				 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				 + "nombre TEXT NOT NULL,"
				 + "precio INTEGER NOT NULL)";
		 
		 ingrediente = "CREATE TABLE IF NOT EXISTS ingredientes"
				 	+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "nombre TEXT NOT NULL,"
					+ "precio REAL NOT NULL)";
		
		 plato_cuenta = "CREATE TABLE IF NOT EXISTS platos_cuentas"
				 	+ "(cuentaId INTEGER NOT NULL,"
					+ "platoId INTEGER NOT NULL,"
				 	+ "unidades INTEGER NOT NULL,"
					+ "FOREIGN KEY(cuentaId) REFERENCES cuentas(id),"
				 	+ "FOREIGN KEY (platoId) REFERENCES platos(id),"
					+ "PRIMARY KEY (cuentaId,platoId))";
		 
		 bebida_cuenta = "CREATE TABLE IF NOT EXISTS bebidas_cuentas"
				 	+ "(cuentaId INTEGER NOT NULL,"
					+ "bebidaId INTEGER NOT NULL,"
				 	+ "unidades INTEGER NOT NULL,"
					+ "FOREIGN KEY(cuentaId) REFERENCES cuentas(id),"
					+ "FOREIGN KEY (bebidaId) REFERENCES bebidas(id),"
					+ "PRIMARY KEY (cuentaId,bebidaId))";
		 
		 ingrediente_plato = "CREATE TABLE IF NOT EXISTS ingredientes_platos"
				 	+ "(ingredienteId INTEGER NOT NULL,"
					+ "platoId INTEGER NOT NULL,"
				 	+ "cantidad INTEGER NOT NULL,"
					+ "FOREIGN KEY(ingredientesId) REFERENCES ingredientes(id),"
					+ "FOREIGN KEY (platoId) REFERENCES platos(id),"
					+ "PRIMARY KEY (ingredientesId,platosId))";

		 
		 s.execute(camarero);
		 s.execute(mesa);
		 s.execute(cuenta);
		 s.execute(bebida);
		 s.execute(plato);
		 s.execute(ingrediente);
		 s.execute(plato_cuenta);
		 s.execute(bebida_cuenta);
		 s.execute(ingrediente_plato);
		 s.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	}
}
