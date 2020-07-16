package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Usuario;

public interface UsuarioRepositorio {

	public abstract int elimina(int idUsuario) ;
	public abstract int inserta(Usuario obj) ;
	public abstract int actualiza(Usuario obj) ;
	public abstract List<Usuario> lista(String filtro);
	
}
