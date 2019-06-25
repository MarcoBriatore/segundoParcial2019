package com.utn.parcial.controller;

import com.utn.parcial.models.AsyincEntity;
import com.utn.parcial.models.Comentarios;
import com.utn.parcial.models.Publicaciones;
import com.utn.parcial.models.Usuario;
import com.utn.parcial.services.ComentarioService;
import com.utn.parcial.services.PublicacionService;
import com.utn.parcial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("async")
public class AsyncAllController {

        @Autowired
        private ComentarioService comentarioService;
        @Autowired
        private PublicacionService publicacionService;
        @Autowired
        private UsuarioService usuarioService;

        @GetMapping("/allContent")
        public ResponseEntity<?> asyncInfoList()
        {

                CompletableFuture<List<Comentarios>> resultMethodC = comentarioService.methodAsync();
                CompletableFuture<List<Publicaciones>> resultMethodP = publicacionService.methodAsync();
                CompletableFuture<List<Usuario>> resultMethodU = usuarioService.methodAsync();
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new AsyincEntity(resultMethodC.join() , resultMethodP.join() , resultMethodU.join()));
        }



}
