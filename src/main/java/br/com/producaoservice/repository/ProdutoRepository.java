package br.com.producaoservice.repository;

import br.com.producaoservice.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigInteger> {
}
