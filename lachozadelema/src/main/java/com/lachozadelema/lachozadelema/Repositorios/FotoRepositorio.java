package com.lachozadelema.lachozadelema.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Foto;


@Repository
public interface FotoRepositorio extends JpaRepository<Foto, String>{
	
	@Query("SELECT a FROM Foto a WHERE a.id LIKE :id")
	public Foto retornarFotoPorId(@Param ("id") String id );
	
	@Query("SELECT c FROM Foto c WHERE c.id = :id")
    public List<Foto> buscarFotoPorId(@Param("id") String id);
	
	@Query("SELECT a FROM Foto a WHERE a.usuario LIKE :usuario")
	public Foto retornarFotoPorUsuario(@Param ("usuario") String nombre );
}
