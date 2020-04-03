package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Bebida;
import modelo.Camarero;
import modelo.Cuenta;
import modelo.Entidad;
import modelo.Ingrediente;
import modelo.Mesa;
import modelo.Plato;

public class SQLModificar {
private static PreparedStatement miSentencia;
	
	public static void modificar(Entidad entidad) {

		if(Camarero.class.isInstance(entidad)) {
			modificarCamarero((Camarero)entidad);
		}
		else if(Bebida.class.isInstance(entidad)) {
			modificarBebida((Bebida)entidad);
		}
		else if(Plato.class.isInstance(entidad)) {
			modificarPlato((Plato)entidad);
		}
		else if(Cuenta.class.isInstance(entidad)) {
			modificarCuenta((Cuenta)entidad);
		}
		else if(Mesa.class.isInstance(entidad)) {
			modificarMesa((Mesa)entidad);
		}
		else if(Ingrediente.class.isInstance(entidad)) {
			modificarIngrediente((Ingrediente)entidad);
		}
	}
	
	public static void modificarCamarero(Camarero camarero) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("UPDATE camareros SET nombre = ?, apellido = ?, dni = ?, sueldo = ? WHERE id = ?");
			
			miSentencia.setString(1, camarero.getNombre());
			miSentencia.setString(2, camarero.getApellido());
			miSentencia.setString(3, camarero.getDni());
			miSentencia.setInt(4, camarero.getSueldo());
			miSentencia.setInt(5, camarero.getId());
			
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarCuenta(Cuenta cuenta) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("UPDATE cuentas SET camareroId = ?, mesaId = ?, importe = ?,"
					+ " metodo_pago = ?, pago_recibido = ? WHERE id = ?");
			
			miSentencia.setInt(1, cuenta.getCamarero().getId());
			miSentencia.setInt(2, cuenta.getMesa().getId());
			miSentencia.setDouble(3, cuenta.getImporte());
			miSentencia.setString(4, cuenta.getMetodo_pago());
			miSentencia.setBoolean(5, cuenta.getPago_recibido());
			miSentencia.setInt(6, cuenta.getId());
			
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarBebida(Bebida bebida) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("UPDATE bebidas SET nombre = ?, precio = ? WHERE id = ?");
			
			miSentencia.setString(1, bebida.getNombre());
			miSentencia.setDouble(2, bebida.getPrecio());
			miSentencia.setInt(3, bebida.getId());
			
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarMesa(Mesa mesa) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("UPDATE mesas SET num_personas = ? WHERE id = ?");
			
			miSentencia.setInt(1, mesa.getNumPersonas());
			miSentencia.setInt(2, mesa.getId());
			
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarPlato(Plato plato) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("UPDATE platos SET nombre = ?, precio = ? WHERE id = ?");
			
			miSentencia.setString(1, plato.getNombre());
			miSentencia.setDouble(2, plato.getPrecio());
			miSentencia.setInt(3, plato.getId());
			
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarIngrediente(Ingrediente ingrediente) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("UPDATE ingredientes SET nombre = ?, precio = ? WHERE id = ?");
			
			miSentencia.setString(1, ingrediente.getNombre());
			miSentencia.setDouble(2, ingrediente.getPrecio());
			miSentencia.setInt(3, ingrediente.getId());
			
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
