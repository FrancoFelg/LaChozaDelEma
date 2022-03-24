package com.lachozadelema.lachozadelema.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lachozadelema.lachozadelema.servicios.UsuarioService;

@Controller
@RequestMapping("/")
public class PortalController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/") // Retorna el register
	public String index(ModelMap model) {
		return "index.html";
	}
	
	//@GetMapping("/login")
	//public String retornarLogin() {
	//	return "login.html";
	//}
	
	 @GetMapping("/login")
	    public String login(ModelMap modelo, 
	    		@RequestParam(required=false) String error,
	    		@RequestParam(required=false) String logout){
	        if (error!=null){
	            modelo.put("error", "Correo electrónico o clave incorrectos.");
	        }
	        if (logout!=null){
	            modelo.put("logout", "Ha salido correctamente");
	        }
	        return "login.html";
	    }
	
	 @PreAuthorize("hasAnyRole('ROLE_USUARIO_REGISTRADO')")
	 @GetMapping("/inicio")
	    public String inicio(ModelMap modelo, HttpSession session){
	        if (modelo.getAttribute("titulo")==null || modelo.getAttribute("titulo")=="" || !modelo.containsAttribute("titulo")){
	            modelo.addAttribute("titulo", "¡Usted ha ingresado con éxito!");
	        }
	        return "index.html";
	    }
	 
	 
		@GetMapping("/logout")
	public String retornarLogout() {
		return "logout.html";
	}
	
}
