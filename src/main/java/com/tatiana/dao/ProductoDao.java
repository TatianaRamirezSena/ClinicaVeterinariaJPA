package com.tatiana.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.tatiana.aplicacion.JPAUtil;
import com.tatiana.entidades.Mascota;
import com.tatiana.entidades.Persona;
import com.tatiana.entidades.PersonasProductos;
import com.tatiana.entidades.Producto;

import controlador.Coordinador;

public class ProductoDao {
	Coordinador miCoordinador;
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarProducto(Producto miProducto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit();
			
			resp="Producto Registrado!";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	
		return resp;
	}
	
	
	public String registrarCompra(PersonasProductos producto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			resp="Se realizo la compra del producto";
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "No se pudo registrar la compra del producto",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		
		return resp;
	}
	
	
	//AGREGO YO
	
	public Producto consultarProducto(Long idProducto) {
		Producto miProducto=entityManager.find(Producto.class, idProducto);
		
		if(miProducto!=null) {
			return miProducto;
		}else {
			return null;
		}
	}
	
	
	public List<Producto> consultarListaProductos(){
		List<Producto> listaProductos=new ArrayList<Producto>();
		Query query=entityManager.createQuery("SELECT p FROM Producto p");
		listaProductos=query.getResultList();
		
		return listaProductos;
		
	}
	
	
	
	public String actualizarProducto(Producto miProducto) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miProducto);
		entityManager.getTransaction().commit();
		
		String resp="Producto Actualizado";
		
		return resp;
	}
	
	
	public String eliminarProducto(Producto miProducto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miProducto);
			entityManager.getTransaction().commit();
			
			resp="Producto Eliminado";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar el producto verifique que no lo hayan comprado");
		}
		return resp;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}


public void setCoordinador(Coordinador miCoordinador) {	
		this.miCoordinador=miCoordinador;	
	}
}
