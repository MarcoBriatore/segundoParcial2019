package com.utn.parcial.models;

import java.util.List;

public class AsyincEntity {
    private List<Comentarios> join;
    private List<Publicaciones> join1;
    private List<Usuario> join2;

    public AsyincEntity(List<Comentarios> join, List<Publicaciones> join1, List<Usuario> join2) {
        this.join = join;
        this.join1 = join1;
        this.join2 = join2;
    }
}
