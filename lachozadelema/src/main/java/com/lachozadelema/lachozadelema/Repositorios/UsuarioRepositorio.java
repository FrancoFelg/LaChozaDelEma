package com.lachozadelema.lachozadelema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	
	@Query("SELECT a FROM Usuario a WHERE a.username LIKE :nombre")
	public Usuario retornarUsuarioPorNombre(@Param ("nombre") String nombre );
}
