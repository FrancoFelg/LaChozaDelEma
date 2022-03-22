package com.lachozadelema.lachozadelema.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@OneToOne(mappedBy = "fotoPerfil_id", cascade = CascadeType.ALL)
	private Foto fotoPerfil;
	
	@OneToMany(
			mappedBy = "comentarios",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Comentarios> comentarios;
	
	private String rol;
	
	private Boolean status;
	
	public Usuario() {}
	
	public Usuario(Long id, String username, String password, Foto fotoPerfil, List<Comentarios> comentarios, String rol, Boolean status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fotoPerfil = fotoPerfil;
		this.comentarios = comentarios;
		this.rol = rol;
		this.status = status;
	}

	public Foto getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public List<Comentarios> getComentario() {
		return comentarios;
	}

	public void setComentario(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Foto getFoto() {
		return fotoPerfil;
	}

	public void setFoto(Foto foto) {
		this.fotoPerfil = foto;
	}
	
	
	
}
