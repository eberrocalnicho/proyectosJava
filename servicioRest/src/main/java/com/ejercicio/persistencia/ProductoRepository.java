package com.ejercicio.persistencia;
 
import java.util.List;

import com.ejercicio.entidad.Producto;

public interface ProductoRepository {

	public void insertar(Producto producto);
	public List<Producto> listar();
	public void modificar(Producto producto);
	public Producto findById(Integer id);
	public void eliminar(Producto producto);
	
}
