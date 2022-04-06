package com.tatiana.gui;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.tatiana.dao.PersonaDao;
import com.tatiana.entidades.Persona;

import controlador.Coordinador;

import java.awt.Color;


public class ListarPersonasGui extends JDialog implements ActionListener{
	PersonaDao miPersona=new PersonaDao();
	
	private JPanel miPanel;
	List<Persona> personas;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
	
	Coordinador miCoordinador;
	
	
	public ListarPersonasGui() {
		setSize( 772, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("lista de Personas");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		miPanel = new JPanel();
		miPanel.setLayout(null);
		
		titulo = new JLabel("Lista de Personas");
		titulo.setForeground(Color.RED);
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		miPanel.add(titulo);
		
		miScrol = new JScrollPane();
		miScrol.setBounds(10,80,736,270);
		miPanel.add(miScrol);
		
		getContentPane().add(miPanel);
		
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	
	
	
	public void llenar(ArrayList<Persona> personas) {
		
		String titulos [] = {"documento","nombre","profesion","telefono","tipo","ciudadN","departamentoN","paisN","fechaN"};
		int celdas;
		if(personas.size()<15) {
			celdas=14;
		}else {
			celdas=personas.size();
		}
		String cuadro [][]= new String [celdas][9];
		if(personas.size()>0) {
			for (int i=0;i<personas.size();i++) {
				cuadro[i][0]=personas.get(i).getIdPersona()+"";
				cuadro[i][1]=personas.get(i).getNombre();
				cuadro[i][2]=personas.get(i).getProfesion();
				cuadro[i][3]=personas.get(i).getTelefono();
				cuadro[i][4]=personas.get(i).getTipo()+"";
				cuadro[i][5]=personas.get(i).getNacimiento().getCiudadNacimiento();
				cuadro[i][6]=personas.get(i).getNacimiento().getDepartamentoNacimiento();
				cuadro[i][7]=personas.get(i).getNacimiento().getPaisNacimiento();
				cuadro[i][8]=personas.get(i).getNacimiento().getFechaNacimiento()+"";
			}
		}else {
			 cuadro = new String [14][9];
		}
		
		miTabla = new JTable(cuadro,titulos);
		miScrol.setViewportView(miTabla);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
