package com.redsocial.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.redsocial.entidad.Usuario;
import com.redsocial.servicio.UsuarioServicio;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServicio servicio;
	
	@RequestMapping("/verUsuario")
	public String verPagina(Model m) {
		List<Usuario> list = servicio.listaUsuario("");
		m.addAttribute("usuarios", list);
		return "crudUsuario";
	}
	
	@RequestMapping("/listaUsuario")
	public String lista(@RequestParam Map<String,String> params, Model m) {
		List<Usuario> list = servicio.listaUsuario(params.get("filtro"));
		m.addAttribute("usuarios", list);
		return "crudUsuario";
	}
	
	@RequestMapping("/registraUsuario")
	public String RegistraUsuario(Usuario obj, Model m) {
		servicio.insertaUsuario(obj);
		List<Usuario> list = servicio.listaUsuario("");
		m.addAttribute("usuarios", list);
		return "crudUsuario";
	}
	
	@RequestMapping("/actualizaUsuario")
	public String ActualizaUsuario(Usuario obj, Model m) {
		servicio.actualizaUsuario(obj);
		List<Usuario> list = servicio.listaUsuario("");
		m.addAttribute("usuarios", list);
		return "crudUsuario";
	}
	
	@RequestMapping("/eliminaUsuario")
	public String elimina(@RequestParam Map<String,String> params, Model m) {
		String id = params.get("id");
		servicio.eliminaUsuario(Integer.parseInt(id));
		List<Usuario> list = servicio.listaUsuario("");
		m.addAttribute("usuarios", list);
		return "crudUsuario";
	}

}
