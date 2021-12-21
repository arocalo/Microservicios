package com.hiberus.repository;
import com.hiberus.domain.entity.Maquina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaquinaRepository extends MongoRepository<Maquina, String> {
    boolean existsByIdFactoriaAndIdMaquina(long idFactoria, long idMaquina);
}

