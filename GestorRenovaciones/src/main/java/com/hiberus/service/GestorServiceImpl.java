package com.hiberus.service;

import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.domain.entity.Averia;
import com.hiberus.repository.AveriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Slf4j
public class GestorServiceImpl implements GestorService{

    @Autowired
    private AveriaRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Boolean guardarAveria(AveriaDTO avrDTO) {
        Averia avr = modelMapper.map(avrDTO, Averia.class);
        try{
            repo.save(avr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<AveriaDTO> consultarListaAverias() {
        List<Averia> list = repo.findAll();
        Type listType = new TypeToken<List<AveriaDTO>>(){}.getType();
        List<AveriaDTO> listDTO = modelMapper.map(list,listType);
        return listDTO;
    }
}
