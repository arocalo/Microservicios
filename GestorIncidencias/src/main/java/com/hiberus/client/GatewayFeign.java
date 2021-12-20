package com.hiberus.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.cloud.openfeign.FeignClient("gateway")
public interface GatewayFeign {

//    @RequestMapping(method = RequestMethod.GET)
//    Boolean factoryInfo();

    @RequestMapping(method = RequestMethod.GET,value="${url.factoria}")
    Boolean factoryInfo(@PathVariable("idFactoria") Long idFactoria,@PathVariable("idMaquina") Long idMaquina);

    @RequestMapping(method = RequestMethod.POST,value="${url.equipos}")
    Boolean asignarEquipo(Long idMaquina);

}
