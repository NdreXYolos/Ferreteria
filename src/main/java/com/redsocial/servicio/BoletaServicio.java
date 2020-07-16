package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Boleta;
import com.redsocial.entidad.Cliente;
import com.redsocial.entidad.Producto;

public interface BoletaServicio {

	
	public abstract List<Cliente> traeClientePorNombre(String filtro) ;
	public abstract List<Producto> traeProductoPorNombre(String nombre);
	public abstract int insertaBoleta(Boleta boleta) ;
	
}
