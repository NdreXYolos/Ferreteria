package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Usuario;
import com.redsocial.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired 
	private UsuarioRepositorio repositorio;
	
	@Override
	public int eliminaUsuario(int idUsuario) {
		return repositorio.elimina(idUsuario);
		
	}

	@Override
	public int insertaUsuario(Usuario obj) {
		return repositorio.inserta(obj);
	}

	@Override
	public int actualizaUsuario(Usuario obj) {
		return repositorio.actualiza(obj);
	}

	@Override
	public List<Usuario> listaUsuario(String filtro) {
		return repositorio.lista(filtro);
	}

	
	
}
