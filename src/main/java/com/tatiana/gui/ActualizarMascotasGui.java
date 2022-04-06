package com.tatiana.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import com.tatiana.dao.MascotaDao;
import com.tatiana.dao.PersonaDao;
import com.tatiana.entidades.Mascota;
import com.tatiana.entidades.Persona;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class ActualizarMascotasGui extends JDialog implements ActionListener {

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
	private JComboBox comboBoxColor;
	private JButton btnActualizar;
	private JButton btnCancelar;
	private JComboBox comboBox;
	private Coordinador miCoordinador;
	private Mascota miAnimal;
	private JButton btnBuscar;

	
	

	public ActualizarMascotasGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
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
		
		JLabel lblTitulo = new JLabel("ACTUALIZAR MASCOTAS");
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
		lblSexo.setBounds(126, 144, 45, 13);
		contentPanel.add(lblSexo);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(252, 144, 70, 13);
		contentPanel.add(lblColor);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(107, 164, 70, 21);
		contentPanel.add(comboBox);
		
		comboBoxColor =new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco ", "Caf\u00E9", "Negro ", "Manchas ", "Gris"}));
		comboBoxColor.setBounds(230, 163, 72, 22);
		contentPanel.add(comboBoxColor);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(173, 217, 89, 23);
		btnActualizar.setVisible(false);
		btnActualizar.addActionListener(this);
		contentPanel.add(btnActualizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(292, 217, 89, 23);
		btnCancelar.addActionListener(this);
		contentPanel.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(64, 218, 85, 21);
		btnBuscar.addActionListener(this);
		contentPanel.add(btnBuscar);
	}


	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==btnBuscar) {
			
			MascotaDao miMascotaDao = new MascotaDao();
			Mascota miAnimal = miMascotaDao.consultarMascota(Long.parseLong(txtIdMascota.getText()));
			
			
			if(miAnimal!=null) {
				txtIdDueno.setText(miAnimal.getDuenio().getIdPersona()+"");
				txtNombre.setText(miAnimal.getNombre());
				txtRaza.setText(miAnimal.getRaza());

				btnActualizar.setVisible(true);
				
				txtIdDueno.setEnabled(true);
				txtNombre.setEnabled(true);
				txtRaza.setEnabled(true);

				
			}else {
				JOptionPane.showMessageDialog(null, "Mascota no existente");
			}
	}

		if(e.getSource()==btnActualizar) {
			
			Mascota miAnimal = new Mascota();
			MascotaDao miMascotaDao = new MascotaDao();
			miAnimal.setColorMascota((String) comboBoxColor.getSelectedItem());
			miAnimal.setNombre(txtNombre.getText());
			miAnimal.setRaza(txtRaza.getText());
			miAnimal.setSexo((String) comboBox.getSelectedItem());
			miAnimal.setIdMascota(Long.parseLong(txtIdMascota.getText()));
			Persona miPersona = new PersonaDao().consultarPersona(Long.parseLong(txtIdDueno.getText()));
			miAnimal.setDuenio(miPersona);
			
			
			String buscandoMas= miMascotaDao.actualizarMascota(miAnimal); 
		
			if(buscandoMas.equals("Mascota Actualizada")) {
				
				JOptionPane.showMessageDialog(null,"Se ha actualizado los datos correctamente.");
				this.dispose();
			}else {
				
				System.out.println("ERRROR");
			}
			
		}else if(e.getSource()==btnCancelar) {
			
			this.dispose();
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
		
	}
}