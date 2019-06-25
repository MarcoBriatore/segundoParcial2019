package com.utn.parcial.controller;


import com.utn.parcial.models.Comentarios;
import com.utn.parcial.models.Publicaciones;
import com.utn.parcial.services.ComentarioService;
import com.utn.parcial.services.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comentarios")
public class ComentarioController
{

    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private PublicacionService publicacionService;

    public void save(@RequestBody Comentarios c)
    {
        comentarioService.save(c);
    }

    @Scheduled(cron = "${TIME}")
    public void deleteByTime() {
        comentarioService.deleteByTime();
    }

    @PutMapping("/{id}")
    public void modificarComentario(@PathVariable("id") final Integer id, @RequestBody Comentarios c) {
        Comentarios com = comentarioService.findById(id);
        Publicaciones p = publicacionService.findById(com.getPublicacion().getId());

        //p.getComentariosList().stream().forEach(comentarios -> {com.equals(comentarios); comentarios = c;});
        for(Comentarios comentario : p.getComentariosList()) {
            if(com.equals(comentario)) {
                comentario = c;
            }
        }
        publicacionService.save(p);
        comentarioService.save(c);
    }

    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable("id") final Integer id) {
        Comentarios c = comentarioService.findById(id);
        Publicaciones p = publicacionService.findById(c.getPublicacion().getId());
        p.getComentariosList().remove(c);
        publicacionService.save(p);
        comentarioService.deleteById(id);
    }


}
