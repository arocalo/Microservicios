package com.hiberus.controller;

import com.hiberus.domain.dto.AveriaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GestorController {
    ResponseEntity<Boolean> recibirAveria(AveriaDTO avrDTO);
    ResponseEntity<List<AveriaDTO>> consultarAverias();
}
