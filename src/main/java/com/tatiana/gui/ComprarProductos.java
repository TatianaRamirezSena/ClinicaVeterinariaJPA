package com.tatiana.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.tatiana.dao.PersonaDao;
import com.tatiana.dao.ProductoDao;
import com.tatiana.entidades.Persona;
import com.tatiana.entidades.PersonasProductos;
import com.tatiana.entidades.Producto;

import controlador.Coordinador;

public class ComprarProductos extends JDialog implements ActionListener {
		private JLabel lblPersona;
		private Coordinador miCoordinador;
		private JTextField textPersona;
		private JTextField textProducto;
		private JButton btnComprar;

		public ComprarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
			super(ventanaPrincipal,modal);
			setSize( 403, 216);
			setLocationRelativeTo(null);
			iniciarComponentes();
			setTitle("Gestión de consultar");
			
		}
		
		public void iniciarComponentes() {
				getContentPane().setLayout(null);
			
				lblPersona = new JLabel("Id Persona");
				lblPersona.setForeground(Color.BLACK);
				lblPersona.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblPersona.setBounds(10, 34, 94, 27);
				getContentPane().add(lblPersona);
				
				JLabel lblProducto = new JLabel("Id Producto");
				lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblProducto.setBounds(203, 40, 99, 14);
				getContentPane().add(lblProducto);
				
				textPersona = new JTextField();
				textPersona.setBounds(114, 39, 67, 20);
				getContentPane().add(textPersona);
				textPersona.setColumns(10);
				
				textProducto = new JTextField();
				textProducto.setBounds(312, 39, 59, 20);
				getContentPane().add(textProducto);
				textProducto.setColumns(10);
				
				btnComprar = new JButton("Comprar");
				btnComprar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnComprar.addActionListener(this);
				btnComprar.setBounds(138, 103, 113, 29);
				getContentPane().add(btnComprar);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(0, 78, 370, 14);
				getContentPane().add(separator);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(0, 73, 425, -11);
				getContentPane().add(separator_1);
			}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnComprar) {
				PersonasProductos producto=new PersonasProductos ();
				Producto miProducto = new Producto();
				PersonaDao miPersonaDao=new PersonaDao();
				ProductoDao miProductoDao= new ProductoDao();
				
				producto.setPersonaId(Long.parseLong(textPersona .getText()));
				producto.setProductoId(Long.parseLong(textProducto .getText()));
				
				Persona miPersona=miPersonaDao.consultarPersona(producto.getPersonaId());
				Producto miProductoC=miProductoDao.consultarProducto(producto.getProductoId());
				
				String res=miProductoDao.registrarCompra(producto);
				
				if(res.equals("Se realizo la compra del producto") ) {
					JOptionPane.showMessageDialog(null, "Compra Exitosa!!");
				}else {
					JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				textPersona.setText("");
				textProducto.setText("");
				
				}	
				
			}
	
		public void setCoordinador(Coordinador miCoordinador) {
			this.miCoordinador=miCoordinador;
			
		}
}
