package com.hiberus.utils;

import com.hiberus.client.GatewayFeign;
import com.hiberus.configuration.RabbitmqConfig;
import com.hiberus.domain.dto.MaquinaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerAverias {

    @Autowired
    private GatewayFeign client;


    @RabbitListener(queues = RabbitmqConfig.QUEUE_GENERIC_NAME)
    public void receiveMessage(final MaquinaDTO mq) {
//        MaquinaDTO mq = message.getBody();
//        String str = new String(message.getBody(), java.nio.charset.StandardCharsets.UTF_8);
//        System.out.println(str);
        log.info("Recibida averia: {}", mq);
       if (client.factoryInfo(mq.getIdFactoria(), mq.getIdMaquina())){
           log.info("Tramitando averia");

       }else{
           log.warn("La maquina de la averia no existe");
       }

    }
}
