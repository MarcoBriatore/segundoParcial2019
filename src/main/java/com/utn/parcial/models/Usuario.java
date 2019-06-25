package com.utn.parcial.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {


    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private Integer id;
    private String nombre;
    private String apellido;
    private String Browser;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "usuario")
    private List<Publicaciones> publicacionesList;




}
