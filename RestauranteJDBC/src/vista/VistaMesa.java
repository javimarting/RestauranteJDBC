package vista;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaMesa extends VistaEntidad {

	private static final long serialVersionUID = -8050512978397581927L;
	private JLabel lblNumPersonas;
	private JTextField txtNumPersonas;
	
	public VistaMesa() {
		super("MESAS", new String[] {"id", "Num_Personas"}, new String[] {"id", "Numero Personas"});
		
		busqueda.put("Numero Personas", "num_personas");
		
		lblNumPersonas = new JLabel("Num_Personas");
		lblNumPersonas.setBounds(25, 140, 100, 15);
		pnlDatos.add(lblNumPersonas);
		
		txtNumPersonas = new JTextField();
		txtNumPersonas.setBounds(130, 137, 140, 20);
		pnlDatos.add(txtNumPersonas);
		

	}

	public JTextField getTxtNumPersonas() {
		return txtNumPersonas;
	}

	public void setTxtNumPersonas(JTextField txtNumPersonas) {
		this.txtNumPersonas = txtNumPersonas;
	}

	public void vaciarCampos() {
		txtNumPersonas.setText("");
	}
}
