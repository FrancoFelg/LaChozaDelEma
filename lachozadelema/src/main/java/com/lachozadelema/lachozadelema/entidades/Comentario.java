package com.lachozadelema.lachozadelema.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	private Usuario usuario;
	
	private Review review;
	
	private String texto;
	
	private Integer cantidadLikes;

	public Comentario() {
		super();
	}

	public Comentario(String id, Usuario usuario, Review review, String texto, Integer cantidadLikes) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.review = review;
		this.texto = texto;
		this.cantidadLikes = cantidadLikes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getCantidadLikes() {
		return cantidadLikes;
	}

	public void setCantidadLikes(Integer cantidadLikes) {
		this.cantidadLikes = cantidadLikes;
	}
	
	
	
	
}
