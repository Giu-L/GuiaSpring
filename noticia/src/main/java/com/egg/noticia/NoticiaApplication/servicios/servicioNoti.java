package com.egg.noticia.NoticiaApplication.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.noticia.NoticiaApplication.entidades.entidadesNoti;
import com.egg.noticia.NoticiaApplication.excepciones.MiException;
import com.egg.noticia.NoticiaApplication.repositorio.repoNoti;

import jakarta.transaction.Transactional;

@Service
public class servicioNoti {
 
    @Autowired
    private repoNoti repoNoti;

   

    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws MiException {
        validar(titulo, cuerpo);

        entidadesNoti Noticias = new entidadesNoti();
        Noticias.setCuerpo(cuerpo);
        Noticias.setTitulo(titulo);

        repoNoti.save(Noticias);
    }

    @Transactional
    public List<entidadesNoti> obtenerNoticias() {
        List<entidadesNoti> noticias = repoNoti.findAll();
        return noticias;
    }
    
    @Transactional
    public void modificarNoti(String cuerpo, String titulo) throws MiException {
        validar(titulo, cuerpo);

        Optional<entidadesNoti> respuesta = repoNoti.findById(titulo);
        Optional<entidadesNoti> respue = repoNoti.findById(cuerpo);

        if (respuesta.isPresent() && respue.isPresent()) {
            entidadesNoti no = respue.get();
            no.setCuerpo(cuerpo);
            no.setTitulo(titulo);
        }
    }

    @Transactional
    public void eliminar(String id) throws MiException {
        Optional<entidadesNoti> respuesta = repoNoti.findById(id);

        if (respuesta.isPresent()) {
           
            repoNoti.deleteById(id);
        }
    }

    private void validar(String titulo, String cuerpo) throws MiException {
       if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El título no puede estar vacío");
       }
       if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("El cuerpo no puede estar vacío");
       }
    }
}

    
    


