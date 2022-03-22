package com.lachozadelema.lachozadelema.entidades;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Foto{

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String mime;
	private String name;
    
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] contenido;

	public Foto() {
		
	}

	public Foto(Integer id, String name, String mime, byte[] contenido) {
		this.id = id;
		this.name = name;
		this.mime = mime;
		this.contenido = contenido;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public byte[] getContenido() {
		return contenido;
	}
	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
