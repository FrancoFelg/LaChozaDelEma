package com.lachozadelema.lachozadelema.servicios;

import org.springframework.stereotype.Service;

@Service
public class ValidatorServicio {
	
	//Validar una cadena no nula
	public void validarString (String contenido, String nombre) throws Exception {
		if(contenido == null || contenido.isEmpty() ) {
			throw new Exception(nombre + "cant be null");
		}
	}
	
	public void validarInteger (Integer contenido, String nombre) throws Exception {
		if( contenido == null || contenido == 0 ) {
			throw new Exception(nombre + "cant be null");
		}
	}
	
}
