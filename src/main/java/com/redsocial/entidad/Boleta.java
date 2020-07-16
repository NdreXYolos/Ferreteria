package com.redsocial.entidad;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Boleta {

	private String idBoleta;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	private String idUsuario;
	
	private Cliente cliente;
	
	private List<DetalleBoleta> detalles;

	public String getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleBoleta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleBoleta> detalles) {
		this.detalles = detalles;
	}

}
