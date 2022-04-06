package com.tatiana.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tatiana.dao.ProductoDao;

import com.tatiana.entidades.Producto;

import controlador.Coordinador;

public class ListarProductos extends JDialog {
	
	ProductoDao miProductoDao=new ProductoDao();
	
	private JPanel contentPanel;
	List<Producto> productos;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrollPane;

	Coordinador miCoordinador;
	
	public ListarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 577, 399);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestión consulta");
		iniciarComponentes();
		
	}
	


	private void iniciarComponentes() {
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);

		titulo = new JLabel("LISTA DE PRODUCTOS");
		titulo.setForeground(Color.RED);
		titulo.setBounds(159,20,241,30);
		titulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		contentPanel.add(titulo);
		
		miScrollPane = new JScrollPane();
		miScrollPane.setBounds(30,70,506,248);
		contentPanel.add(miScrollPane);
		
		getContentPane().add(contentPanel);
		
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void llenar(List<Producto> productos) {
		String titulos [] = {"idProducto","nombre","Precio"};
		
		System.out.println(productos.size());
		int celdas;
		if(productos.size()<15) {
			celdas=14;
		}else {
			celdas=productos.size();
		}
		String cuadro [][]= new String [celdas][3];
		if(productos.size()>0) {
			
			
			for (int i=0;i<productos.size();i++) {
				cuadro[i][0]=productos.get(i).getIdProducto()+"";
				cuadro[i][1]=productos.get(i).getNombreProducto();
				cuadro[i][2]=productos.get(i).getPrecioProducto()+"";
				
			}
		}else {
			 cuadro = new String [14][2];
		}
		
		miTabla = new JTable(cuadro,titulos);
		miScrollPane.setViewportView(miTabla);
		setVisible(true);
		
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}


}
