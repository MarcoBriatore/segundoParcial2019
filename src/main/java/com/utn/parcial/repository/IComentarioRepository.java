package com.utn.parcial.repository;

import com.utn.parcial.models.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentarios,Integer> {

    String NATIVE_QUERY ="DELETE FROM comentarios c WHERE c.tiempo < (now() - INTERVEAL ${TIME} MINUTES)";

    @Query(value = NATIVE_QUERY, nativeQuery = true)
    void deleteByTimeProper();

}
