package com.tatiana.gui;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.tatiana.dao.PersonaDao;
import com.tatiana.entidades.Persona;

import controlador.Coordinador;


public class EliminarPersonaGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JButton btnEliminar;
	private JLabel lblDocumento;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JTextField txtTelefono;
	private JTextField txtProfesion;
	private JTextField txtTipo;
	private JPanel panelNacimiento;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnnio;
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField txtPais;
	private JButton btnBuscar;
	private JButton btnListar;
	private JLabel lblMsj;
	private JButton btnCancelar;
	
	Coordinador miCoordinador;
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
public EliminarPersonaGui(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		setSize( 598, 376);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		iniciarComponentes();
		setTitle("Gestión de eliminar");
		
	}
	
	public void iniciarComponentes() {

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(138, 72, 71, 21);
		contentPanel.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(220, 72, 112, 20);
		contentPanel.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 103, 71, 21);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(99, 103, 460, 21);
		contentPanel.add(txtNombre);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(24, 135, 71, 21);
		contentPanel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(99, 135, 86, 20);
		contentPanel.add(txtTelefono);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(195, 135, 71, 21);
		contentPanel.add(lblProfesion);
		
		txtProfesion = new JTextField();
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(260, 135, 167, 20);
		contentPanel.add(txtProfesion);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(437, 135, 71, 21);
		contentPanel.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(473, 135, 86, 20);
		contentPanel.add(txtTipo);
		
		panelNacimiento = new JPanel();
		panelNacimiento.setBorder(new TitledBorder(null, "Datos de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNacimiento.setBounds(21, 177, 538, 109);
		contentPanel.add(panelNacimiento);
		panelNacimiento.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
		lblFecha.setBounds(10, 29, 122, 14);
		panelNacimiento.add(lblFecha);
		
		txtDia = new JTextField();
		txtDia.setBounds(142, 28, 25, 20);
		txtDia.setColumns(10);
		panelNacimiento.add(txtDia);
		
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(190, 28, 25, 20);
		panelNacimiento.add(txtMes);
		
		txtAnnio = new JTextField();
		txtAnnio.setColumns(10);
		txtAnnio.setBounds(238, 28, 54, 20);
		panelNacimiento.add(txtAnnio);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(177, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setBounds(224, 31, 38, 14);
		panelNacimiento.add(lblNewLabel_1_1);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 59, 71, 21);
		panelNacimiento.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(74, 59, 86, 20);
		panelNacimiento.add(txtCiudad);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(185, 59, 92, 21);
		panelNacimiento.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(281, 59, 86, 20);
		panelNacimiento.add(txtDepartamento);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(385, 59, 54, 21);
		panelNacimiento.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(424, 59, 86, 20);
		panelNacimiento.add(txtPais);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 297, 538, 12);
		contentPanel.add(separator);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(31, 303, 89, 23);
		contentPanel.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(366,72,112,21);
		btnBuscar.addActionListener(this);
		contentPanel.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("ELIMINAR PERSONA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(171, 23, 196, 21);
		contentPanel.add(lblNewLabel);
		
		lblMsj = new JLabel("");
		lblMsj.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMsj.setBounds(321, 307, 213, 14);
		contentPanel.add(lblMsj);
		
		btnCancelar= new JButton("cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(195, 304, 116, 21);
		contentPanel.add(btnCancelar);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			PersonaDao miPersonaDao=new PersonaDao();
			Long idDocumento=Long.parseLong(txtDocumento.getText());
			Persona persona=miPersonaDao.consultarPersona(idDocumento);
			if(persona!=null) {
				
				txtNombre.setText(persona.getNombre());
				txtProfesion.setText(persona.getProfesion());
				txtTelefono.setText(persona.getTelefono());
				txtTipo.setText(persona.getTipo()+"");
				
				txtCiudad.setText(persona.getNacimiento().getCiudadNacimiento());
				txtDepartamento.setText(persona.getNacimiento().getDepartamentoNacimiento());
				txtPais.setText(persona.getNacimiento().getPaisNacimiento());
				txtDia.setText(persona.getNacimiento().getFechaNacimiento().getDayOfMonth()+"");
				txtMes.setText(persona.getNacimiento().getFechaNacimiento().getMonthValue()+"");
				txtAnnio.setText(persona.getNacimiento().getFechaNacimiento().getYear()+"");
				
			}else {
				JOptionPane.showMessageDialog(null,"La persona No existe");
			}
		}
		
		if(e.getSource()==btnEliminar) {
			
			String resp=JOptionPane.showInputDialog("Esta seguro de eliminar a esta persona (Si/No)");
			
			if(resp.equalsIgnoreCase("si")) {
				PersonaDao miPersonaDao=new PersonaDao();
				Long idDocumento=(Long.parseLong(txtDocumento.getText()));
				Persona persona=miPersonaDao.consultarPersona(idDocumento);
				
				JOptionPane.showMessageDialog(null, miPersonaDao.eliminarPersona(persona));
				
				txtAnnio.setText("");
				txtNombre.setText("");
				txtCiudad.setText("");
				txtDepartamento.setText("");
				txtDia.setText("");
				txtDocumento.setText("");
				txtMes.setText("");
				txtPais.setText("");
				txtProfesion.setText("");
				txtTelefono.setText("");
				txtTipo.setText("");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion");
			}
			
		}
			if(e.getSource()==btnCancelar) {
			this.dispose();
		}
	}
}