package com.tatiana.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import com.tatiana.dao.MascotaDao;
import com.tatiana.entidades.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;

public class ConsultarMascotasGui extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
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
	private JButton btnBuscar;
	private JButton btnCancelar;
	private Coordinador miCoordinador;
	private JButton btnListar;
	

	public ConsultarMascotasGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		setBounds(100, 100, 450, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtIdMascota = new JTextField();
		txtIdMascota.setBounds(126, 66, 170, 19);
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
		
		JLabel lblTitulo = new JLabel("CONSULTAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTitulo.setBounds(46, 10, 318, 45);
		contentPanel.add(lblTitulo);
		
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
		lblRaza.setBounds(319, 92, 45, 13);
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(175, 206, 85, 21);
		btnBuscar.addActionListener(this);
		contentPanel.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(288, 206, 85, 21);
		btnCancelar.addActionListener(this);
		contentPanel.add(btnCancelar);
		
		btnListar = new JButton("Listar Mascotas");
		btnListar.setBounds(23, 205, 125, 23);
		btnListar.addActionListener(this);
		contentPanel.add(btnListar);

	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBuscar) {
			
			
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
		}else if(e.getSource()==btnListar) {
			miCoordinador.mostrarVentanaListarMascotas();	
		}
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
		
	}
	
}
