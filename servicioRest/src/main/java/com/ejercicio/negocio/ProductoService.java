package com.ejercicio.negocio;

import java.util.List;

import com.ejercicio.entidad.Producto;

public interface ProductoService {

	public void insertar(Producto producto);
	public List<Producto> listar();
	public Producto buscar(Integer id);
	public void modificar(Producto producto) ;
	public void borrar(Producto producto);
}
