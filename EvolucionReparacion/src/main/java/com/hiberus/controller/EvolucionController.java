package com.hiberus.controller;


import com.hiberus.domain.dto.AveriaDTO;
import org.springframework.http.ResponseEntity;

public interface EvolucionController {
    ResponseEntity<AveriaDTO> evolucionarAveria(AveriaDTO avr);
}
