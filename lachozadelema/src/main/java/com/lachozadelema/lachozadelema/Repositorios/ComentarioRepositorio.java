package com.lachozadelema.lachozadelema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Comentarios;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentarios, Long>{
	
	@Query("SELECT a FROM Comentarios a WHERE a.usuario.username like :username")
	public Comentarios retornarComentarioPorUsuario(@Param("username") String usuario);
	
}
