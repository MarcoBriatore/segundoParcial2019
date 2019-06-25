package com.utn.parcial.controller;

import com.utn.parcial.models.Publicaciones;
import com.utn.parcial.models.Usuario;
import com.utn.parcial.services.ComentarioService;
import com.utn.parcial.services.PublicacionService;
import com.utn.parcial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private PublicacionService publicacionService;


    @GetMapping("/")
    public List<Usuario> getAllUser()
    {
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getUser(@PathVariable final Integer id)
    {
        return usuarioService.getUser(id);
    }

    @PostMapping("/")
    public void saveUser(@RequestHeader("User-Agent") final String header, @RequestBody final Usuario u) {
        u.setBrowser(header);
        usuarioService.save(u);
    }

    @PostMapping("/{id}/publicacion")
    public void altaPublicacion(@RequestBody Publicaciones p,@PathVariable final Integer id )
    {
        Usuario u = usuarioService.getUser(id);
        u.getPublicacionesList().add(p);
        usuarioService.save(u);
        publicacionService.save(p);
    }

    @PutMapping("/{id}")
    public void modificarUsuario(@PathVariable("id") final Integer id, @RequestBody Usuario u) {
         Usuario user = usuarioService.findById(id);
         user.setBrowser(u.getBrowser());
         user.setNombre(u.getNombre());
         user.setApellido(u.getApellido());
         usuarioService.save(u);
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") final Integer id) {
        usuarioService.deleteById(id);
    }




}
