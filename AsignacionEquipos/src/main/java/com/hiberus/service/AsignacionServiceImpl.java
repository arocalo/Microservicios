package com.hiberus.service;

import com.hiberus.domain.dto.AveriaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Value("${equipos}")
    String[] equipos;

    @Override
    public AveriaDTO asignarEquipo(AveriaDTO avr) {
        avr.setEstado(AveriaDTO.Estados.INICIAL);
        avr.setFechaInicioEquipo(new Date());
        avr.setEquipo(equipos[(int) (avr.getFechaInicioEquipo().getTime()%equipos.length)]);
        return avr;
    }

}
