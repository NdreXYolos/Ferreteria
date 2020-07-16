package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Usuario;

public interface UsuarioServicio {

	
	public abstract int eliminaUsuario(int idUsuario) ;
	public abstract int insertaUsuario(Usuario obj) ;
	public abstract int actualizaUsuario(Usuario obj) ;
	public abstract List<Usuario> listaUsuario(String filtro) ;
	
}
