package com.lachozadelema.lachozadelema.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Review {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	private String titulo;
	
	private String sinopsis;
	
	private String textoAnalisis;
	
	private Integer clasificacion;
	
	//private List listaComentarios;
	
	private Foto imagen;

	public Review() {
		super();
	}

	public Review(String id, String titulo, String sinopsis, String textoAnalisis, Integer clasificacion, Foto imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.textoAnalisis = textoAnalisis;
		this.clasificacion = clasificacion;
		this.imagen = imagen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
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

	public Foto getImagen() {
		return imagen;
	}

	public void setImagen(Foto imagen) {
		this.imagen = imagen;
	}
	
	
	
}
