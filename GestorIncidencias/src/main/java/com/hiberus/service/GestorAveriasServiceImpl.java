package com.hiberus.service;

import com.hiberus.client.GatewayFeign;
import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.domain.dto.MaquinaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GestorAveriasServiceImpl  implements GestorAveriasService {
    @Autowired
    private GatewayFeign client;

    @Override
    public void gestionarAverias(MaquinaDTO mq) {
        if (client.factoryInfo(mq.getIdFactoria(), mq.getIdMaquina())){
            log.info("Tramitando averia");
            AveriaDTO avr = new AveriaDTO(mq.getId(),"",mq.getIdFactoria(),mq.getIdMaquina(),mq.getFechaAlta(),null,null,null);
            avr =client.asignarEquipo(avr);

        }else{
            log.warn("La maquina de la averia no existe");
        }
    }
}
