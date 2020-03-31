package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Bebida;
import modelo.Camarero;
import modelo.Cuenta;
import modelo.Entidad;
import modelo.Ingrediente;
import modelo.Mesa;
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
	
	public  static ArrayList<Entidad> consultarMesas() {
		ResultSet rs;
		ArrayList<Entidad> mesas = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM mesas");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Mesa mesa = new Mesa();
				mesa.setId(rs.getInt("id"));
				mesa.setNumPersonas(rs.getInt("num_personas"));			
				
				mesas.add(mesa);
			}
			rs.close();
			miSentencia.close();
			return mesas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public  static ArrayList<Entidad> consultarCuentas() {
		ResultSet rs;
		ArrayList<Entidad> cuentas = new ArrayList<>();
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("SELECT * FROM cuentas");
			rs = miSentencia.executeQuery();
			while(rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setId(rs.getInt("id"));
				Integer camareroId = rs.getInt("camareroId");
				cuenta.setCamarero((Camarero)consultarCamarero("id", String.valueOf(camareroId)).get(0));		
				Integer mesaId = rs.getInt("mesaId");
				cuenta.setMesa((Mesa)consultarMesa("id", String.valueOf(mesaId)).get(0));
				cuenta.setImporte(rs.getDouble("importe"));
				cuenta.setMetodo_pago(rs.getString("metodo_pago"));
				cuenta.setPago_recibido(rs.getBoolean("pago_recibido"));
				//cuenta.setFecha(rs.getDate("fecha").toLocalDate());
				
				cuentas.add(cuenta);
			}
			rs.close();
			miSentencia.close();
			return cuentas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Entidad> consultarCamarero(String opcion, String valor) {
		ResultSet rs;
		ArrayList<Entidad> camareros = new ArrayList<>();
		String consulta = "SELECT * FROM camareros WHERE "+opcion+" = ?";
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement(consulta);
			if(opcion == "id") {
				miSentencia.setInt(1, Integer.valueOf(valor));
			}
			else if(opcion == "Nombre" || opcion == "Apellido") {
				miSentencia.setString(1, valor);
			}
			
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
		}catch(SQLException e) {
			return null;
		}
	}
	
	public static ArrayList<Entidad> consultarCuenta(String opcion, String valor) {
		ResultSet rs;
		ArrayList<Entidad> cuentas = new ArrayList<>();
		String consulta = "SELECT * FROM cuentas WHERE "+opcion+" = ?";
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement(consulta);
			if(opcion == "id") {
				miSentencia.setInt(1, Integer.valueOf(valor));
			}
			
			rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setId(rs.getInt("id"));
				cuenta.setCamarero((Camarero)consultarCamarero("id", String.valueOf(rs.getInt("camareroId"))).get(0));
				cuenta.setMesa((Mesa)consultarMesa("id", String.valueOf(rs.getInt("mesaId"))).get(0));
				cuenta.setImporte(rs.getDouble("importe"));
				cuenta.setMetodo_pago(rs.getString("metodo_pago"));
				cuenta.setPago_recibido(rs.getBoolean("pago_recibido"));
				
				cuentas.add(cuenta);
			}
			
			rs.close();
			miSentencia.close();
			return cuentas;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public static ArrayList<Entidad> consultarBebida(String opcion, String valor) {
		ResultSet rs;
		ArrayList<Entidad> bebidas = new ArrayList<>();
		String consulta = "SELECT * FROM bebidas WHERE "+opcion+" = ?";
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement(consulta);
			if(opcion == "id") {
				miSentencia.setInt(1, Integer.valueOf(valor));
			}
			else if(opcion == "Nombre") {
				miSentencia.setString(1, valor);
			}
			
			
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
		}catch(SQLException e) {
			return null;
		}
	}
	
	public static ArrayList<Entidad> consultarPlato(String opcion, String valor) {
		ResultSet rs;
		ArrayList<Entidad> platos = new ArrayList<>();
		String consulta = "SELECT * FROM platos WHERE "+opcion+" = ?";
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement(consulta);
			if(opcion == "id") {
				miSentencia.setInt(1, Integer.valueOf(valor));
			}
			else if(opcion == "Nombre") {
				miSentencia.setString(1, valor);
			}
			
			
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
		}catch(SQLException e) {
			return null;
		}
	}
	
	public static ArrayList<Entidad> consultarIngrediente(String opcion, String valor) {
		ResultSet rs;
		ArrayList<Entidad> ingredientes = new ArrayList<>();
		String consulta = "SELECT * FROM ingredientes WHERE "+opcion+" = ?";
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement(consulta);
			if(opcion == "id") {
				miSentencia.setInt(1, Integer.valueOf(valor));
			}
			else if(opcion == "Nombre") {
				miSentencia.setString(1, valor);
			}
			
			
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
		}catch(SQLException e) {
			return null;
		}
	}
	
	public static ArrayList<Entidad> consultarMesa(String opcion, String valor) {
		ResultSet rs;
		ArrayList<Entidad> mesas = new ArrayList<>();
		String consulta = "SELECT * FROM mesas WHERE "+opcion+" = ?";
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement(consulta);
			
				miSentencia.setInt(1, Integer.valueOf(valor));
			
			
			rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				Mesa mesa = new Mesa();
				mesa.setId(rs.getInt("id"));
				mesa.setNumPersonas(rs.getInt("num_personas"));				
				
				mesas.add(mesa);
			}
			
			rs.close();
			miSentencia.close();
			return mesas;
		}catch(SQLException e) {
			return null;
		}
	}
}
