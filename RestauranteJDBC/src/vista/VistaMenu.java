package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.Controlador;


public class VistaMenu extends JPanel {

	private JPanel pnlCamareros;
	private JPanel pnlPlatos;
	private JPanel pnlCuentas;
	private JPanel pnlHome;
	private JPanel pnlBebidas;
	private JPanel pnlMesas;
	private JPanel pnlIngredientes;
	private JLabel lblHome;
	private JLabel lblCamareros;
	private JLabel lblCuentas;
	private JLabel lblMesas;
	private JLabel lblBebidas;
	private JLabel lblPlatos;
	private JLabel lblIngredientes;
	private JLabel lblLogo;

	private Image img_camarero = 
			new ImageIcon(VistaMenu.class.getResource("../res/waiter.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	private Image img_cuenta = 
			new ImageIcon(VistaMenu.class.getResource("../res/bill.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	private Image img_home = 
			new ImageIcon(VistaMenu.class.getResource("../res/home.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	private Image img_logo = 
			new ImageIcon(VistaMenu.class.getResource("../res/food.png")).
			getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	
	private Image img_plato = 
			new ImageIcon(VistaMenu.class.getResource("../res/plate.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	private Image img_bebida = 
			new ImageIcon(VistaMenu.class.getResource("../res/drink.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	private Image img_mesa = 
			new ImageIcon(VistaMenu.class.getResource("../res/table.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	private Image img_ingrediente = 
			new ImageIcon(VistaMenu.class.getResource("../res/ingredient.png")).
			getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	
	
	public VistaMenu() {
		
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 170, 578);
		setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(20, 22, 130, 107);
		lblLogo.setIcon(new ImageIcon(img_logo));
		add(lblLogo);
		
		pnlHome = new JPanel();
		configuracionPanel(pnlHome, 140);
		mouseListen(pnlHome);
		configuracionLabel("HOME", lblHome, pnlHome, new ImageIcon(img_home));
		
		pnlCamareros = new JPanel();
		configuracionPanel(pnlCamareros, 212);
		mouseListen(pnlCamareros);
		configuracionLabel("CAMAREROS", lblCamareros, pnlCamareros, new ImageIcon(img_camarero));
		
		pnlCuentas = new JPanel();
		configuracionPanel(pnlCuentas, 176);
		mouseListen(pnlCuentas);
		configuracionLabel("CUENTAS", lblCuentas, pnlCuentas, new ImageIcon(img_cuenta));
		
		pnlPlatos = new JPanel();
		configuracionPanel(pnlPlatos, 320);
		mouseListen(pnlPlatos);
		configuracionLabel("PLATOS", lblPlatos, pnlPlatos, new ImageIcon(img_plato));
		
		pnlBebidas = new JPanel();
		configuracionPanel(pnlBebidas, 284);
		mouseListen(pnlBebidas);
		configuracionLabel("BEBIDAS", lblBebidas, pnlBebidas, new ImageIcon(img_bebida));		
		
		pnlMesas = new JPanel();
		configuracionPanel(pnlMesas, 248);
		mouseListen(pnlMesas);
		configuracionLabel("MESAS", lblMesas, pnlMesas, new ImageIcon(img_mesa));
		
		pnlIngredientes = new JPanel();
		configuracionPanel(pnlIngredientes, 356);
		mouseListen(pnlIngredientes);
		configuracionLabel("INGREDIENTES", lblIngredientes, pnlIngredientes, new ImageIcon(img_ingrediente));

		cambiarColorPanel(pnlHome);
	}
	
	
	//Getters
	public JPanel getPnlCamareros() {
		return pnlCamareros;
	}


	public JPanel getPnlPlatos() {
		return pnlPlatos;
	}


	public JPanel getPnlCuentas() {
		return pnlCuentas;
	}


	public JPanel getPnlHome() {
		return pnlHome;
	}


	public JPanel getPnlBebidas() {
		return pnlBebidas;
	}


	public JPanel getPnlMesas() {
		return pnlMesas;
	}


	public JPanel getPnlIngredientes() {
		return pnlIngredientes;
	}


	public void cambiarColorPanel(JPanel panel) {
		pnlHome.setBackground(new Color(51, 102, 153));
		pnlCamareros.setBackground(new Color(51, 102, 153));
		pnlCuentas.setBackground(new Color(51, 102, 153));
		pnlPlatos.setBackground(new Color(51, 102, 153));
		pnlMesas.setBackground(new Color(51, 102, 153));
		pnlBebidas.setBackground(new Color(51, 102, 153));
		pnlIngredientes.setBackground(new Color(51, 102, 153));		
		panel.setBackground(new Color(130, 171, 212));
	}
	
	public void configuracionPanel(JPanel panel, int y) {
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, y, 170, 36);		
		add(panel);
	}
	
	public void configuracionLabel(String nombre, JLabel label, JPanel panel, ImageIcon imagen) {
		label = new JLabel(nombre);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.WHITE);
		label.setBounds(25, 3, 122, 30);
		label.setIcon(imagen);
		panel.add(label);
	}
	
	public void mouseListen(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambiarColorPanel(panel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
	
	public void conectarControlador(Controlador c) {				
		pnlCamareros.addMouseListener(c);
		pnlHome.addMouseListener(c);
		pnlCuentas.addMouseListener(c);
		pnlBebidas.addMouseListener(c);
		pnlIngredientes.addMouseListener(c);
		pnlMesas.addMouseListener(c);
		pnlPlatos.addMouseListener(c);
	}

	
}
