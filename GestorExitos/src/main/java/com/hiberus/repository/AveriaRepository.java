package com.hiberus.repository;
import com.hiberus.domain.entity.Averia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AveriaRepository extends MongoRepository<Averia, String> {
}

