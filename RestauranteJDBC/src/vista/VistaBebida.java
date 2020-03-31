package vista;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaBebida extends VistaEntidad {

	private static final long serialVersionUID = -5588308423734549784L;
	
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JTextField txtNombre;
	private JTextField txtPrecio;

	public VistaBebida() {
		super("BEBIDAS", new String[] {"id", "Nombre", "Precio"}, new String[] {"id", "Nombre"});
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 110, 60, 15);
		pnlDatos.add(lblNombre);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(40, 160, 60, 15);
		pnlDatos.add(lblPrecio);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 107, 140, 20);
		pnlDatos.add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(130, 157, 140, 20);
		pnlDatos.add(txtPrecio);
		

	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public void vaciarCampos() {
		txtNombre.setText("");
		txtPrecio.setText("");
	}
	
	
}
