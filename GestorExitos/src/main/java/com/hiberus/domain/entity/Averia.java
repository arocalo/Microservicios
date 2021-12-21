package com.hiberus.domain.entity;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(force = true)
@Document(collection = "averias")
public class Averia {
    public enum Estados
    {
        INICIAL,EN_PROCESO, REPARADA, SIN_SOLUCIÓN
    }
    @Id
    private String id;
    private String equipo;
    private long idFactoria;
    private long idMaquina;
    private Date fechaAlta;
    private Date fechaInicioEquipo;
    private Date fechaActualizacion;
    private Estados estado;
}

