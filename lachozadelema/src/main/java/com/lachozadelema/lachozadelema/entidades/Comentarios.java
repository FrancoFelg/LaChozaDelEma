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
@Table(name="comentarios")
public class Comentarios implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comentarios_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String texto;
	
	@OneToOne(mappedBy = "usuario_id", cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name="review", referencedColumnName = "id", nullable= false)
	private List<Review> Reviews;

	public Comentarios() {
		
	}

	public Comentarios(Long id, String texto, Usuario usuario, List<Review> Reviews) {
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.Reviews = Reviews;
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

	public List<Review> getReview() {
		return Reviews;
	}

	public void setReview(List<Review> review) {
		Reviews = review;
	}
	
}
