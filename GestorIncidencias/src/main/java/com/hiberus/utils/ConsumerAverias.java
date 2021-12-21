package com.hiberus.utils;

import com.hiberus.client.GatewayFeign;
import com.hiberus.configuration.RabbitmqConfig;
import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.domain.dto.MaquinaDTO;
import com.hiberus.service.GestorAveriasServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerAverias {

   @Autowired
   private GestorAveriasServiceImpl gestor;

//    Consumidor1
    @RabbitListener(queues = RabbitmqConfig.QUEUE_GENERIC_NAME)
    public void recivirAlerta(final MaquinaDTO mq) {
        log.info("Recibida averia: {}", mq);
        gestor.gestionarAverias(mq);

    }
//    Consumidor2
    @RabbitListener(queues = RabbitmqConfig.QUEUE_GENERIC_NAME)
    public void recivirAlerta2(final MaquinaDTO mq) {
        log.info("Recibida averia: {}", mq);
        gestor.gestionarAverias(mq);
    }
}
