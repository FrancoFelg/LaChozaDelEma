package com.lachozadelema.lachozadelema.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.multipart.MultipartFile;

import com.lachozadelema.lachozadelema.Repositorios.ReviewRepositorio;
import com.lachozadelema.lachozadelema.entidades.Review;
import com.lachozadelema.lachozadelema.entidades.Usuario;
import com.lachozadelema.lachozadelema.entidades.Comentarios;
import com.lachozadelema.lachozadelema.entidades.Foto;
import java.util.Optional;

@Service
public class ReviewServicio {

	@Autowired
	private ReviewRepositorio reviewRepositorio;
	
	@Autowired
	private ValidatorServicio validator;
	
	@Autowired
	private FotoServicio fotoServicio;
	
	
	
	//CREATE
	@Transactional
	public void crearReview(String titulo, String descripcion, String textoAnalisis, Integer clasificacion, MultipartFile archive, List<Comentarios> comentarios, Boolean alta) throws Exception {		
		validator.validarString(titulo, "titulo");
		validator.validarString(descripcion, "descripcion");
		validator.validarString(textoAnalisis, "texto analisis");
		validator.validarInteger(clasificacion, "clasificacion");					
		
		try {
			Review review = new Review();
			
			reviewRepositorio.save(review);
			
		}catch( Exception e ) {
			e.printStackTrace();
		}				
		
	}
	
	
	
	
	//READ
	@Transactional
	public Review retornarReviewPorId(Long id) throws Exception {
		Review review = reviewRepositorio.findById(id).get();
		
		if( review != null ) {
			return review;
		}
		throw new Exception("No one review has the mentioned ID");
	}
	
	
	
	
	@Transactional
	public List<Review> retornarReviews() throws Exception {
		return reviewRepositorio.findAll();
	}
	
	
	
	
	//UPDATE
	@Transactional
	public void editar(Long id, String titulo, String descripcion, String textoAnalisis, Integer clasificacion, MultipartFile archive, List<Comentarios> comentarios, Boolean alta) throws Exception {		
		//validator.validarInteger(id, "id");
		validator.validarString(titulo, "titulo");
		validator.validarString(descripcion, "descripcion");
		validator.validarString(textoAnalisis, "texto analisis");
		validator.validarInteger(clasificacion, "clasificacion");
		
		try {
			Review review = reviewRepositorio.getById(id);
			review.setTitulo(titulo);
			review.setTextoAnalisis(textoAnalisis);
			review.setDescripcion(descripcion);
			review.setClasificacion(clasificacion);
			
			if (archive!=null && archive.isEmpty()) {	
				Foto imagen = fotoServicio.guardar(archive);
	            review.setFotos(imagen);
	        }
			review.setAlta(alta);
			reviewRepositorio.save(review);
			
		}catch( Exception e ) {
			e.printStackTrace();
		}				
		
	}
	
	
	
	//DOWN
	@Transactional
	public Review baja(Long id) {
		Review review = reviewRepositorio.getById(id);
		review.setAlta(false);
		return reviewRepositorio.save(review);
	}
	
	
	
	//UP
	@Transactional
    public Review alta(Long id){
		Review review = reviewRepositorio.getById(id);
		review.setAlta(true);
		return reviewRepositorio.save(review);
	}
	
	
	//DELETE
	@Transactional
	public void eliminarReview(Long id) throws Exception {
		Optional<Review> respuesta = reviewRepositorio.findById(id);
		if(respuesta.isPresent()) {
			Review review = respuesta.get();
			review.setAlta(false);
			reviewRepositorio.save(review);
			}else {
			throw new Exception("No se encontró la reseña solicitada.");
		}
	}
	
	
	
	@Transactional
	public Review getByID(Long id) {
		return reviewRepositorio.getById(id);
	}
	
	
	
	@Transactional
	public Review buscarPorTitulo(String titulo) {
		return reviewRepositorio.retornarReviewPorTitulo(titulo);
	}
	
	
	
	
	@Transactional
	public List <Review> mostrarTodos(String titulo){
		return reviewRepositorio.retornarReviewsPorTitulo(titulo);
	}
	
}
