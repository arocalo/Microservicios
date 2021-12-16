package com.hiberus.domain.dto;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(force = true)
public class MaquinaDTO {
    private String id;
    private long idFactoria;
    private long idMaquina;
    private Date fechaAlta;
}

