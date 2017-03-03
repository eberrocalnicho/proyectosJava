package com.ejercicio.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Producto  implements Serializable{
 
	public Producto(Integer idProducto,String descripcion, double precio) {
		super();
		this.idProducto=idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public Producto() {
		super();
	}
	
	@Id
	private Integer idProducto;
	
	private String descripcion;
	
	private double precio;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
