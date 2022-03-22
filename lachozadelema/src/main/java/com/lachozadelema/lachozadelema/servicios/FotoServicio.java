package com.lachozadelema.lachozadelema.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lachozadelema.lachozadelema.Repositorios.FotoRepositorio;
import com.lachozadelema.lachozadelema.entidades.Foto;

@Service
public class FotoServicio {
	
	@Autowired
	private FotoRepositorio fotoRepositorio;
	
	public Foto guardar(MultipartFile image) throws Exception{
		if(image != null) { //En caso de que la imagen no sea nula
			try {
				Foto foto = new Foto(); //Genero un nuevo objeto (id única)
				//Setteo sus atributos
				foto.setMime(image.getContentType());
				foto.setName(image.getName());
				foto.setContenido(image.getBytes());
				
				return fotoRepositorio.save(foto);//Devuelvo la imágen que guardo
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return null; //Si es nula retorna nulo
	}
	
	public Foto actualizar(Long idFoto, MultipartFile image) throws Exception {
		if(image != null) { //En caso de que la imagen no sea nula
			try {
				Foto foto = new Foto(); //Genero un nuevo objeto (id única)
				
				if(idFoto != null) { //Si la id no es nula
					Optional<Foto> respuesta = fotoRepositorio.findById(idFoto); //Obtengo un objeto buscado por id desde el repositorio, si no, devuelve null
					if(respuesta.isPresent()) { //Si la respuesta no es nula
						foto = respuesta.get(); //El objeto foto ahora es igual a la foto encontrada por id
					}
				}
				
				//Setteo sus atributos
				foto.setMime(image.getContentType());
				foto.setName(image.getName());
				foto.setContenido(image.getBytes());
				
				return fotoRepositorio.save(foto);//Devuelvo la imágen que guardo
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return null; //Si es nula retorna nulo
	}
	
}
