package br.com.producaoservice.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.producaoservice.model.MateriaPrimaEntity;

@Repository
public interface MateriaPrimaRepository extends JpaRepository<MateriaPrimaEntity, BigInteger> {
}