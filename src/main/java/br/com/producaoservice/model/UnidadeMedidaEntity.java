package br.com.producaoservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TB_UNIDADE_MEDIDA")
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
