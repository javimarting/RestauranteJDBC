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

public class SQLEliminar {
private static PreparedStatement miSentencia;
	
	public static void eliminar(Entidad entidad) {
		
			if(Camarero.class.isInstance(entidad)) {
				eliminarCamarero(entidad.getId());
			}
			else if(Bebida.class.isInstance(entidad)) {
				eliminarBebida(entidad.getId());
			}
			else if(Plato.class.isInstance(entidad)) {
				eliminarPlato(entidad.getId());
			}
			else if(Cuenta.class.isInstance(entidad)) {
				//eliminarCuenta(entidad.getId());
			}
			else if(Mesa.class.isInstance(entidad)) {
				eliminarMesa(entidad.getId());
			}
			else if(Ingrediente.class.isInstance(entidad)) {
				eliminarIngrediente(entidad.getId());
			}	
		
	}
	
	
	public static void eliminarCamarero(Integer id) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("DELETE FROM Camareros WHERE id = (?)");
			miSentencia.setInt(1, id);
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void eliminarBebida(Integer id) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("DELETE FROM Bebidas WHERE id = (?)");
			miSentencia.setInt(1, id);
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarIngrediente(Integer id) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("DELETE FROM Ingredientes WHERE id = (?)");
			miSentencia.setInt(1, id);
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarMesa(Integer id) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("DELETE FROM Mesas WHERE id = (?)");
			miSentencia.setInt(1, id);
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarPlato(Integer id) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("DELETE FROM Platos WHERE id = (?)");
			miSentencia.setInt(1, id);
			miSentencia.executeUpdate();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarTablas() {
		try {
			PreparedStatement s = SQLConexion.getConexion().prepareStatement("DROP TABLE IF EXISTS ?");
			
			s.setString(1, "camareros");
			s.executeUpdate();
			s.setString(1, "cuentas");
			s.executeUpdate();
			s.setString(1, "bebidas");
			s.executeUpdate();
			s.setString(1, "mesas");
			s.executeUpdate();
			s.setString(1, "ingredientes");
			s.executeUpdate();
			s.setString(1, "platos");
			s.executeUpdate();
			s.setString(1, "plato_cuenta");
			s.executeUpdate();
			s.setString(1, "bebida_cuenta");
			s.executeUpdate();
			s.setString(1, "ingrediente_plato");
			s.executeUpdate();
			
			s.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
