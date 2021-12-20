package com.hiberus.controller;

import com.hiberus.domain.dto.AveriaDTO;
import org.springframework.http.ResponseEntity;

public interface AsignacionController {
    ResponseEntity<AveriaDTO> asignarEquipo(AveriaDTO avr);
}
