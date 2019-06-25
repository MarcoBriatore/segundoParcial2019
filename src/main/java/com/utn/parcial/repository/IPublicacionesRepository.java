package com.utn.parcial.repository;

import com.utn.parcial.models.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPublicacionesRepository extends JpaRepository<Publicaciones,Integer> {

    String NATIVE_QUERY = "Select p.titulo, u.nombre, count(c.id) as cantidad " +
            "from usuario u " +
            "inner join publicaciones p on p.usuario_id = usuario_id " +
            "inner join comentarios c on c.publicacion_id = p.publicacion_id " +
            "group by u.nombre,p.titulo";

    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<ProyectionPublicacionMasCantComent> publicacionMasCantComent();


}
