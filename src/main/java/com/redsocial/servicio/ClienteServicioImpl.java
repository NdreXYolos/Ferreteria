package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Cliente;
import com.redsocial.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio{

	@Autowired
	private ClienteRepositorio repositorio;
	
	@Override
	public int eliminaCliente(int idCliente) {
		return repositorio.elimina(idCliente);
	}

	@Override
	public int insertaCliente(Cliente obj) {
		return repositorio.inserta(obj);
	}

	@Override
	public int actualizaCliente(Cliente obj) {
		return repositorio.actualiza(obj);
	}

	@Override
	public List<Cliente> listaCliente(String filtro) {
		return repositorio.lista(filtro);
	}

}
