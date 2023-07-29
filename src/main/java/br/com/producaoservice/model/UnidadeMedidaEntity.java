package br.com.producaoservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;

public class UnidadeMedidaEntity {

    @Id
    @Column(name = "ID")
    private BigInteger id;

    @NotNull
    @Size(max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Size(max = 5)
    @Column(name = "SIGLA")
    private String sigla;
}
