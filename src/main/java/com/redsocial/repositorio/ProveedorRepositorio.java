package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Proveedor;

public interface ProveedorRepositorio {

	public abstract int inserta(Proveedor obj);
	public abstract int actualiza(Proveedor obj);
	public abstract int elimina(int idProveedor);
	public abstract List<Proveedor> lista(String filtro);
}
