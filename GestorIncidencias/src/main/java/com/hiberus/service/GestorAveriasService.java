package com.hiberus.service;

import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.domain.dto.MaquinaDTO;

public interface GestorAveriasService {
    void gestionarAverias(MaquinaDTO mq);
}
