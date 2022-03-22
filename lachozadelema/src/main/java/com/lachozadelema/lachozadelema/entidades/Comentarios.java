package com.lachozadelema.lachozadelema.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Comentarios")
public class Comentarios{	

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String texto;
	
	@ManyToOne
	@JoinColumn(name = "comentarios")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "review")
	private Review review;

	public Comentarios() {
		
	}

	public Comentarios(Long id, String texto, Usuario usuario, Review review) {
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
	
}
