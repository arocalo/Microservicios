package com.hiberus.client;

import com.hiberus.domain.dto.AveriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("gateway")
public interface GatewayFeign {

//    @RequestMapping(method = RequestMethod.GET)
//    Boolean factoryInfo();

    @RequestMapping(method = RequestMethod.GET,value="${url.factoria}")
    Boolean factoryInfo(@PathVariable("idFactoria") Long idFactoria,@PathVariable("idMaquina") Long idMaquina);

    @RequestMapping(method = RequestMethod.POST,value="${url.equipos}")
    AveriaDTO asignarEquipo(AveriaDTO avr);

    @RequestMapping(method = RequestMethod.POST,value="${url.evolucion}")
    AveriaDTO evolucionarAveria(AveriaDTO avr);

    @RequestMapping(method = RequestMethod.POST,value="${url.renovaciones}")
    Boolean renovarAveria(AveriaDTO avr);

    @RequestMapping(method = RequestMethod.POST,value="${url.exitos}")
    Boolean cerrarAveriaExitosa(AveriaDTO avr);

}
