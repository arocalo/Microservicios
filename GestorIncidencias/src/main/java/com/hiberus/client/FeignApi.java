package com.hiberus.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "companyClient" ,url = "${url.factoria}")
public interface FeignApi {

//    @RequestMapping(method = RequestMethod.GET)
//    Boolean factoryInfo();

    @RequestMapping(method = RequestMethod.GET,value="/{idFactoria}/{idMaquina}")
    Boolean factoryInfo(@PathVariable("idFactoria") Long idFactoria,@PathVariable("idMaquina") Long idMaquina);


}