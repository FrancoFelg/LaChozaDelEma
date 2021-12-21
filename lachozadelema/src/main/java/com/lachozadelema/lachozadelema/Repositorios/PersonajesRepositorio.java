package com.lachozadelema.lachozadelema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Personaje;


@Repository
public interface PersonajesRepositorio extends JpaRepository<Personaje, String>{
	
	@Query("SELECT a FROM Personaje a WHERE a.id LIKE :id")
	public Personaje retornarPersonajePorId(@Param ("id") String id );
	
	@Query("SELECT a FROM Personaje a WHERE a.nombre LIKE :nombre")
	public Personaje retornarPersonajePorNombre(@Param ("nombre") String nombre );
}
