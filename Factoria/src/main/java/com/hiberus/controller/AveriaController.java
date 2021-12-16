package com.hiberus.controller;

import com.hiberus.domain.dto.MaquinaDTO;
import org.springframework.http.ResponseEntity;

public interface AveriaController {
    ResponseEntity<Boolean> recibirIncidencia(long idFactoria,long idMaquina);
    ResponseEntity<Boolean> existsFactoriaMaquina(long idFactoria,long idMaquina);
}
