package com.utn.parcial.services;

import com.utn.parcial.models.Comentarios;
import com.utn.parcial.repository.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ComentarioService {

    @Autowired
    private IComentarioRepository iComentarioRepository;


    public List<Comentarios> getALl()
    {
        return iComentarioRepository.findAll();
    }

    public Comentarios getComentario(Integer id)
    {
        return iComentarioRepository.findById(id).orElse(null);
    }

    public void remove(Integer id)
    {
        iComentarioRepository.deleteById(id);
    }

    public void save(Comentarios u)
    {
        iComentarioRepository.save(u);
    }

    public void update(Comentarios u)
    {
        iComentarioRepository.save(u);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentarios>> methodAsync() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(getALl());
    }


    public void deleteByTime() {
        iComentarioRepository.deleteByTimeProper();
    }

    public Comentarios findById(Integer id) {
        return (iComentarioRepository.findById(id)).get();
    }

    public void deleteById(Integer id) {
        iComentarioRepository.deleteById(id);
    }
}
