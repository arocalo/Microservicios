package com.hiberus.domain.dto;

import lombok.*;

import java.util.Date;




@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(force = true)
public class AveriaDTO {
    public enum Estados
    {
        INICIAL,EN_PROCESO, REPARADA, SIN_SOLUCIÓN
    }
    private String id;
    private String equipo;
    private long idFactoria;
    private long idMaquina;
    private Date fechaAlta;
    private Date fechaInicioEquipo;
    private Date fechaActualizacion;
    private Estados estado;
}

