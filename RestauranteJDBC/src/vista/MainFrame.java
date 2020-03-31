package vista;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Controlador;



public class MainFrame extends JFrame {

	private static final long serialVersionUID = 7464192795906083075L;
	private JPanel contentPane;
	private VistaMenu vistaMenu;
	private VistaHome vistaHome;
	private VistaBebida vistaBebida;
	private VistaPlato vistaPlato;
	private VistaIngrediente vistaIngrediente;
	private VistaCamarero vistaCamarero;
	private VistaMesa vistaMesa;
	private VistaCuenta vistaCuenta;

	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(130, 171, 212));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		
		vistaMenu = new VistaMenu();
		contentPane.add(vistaMenu);
		
		vistaHome = new VistaHome();
		contentPane.add(vistaHome);
		
		vistaBebida = new VistaBebida();
		contentPane.add(vistaBebida);
		
		vistaPlato = new VistaPlato();
		contentPane.add(vistaPlato);
		
		vistaIngrediente = new VistaIngrediente();
		contentPane.add(vistaIngrediente);
		
		vistaCamarero = new VistaCamarero();
		contentPane.add(vistaCamarero);
		
		vistaMesa = new VistaMesa();
		contentPane.add(vistaMesa);
		
		vistaCuenta = new VistaCuenta();
		contentPane.add(vistaCuenta);
		
	}
	
	public void conectarControlador(Controlador c) {
		vistaHome.conectarControlador(c);
		vistaMenu.conectarControlador(c);
	}

	public void mostrarVista(JPanel vista) {
		vistaHome.setVisible(false);
		vistaBebida.setVisible(false);
		vistaPlato.setVisible(false);
		vistaIngrediente.setVisible(false);
		vistaCamarero.setVisible(false);
		vistaMesa.setVisible(false);
		vistaCuenta.setVisible(false);
		vista.setVisible(true);
	}
	
	public VistaMenu getVistaMenu() {
		return vistaMenu;
	}
	
	public VistaBebida getVistaBebida() {
		return vistaBebida;
	}

	public VistaHome getVistaHome() {
		return vistaHome;
	}
	
	public VistaPlato getVistaPlato() {
		return vistaPlato;
	}
	
	public VistaCamarero getVistaCamarero() {
		return vistaCamarero;
	}
	
	public VistaIngrediente getVistaIngrediente() {
		return vistaIngrediente;
	}
	
	public VistaMesa getVistaMesa() {
		return vistaMesa;
	}
	
	public VistaCuenta getVistaCuenta() {
		return vistaCuenta;
	}
}
