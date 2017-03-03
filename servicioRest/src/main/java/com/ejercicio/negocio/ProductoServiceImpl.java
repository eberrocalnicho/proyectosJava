package com.ejercicio.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.entidad.Producto;
import com.ejercicio.persistencia.ProductoRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ProductoServiceImpl implements ProductoService {
 
	
	@Autowired
	ProductoRepository productoRepository;
	

	@Override
	public void insertar(Producto producto) {
		productoRepository.insertar(producto);
	}

	@Override
	public List<Producto> listar() {
	 	return (List<Producto>) productoRepository.listar();
	}

	@Override
	public Producto buscar(Integer id) {
	 	return productoRepository.findById(id);
	}

	@Override
	public void modificar(Producto producto) {
		productoRepository.modificar(producto);	
	}

	@Override
	public void borrar(Producto producto) {
		productoRepository.eliminar(producto);
	}
	
	
}
