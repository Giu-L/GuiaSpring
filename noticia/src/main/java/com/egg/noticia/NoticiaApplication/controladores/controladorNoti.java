package com.egg.noticia.NoticiaApplication.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.noticia.NoticiaApplication.entidades.entidadesNoti;
import com.egg.noticia.NoticiaApplication.excepciones.MiException;
import com.egg.noticia.NoticiaApplication.servicios.servicioNoti;

@RequestMapping("/entidadesNoti")
public class controladorNoti {
    @Autowired
    private servicioNoti servicioNoti;

    @GetMapping("/registrar")
        public String registrar(){
        return "registrar";
    }
    @PostMapping("/registro")
        public String registro(@RequestParam String titulo, @RequestParam String cuerpo ) throws MiException{
            servicioNoti.crearNoticia(titulo, cuerpo);
            return "indexNoti";
           }
          
  @GetMapping("/lista")
        public String listar(ModelMap modelo){
        List<entidadesNoti> noticias = servicioNoti.obtenerNoticias();
        modelo.addAttribute("noticias", noticias);
        return "index.html";
}

    @GetMapping("modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo){
        modelo.put("noticia", servicioNoti.obtenerNoticias());
        List<entidadesNoti> noti = servicioNoti.obtenerNoticias();

        modelo.addAttribute(noti);
        return "redirect:../";
    }

    //@PostMapping("modificar/{id}")
   // public String modificar(@PathVariable String id, String cuerpo, String titulo, ModelMap modelo){
      // try {
//List<entidadesNoti> noti = servicioNoti.obtenerNoticias();

        //    modelo.addAttribute("noti", noti);
        //    servicioNoti.modificarNoti(cuerpo, titulo);
//
//return "redirect:../lista";
       // } catch (MiException e) {
       //     List<entidadesNoti> noti = servicioNoti.obtenerNoticias();
       //     modelo.put("error", e.getMessage());

       //     modelo.addAttribute("noti",noti);

       //     return "modificarNoti.html";        }
    }



