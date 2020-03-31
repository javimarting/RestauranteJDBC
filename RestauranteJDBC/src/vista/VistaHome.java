package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controlador.Controlador;


public class VistaHome extends JPanel {


	private static final long serialVersionUID = -8870925811170010039L;
	private JButton btnCrearTablas;
	private JButton btnInsertarDatos;
	private JButton btnEliminarTablas;
	
	
	public VistaHome() {
		
		setBackground(new Color(130, 171, 212));
		setBounds(170, 0, 530, 578);
		setLayout(null);
		
		btnCrearTablas = new JButton("CREAR TABLAS");
		mouseListen(btnCrearTablas);
		configuracionBoton(btnCrearTablas, 203);
		
		btnInsertarDatos = new JButton("INSERTAR DATOS DE PRUEBA");
		mouseListen(btnInsertarDatos);
		configuracionBoton(btnInsertarDatos, 260);
		
		btnEliminarTablas = new JButton("BORRAR TABLAS");
		mouseListen(btnEliminarTablas);
		configuracionBoton(btnEliminarTablas, 317);
		
	}
	
	public JButton getBotonCrearTablas() {
		return btnCrearTablas;
	}
	
	public JButton getBotonInsertarDatos() {
		return btnInsertarDatos;
	}
	
	public JButton getBotonEliminarTablas() {
		return btnEliminarTablas;
	}
	
	public void configuracionBoton(JButton boton, int y) {
		boton.setOpaque(true);
		boton.setForeground(Color.WHITE);
		boton.setBorder(null);
		boton.setBackground(new Color(51, 102, 153));
		boton.setBounds(156, y, 213, 35);
		add(boton);
	}
	
	public void mouseListen(JButton boton) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}			
			@Override
			public void mousePressed(MouseEvent e) {
				boton.setBorder(new LineBorder(new Color(0, 0, 51), 2));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				boton.setBorder(null);
			}
		});
	}
	
	public void conectarControlador(Controlador c) {
		btnCrearTablas.addMouseListener(c);
		btnInsertarDatos.addMouseListener(c);
		btnEliminarTablas.addMouseListener(c);
	}
}
