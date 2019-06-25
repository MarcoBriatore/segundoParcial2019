package com.utn.parcial.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PublicacionMasCantComent {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private String getPublicacion;
    private String getNombre;
    private Integer getCantidadComentarios;

}
