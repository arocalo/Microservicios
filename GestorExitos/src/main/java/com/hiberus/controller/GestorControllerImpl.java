package com.hiberus.controller;

import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.service.GestorServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/exitos", produces = MediaType.APPLICATION_JSON_VALUE)
public class GestorControllerImpl implements GestorController{

    @Autowired
    private GestorServiceImpl service;


    @Override
    @PostMapping(value = "/registro")
    @ApiOperation(value = "Registrar averia exitosa", notes = "Se guardan en la base de datos las averias con estado de exito")
    public ResponseEntity<Boolean> recibirAveria(@RequestBody AveriaDTO avrDTO) {
        return ResponseEntity.ok(service.guardarAveria(avrDTO));
    }

    @Override
    @GetMapping("/list")
    @ApiOperation(value = "Lista de averias exitosas", notes = "Se obtiene la lista de averias exitosas de la bdd")
    public ResponseEntity<List<AveriaDTO>> consultarAverias() {
        return ResponseEntity.ok(service.consultarListaAverias());
    }
}
