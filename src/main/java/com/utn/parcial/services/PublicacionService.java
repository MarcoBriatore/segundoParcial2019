package com.utn.parcial.services;

import com.utn.parcial.models.PublicacionMasCantComent;
import com.utn.parcial.models.Publicaciones;
import com.utn.parcial.repository.IPublicacionesRepository;
import com.utn.parcial.repository.ProyectionPublicacionMasCantComent;
import com.utn.parcial.repository.IPublicacionesMasCantComent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class PublicacionService {


    @Autowired
    private IPublicacionesRepository iPublicacionesRepository;
    @Autowired
    private IPublicacionesMasCantComent iPublicacionesMasCantComent;


    public List<Publicaciones> getALl()
    {
        return iPublicacionesRepository.findAll();
    }


    public void save(Publicaciones p) {
        iPublicacionesRepository.save(p);
    }

    public Publicaciones findByid(Integer id) {
        return iPublicacionesRepository.findById(id).orElse(null);
    }

    public List<ProyectionPublicacionMasCantComent> getPublicacionesMasComent()
    {
        return iPublicacionesRepository.publicacionMasCantComent();
    }
    public List<PublicacionMasCantComent> getPublicacionesMasComentClass()
    {
        return iPublicacionesMasCantComent.findAll();
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicaciones>> methodAsync() {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return CompletableFuture.completedFuture(getALl());
    }

    public Publicaciones findById(Integer id) {
        return iPublicacionesRepository.findById(id).get();
    }

    public void saveWithCantComent(PublicacionMasCantComent publicacionMasCantComent) {
        iPublicacionesMasCantComent.save(publicacionMasCantComent);
    }
}
