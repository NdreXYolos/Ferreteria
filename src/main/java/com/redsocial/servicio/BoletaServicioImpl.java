package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocial.entidad.Boleta;
import com.redsocial.entidad.Cliente;
import com.redsocial.entidad.Producto;
import com.redsocial.repositorio.BoletaRepositorio;

@Service
public class BoletaServicioImpl implements BoletaServicio{

	@Autowired
	private BoletaRepositorio repositorio;

	@Override
	public List<Cliente> traeClientePorNombre(String filtro)  {
		return repositorio.traeClientePorNombre(filtro);
	}

	@Override
	public List<Producto> traeProductoPorNombre(String filtro) {
		return repositorio.traeProductoPorNombre(filtro);
	}

	@Override
	@Transactional
	public int insertaBoleta(Boleta boleta) {
		return repositorio.insertaBoleta(boleta);
	}

	
}
