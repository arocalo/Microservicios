package com.hiberus.controller;

import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.service.EvolucionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/evolucion", produces = MediaType.APPLICATION_JSON_VALUE)
public class EvolucionControllerImpl implements EvolucionController{

    @Autowired
    private EvolucionServiceImpl service;

    @Override
    @PostMapping(value = "")
    @ApiOperation(value = "Evolucionar Averia", notes = "Cambia el estado y la fecha de actualización de una averia")
    public ResponseEntity<AveriaDTO> evolucionarAveria(@RequestBody AveriaDTO avr) {
        return ResponseEntity.ok(service.evolucionarAveria(avr));
    }
}
