package controlador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Bebida;
import modelo.Camarero;
import modelo.Cuenta;
import modelo.Entidad;
import modelo.Ingrediente;
import modelo.Mesa;
import modelo.Plato;

public class SQLInsertar {

private static PreparedStatement miSentencia;
	
	public static void insertar(Entidad entidad) {

		if(Camarero.class.isInstance(entidad)) {
			insertarCamarero((Camarero)entidad);
		}
		else if(Bebida.class.isInstance(entidad)) {
			insertarBebida((Bebida)entidad);
		}
		else if(Plato.class.isInstance(entidad)) {
			insertarPlato((Plato)entidad);
		}
		else if(Cuenta.class.isInstance(entidad)) {
			insertarCuenta((Cuenta)entidad);
		}
		else if(Mesa.class.isInstance(entidad)) {
			insertarMesa((Mesa)entidad);
		}
		else if(Ingrediente.class.isInstance(entidad)) {
			insertarIngrediente((Ingrediente)entidad);
		}
	}
	
	public static void insertarCamarero(Camarero camarero) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("INSERT INTO camareros"
					+ " (nombre, apellido, dni, sueldo) VALUES (?, ?, ?, ?)");
			
			miSentencia.setString(1, camarero.getNombre());
			miSentencia.setString(2, camarero.getApellido());
			miSentencia.setString(3, camarero.getDni());
			miSentencia.setInt(4, camarero.getSueldo());
			miSentencia.execute();
			
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void insertarMesa(Mesa mesa) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("INSERT INTO mesas"
					+ " (num_personas) VALUES (?)");			
			miSentencia.setInt(1, mesa.getNumPersonas());
			miSentencia.execute();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public static void insertarBebida(Bebida bebida) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("INSERT INTO bebidas"
					+ " (nombre, precio) VALUES (?, ?)");		
			miSentencia.setString(1, bebida.getNombre());
			miSentencia.setDouble(2, bebida.getPrecio());
			miSentencia.execute();
			miSentencia.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	

	public static void insertarPlato(Plato plato) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("INSERT INTO platos"
					+ " (nombre, precio) VALUES (?, ?)");		
			miSentencia.setString(1, plato.getNombre());
			miSentencia.setDouble(2, plato.getPrecio());
			miSentencia.execute();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public static void insertarIngrediente(Ingrediente ingrediente) {
		try {
			miSentencia = SQLConexion.getConexion().prepareStatement("INSERT INTO ingredientes"
					+ " (nombre, precio) VALUES (?, ?)");		
			miSentencia.setString(1, ingrediente.getNombre());
			miSentencia.setDouble(2, ingrediente.getPrecio());
			miSentencia.execute();
			miSentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public static void insertarCuenta(Cuenta cuenta) {
		try {			
			miSentencia = SQLConexion.getConexion().prepareStatement("INSERT INTO Cuentas"
					+ " (camareroId, mesaId, fecha, importe, metodo_pago, pago_recibido) VALUES (?, ?, ?, ?, ?, ?)");		
			miSentencia.setInt(1, cuenta.getCamarero().getId());
			miSentencia.setInt(2, cuenta.getMesa().getId());
			miSentencia.setDate(3, Date.valueOf(cuenta.getFecha()));
			miSentencia.setDouble(4, cuenta.getImporte());
			miSentencia.setString(5, cuenta.getMetodo_pago());
			miSentencia.setBoolean(6, cuenta.getPago_recibido());			
			miSentencia.execute();
			miSentencia.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


public static void insertarDatosPrueba() {
	Camarero camarero1 = new Camarero("Javier", "Martin", "54298855H", 15000);
	Camarero camarero2 = new Camarero("Carolina", "Begara", "54298857C", 14000);
	Camarero camarero3 = new Camarero("Ana", "Pita", "54298827J", 20000);

	ArrayList<Camarero> camareros_prueba = new ArrayList<>();

	camareros_prueba.add(camarero1);
	camareros_prueba.add(camarero2);
	camareros_prueba.add(camarero3);

	for (Camarero camarero : camareros_prueba) {
		insertarCamarero(camarero);
		//camarero.setId(SQLConsultarTabla.consultarCamareroId(camarero));
	}
		
	
	//Mesas prueba
	Mesa mesa1 = new Mesa (6);
	Mesa mesa2 = new Mesa(8);
	
	ArrayList<Mesa> mesas_prueba = new ArrayList<>();
	
	mesas_prueba.add(mesa1);
	mesas_prueba.add(mesa2);
	
	for(Mesa mesa : mesas_prueba) {
		insertarMesa(mesa);
		//mesa.setId(SQLConsultarTabla.consultarMesa("id", ));
	}
	
	//Cuentas prueba
	/*
	Cuenta cuenta1 = new Cuenta (camarero1, mesa2);
	Cuenta cuenta2 = new Cuenta(camarero3, mesa1);
	
	ArrayList<Cuenta> cuentas_prueba = new ArrayList<>();
	
	cuentas_prueba.add(cuenta1);
	cuentas_prueba.add(cuenta2);
	
	
	for(Cuenta cuenta : cuentas_prueba) {
		insertarCuenta(cuenta);
	}*/
	
	//Bebidas prueba
	Bebida bebida1 = new Bebida("Coca-cola", 2.5);
	Bebida bebida2 = new Bebida("Fanta Naranja", 2.5);
	
	ArrayList<Bebida> bebidas_prueba = new ArrayList<>();
	
	bebidas_prueba.add(bebida1);
	bebidas_prueba.add(bebida2);
	
	for(Bebida bebida : bebidas_prueba) {
		insertarBebida(bebida);
	}
	
	//Ingredientes prueba
	Ingrediente ingrediente1 = new Ingrediente("Queso", 2.5);
	Ingrediente ingrediente2 = new Ingrediente("Tomate", 1.5);
	
	ArrayList<Ingrediente> ingredientes_prueba = new ArrayList<>();
	
	ingredientes_prueba.add(ingrediente1);
	ingredientes_prueba.add(ingrediente2);
	
	for(Ingrediente ingrediente : ingredientes_prueba) {
		insertarIngrediente(ingrediente);
	}
	
	//Platos prueba
	Plato plato1 = new Plato("Ensalada", 10.);
	Plato plato2 = new Plato("Hamburguesa", 15.);
	
	ArrayList<Plato> platos_prueba = new ArrayList<>();
	
	platos_prueba.add(plato1);
	platos_prueba.add(plato2);
	
	for(Plato plato : platos_prueba) {
		insertarPlato(plato);
	}
	
	}
}
