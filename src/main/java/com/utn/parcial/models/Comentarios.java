package com.utn.parcial.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comentarios {


    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fecha;
    private String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "publicacion_id", referencedColumnName = "publicacion_id")
    private Publicaciones publicacion;

    @PrePersist
    public void setTime() {
        if (isNull(this.getFecha())) {
            this.fecha = LocalDateTime.now();
        }
    }


}
