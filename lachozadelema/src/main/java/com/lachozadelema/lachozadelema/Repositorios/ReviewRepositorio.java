package com.lachozadelema.lachozadelema.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Review;

@Repository
public interface ReviewRepositorio extends JpaRepository<Review, String>{

	@Query("SELECT a FROM Review a WHERE a.titulo like :titulo")
	public List<Review> retornarReviewsPorTitulo(@Param("titulo") String titulo);
	
}
