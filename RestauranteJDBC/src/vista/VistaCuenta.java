package vista;

import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Camarero;
import modelo.Entidad;
import modelo.Mesa;

public class VistaCuenta extends VistaEntidad {


	private static final long serialVersionUID = 6013944310181557945L;
	private JLabel lblCamarero;
	private JLabel lblMesa;
	private JLabel lblImporte;
	private JLabel lblMetodoPago;
	
	private JComboBox<Entidad> cbCamareros;
	private JComboBox<Entidad> cbMesas;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtSueldo;
	
	public VistaCuenta() {
		super("CUENTAS", new String[] {"id", "Fecha", "Importe"}, new String[] {"id", "Camarero"});
		
		lblCamarero = new JLabel("Camarero");
		lblCamarero.setBounds(40, 80, 60, 15);
		pnlDatos.add(lblCamarero);
		
		lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(40, 120, 60, 15);
		pnlDatos.add(lblMesa);
		
		lblImporte = new JLabel("DNI");
		lblImporte.setBounds(40, 160, 60, 15);
		pnlDatos.add(lblImporte);
		
		lblMetodoPago = new JLabel("Sueldo");
		lblMetodoPago.setBounds(40, 200, 60, 15);
		pnlDatos.add(lblMetodoPago);
		
		cbCamareros = new JComboBox<>();
		cbCamareros.setBounds(130, 77, 140, 20);
		pnlDatos.add(cbCamareros);
		
		cbMesas = new JComboBox<>();
		cbMesas.setBounds(130, 117, 140, 20);
		pnlDatos.add(cbMesas);
		
		/*txtNombre = new JTextField();
		txtNombre.setBounds(130, 77, 140, 20);
		pnlDatos.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(130, 117, 140, 20);
		pnlDatos.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setBounds(130, 157, 140, 20);
		pnlDatos.add(txtDni);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(130, 197, 140, 20);
		pnlDatos.add(txtSueldo);*/
		
		pnlBotonesSecundario.setLocation(115, 350);
	}
	
	public void vaciarCampos() {
		
	}

	public JComboBox<Entidad> getCbCamareros() {
		return cbCamareros;
	}

	public JComboBox<Entidad> getCbMesas() {
		return cbMesas;
	}

	public void setCbCamareros(JComboBox<Entidad> cbCamareros) {
		this.cbCamareros = cbCamareros;
	}

	public void setCbMesas(JComboBox<Entidad> cbMesas) {
		this.cbMesas = cbMesas;
	}
	
	

}
