package com.lachozadelema.lachozadelema.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Review {

	//@OneToMany
	//private Foto foto;
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	private String titulo;
	private String descripcion;
	private String textoAnalisis;
	private Integer clasificacion;
	/*
	 @OneToMany
	 private List<Comentario> comentarios;
	 */
	
	public Review() {		
	}
	
	
	public Review(String titulo, String descripcion, String textoAnalisis, Integer clasificacion) {		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.textoAnalisis = textoAnalisis;
		this.clasificacion = clasificacion;
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
