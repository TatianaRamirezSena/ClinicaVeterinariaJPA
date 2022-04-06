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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.tatiana.dao.ProductoDao;
import com.tatiana.entidades.Producto;

import controlador.Coordinador;


public class EliminarProductos extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField textId;
	private JButton btnEliminar;
	private Coordinador miCoordinador;
	private JButton btnBuscar;
	private JLabel lblMsj;
	private JTextArea textArea;
	private JTextField textNombre;
	private JTextField textPrecio;
	
public EliminarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 344, 298);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gesti\u00F3n de eliminar");
		
	}
	
	public void iniciarComponentes() {

		setBounds(100, 100, 311, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMsj = new JLabel("");
		lblMsj.setBounds(67, 214, 140, 23);
		contentPane.add(lblMsj);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 71, 285, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(15, 119, 101, 20);
		panel.add(textPrecio);
		textPrecio.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(15, 75, 101, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textId = new JTextField();
		textId.setBounds(95, 25, 77, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(182, 25, 93, 20);
		panel.add(btnBuscar);
		
		JLabel lblproducto = new JLabel("ID Producto");
		lblproducto.setBounds(10, 23, 91, 23);
		panel.add(lblproducto);
		lblproducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(167, 97, 98, 23);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("ELIMINAR PRODUCTOS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(43, 11, 222, 49);
		contentPane.add(lblNewLabel);
		btnBuscar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			
			
			ProductoDao miProductoDao= new ProductoDao();
			
			try {
				Long idProducto=Long.parseLong(textId .getText());
				Producto miProducto=miProductoDao.consultarProducto(idProducto);
				
				
				if(miProducto!=null) {
					System.out.println(miProducto);
					textNombre.setText(miProducto.getNombreProducto());
					textPrecio.setText(miProducto.getPrecioProducto()+"");
				}else {
					JOptionPane.showMessageDialog(null, "No se encuentra el producto, verifique el id","ADVERTENCIA!!",JOptionPane.WARNING_MESSAGE);
					}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Debes ingresar el ID primero");
			}
			
			
		}
		if(e.getSource()==btnEliminar) {
			String resp=JOptionPane.showInputDialog("Esta seguro de eliminar este producto (Si/No)");
			
			if(resp.equalsIgnoreCase("si")) {
				ProductoDao miProductoDao= new ProductoDao();
				Long idProducto=Long.parseLong(textId .getText());
				Producto miProducto=miProductoDao.consultarProducto(idProducto);
				
				JOptionPane.showMessageDialog(null,miProductoDao.eliminarProducto(miProducto));
			}else {
				JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion del producto");
			}

		}
		
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

}
