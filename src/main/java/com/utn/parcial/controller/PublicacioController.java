package com.utn.parcial.controller;

import com.utn.parcial.models.PublicacionMasCantComent;
import com.utn.parcial.models.Publicaciones;
import com.utn.parcial.models.Usuario;
import com.utn.parcial.repository.ProyectionPublicacionMasCantComent;
import com.utn.parcial.services.PublicacionService;
import com.utn.parcial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publicaciones")
public class PublicacioController {


    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/")
    public void save(@RequestBody Publicaciones p)
    {
        publicacionService.save(p);
    }

    @GetMapping("/{id}")
    public Publicaciones getPublicacion(@PathVariable final Integer id)
    {
        return publicacionService.findByid(id);
    }

    @GetMapping("/all")
    public List<ProyectionPublicacionMasCantComent> getPublicacionesMasComent()
    {
        return publicacionService.getPublicacionesMasComent();
    }

    @GetMapping("/allDTO")
    public List<PublicacionMasCantComent> getPublicacionesMasComentClass()
    {
        return publicacionService.getPublicacionesMasComentClass();
    }

    @PutMapping("/{id}")
    public void modificarPublicacion(@PathVariable("id") final Integer id, @RequestBody final Publicaciones p) {
        Publicaciones oldPublic = publicacionService.findById(id);
        Usuario u = usuarioService.findById(p.getUsuario().getId());

        for(Publicaciones pub : u.getPublicacionesList()) {
            if(oldPublic.getId().equals(pub.getId())) {
                pub = p;
            }
        }

        publicacionService.save(p);
        usuarioService.save(u);
    }

    @PostMapping("/withComent")
    public void savePublicWithComent(@RequestBody PublicacionMasCantComent publicacionMasCantComent)
    {
        publicacionService.saveWithCantComent(publicacionMasCantComent);
    }



}
