package com.redsocial.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.redsocial.entidad.Proveedor;
import com.redsocial.servicio.ProveedorServicio;

@Controller
public class ProveedorController {

	@Autowired
	private ProveedorServicio servicio;
	
	@RequestMapping("/verProveedor") 
	public String verPagina(Model m) {
		List<Proveedor> list = servicio.listaProveedor("");
		m.addAttribute("PROVEEDOR", list);
		return "crudProveedor";
	}
	
	@RequestMapping("/listaProveedor") 
	public String lista(@RequestParam Map<String,String> params, Model m) {
		String fil = params.get("filtro");
		List<Proveedor> lista = servicio.listaProveedor(fil);
		m.addAttribute("PROVEEDOR", lista);
		return "crudProveedor";
	}
	
	@RequestMapping("/registraProveedor") 
	public String registra(Proveedor obj, Model m) {
		servicio.insertaProveedor(obj);
		List<Proveedor> lista = servicio.listaProveedor("");
		m.addAttribute("PROVEEDOR", lista);
		return "crudProveedor";
	}
	
	@RequestMapping("/actualizaProveedor") 
	public String actualiza(Proveedor obj, Model m) {
		servicio.actualizaProveedor(obj);
		List<Proveedor> lista = servicio.listaProveedor("");
		m.addAttribute("PROVEEDOR", lista);
		return "crudProveedor";
	}
	
	@RequestMapping("/eliminaProveedor")
	public String elimina(@RequestParam Map<String,String> params, Model m) {
		String id = params.get("id");
		servicio.eliminaProveedor(Integer.parseInt(id));
		List<Proveedor> list = servicio.listaProveedor("");
		m.addAttribute("PROVEEDOR", list);
		return "crudProveedor";
	}
	
}
