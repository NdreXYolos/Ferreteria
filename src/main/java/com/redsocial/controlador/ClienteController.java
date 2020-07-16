package com.redsocial.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.redsocial.entidad.Cliente;
import com.redsocial.servicio.ClienteServicio;

@Controller
public class ClienteController {

	@Autowired
	private ClienteServicio servicio;
	
	@RequestMapping("/verCliente")
	public String verPagina(Model m) {
		List<Cliente> list = servicio.listaCliente("");
		m.addAttribute("clientes", list);
		return "crudCliente";
	}
	
	@RequestMapping("/listaCliente")
	public String lista(@RequestParam Map<String,String> params, Model m) {
		List<Cliente> list = servicio.listaCliente(params.get("filtro"));
		m.addAttribute("clientes", list);
		return "crudCliente";
	}
	
	@RequestMapping("/registraCliente")
	public String RegistraCliente(Cliente obj, Model m) {
		servicio.insertaCliente(obj);
		List<Cliente> list = servicio.listaCliente("");
		m.addAttribute("clientes", list);
		return "crudCliente";
	}
	
	@RequestMapping("/actualizaCliente")
	public String ActualizaCliente(Cliente obj, Model m) {
		servicio.actualizaCliente(obj);
		List<Cliente> list = servicio.listaCliente("");
		m.addAttribute("clientes", list);
		return "crudCliente";
	}
	
	@RequestMapping("/eliminaCliente")
	public String elimina(@RequestParam Map<String,String> params, Model m) {
		String id = params.get("id");
		servicio.eliminaCliente(Integer.parseInt(id));
		List<Cliente> list = servicio.listaCliente("");
		m.addAttribute("clientes", list);
		return "crudCliente";
	}
	
	
	
}
