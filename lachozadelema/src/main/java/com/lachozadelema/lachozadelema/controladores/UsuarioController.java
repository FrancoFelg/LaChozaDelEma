package com.lachozadelema.lachozadelema.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lachozadelema.lachozadelema.Errores.ErrorServicio;
import com.lachozadelema.lachozadelema.Repositorios.UsuarioRepositorio;
import com.lachozadelema.lachozadelema.entidades.Usuario;
import com.lachozadelema.lachozadelema.servicios.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	@GetMapping("/crearUsuario") // Retorna el register
	public String retornarRegister(ModelMap model) {
		return "register.html";
	}
	
	
	@PostMapping("/crearUsuario") //
	public String redireccionarRegister(ModelMap model, @RequestParam MultipartFile archive, @RequestParam String username, @RequestParam String password) throws Exception {
		usuarioService.crearUsuario(username, password, archive);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(ModelMap model, @PathVariable ("id") Long id) {
		Usuario usuario = usuarioService.getByID(id);
        model.put("usuario", usuario);
        model.put("id", usuario.getId());
		return "editarUsuario.hmtl";
	}
	
	
	@PostMapping("/editarUsuario/{id}")
	public String editarUsuario(ModelMap model, @RequestParam Long id, @RequestParam String username, @RequestParam String password, @RequestParam MultipartFile archive) throws Exception{
		try {
			usuarioService.editarUsuario(id, username, password, archive);
            return "redirect:/";
        } catch (Exception ex) {
            model.put("error", ex.getMessage());
            model.put("username", username);
            model.put("password", password);
            model.put("archive", archive);
            return "redirect:/";
        }
	}
	
	
	@GetMapping("/usuario/{idUsuario}")
	public String usuario(ModelMap model, @PathVariable(name = "idUsuario", required = true) Long id) {
		Usuario usuario = usuarioRepositorio.getById(id);
		model.put("usuario", usuario);
		
		model.put("idUsuario", usuario.getId());
		model.put("username", usuario.getUsername());
		model.put("password", usuario.getPassword());
		model.put("fotoPerfil", usuario.getFoto());
		
		return "usuario.html";
	}
	
	
	@GetMapping("/login")
	public String retornarLogin() {
		return "login.html";
	}
	
	@GetMapping("/logout")
	public String retornarLogout() {
		return "logout.html";
	}
	
}
