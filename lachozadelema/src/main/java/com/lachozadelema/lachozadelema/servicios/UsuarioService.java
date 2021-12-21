package com.lachozadelema.lachozadelema.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lachozadelema.lachozadelema.Errores.ErrorServicio;
import com.lachozadelema.lachozadelema.Repositorios.UsuarioRepositorio;
import com.lachozadelema.lachozadelema.entidades.Usuario;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	//Create
	public void crearUsuario(String nombre, String Password) throws ErrorServicio {
		
		
		Usuario usuario = new Usuario();
		usuario.setUsername(nombre);
		usuario.setPassword(Password);
		usuario.setRol("ROL_USER");
		usuario.setStatus(true);
		
		usuarioRepositorio.save(usuario);
		
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.retornarUsuarioPorNombre(username);
		if(usuario != null) {
			List<GrantedAuthority> permisos = new ArrayList<>();
			
			GrantedAuthority p1 = new SimpleGrantedAuthority(usuario.getRol());
			permisos.add(p1);

			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession();
			session.setAttribute("usuariosession", usuario);
			
			User user = new User(usuario.getUsername(), usuario.getPassword(), permisos);
			return user;
		}	
		
		return null;
	}
	
}
