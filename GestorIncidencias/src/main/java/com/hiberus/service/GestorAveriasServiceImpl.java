package com.hiberus.service;

import com.hiberus.client.GatewayFeign;
import com.hiberus.domain.dto.AveriaDTO;
import com.hiberus.domain.dto.MaquinaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GestorAveriasServiceImpl implements GestorAveriasService {
    @Autowired
    private GatewayFeign client;

    @Override
    public void gestionarAverias(MaquinaDTO mq) {
        if (client.factoryInfo(mq.getIdFactoria(), mq.getIdMaquina())) {
            log.info("Tramitando averia");
            AveriaDTO avr = new AveriaDTO(mq.getId(), "", mq.getIdFactoria(), mq.getIdMaquina(), mq.getFechaAlta(), null, null, null);
            avr = client.asignarEquipo(avr);
            avr = client.evolucionarAveria(avr);
            
            while (avr.getEstado() == AveriaDTO.Estados.EN_PROCESO) {
                log.info("La averia se encuentra en proceso: {}", avr);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                avr = client.evolucionarAveria(avr);
            }

            switch (avr.getEstado()) {
                case REPARADA:
                    System.out.println("Reparada");
                    break;
                case SIN_SOLUCIÓN:
                    System.out.println("Sin solucion");
                    break;
                default:
                    log.error("La averia no se ha procesado correctamente");
                    break;
            }

            log.info("Averia procesada {}", avr);

        } else {
            log.warn("La maquina de la averia no existe");
        }
    }
}
