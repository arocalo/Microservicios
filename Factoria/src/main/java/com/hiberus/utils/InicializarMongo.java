package com.hiberus.utils;

import com.hiberus.domain.entity.Maquina;
import com.hiberus.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class InicializarMongo implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private MaquinaRepository repo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        repo.save(new Maquina(null, 1, 1));
        repo.save(new Maquina(null, 1, 2));
        repo.save(new Maquina(null, 1, 3));
        repo.save(new Maquina(null, 2, 1));
        repo.save(new Maquina(null, 2, 2));
        repo.save(new Maquina(null, 2, 3));
        repo.save(new Maquina(null, 3, 1));
        repo.save(new Maquina(null, 3, 2));
        repo.save(new Maquina(null, 3, 3));
    }
}

