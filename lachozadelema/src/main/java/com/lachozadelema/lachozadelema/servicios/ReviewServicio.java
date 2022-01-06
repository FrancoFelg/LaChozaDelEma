package com.lachozadelema.lachozadelema.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lachozadelema.lachozadelema.Repositorios.ReviewRepositorio;
import com.lachozadelema.lachozadelema.entidades.Review;

@Service
public class ReviewServicio {

	@Autowired
	private ReviewRepositorio reviewRepositorio;
	
	@Autowired
	private ValidatorServicio validator;
	
	//CREATE
	public void crearReview(String titulo, String descripcion, String textoAnalisis, Integer clasificacion) throws Exception {		
		validator.validarString(titulo, "titulo");
		validator.validarString(descripcion, "descripcion");
		validator.validarString(textoAnalisis, "texto analisis");
		validator.validarInteger(clasificacion, "clasificacion");					
		
		try {
			Review review = new Review
					(titulo, 
					descripcion, 
					textoAnalisis, 
					clasificacion);
			
			reviewRepositorio.save(review);
			
		}catch( Exception e ) {
			e.printStackTrace();
		}				
		
	}
	//READ
	public Review retornarReviewPorId(String id) throws Exception {
		validator.validarString(id, "id");
		Review review = reviewRepositorio.findById(id).get();
		
		if( review != null ) {
			return review;
		}
		throw new Exception("No one review has the mentioned ID");
	}
	
	public List<Review> retornarReviews() throws Exception {
		return reviewRepositorio.findAll();
	}
	//UPDATE
	public void editar(String id, String titulo, String descripcion, String textoAnalisis, Integer clasificacion) throws Exception {		
		validator.validarString(id, "id");
		validator.validarString(titulo, "titulo");
		validator.validarString(descripcion, "descripcion");
		validator.validarString(textoAnalisis, "texto analisis");
		validator.validarInteger(clasificacion, "clasificacion");					
		
		try {
			Review review = reviewRepositorio.findById(id).get();
			review.setTitulo(id);
			review.setTextoAnalisis(textoAnalisis);
			review.setDescripcion(descripcion);
			review.setClasificacion(clasificacion);
			
			reviewRepositorio.save(review);
			
		}catch( Exception e ) {
			e.printStackTrace();
		}				
		
	}
	
	//DOWN
	
	//UP
	
	//DELETE
	
}
