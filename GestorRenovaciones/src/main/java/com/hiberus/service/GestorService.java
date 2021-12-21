package com.hiberus.service;

import com.hiberus.domain.dto.AveriaDTO;

import java.util.List;

public interface GestorService {
    Boolean guardarAveria(AveriaDTO avrDTO);
    List<AveriaDTO> consultarListaAverias();
}
