package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Bebida;

public class SQLConsulta {

	private static PreparedStatement miSentencia;
	
	public  static ArrayList<Bebida> consultarBebidas() {
		ResultSet rs;
		ArrayList<Bebida> bebidas = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM bebidas");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Bebida bebida = new Bebida();
				bebida.setId(rs.getInt("id"));
				bebida.setNombre(rs.getString("Nombre"));
				bebida.setPrecio(rs.getDouble("Precio"));
				
				bebidas.add(bebida);
			}
			rs.close();
			miSentencia.close();
			return bebidas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
