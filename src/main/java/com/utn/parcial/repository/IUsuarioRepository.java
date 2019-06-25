package com.utn.parcial.repository;

import com.utn.parcial.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {


}
