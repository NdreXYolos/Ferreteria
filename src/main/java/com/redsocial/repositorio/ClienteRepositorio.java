package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Cliente;

public interface ClienteRepositorio {

	public abstract int elimina(int idCliente) ;
	public abstract int inserta(Cliente obj) ;
	public abstract int actualiza(Cliente obj) ;
	public abstract List<Cliente> lista(String filtro);
}
