package com.hiberus.controller;


import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.service.AsignacionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/averia", produces = MediaType.APPLICATION_JSON_VALUE)
public class AsignacionControllerImpl implements AsignacionController {
    @Autowired
    private AsignacionServiceImpl service;

    @Override
    @PostMapping(value = "/users")
    @ApiOperation(value = "Asignar equipo", notes = "Asigna un equipo valido a una averia que se pase por POST")
    public ResponseEntity<AveriaDTO> asignarEquipo(AveriaDTO avr) {
        return ResponseEntity.ok(service.asignarEquipo(avr));
    }

}
