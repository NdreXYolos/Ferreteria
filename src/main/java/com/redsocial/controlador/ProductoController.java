package com.redsocial.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.redsocial.entidad.Producto;
import com.redsocial.servicio.ProductoServicio;

@Controller
public class ProductoController {
   
	@Autowired
	private ProductoServicio servicio;
	
	
	@RequestMapping("/verProducto")
	public String verPagina(Model m) {
		List<Producto> list = servicio.listaProducto("");
		m.addAttribute("productos", list);
		return "crudProducto";
	}
	
	@RequestMapping("/listaProducto")
	public String lista(@RequestParam Map<String,String> params, Model m) {
		List<Producto> list = servicio.listaProducto(params.get("filtro"));
		m.addAttribute("productos", list);
		return "crudProducto";
	}
	
	@RequestMapping("/registraProducto")
	public String RegistraProducto(Producto obj, Model m) {
		servicio.insertaProducto(obj);
		List<Producto> list = servicio.listaProducto("");
		m.addAttribute("productos", list);
		return "crudProducto";
	}
	
	@RequestMapping("/actualizaProducto")
	public String ActualizaProducto(Producto obj, Model m) {
		servicio.actualizaProducto(obj);
		List<Producto> list = servicio.listaProducto("");
		m.addAttribute("productos", list);
		return "crudProducto";
	}
	
	@RequestMapping("/eliminaProducto")
	public String elimina(@RequestParam Map<String,String> params, Model m) {
		String id = params.get("id");
		servicio.eliminaProducto(Integer.parseInt(id));
		List<Producto> list = servicio.listaProducto("");
		m.addAttribute("productos", list);
		return "crudProducto";
	}

}
