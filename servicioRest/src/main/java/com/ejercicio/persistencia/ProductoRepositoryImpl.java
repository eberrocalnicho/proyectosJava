package com.ejercicio.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ejercicio.entidad.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	@Autowired
	MongoOperations mongoOperations;
		
	@Override
	public void modificar(Producto producto) {
		mongoOperations.updateMulti(getQuery(producto.getIdProducto()),getUpdate(producto) , Producto.class);
	}

	public Producto findById(Integer id) {
		return mongoOperations.findOne(getQuery(id), Producto.class);
	}

	public void eliminar(Producto producto) {
		mongoOperations.remove(getQuery(producto.getIdProducto()), Producto.class);
	}
	
	public Query getQuery(Integer idProducto){
		return new Query(Criteria.where("idProducto").is(idProducto));
	}
	
	public Update getUpdate(Producto producto){
		Update update= new Update();
		update.set("descripcion", producto.getDescripcion());
		update.set("precio", producto.getPrecio());
		return update;
	}

	public void insertar(Producto producto) {
	    mongoOperations.save(producto);
	}

	public List<Producto> listar() {
		 return mongoOperations.findAll(Producto.class);
	}
}
