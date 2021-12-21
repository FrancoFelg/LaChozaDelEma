package com.lachozadelema.lachozadelema.Repositorios;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Review;


@Repository
public interface ReviewRepositorio extends JpaRepository<Review, String>{

	@Query("SELECT a FROM Review a WHERE a.id LIKE :id")
	public Review retornarReviewPorId(@Param ("id") String id );
	
	@Query("SELECT a FROM Review a WHERE a.titulo LIKE :titulo")
	public Review retornarReviewPorTitulo(@Param ("titulo") String titulo );
	
	@Query("SELECT a FROM Review a WHERE a.fechaPublicacion LIKE :fechaPublicacion")
	public Review retornarReviewPorFechaPublicacion(@Param("fechaPublicacion") Date fechaPublicacion);
}
