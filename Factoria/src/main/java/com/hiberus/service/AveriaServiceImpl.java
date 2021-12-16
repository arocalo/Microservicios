package com.hiberus.service;

import com.hiberus.configuration.RabbitmqConfig;
import com.hiberus.domain.dto.MaquinaDTO;
import com.hiberus.domain.entity.Maquina;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class AveriaServiceImpl implements AveriaService{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Boolean enviarAveria(long idFactoria, long idMaquina) {
        try{
            //Enviamos una MaquinaDTO sin verificar si existe ya que GestorIncidencias se tiene que encargar de verificar si esta existe o no
            String uniqueID = UUID.randomUUID().toString();
            MaquinaDTO mq = new MaquinaDTO(uniqueID,idFactoria,idMaquina, new Date());
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, mq);
            log.info("Enviada incidencia a RabbitMQ");
            return true;
        }catch (Exception e){
            log.error("Problema al enviar averia a rabbitMQ");
            return false;
        }
    }
}
