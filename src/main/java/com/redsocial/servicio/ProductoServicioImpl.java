package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Producto;
import com.redsocial.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio{

	@Autowired
	private ProductoRepositorio repositorio;
	
	@Override
	public int eliminaProducto(int idProducto) {
		return repositorio.elimina(idProducto);
	}

	@Override
	public int insertaProducto(Producto obj) {
		return repositorio.inserta(obj);
	}

	@Override
	public int actualizaProducto(Producto obj) {
		return repositorio.actualiza(obj);
	}

	@Override
	public List<Producto> listaProducto(String filtro) {
		return repositorio.lista(filtro);
	}
	
	
	
	

}
