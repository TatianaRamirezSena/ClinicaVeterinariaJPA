


package com.tatiana.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name="id_persona")
	private Long idPersona;
	
	@Column(name="nombre_persona")
	private String nombre;
	
	@Column(name="telefono_persona")
	private String telefono;
	
	@Column(name="profesion_persona")
	private String profesion;
	
	@Column(name="tipo_persona")
	private int tipo;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="nacimiento_id", referencedColumnName="id_nacimiento")
	private Nacimiento nacimiento;
	
	@OneToMany(mappedBy="duenio" , cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Mascota> listaMascotas;
	
	@ManyToMany
	@JoinTable(name="personas_productos", 
	joinColumns=@JoinColumn(name="persona_id"), 
	inverseJoinColumns=@JoinColumn(name="producto_id"))
	private List<Producto> listaProductos;
	
	
	public Persona() {
		this.listaMascotas=new ArrayList<Mascota>();
	}

	public Persona(Long idPersona, String nombre, String telefono, String profesion, int tipo, Nacimiento nacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.profesion = profesion;
		this.tipo = tipo;
		this.nacimiento = nacimiento;
		this.listaMascotas=new ArrayList<Mascota>();
	}
	
	
	
	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
	
	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Nacimiento getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Nacimiento nacimiento) {
		this.nacimiento = nacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", telefono=" + telefono + ", profesion="
				+ profesion + ", tipo=" + tipo + ", nacimiento=" + nacimiento + "listaMascotas"+listaMascotas+"listaProductos"+listaProductos+"]";
	}
	
	
	
	

}
