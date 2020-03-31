package vista;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaCamarero extends VistaEntidad {

	private static final long serialVersionUID = 1712130150097074006L;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblSueldo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtSueldo;
	
	public VistaCamarero() {
		super("CAMAREROS", new String[] {"id", "Nombre", "Apellido", "DNI", "Sueldo"}, new String[] {"id", "Nombre", "Apellido"});
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 80, 60, 15);
		pnlDatos.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 120, 60, 15);
		pnlDatos.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(40, 160, 60, 15);
		pnlDatos.add(lblDni);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(40, 200, 60, 15);
		pnlDatos.add(lblSueldo);
		
		txtNombre = new JTextField();
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
		pnlDatos.add(txtSueldo);
		
		pnlBotonesSecundario.setLocation(115, 350);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public JTextField getTxtSueldo() {
		return txtSueldo;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public void setTxtSueldo(JTextField txtSueldo) {
		this.txtSueldo = txtSueldo;
	}

	public void vaciarCampos() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtSueldo.setText("");
	}
	
}
