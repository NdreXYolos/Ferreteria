package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Boleta;
import com.redsocial.entidad.Cliente;
import com.redsocial.entidad.Producto;

public interface BoletaRepositorio {

	public abstract List<Cliente> traeClientePorNombre(String filtro) ;
	public abstract List<Producto> traeProductoPorNombre(String filtro) ;
	public abstract int insertaBoleta(Boleta bean);

}
