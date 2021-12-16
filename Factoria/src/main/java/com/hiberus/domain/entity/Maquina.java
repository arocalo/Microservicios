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
@Document(collection = "factoria")
public class Maquina {
    @Id
    private String id;
    private long idFactoria;
    private long idMaquina;
}

