package com.tatiana.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;



public class VentanaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private AbstractButton itemRegistrarPersonas; 
	private JMenuItem itemConsultarPersonas;
	private JMenuItem itemEliminarPersonas;
	private JMenuItem itemRegistrarMascotas;
	private JMenuItem itemConsultarMascotas;
	private JMenuItem itemActualizarMascotas;
	private JMenuItem itemEliminarMascotas;
	private JMenuItem itemEliminarProductos;
	private JMenuItem itemActualizarProductos;
	private JMenuItem itemConsultaProductos;
	private JMenuItem itemRegistroProductos;
	private JMenuItem itemActualizarPersonas;
	private JMenuItem itemListarMascotas;
	private JMenuBar menuBar;
	private JMenu menuPersonas;
	private JMenu MenuMascotas;
	private JMenu menuProductos;
	private JLabel lblTitulo;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblImagen;
	private Coordinador miCoordinador;
	private JMenuItem itemListarProductos;
	private JMenuItem itemComprarProductos;

	
	public VentanaPrincipal() {
		iniciarComponentes();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setResizable(false);
		setTitle("Clinica Veterinaria");
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuPersonas = new JMenu("Gestionar Personas");
		menuBar.add(menuPersonas);
		
		itemRegistrarPersonas = new JMenuItem("Registrar");
		itemRegistrarPersonas.addActionListener(this);
		menuPersonas.add(itemRegistrarPersonas);
		
		itemConsultarPersonas = new JMenuItem("Consultar");
		itemConsultarPersonas.addActionListener(this);
		menuPersonas.add(itemConsultarPersonas);
		
		itemActualizarPersonas = new JMenuItem("Actualizar");
		itemActualizarPersonas.addActionListener(this);
		menuPersonas.add(itemActualizarPersonas);
		
		itemEliminarPersonas = new JMenuItem("Eliminar");
		itemEliminarPersonas.addActionListener(this);
		menuPersonas.add(itemEliminarPersonas);
		

		MenuMascotas = new JMenu("Gestionar Mascotas");
		menuBar.add(MenuMascotas);
		
		itemRegistrarMascotas = new JMenuItem("Registrar");
		itemRegistrarMascotas.addActionListener(this);
		MenuMascotas.add(itemRegistrarMascotas);
		
		itemConsultarMascotas = new JMenuItem("Consultar");
		itemConsultarMascotas.addActionListener(this);
		MenuMascotas.add(itemConsultarMascotas);
		
		itemActualizarMascotas = new JMenuItem("Actualizar");
		itemActualizarMascotas.addActionListener(this);
		MenuMascotas.add(itemActualizarMascotas);
		
		itemEliminarMascotas = new JMenuItem("Eliminar");
		itemEliminarMascotas.addActionListener(this);
		MenuMascotas.add(itemEliminarMascotas);
		
		itemListarMascotas = new JMenuItem("Listar");
		itemListarMascotas.addActionListener(this);
		MenuMascotas.add(itemListarMascotas);
		
		menuProductos = new JMenu("Gestionar Productos");
		menuBar.add(menuProductos);
		
		itemRegistroProductos = new JMenuItem("Registrar");
		itemRegistroProductos.addActionListener(this);
		menuProductos.add(itemRegistroProductos);
		
		itemConsultaProductos = new JMenuItem("Consultar");
		itemConsultaProductos.addActionListener(this);
		menuProductos.add(itemConsultaProductos);
		
		itemActualizarProductos = new JMenuItem("Actualizar");
		itemActualizarProductos.addActionListener(this);
		menuProductos.add(itemActualizarProductos);
		
		itemEliminarProductos = new JMenuItem("Eliminar");
		itemEliminarProductos.addActionListener(this);
		
		itemListarProductos = new JMenuItem("Listar");
		itemListarProductos.addActionListener(this);
		
		itemComprarProductos = new JMenuItem("Comprar");
		itemComprarProductos.addActionListener(this);
		
		menuProductos.add(itemEliminarProductos);
		menuProductos.add(itemListarProductos);
		menuProductos.add(itemComprarProductos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("GESTION CLINICA VETERINARIA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/veterinario.jpg")));
		panel.add(lblImagen, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==itemRegistrarPersonas) {
			miCoordinador.mostrarVentanaRegistroPersonas();
		}
		if(e.getSource()==itemActualizarPersonas) {
			miCoordinador.mostrarVentanaActualizarPersona();
		}
		if(e.getSource()==itemConsultarPersonas) {
			miCoordinador.mostrarVentanaConsultaPersona();
		}
		if(e.getSource()==itemEliminarPersonas) {
			miCoordinador.mostrarVentanaEliminarPersona();
		}
	
		if (e.getSource()==itemRegistroProductos) {
			miCoordinador.mostrarVentanaRegistroProductos();
		}
		if(e.getSource()==itemConsultaProductos) {
			miCoordinador.mostrarVentanaConsultarProductos();
		}
		
		if(e.getSource()==itemActualizarProductos) {
			miCoordinador.mostrarVentanaActualizarProductos();
		}
		if(e.getSource()==itemEliminarProductos) {
			miCoordinador.mostrarVentanaEliminarProductos();
		}
		if (e.getSource()==itemRegistrarMascotas) {
			miCoordinador.mostrarVentanaRegistroMascotas();
		}
		if (e.getSource()==itemListarProductos) {
			miCoordinador.mostrarVentanalistarProductos();;
		}
		if(e.getSource()==itemComprarProductos) {
			miCoordinador.mostrarVentanaComprarProductos();
		}
		if (e.getSource()==itemActualizarMascotas) {
			miCoordinador.mostrarVentanaActualizarMascotas();
		}
		if(e.getSource()==itemListarMascotas) {
			miCoordinador.mostrarVentanaListarMascotas();
		}
		if(e.getSource()==itemConsultarMascotas) {
			miCoordinador.mostrarVentanaConsultarMascotas();
		}
		if(e.getSource()==itemEliminarMascotas) {
			miCoordinador.mostrarVentanaEliminarMascotas();
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
	}
}
