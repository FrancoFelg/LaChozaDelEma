package com.lachozadelema.lachozadelema.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lachozadelema.lachozadelema.Errores.ErrorServicio;
import com.lachozadelema.lachozadelema.servicios.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/crearUsuario") // Retorna el register
	public String retornarRegister() {
		return "register.html";
	}
	
	@PostMapping("/crearUsuario") //
	public String redireccionarRegister(@RequestParam String username, @RequestParam String password) throws ErrorServicio {
		usuarioService.crearUsuario(username, password);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String retornarLogin() {
		return "login.html";
	}
	
	
	
}
