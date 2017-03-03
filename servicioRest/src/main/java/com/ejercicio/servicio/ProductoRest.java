package com.ejercicio.servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.entidad.Producto;
import com.ejercicio.negocio.ProductoService;
import com.ejercicio.servicio.dto.ProductoDto; 

@RestController
public class ProductoRest {

	@Autowired
	ProductoService productoService;
	
	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@RequestMapping(value="producto", method=RequestMethod.POST,consumes="application/json")
	public void insertar(@RequestBody ProductoDto productoDto) {
 
		Producto producto = productoDto.asProducto();
		productoService.insertar(producto);
     }
	
	@RequestMapping(value="producto", method=RequestMethod.PUT,consumes="application/json")
	public void modificar(@RequestBody ProductoDto productoDto) {
 
		Producto producto = productoDto.asProducto();
		productoService.modificar(producto);
     }
	
	@RequestMapping(value = "producto/delete", method = RequestMethod.PUT,consumes="application/json")
	public void borrar(@RequestBody ProductoDto productoDto) {
		Producto producto = productoDto.asProducto();
		productoService.borrar(producto);
	  
	}

	@RequestMapping(value = "producto/{idProducto}", method = RequestMethod.GET, produces = "application/json")
	public ProductoDto buscar(@PathVariable("idProducto") Integer idProducto) {
		Producto producto = productoService.buscar(idProducto);
		return new ProductoDto(producto);
	}
	@RequestMapping(value = "productos", method = RequestMethod.GET, produces = "application/json")
	public List<ProductoDto> listar() {
 
		List<Producto> productos = productoService.listar();
		List<ProductoDto> productoDto= new ArrayList<ProductoDto>();
		for (Producto p : productos) {
			productoDto.add(new ProductoDto(p));
		}
		return productoDto;
	}

}
