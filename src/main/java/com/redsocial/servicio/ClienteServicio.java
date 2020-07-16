package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Cliente;


public interface ClienteServicio {

	public abstract int eliminaCliente(int idCliente) ;
	public abstract int insertaCliente(Cliente obj) ;
	public abstract int actualizaCliente(Cliente obj) ;
	public abstract List<Cliente> listaCliente(String filtro) ;
}
