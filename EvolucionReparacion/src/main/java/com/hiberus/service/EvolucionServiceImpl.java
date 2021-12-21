package com.hiberus.service;

import com.hiberus.domain.dto.AveriaDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EvolucionServiceImpl implements EvolucionService {
    @Override
    public AveriaDTO evolucionarAveria(AveriaDTO avr) {
        avr.setFechaActualizacion(new Date());
        switch ((int) (avr.getFechaActualizacion().getTime()%3)) {
            case 0:
                avr.setEstado(AveriaDTO.Estados.EN_PROCESO);
                break;
            case 1:
                avr.setEstado(AveriaDTO.Estados.REPARADA);
                break;
            case 2:
                avr.setEstado(AveriaDTO.Estados.SIN_SOLUCIÓN);
                break;
        }
        return avr;
    }
}
