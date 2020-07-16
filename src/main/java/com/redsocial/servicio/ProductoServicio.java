package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Producto;



public interface ProductoServicio {

	public abstract int eliminaProducto(int idProducto) ;
	public abstract int insertaProducto(Producto obj) ;
	public abstract int actualizaProducto(Producto obj) ;
	public abstract List<Producto> listaProducto(String filtro) ;

	
	
}
