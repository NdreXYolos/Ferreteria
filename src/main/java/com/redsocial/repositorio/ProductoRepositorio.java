package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Producto;


public interface ProductoRepositorio {
 
	public abstract int elimina(int idProducto) ;
	public abstract int inserta(Producto obj) ;
	public abstract int actualiza(Producto obj) ;
	public abstract List<Producto> lista(String filtro);
}
