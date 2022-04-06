package com.tatiana.gui;

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
import javax.swing.border.BevelBorder;

import com.tatiana.dao.ProductoDao;
import com.tatiana.entidades.Producto;

import controlador.Coordinador;


public class ActualizarProductos extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textId;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JLabel lblPrecio;
	private Coordinador miCoordinador;

	public ActualizarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 440, 277);
		setLocationRelativeTo(null);
		iniciarComponentes();
		setTitle("Gestion de actualizar");
		
	}
	
	public void iniciarComponentes() {
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(23, 49, 378, 174);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(137, 62, 73, 23);
			panel.add(btnBuscar);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
				textId = new JTextField();
				textId.setBounds(160, 9, 86, 20);
				panel.add(textId);
				textId.setColumns(10);
				
					lblTitulo = new JLabel("ID Producto");
					lblTitulo.setBounds(55, 7, 95, 20);
					panel.add(lblTitulo);
					lblTitulo.setFont(new Font("Verdana", Font.BOLD, 13));
					
						lblNombre = new JLabel("Nombre:");
						lblNombre.setBounds(10, 120, 67, 27);
						panel.add(lblNombre);
						lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
						
						textNombre = new JTextField();
						textNombre.setBounds(77, 124, 86, 20);
						panel.add(textNombre);
						textNombre.setColumns(10);
						
						lblPrecio = new JLabel("Precio:");
						lblPrecio.setBounds(192, 126, 67, 14);
						panel.add(lblPrecio);
						lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
						
						textPrecio = new JTextField();
						textPrecio.setBounds(256, 124, 86, 20);
						panel.add(textPrecio);
						textPrecio.setColumns(10);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(10, 85, 321, -13);
						panel.add(separator);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(10, 96, 358, 13);
						panel.add(separator_1);
						
						btnActualizar = new JButton("Actualizar");
						btnActualizar.setBounds(20, 63, 103, 23);
						panel.add(btnActualizar);
						btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnActualizar.addActionListener(this);
					
					JLabel lblNewLabel = new JLabel("ACTUALIZAR PRODUCTOS");
					lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
					lblNewLabel.setBounds(87, 11, 271, 27);
					getContentPane().add(lblNewLabel);
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
					JOptionPane.showMessageDialog(null,"El producto no existe");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Debes ingresar el ID primero");
			}
			
		}
		if(e.getSource()==btnActualizar) {
			
			Producto miProducto=new Producto();
			
			try {
				miProducto.setIdProducto(Long.parseLong(textId.getText()));
				miProducto.setNombreProducto(textNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(textPrecio.getText()));
				
				ProductoDao miProductoDao=new ProductoDao();
				System.out.println(miProducto);
				JOptionPane.showMessageDialog(null, miProductoDao.actualizarProducto(miProducto));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Debes llenar los campos primero");
			}
			
			
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
