package com.lachozadelema.lachozadelema.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Review;

@Repository
public interface ReviewRepositorio extends JpaRepository<Review, Long>{

	@Query("SELECT a FROM Review a WHERE a.id like :id")
	public Review retornarReviewsPorId(@Param("id") Long id);
	
	@Query("SELECT a FROM Review a WHERE a.titulo like :titulo")
	public List<Review> retornarReviewsPorTitulo(@Param("titulo") String titulo);
	
	@Query("SELECT a FROM Review a WHERE a.titulo like :titulo")
	public Review retornarReviewPorTitulo(@Param("titulo") String titulo);
	
}
