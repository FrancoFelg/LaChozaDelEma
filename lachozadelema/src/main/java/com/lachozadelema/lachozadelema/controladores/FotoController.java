package com.lachozadelema.lachozadelema.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lachozadelema.lachozadelema.Errores.ErrorServicio;
import com.lachozadelema.lachozadelema.Repositorios.ReviewRepositorio;
import com.lachozadelema.lachozadelema.Repositorios.UsuarioRepositorio;
import com.lachozadelema.lachozadelema.entidades.Review;
import com.lachozadelema.lachozadelema.entidades.Usuario;

@Controller
@RequestMapping("/foto")
public class FotoController {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private ReviewRepositorio reviewRepositorio;
	
	@GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<byte[]> fotoUsuario(@PathVariable Long idUsuario) throws ErrorServicio{
        try {
            Usuario usuario = usuarioRepositorio.getById(idUsuario);
            if (usuario.getFoto()==null){
                throw new ErrorServicio("Este usuario no tiene foto");
            }
            byte[] foto = usuario.getFoto().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(foto,headers,HttpStatus.OK);
        }
        catch(Exception ex){
            System.out.println("ERROR_FOTO");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
    
    @GetMapping("/review/{idReview}")
    public ResponseEntity<byte[]> fotoReview(@PathVariable Long idReview) throws ErrorServicio{
        try {
            Review review = reviewRepositorio.getById(idReview);
            if (review.getFotos()==null){
                throw new ErrorServicio("Este usuario no tiene foto");
            }
            byte[] foto = review.getFotos().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(foto,headers,HttpStatus.OK);
        }
        catch(Exception ex){
            System.out.println("ERROR_FOTO");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
