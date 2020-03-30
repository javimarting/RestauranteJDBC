package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Bebida;
import modelo.Camarero;
import modelo.Entidad;
import modelo.Ingrediente;
import modelo.Plato;

public class SQLConsulta {

	private static PreparedStatement miSentencia;
	
	public  static ArrayList<Entidad> consultarBebidas() {
		ResultSet rs;
		ArrayList<Entidad> bebidas = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM bebidas");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Bebida bebida = new Bebida();
				bebida.setId(rs.getInt("id"));
				bebida.setNombre(rs.getString("nombre"));
				bebida.setPrecio(rs.getDouble("precio"));
				
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
	
	public  static ArrayList<Entidad> consultarPlatos() {
		ResultSet rs;
		ArrayList<Entidad> platos = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM platos");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Plato plato = new Plato();
				plato.setId(rs.getInt("id"));
				plato.setNombre(rs.getString("nombre"));
				plato.setPrecio(rs.getDouble("precio"));
				
				platos.add(plato);
			}
			rs.close();
			miSentencia.close();
			return platos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public  static ArrayList<Entidad> consultarIngredientes() {
		ResultSet rs;
		ArrayList<Entidad> ingredientes = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM ingredientes");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setId(rs.getInt("id"));
				ingrediente.setNombre(rs.getString("nombre"));
				ingrediente.setPrecio(rs.getDouble("precio"));
				
				ingredientes.add(ingrediente);
			}
			rs.close();
			miSentencia.close();
			return ingredientes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public  static ArrayList<Entidad> consultarCamareros() {
		ResultSet rs;
		ArrayList<Entidad> camareros = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM camareros");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Camarero camarero = new Camarero();
				camarero.setId(rs.getInt("id"));
				camarero.setNombre(rs.getString("nombre"));
				camarero.setApellido(rs.getString("apellido"));
				camarero.setDni(rs.getString("dni"));
				camarero.setSueldo(rs.getInt("sueldo"));
				
				camareros.add(camarero);
			}
			rs.close();
			miSentencia.close();
			return camareros;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
