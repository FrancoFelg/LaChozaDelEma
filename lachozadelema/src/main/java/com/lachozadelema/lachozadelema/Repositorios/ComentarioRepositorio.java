package com.lachozadelema.lachozadelema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, String>{
	
	@Query("SELECT a FROM Comentario a WHERE a.id LIKE :id")
	public Comentario retornarComentarioPorId(@Param ("id") String id );
	
	@Query("SELECT a FROM Comentario a WHERE a.usuario LIKE :usuario")
	public Comentario retornarComentarioPorUsuario(@Param ("usuario") String nombre );
}
