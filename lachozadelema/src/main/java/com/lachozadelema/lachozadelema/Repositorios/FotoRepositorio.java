package com.lachozadelema.lachozadelema.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Foto;

@Repository
public interface FotoRepositorio extends JpaRepository<Foto, Long>{
	
	@Query("SELECT a FROM Comentarios a WHERE a.id like :id")
	public Optional<Foto> findById(Integer idFoto);
	
}
