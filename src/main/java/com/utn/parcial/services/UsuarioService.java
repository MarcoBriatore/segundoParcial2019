package com.utn.parcial.services;

import com.utn.parcial.models.Usuario;
import com.utn.parcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class UsuarioService {


    @Autowired
    private IUsuarioRepository iUsuarioRepository;


    public List<Usuario> getAll()
    {
        return iUsuarioRepository.findAll();
    }
    public void remove(Integer id)
    {
        iUsuarioRepository.deleteById(id);
    }

    public Usuario getUser(Integer id)
    {
        return iUsuarioRepository.findById(id).orElse(null);
    }

    public void save(Usuario u)
    {
        iUsuarioRepository.save(u);
    }

    public void update(Usuario u)
    {
        iUsuarioRepository.save(u);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> methodAsync() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(getAll());
    }

    public Usuario findById(Integer id) {
        return iUsuarioRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        iUsuarioRepository.deleteById(id);
    }
}
