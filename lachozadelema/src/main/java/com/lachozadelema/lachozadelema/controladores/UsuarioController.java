package com.lachozadelema.lachozadelema.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String redireccionarRegister(@RequestParam MultipartFile image, @RequestParam String username, @RequestParam String password) throws Exception {
		usuarioService.crearUsuario(image, username, password);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String retornarLogin() {
		return "login.html";
	}
	
	
	
}
