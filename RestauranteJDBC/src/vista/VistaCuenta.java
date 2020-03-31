package vista;

import java.sql.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.Entidad;

public class VistaCuenta extends VistaEntidad {


	private static final long serialVersionUID = 6013944310181557945L;
	private JLabel lblCamarero;
	private JLabel lblMesa;
	private JLabel lblImporte;
	private JLabel lblMetodoPago;
	private JLabel lblPagoRecibido;
	
	private JComboBox<Entidad> cbCamareros;
	private JComboBox<Entidad> cbMesas;
	private JComboBox<String> cbMetodoPago;
	
	private JTextField txtImporte;
	private JCheckBox chbPagoRecibido;

	
	public VistaCuenta() {
		super("CUENTAS", new String[] {"id", "Fecha", "Importe", "Método pago", "Pago recibido"}, new String[] {"id", "Camarero"});
		
		lblCamarero = new JLabel("Camarero");
		lblCamarero.setBounds(40, 80, 60, 15);
		pnlDatos.add(lblCamarero);
		
		lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(40, 120, 60, 15);
		pnlDatos.add(lblMesa);
		
		lblImporte = new JLabel("Importe");
		lblImporte.setBounds(40, 160, 60, 15);
		pnlDatos.add(lblImporte);
		
		lblMetodoPago = new JLabel("Método pago");
		lblMetodoPago.setBounds(30, 200, 90, 15);
		pnlDatos.add(lblMetodoPago);
		
		lblPagoRecibido = new JLabel("Pago recibido");
		lblPagoRecibido.setBounds(30, 240, 90, 15);
		pnlDatos.add(lblPagoRecibido);
		
		cbCamareros = new JComboBox<>();
		cbCamareros.setBounds(130, 77, 140, 20);
		pnlDatos.add(cbCamareros);
		
		cbMesas = new JComboBox<>();
		cbMesas.setBounds(130, 117, 140, 20);
		pnlDatos.add(cbMesas);
		
		txtImporte = new JTextField();
		txtImporte.setBounds(130, 157, 140, 20);
		pnlDatos.add(txtImporte);
		
		cbMetodoPago = new JComboBox<>(new String[] {"Tarjeta", "Efectivo"});
		cbMetodoPago.setBounds(130, 197, 140, 20);
		cbMetodoPago.setSelectedItem(null);
		pnlDatos.add(cbMetodoPago);
		
		chbPagoRecibido = new JCheckBox();
		chbPagoRecibido.setBounds(130, 232, 150, 30);
		pnlDatos.add(chbPagoRecibido);
		
		pnlBotonesSecundario.setLocation(115, 390);
	}
	
	public void vaciarCampos() {
		cbCamareros.setSelectedItem(null);
		cbMesas.setSelectedItem(null);
		txtImporte.setText("");
		cbMetodoPago.setSelectedItem(null);
		chbPagoRecibido.setSelected(false);
	}

	public JComboBox<Entidad> getCbCamareros() {
		return cbCamareros;
	}

	public JComboBox<Entidad> getCbMesas() {
		return cbMesas;
	}

	public JTextField getTxtImporte() {
		return txtImporte;
	}

	public JComboBox<String> getCbMetodoPago() {
		return cbMetodoPago;
	}

	public JCheckBox getChbPagoRecibido() {
		return chbPagoRecibido;
	}

	public void setChbPagoRecibido(JCheckBox chbPagoRecibido) {
		this.chbPagoRecibido = chbPagoRecibido;
	}

	public void setCbMetodoPago(JComboBox<String> cbMetodoPago) {
		this.cbMetodoPago = cbMetodoPago;
	}

	public void setTxtImporte(JTextField txtImporte) {
		this.txtImporte = txtImporte;
	}

	public void setCbCamareros(JComboBox<Entidad> cbCamareros) {
		this.cbCamareros = cbCamareros;
	}

	public void setCbMesas(JComboBox<Entidad> cbMesas) {
		this.cbMesas = cbMesas;
	}
	
	

}
