package com.lachozadelema.lachozadelema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lachozadelema.lachozadelema.entidades.Foto;

@Repository
public interface FotoRepositorio extends JpaRepository<Foto, String>{

}
