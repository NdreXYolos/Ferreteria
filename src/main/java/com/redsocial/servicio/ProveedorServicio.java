package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Proveedor;

public interface ProveedorServicio  {

	public abstract int eliminaProveedor(int idProveedor) ;
	public abstract int insertaProveedor(Proveedor  obj) ;
	public abstract int actualizaProveedor(Proveedor obj) ;
	public abstract List<Proveedor> listaProveedor(String filtro) ;

	
	
}
