package com.tatiana.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.tatiana.dao.MascotaDao;
import com.tatiana.dao.PersonaDao;
import com.tatiana.entidades.Mascota;
import com.tatiana.entidades.Mascota;
import com.tatiana.entidades.Persona;

import controlador.Coordinador;

public class RegistrarMascotasGui extends JDialog implements ActionListener{

	private final JPanel contentPanel=new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JTextField txtIdMascota;
	private JLabel lblNombre;
	private JLabel lblRaza;
	private JLabel lblSexo;
	private JComboBox comboBoxSexo;
	private JLabel lblColor;
	private JComboBox comboBoxColor;
	private JLabel lblDueno;
	
	
	public RegistrarMascotasGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 408, 288);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		
		iniciarComponentes();
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 192);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(199, 17, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setBounds(269, 17, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 49, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 49, 86, 20);
		panel.add(txtNombre);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 49, 71, 21);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 49, 86, 20);
		panel.add(txtRaza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 127, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 150, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 150, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 81, 71, 21);
		panel.add(lblSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		comboBoxSexo.setBounds(88, 81, 86, 22);
		panel.add(comboBoxSexo);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 82, 71, 21);
		panel.add(lblColor);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Caf\u00E9", "Gris", "Manchas"}));
		comboBoxColor.setBounds(269, 81, 86, 22);
		panel.add(comboBoxColor);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnRegistrar) {
			
			Mascota miAnimal = new Mascota();
			
			miAnimal.setIdMascota(null);
			miAnimal.setNombre(txtNombre.getText());
			miAnimal.setRaza(txtRaza.getText());
			miAnimal.setColorMascota((String) comboBoxColor.getSelectedItem());
			miAnimal.setSexo((String) comboBoxSexo.getSelectedItem());
			
			PersonaDao miPersonaDao = new PersonaDao();
			MascotaDao miMascotaDao = new MascotaDao();
			
			Persona miPersona = miPersonaDao.consultarPersona(Long.parseLong(txtIdDueno.getText()));
			
			
			if(miPersona != null) {
				
				miAnimal.setDuenio(miPersona);
				String res = miMascotaDao.registrarMascota(miAnimal);
				if(res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
				}else {
					JOptionPane.showMessageDialog(null, res);
					
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Id de Due�o no existente, Porfavor ingrese uno existente");
			}
			
			txtIdDueno.setText("");;
			txtNombre.setText("");
			txtRaza.setText("");
			
			
		}else if(e.getSource()==btnCancelar) {
			this.dispose();
		}
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}