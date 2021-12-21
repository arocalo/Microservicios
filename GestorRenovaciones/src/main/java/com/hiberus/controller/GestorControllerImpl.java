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
@RequestMapping(path = "/renovaciones", produces = MediaType.APPLICATION_JSON_VALUE)
public class GestorControllerImpl implements GestorController{

    @Autowired
    private GestorServiceImpl service;


    @Override
    @PostMapping(value = "/registro")
    @ApiOperation(value = "Registrar averia SIN_SOLUCION", notes = "Se guardan en la base de datos las averias con estado de SIN_SOLUCION")
    public ResponseEntity<Boolean> recibirAveria(@RequestBody AveriaDTO avrDTO) {
        return ResponseEntity.ok(service.guardarAveria(avrDTO));
    }

    @Override
    @GetMapping("/list")
    @ApiOperation(value = "Lista de averias SIN_SOLUCION", notes = "Se obtiene la lista de averias SIN_SOLUCION de la bdd")
    public ResponseEntity<List<AveriaDTO>> consultarAverias() {
        return ResponseEntity.ok(service.consultarListaAverias());
    }
}
