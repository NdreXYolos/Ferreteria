package com.redsocial.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redsocial.entidad.Boleta;
import com.redsocial.entidad.Cliente;
import com.redsocial.entidad.DetalleBoleta;
import com.redsocial.entidad.Mensaje;
import com.redsocial.entidad.Producto;
import com.redsocial.servicio.BoletaServicio;

@Controller
public class BoletaController {

	@Autowired
	private BoletaServicio servicio;
	
	@RequestMapping("/verBoleta")
	public String verBoleta() {
		return "boleta";
	}
	
	@RequestMapping("/cargaCliente")
	@ResponseBody
	public List<Cliente> cargaCli(String filtro) {
		List<Cliente> salida = servicio.traeClientePorNombre(filtro);
		return salida;
	}
	
	@RequestMapping("/cargaProducto")
	@ResponseBody
	public List<Producto> cargaPro(String filtro) {
		List<Producto> salida = servicio.traeProductoPorNombre(filtro);
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/eliminaSeleccion")
	@ResponseBody
	public List<Producto> eliminar(Producto producto, HttpSession session) {
		ArrayList<Producto> salida = (ArrayList<Producto>) session.getAttribute("data");
		if (salida != null) {
			for (Producto x : salida) {
				if (x.getIdProducto().equals(producto.getIdProducto()) ) {
					salida.remove(x);
					break;
				}
			}
			session.setAttribute("data", salida);
		}
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/agregarSeleccion")
	@ResponseBody
	public List<Producto> agregar(Producto producto, HttpSession session) {
		ArrayList<Producto> salida = (ArrayList<Producto>) session.getAttribute("data");
		if (salida == null) {
			salida = new ArrayList<Producto>();
		}
		salida.add(producto);
		session.setAttribute("data", salida);
		return salida;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/listaSeleccion")
	@ResponseBody
	public List<Producto> lista(HttpSession session) {
		ArrayList<Producto> salida = (ArrayList<Producto>) session.getAttribute("data");
		if (salida == null) {
			salida = new ArrayList<Producto>();
		}
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/registra")
	@ResponseBody
	public Mensaje registra(Boleta boleta,HttpSession session) {
		Mensaje objMensaje = new Mensaje();
		String salida = "";
		
		//El usuario que es el que realiza la boleta
		boleta.setIdUsuario("1");
		
		ArrayList<Producto> data = (ArrayList<Producto>) session.getAttribute("data");
		ArrayList<DetalleBoleta> detalles = new ArrayList<DetalleBoleta>();
		for (Producto x : data) {
			DetalleBoleta d = new DetalleBoleta();
			d.setIdProducto(x.getIdProducto());
			d.setCantidad(x.getCantidad());
			d.setPrecio(x.getPrecio());
			detalles.add(d);
		}
		
		// eliminar los objetos en sesi�n
		session.removeAttribute("data");
				
		boleta.setDetalles(detalles);
		int idBoleta = servicio.insertaBoleta(boleta);
		
		if ( idBoleta > 0 ) {
			salida =  "Se generó la boleta con código N° : " + idBoleta +"<br><br>";
			salida += "Cliente :"+boleta.getCliente().getNombre() + "<br><br>";
			salida += "<table class=\"table\"><tr><td>Producto</td><td>Precio</td><td>Cantidad</td><td>Subtotal</td></tr>";
			double monto = 0;
			for (Producto x : data) {
				salida +="<tr><td>"+ x.getNombre() + "</td><td>" + x.getPrecio()+ "</td><td>" + x.getCantidad() +"</td><td>" + x.getTotalParcial() +"</td></tr>";
				monto += x.getCantidad() * x.getPrecio();
			}
			salida += "</table><br>";
			salida += "Monto a pagar : "+monto;
		}
		objMensaje.setTexto(salida);
		return objMensaje;
	}
}
