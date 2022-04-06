package com.tatiana.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import com.tatiana.dao.MascotaDao;
import com.tatiana.entidades.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class EliminarMascotasGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdMascota;
	private JTextField txtNombre;
	private JTextField txtIdDueno;
	private JTextField txtRaza;
	private JLabel lblIdMascota;
	private JLabel lblNombre;
	private JLabel lblIdDueno;
	private JLabel lblRaza;
	private JLabel lblSexo;
	private JLabel lblColor;
	private JTextField txtSexo;
	private JTextField txtColor;
	private JButton btnEliminar;
	private JButton btnCancelar;
	Coordinador miCoordinador;
	MascotaDao miMascotaDao;
	private JButton btnBuscar;

	public EliminarMascotasGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			
			txtIdMascota = new JTextField();
			txtIdMascota.setBounds(128, 63, 170, 19);
			contentPanel.add(txtIdMascota);
			txtIdMascota.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(23, 115, 96, 19);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtIdDueno = new JTextField();
			txtIdDueno.setBounds(158, 115, 96, 19);
			contentPanel.add(txtIdDueno);
			txtIdDueno.setColumns(10);
			
			txtRaza = new JTextField();
			txtRaza.setBounds(304, 115, 96, 19);
			contentPanel.add(txtRaza);
			txtRaza.setColumns(10);
			
			lblIdMascota = new JLabel("ID Mascota");
			lblIdMascota.setForeground(Color.RED);
			lblIdMascota.setHorizontalAlignment(SwingConstants.CENTER);
			lblIdMascota.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
			lblIdMascota.setBounds(152, 49, 125, 13);
			contentPanel.add(lblIdMascota);
			
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(41, 92, 45, 13);
			contentPanel.add(lblNombre);
			
			lblIdDueno = new JLabel("Id due\u00F1o ");
			lblIdDueno.setBounds(191, 92, 63, 13);
			contentPanel.add(lblIdDueno);
			
			lblRaza = new JLabel("Raza");
			lblRaza.setBounds(338, 92, 45, 13);
			contentPanel.add(lblRaza);
			
			lblSexo = new JLabel("Sexo");
			lblSexo.setBounds(128, 144, 45, 13);
			contentPanel.add(lblSexo);
			
			lblColor = new JLabel("Color");
			lblColor.setHorizontalAlignment(SwingConstants.CENTER);
			lblColor.setBounds(247, 144, 70, 13);
			contentPanel.add(lblColor);
			
			txtSexo = new JTextField();
			txtSexo.setBounds(95, 167, 96, 19);
			contentPanel.add(txtSexo);
			txtSexo.setColumns(10);
			
			txtColor = new JTextField();
			txtColor.setBounds(247, 167, 96, 19);
			contentPanel.add(txtColor);
			txtColor.setColumns(10);
			
			btnEliminar = new JButton("ELIMINAR");
			btnEliminar.setBounds(169, 206, 85, 21);
			btnEliminar.addActionListener(this);
			contentPanel.add(btnEliminar);
			
			btnCancelar = new JButton("CANCELAR");
			btnCancelar.setBounds(283, 206, 85, 21);
			btnCancelar.addActionListener(this);
			contentPanel.add(btnCancelar);

			JLabel lblTitulo = new JLabel("ELIMINAR MASCOTAS");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblTitulo.setBounds(55, 10, 304, 24);
			contentPanel.add(lblTitulo);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(53, 206, 85, 21);
			btnBuscar.addActionListener(this);
			contentPanel.add(btnBuscar);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnEliminar) {
			String resp=JOptionPane.showInputDialog("Esta seguro de eliminar a esta mascota (Si/No)");
			
			if(resp.equalsIgnoreCase("si")) {
				Long idMascota = Long.parseLong(txtIdMascota.getText());
				MascotaDao miMascotaDao = new MascotaDao();
				Mascota miAnimal = miMascotaDao.consultarMascota(idMascota);
				
				
				String verificarEliminacion = miMascotaDao.eliminarMascota(miAnimal);
				
				if(verificarEliminacion.equals("Mascota Eliminada")) {
					
					JOptionPane.showMessageDialog(null, "Se ha eliminado con exito la mascota");
					this.dispose();
				}else {
					
					JOptionPane.showMessageDialog(null, "No existe esta mascota en la base de datos. ");
					this.dispose();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion de la mascota");
			}
			
			
		
		}else if (e.getSource()==btnBuscar) {
			
			MascotaDao miMascotaDao = new MascotaDao();
			Mascota miAnimal = miMascotaDao.consultarMascota(Long.parseLong(txtIdMascota.getText()));
			
			if(miAnimal!=null) {
				
				txtIdDueno.setText(miAnimal.getDuenio().getIdPersona()+"");
				txtNombre.setText(miAnimal.getNombre());
				txtRaza.setText(miAnimal.getRaza());
				txtColor.setText(miAnimal.getColorMascota());
				txtSexo.setText(miAnimal.getSexo());
			}else {
				
				JOptionPane.showMessageDialog(null, "Esta mascota no existe en la base de datos. ");
			}
		}else if(e.getSource()==btnCancelar) {
			
			this.dispose();
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
		
	}

}
