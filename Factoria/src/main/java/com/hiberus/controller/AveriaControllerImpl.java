package com.hiberus.controller;

import com.hiberus.domain.dto.MaquinaDTO;
import com.hiberus.repository.MaquinaRepository;
import com.hiberus.service.AveriaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/averia", produces = MediaType.APPLICATION_JSON_VALUE)
public class AveriaControllerImpl implements AveriaController{

    @Autowired
    private MaquinaRepository repo;
    @Autowired
    private AveriaService service;



    @Override
    @GetMapping("/{factoriaId}/{maquinaId}")
    @ApiOperation(value = "Comunicar incidencia", notes = "Se enviar de manera asincrona un mensaje con la información de una avería")
    public ResponseEntity<Boolean> recibirIncidencia(@PathVariable("factoriaId") long idFactoria, @PathVariable("maquinaId") long idMaquina) {
        return  ResponseEntity.ok(service.enviarAveria(idFactoria,idMaquina));
    }

    @Override
    @GetMapping("/exists/{factoriaId}/{maquinaId}")
    @ApiOperation(value = "Comprobar Factoria-Maquina", notes = "Se comprueba si existe una maquina en una factoria")
    public ResponseEntity<Boolean> existsFactoriaMaquina(@PathVariable("factoriaId") long idFactoria, @PathVariable("maquinaId") long idMaquina) {
        return ResponseEntity.ok(repo.existsByIdFactoriaAndIdMaquina(idFactoria,idMaquina));
    }
}
