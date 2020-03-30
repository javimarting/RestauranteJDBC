package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConexion {
private static Connection conexion = null;
	
	public SQLConexion (){
		
		try {			
			Class.forName("org.sqlite.JDBC");			
		}catch(ClassNotFoundException e) {
			System.exit(0);
		}
		
		//Establecer conexión
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:./db/restaurante.db");
			conexion.createStatement().execute("PRAGMA foreign_keys=ON");
			
			
		}catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
		}
		
		
	}
	
	public static Connection getConexion() {
		return conexion;
	}
	
	public static void cerrarConexion() {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
