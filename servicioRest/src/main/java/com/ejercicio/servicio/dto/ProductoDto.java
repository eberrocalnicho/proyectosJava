package com.ejercicio.servicio.dto;

import java.io.Serializable;

import com.ejercicio.entidad.Producto;


public class ProductoDto implements Serializable{

	private int idProducto;
	private String descripcion;
	private double precio;
	
	public int getIdProducto() {
		return idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ProductoDto(int idProducto, String descripcion, double precio) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public ProductoDto() {
		super();
		 
	}
	public ProductoDto(Producto producto) {
 		 idProducto = producto.getIdProducto();
		 descripcion = producto.getDescripcion();
		 precio = producto.getPrecio();
	}
	public Producto asProducto(){
		return new Producto(idProducto,descripcion,precio);
	}
	
}
