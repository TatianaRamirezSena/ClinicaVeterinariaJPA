package com.tatiana.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.tatiana.dao.ProductoDao;
import com.tatiana.entidades.Persona;
import com.tatiana.entidades.PersonasProductos;
import com.tatiana.entidades.Producto;

import controlador.Coordinador;



public class RegistrarProductos  extends JDialog implements ActionListener {

	private final JPanel contentPanel= new JPanel();
	private JTextField txtNombre,txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JLabel lblTitulo;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textPersona;
	private JLabel lblIdPersona;
	
	public RegistrarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 265);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 46, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(83, 46, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(209, 46, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(269, 46, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 97, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(269, 120, 94, 23);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(148, 120, 102, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			Producto miProducto=new Producto();
			
			try {
				miProducto.setIdProducto(null);
				miProducto.setNombreProducto(txtNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
			
					ProductoDao miProductoDao=new ProductoDao();
					String res = miProductoDao.registrarProducto(miProducto);
					
					if(res.equals("Producto Registrado!") ) {
						JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
					}else {
						JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Debes llenar los campos primero");
			}
			
		txtNombre.setText("");
		txtPrecio.setText("");
		
		}
	
		 if(e.getSource()==btnCancelar) {
				this.dispose();
			}
	}
			
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
