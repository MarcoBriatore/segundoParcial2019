package com.utn.parcial.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Publicaciones {

    @Id
    @GeneratedValue
    @Column(name = "publicacion_id")
    private Integer id;
    private String titulo;
    private String descripcion;
    private String foto;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaPublicacion;
    private Integer liked;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "publicacion")
    private List<Comentarios> comentariosList;

    @PrePersist
    public void setTime() {
        if (isNull(this.getFechaPublicacion())) {
            this.fechaPublicacion = LocalDateTime.now();
        }
    }



}
