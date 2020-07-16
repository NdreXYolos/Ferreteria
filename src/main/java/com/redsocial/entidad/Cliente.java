package com.redsocial.entidad;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {

	private String idCliente;

	private String nombre;

	private String apellido;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
