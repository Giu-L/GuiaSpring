package com.egg.noticia.NoticiaApplication.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.egg.noticia.NoticiaApplication.entidades.entidadesNoti;

public interface repoNoti extends JpaRepository<entidadesNoti,String>  {
    @Query("SELECT t FROM entidadesNoti t WHERE t.titulo =:titulo")
    public entidadesNoti buscarporTitulo(@Param("titulo") String titulo);

    @Query("SELECT c FROM entidadesNoti c WHERE c.cuerpo =: cuerpo")
    public entidadesNoti buscarporCuerpo(@Param("cuerpo")String cuerpo);


    
}
