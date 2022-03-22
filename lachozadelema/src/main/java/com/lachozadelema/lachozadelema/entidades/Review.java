package com.lachozadelema.lachozadelema.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;



@Entity
@Table(name="Review")
public class Review{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	private String descripcion;
	private String textoAnalisis;
	private Integer clasificacion;
		
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="foto_id")
	private Foto fotos;
	
	@OneToMany(
			mappedBy = "review",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Comentarios> comentarios;
	 
	private Boolean alta;
	
	public Review() {		
	}
	
	public Review(Long id, String titulo, String descripcion, String textoAnalisis, Integer clasificacion, Foto fotos, List<Comentarios> comentarios, Boolean alta) {	
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.textoAnalisis = textoAnalisis;
		this.clasificacion = clasificacion;
		this.comentarios = comentarios;
		this.fotos = fotos;
		this.alta = alta;
	}

	public Foto getFotos() {
		return fotos;
	}

	public void setFotos(Foto fotos) {
		this.fotos = fotos;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTextoAnalisis() {
		return textoAnalisis;
	}

	public void setTextoAnalisis(String textoAnalisis) {
		this.textoAnalisis = textoAnalisis;
	}

	public Integer getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Integer clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
